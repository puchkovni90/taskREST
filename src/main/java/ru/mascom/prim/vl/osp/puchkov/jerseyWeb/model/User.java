package ru.mascom.prim.vl.osp.puchkov.jerseyWeb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
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

    @Override
    public String toString() {
        return "User{" +
                "'id':'" + id + '\'' +
                ", 'username':'" + username + '\'' +
                ", 'passwdHashcode':'" + passwdHashcode +
                "'}";
    }
}
