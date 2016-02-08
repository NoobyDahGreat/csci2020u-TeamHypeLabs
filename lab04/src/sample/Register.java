package sample;

/**
 * Created by jude on 08/02/16.
 * Created al by Brad on 08/02/12
 */
public class Register {
    private String username;
    private String password;
    private String fullName;
    private String emailAddress;
    private String number;

    public Register(String username, String password, String fullName, String emailAddress, String number) {
        setUsername(username);
        setPassword(password);
        setFullName(fullName);
        setEmailAddress(emailAddress);
        setNumber(number);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
