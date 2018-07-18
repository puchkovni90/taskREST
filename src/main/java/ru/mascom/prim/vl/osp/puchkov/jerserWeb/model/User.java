package ru.mascom.prim.vl.osp.puchkov.jerserWeb.model;

public class User {
    private String username;
    private Integer passwdHashcode;


    public User() {
    }

    public User(String username, Integer passwdHashcode) {
        this.username = username;
        this.passwdHashcode = passwdHashcode;
    }

    public User(String username, String password) {
        this.username = username;
        this.passwdHashcode = password.hashCode();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.passwdHashcode = password.hashCode();
    }

    public Integer getPasswdHashcode() {
        return passwdHashcode;
    }

    public void setPasswdHashcode(Integer passwdHashcode) {
        this.passwdHashcode = passwdHashcode;
    }

}
