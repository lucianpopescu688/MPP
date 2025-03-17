package model;

public class User {
    private int IDUser;
    private String username;
    private String password;

    public User() {}

    public User(int IDUser, String username, String password) {
        this.IDUser = IDUser;
        this.username = username;
        this.password = password;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
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

    @Override
    public String toString() {
        return "User{" +
                "IDUser=" + IDUser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
