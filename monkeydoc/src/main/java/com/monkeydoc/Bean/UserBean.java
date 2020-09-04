package com.monkeydoc.Bean;

public class UserBean {
    private String id;
    private String tel;
    private String email;
    private String userName;
    private String password;

    public UserBean(String tel, String email, String userName, String password) {
        this.tel = tel;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
