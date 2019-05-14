package com.hrm.user.beans;

import java.util.Date;

public class User {

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", createdate=" + createdate +
                ", username='" + username + '\'' +
                '}';
    }



    private Integer ID;
    private String loginname;

    private String password;
    private String status;
    private Date createdate;
    private String username;



    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User() {
    }

    public User(Integer id, String loginname, String password, String status, Date createdate, String username) {
        this.ID = id;
        this.loginname = loginname;
        this.password = password;
        this.status = status;
        this.createdate = createdate;
        this.username = username;
    }
}
