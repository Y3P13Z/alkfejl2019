package storage.storage.inputModels.User;

public class LoginInputModel {

    private String password;
    private String username;

    public LoginInputModel(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public LoginInputModel() {
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
}
