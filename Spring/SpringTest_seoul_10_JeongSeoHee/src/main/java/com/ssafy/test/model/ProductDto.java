package com.ssafy.test.model;

public class ProductDto {	
	String ano = "";
	String usernumber = "";
	String issuedate = "";
	String issue = "";
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	@Override
	public String toString() {
		return "ProductDto [ano=" + ano + ", usernumber=" + usernumber + ", issuedate=" + issuedate + ", issue=" + issue
				+ "]";
	}
	
}
