package com.itwill.team1.sho.Domain;

import java.sql.Timestamp;

public class membershoVO {

	private String id;
	private String password;
	private String nickname;
	private String email;
	private String address;
	private String address_detail;
	private String logo;
	private Integer type;
	private Integer address_num;
	private Timestamp reg_date;
	private Timestamp up_date;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type=type;
	}

	public Integer getAddress_num() {
		return address_num;
	}

	public void setAddress_num(Integer address_num) {
		this.address_num = address_num;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

	public Timestamp getUp_date() {
		return up_date;
	}

	public void setUp_date(Timestamp up_date) {
		this.up_date = up_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	@Override
	public String toString() {
		return "membershoVO [id=" + id + ", password=" + password + ", nickname=" + nickname + ", email=" + email
				+ ", address=" + address + ", address_detail=" + address_detail + ", logo=" + logo + ", type=" + type
				+ ", address_num=" + address_num + ", reg_date=" + reg_date + ", up_date=" + up_date + "]";
	}
	
}
