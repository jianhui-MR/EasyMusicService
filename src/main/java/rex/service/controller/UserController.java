package rex.service.controller;

import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import rex.service.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/toLogin")
    public JSONObject toLogin(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("status",9);
        return jsonObject;
    }

    @RequestMapping("/loginUser")
    public JSONObject login(@RequestParam("account")String account, @RequestParam("password")String password, HttpServletRequest request){
        HttpSession session=request.getSession(true);
        return service.login(account,password,session);
    }

    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public JSONObject register(@RequestParam("account")String account,
                               @RequestParam("password")String password,
                               @RequestParam("name")String name,
                               @RequestParam("email")String email){
        return service.register(account,password,name,email);
    }

    @RequestMapping("/modifyPassword")
    public JSONObject modifyPassword(@RequestParam("account")String account,@RequestParam("password")String password){
        return service.modifyPassword(account,password);
    }


    @RequestMapping(value = "/getVerificationCode",method = RequestMethod.POST)
    public JSONObject getVerificationCode(@RequestParam("email")String email){
        return service.getVerificationCode(email);
    }

    @RequestMapping(value = "/retrievePassword",method = RequestMethod.POST)
    public JSONObject retrievePassword(@RequestParam("account") String account){
        return service.retrievePasswordFromEmail(account);
    }


    @RequestMapping(value = "/setUserHeadSculpture",method = RequestMethod.POST)
    public JSONObject setUserHeadSculpture(@RequestParam("account")String account,@RequestParam("headSculpture") MultipartFile headSculpture){
        return service.setUserHeadSculpture(account,headSculpture);
    }

    @RequestMapping(value = "/getUserHeadSculpture",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getUserHeadSculpture(@RequestParam("account")String account){
        return service.getUserHeadSculpture(account);
    }


}
