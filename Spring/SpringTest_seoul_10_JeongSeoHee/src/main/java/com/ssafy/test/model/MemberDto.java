package com.ssafy.test.model;

public class MemberDto {
	private String id;
	private String name;
	private String pw;
	private String rclass;
	private String rname;
	private String usernumber;
	private String position;
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", name=" + name + ", pw=" + pw + ", rclass=" + rclass + ", rname=" + rname
				+ ", usernumber=" + usernumber + ", position=" + position + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getRclass() {
		return rclass;
	}
	public void setRclass(String rclass) {
		this.rclass = rclass;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}	
}
