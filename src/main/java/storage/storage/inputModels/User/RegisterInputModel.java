package storage.storage.inputModels.User;

public class RegisterInputModel {

    private String password;
    private String confirmPassword;
    private String username;

    public RegisterInputModel(String password, String confirmPassword, String username) {
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.username = username;
    }

    public RegisterInputModel() {
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
