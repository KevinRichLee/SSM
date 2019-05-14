package com.hrm.user.beans;

import java.util.Date;

public class Notice {
    private Integer id;
    private String title;
    private String content;
    private Date create_date;
    private User user;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    private String user_id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Notice() {
    }

    public Notice(Integer id, String title, String content, Date create_date, User user, String user_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.create_date = create_date;
        this.user = user;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", create_date='" + create_date + '\'' +
                ", user=" + user +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
