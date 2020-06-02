package com.talentnxg.talentnxgapi.models;

public class UserProfile {
	private String userName;
	private String fullName;
	private Integer active;
	private String userAvatar;
	public UserProfile() {
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	
}
