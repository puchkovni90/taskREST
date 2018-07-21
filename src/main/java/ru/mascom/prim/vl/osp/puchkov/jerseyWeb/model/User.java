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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (passwdHashcode != null ? !passwdHashcode.equals(user.passwdHashcode) : user.passwdHashcode != null)
            return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (passwdHashcode != null ? passwdHashcode.hashCode() : 0);
        return result;
    }
}
