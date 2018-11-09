package Models;

public class LoginModel {
    private String emailAddress;
    private String password;
    private String badEmail;
    private String wrongEmail;
    private String badPassword;



    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBadEmail() {
        return badEmail;
    }

    public void setBadEmail(String badEmail) {
        this.badEmail = badEmail;
    }

    public String getWrongEmail() {
        return wrongEmail;
    }

    public void setWrongEmail(String wrongEmail) {
        this.wrongEmail = wrongEmail;
    }

    public String getBadPassword() {
        return badPassword;
    }

    public void setBadPassword(String badPassword) {
        this.badPassword = badPassword;
    }

}
