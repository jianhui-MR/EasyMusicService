package rex.service.service;

import org.springframework.web.multipart.MultipartFile;
import rex.service.bean.User;
import rex.service.mapper.UserMapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import rex.service.token.TokenProccessor;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    UserMapper mapper;

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 登录
     * @param account 账号
     * @param password 密码
     * @return
     */
    public JSONObject login(@NotNull String account, @NotNull String password, HttpSession session){
        JSONObject object=new JSONObject();
        String token= TokenProccessor.getInstance().makeToken();
        session.setAttribute("token",token);
        try{
            User user=mapper.getLoginUserInfo(account,password);
            object.put("status",0);
            object.put("userName",user.getName());
            object.put("userAccount",user.getAccount());
            object.put("token",token);
        }catch (Exception e) {
            e.printStackTrace();
            object.put("status", 1);
        }
        return object;
    }

    /**
     * 注册
     * @param account 账号
     * @param password 密码
     * @return
     */
    public JSONObject register(@NotNull String account,@NotNull String password,@NotNull String name,@NotNull String email){
        JSONObject jsonObject=new JSONObject();
        try{
            mapper.addUser(account,password,name,email);
            jsonObject.put("status",0);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status",1);
        }
        return jsonObject;
    }

    /**
     * 修改密码
     * @param account
     * @param password
     * @return
     */
    public JSONObject modifyPassword(@NotNull String account,@NotNull String password){
        JSONObject jsonObject=new JSONObject();
        try{
            mapper.modifyPassword(account,password);
            jsonObject.put("status",0);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status",1);
        }
        return jsonObject;
    }


    /**
     * 获取验证码
     * @param email 用户Email
     * @return
     */
    public JSONObject getVerificationCode(@NotNull String email){
        JSONObject jsonObject=new JSONObject();
        try{
            Random random=new Random();
            int verificationCode=random.nextInt(9000)+1000;
            sendEmailToUser(email,verificationCode);
            jsonObject.put("status",0);
            jsonObject.put("verificationCode",verificationCode);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status",1);
        }
        return jsonObject;
    }

    /**
     *获取用户Email及随机验证码
     */
    public JSONObject retrievePasswordFromEmail(String account){
        JSONObject jsonObject=new JSONObject();
        try {
            String email=mapper.getUserEmail(account);
            int verificationCode=new Random().nextInt(9000)+1000;
            sendEmailToUser(email,verificationCode);
            jsonObject.put("status",0);
            jsonObject.put("verificationCode",verificationCode);
            jsonObject.put("userEmail",email);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status",1);
        }
        return jsonObject;
    }

    /**
     * 发送邮件给用户
     * @param email
     * @param code
     */
    private void sendEmailToUser(String email,int code){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("1754154934@qq.com");
        message.setTo(email);
        message.setSubject("EasyMusic");
        message.setText("此次验证码为:"+code);
        mailSender.send(message);
    }

    /**
     * 设置用户头像
     * @param account
     * @param headSculpture
     * @return
     */
    public JSONObject setUserHeadSculpture(String account, MultipartFile headSculpture){

        JSONObject jsonObject=new JSONObject();
        try{
//            mapper.setUserHeadSculpture(account,headSculpture);
            File file=new File("C:/EasyMusic/headSculpture/"+account+".jpg");
            File path=new File("C:/EasyMusic/headSculpture/");
            if (!path.exists()){
                path.mkdirs();
            }
            if (!file.exists()){
                file.createNewFile();
            }
//
            FileOutputStream outputStream=new FileOutputStream(file);
//            inputStream=(FileInputStream) multiReq.getFile("file").getInputStream();

            outputStream.write(headSculpture.getBytes());
            outputStream.flush();
            outputStream.close();

            jsonObject.put("status",0);
        }catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status",1);
        }

        return  jsonObject;
    }

    /**
     * 获取用户头像
     * @param account
     * @return
     */
    public byte[] getUserHeadSculpture(String account){
        byte[] bytes=null;
        try {
            File file=new File("C:/EasyMusic/headSculpture/"+account+".jpg");
            FileInputStream inputStream=new FileInputStream(file);
            bytes=new byte[inputStream.available()];
            inputStream.read(bytes);
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();;
        }
        return bytes;
    }

}
