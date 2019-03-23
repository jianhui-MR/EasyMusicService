package rex.service.Mapper;

import rex.service.Bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    //用户登录
    User getLoginUserInfo(String account,String password);

    //注册
    void addUser(String account, String password, String name,String email);

    //修改密码
    void modifyPassword(String account, String password);

    //获取用户Email
    String getUserEmail(String account);

    //设置用户头像
    void setUserHeadSculpture(String account,String headSculpture);

    //获取用户头像
    String getUserHeadSculpture(String account);

}
