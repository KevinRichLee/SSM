package com.aynu.crm.pojo;

public class Users {

	private Integer userId;
	private String userName;
	private String userPassword;
	private String userState;
	private String userPhone;
	private String userEmailAdr;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmailAdr() {
		return userEmailAdr;
	}
	public void setUserEmailAdr(String userEmailAdr) {
		this.userEmailAdr = userEmailAdr;
	}
	public Users(String userName, String userPassword, String userState, String userPhone, String userEmailAdr) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userState = userState;
		this.userPhone = userPhone;
		this.userEmailAdr = userEmailAdr;
	}
	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userState="
				+ userState + ", userPhone=" + userPhone + ", userEmailAdr=" + userEmailAdr + "]";
	}
}
