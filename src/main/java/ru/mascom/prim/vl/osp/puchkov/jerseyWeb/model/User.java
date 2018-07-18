package ru.mascom.prim.vl.osp.puchkov.jerseyWeb.model;

public class User {
    private Integer id;
    private String username;
    private Integer passwdHashcode;


    public User() {
    }

    public User(Integer id, String username, Integer passwdHashcode) {
        this.id = id;
        this.username = username;
        this.passwdHashcode = passwdHashcode;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.passwdHashcode = password.hashCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
