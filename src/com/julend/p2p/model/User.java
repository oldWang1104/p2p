package com.julend.p2p.model;

public class User {
	
	private Integer id;
	
	private String name;
	
	private String cname;
	
	private String password;
	
	private String email;
	
	private String phone;
	
	private String mobile;
	
	
	public User(){}
	
	
	public User(Integer id, String name, String cname,String password, String email,
			String phone, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.cname = cname;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.mobile = mobile;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+":"+password;
	}
	
}
