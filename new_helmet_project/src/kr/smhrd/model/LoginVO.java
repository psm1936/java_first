package kr.smhrd.model;

public class LoginVO {
	private String memberid;
	private String membername;
	private String password;
	private String memberage;
	private String memberphone;

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberage() {
		return memberage;
	}

	public void setMemberage(String memberage) {
		this.memberage = memberage;
	}

	public String getMemberphone() {
		return memberphone;
	}

	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}

}