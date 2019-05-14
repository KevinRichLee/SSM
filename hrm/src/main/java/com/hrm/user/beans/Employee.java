package com.hrm.user.beans;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Employee {
    private Integer id;
    private Dept dept;
    private Job job;
    private Integer dept_id;
    private Integer job_id;
    private String name;
    private String card_id;
    private String address;
    private String post_code;
    private String tel;
    private String phone;
    private String qq_num;
    private String email;
    private Integer sex;
    private String party;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String race;
    private String education;
    private String speciality;
    private String hobby;
    private String remark;
    private Date create_date;


    public Employee(Integer id, Dept dept, Job job, Integer dept_id, Integer job_id, String name, String card_id, String address, String post_code, String tel, String phone, String qq_num, String email, Integer sex, String party, Date birthday, String race, String education, String speciality, String hobby, String remark, Date create_date) {
        this.id = id;
        this.dept = dept;
        this.job = job;
        this.dept_id = dept_id;
        this.job_id = job_id;
        this.name = name;
        this.card_id = card_id;
        this.address = address;
        this.post_code = post_code;
        this.tel = tel;
        this.phone = phone;
        this.qq_num = qq_num;
        this.email = email;
        this.sex = sex;
        this.party = party;
        this.birthday = birthday;
        this.race = race;
        this.education = education;
        this.speciality = speciality;
        this.hobby = hobby;
        this.remark = remark;
        this.create_date = create_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq_num() {
        return qq_num;
    }

    public void setQq_num(String qq_num) {
        this.qq_num = qq_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", dept=" + dept +
                ", job=" + job +
                ", dept_id=" + dept_id +
                ", job_id=" + job_id +
                ", name='" + name + '\'' +
                ", card_id='" + card_id + '\'' +
                ", address='" + address + '\'' +
                ", post_code='" + post_code + '\'' +
                ", tel='" + tel + '\'' +
                ", phone='" + phone + '\'' +
                ", qq_num='" + qq_num + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", party='" + party + '\'' +
                ", birthday='" + birthday + '\'' +
                ", race='" + race + '\'' +
                ", education='" + education + '\'' +
                ", speciality='" + speciality + '\'' +
                ", hobby='" + hobby + '\'' +
                ", remark='" + remark + '\'' +
                ", create_date=" + create_date +
                '}';
    }

    public Employee() {
    }

}
