package com.ntt.domain;

public class UserDetails {
	private int uid;
	private String uname;
	private String upassword;
	private String ucity;
	private String uemail;
	private long ucontactNumber;
	private int roleId;
	
	public UserDetails(int uid, String uname, String upassword, String ucity, String uemail, Long ucontactNumber, int roleId) {
		//super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.ucity = ucity;
		this.uemail = uemail;
		this.ucontactNumber = ucontactNumber;
		this.roleId = roleId;
	}
	// for the login part
	public UserDetails(int id, String password) {
		uid = id;
		upassword = password;
	}
	
	public UserDetails(int roleId) {
		// TODO Auto-generated constructor stub
		this.roleId = roleId;
	}
	public UserDetails() {

	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public long getUcontactNumber() {
		return ucontactNumber;
	}
	public void setUcontactNumber(long ucontactNumber) {
		this.ucontactNumber = ucontactNumber;
	}
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String toString()
	{
		return ("CustomerID-"+uid+", CustomerName-"+uname+", CustomerPassword-"+upassword+", CustomerCity"+ucity+", CustomerEmail-"+uname+", CustomerContactNo-"+ucontactNumber+", RoleId-"+roleId ).toString();
	}

}
