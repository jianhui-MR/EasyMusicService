package rex.service.Bean;

/**
 * @author MRJH
 * @created 2018-12-04 15:27
 **/
public class User {


    private String Account;
    private String Password;
    private String name;
    private String email;
    private String headSculpture;

    public String getHeadSculpture() {
        return headSculpture;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "账号:"+Account+"昵称:"+name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
