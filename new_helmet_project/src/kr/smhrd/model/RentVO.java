package kr.smhrd.model;

public class RentVO {
	private String rentid;
	private int rentdate;
	private String rentplaceid;
	private int returndate;
	private String returnplaceid;
	private String memberid;
	private String helmetid;
	public String getRentid() {
		return rentid;
	}
	public void setRentid(String rentid) {
		this.rentid = rentid;
	}
	public int getRentdate() {
		return rentdate;
	}
	public void setRentdate(int rentdate) {
		this.rentdate = rentdate;
	}
	public String getRentplaceid() {
		return rentplaceid;
	}
	public void setRentplaceid(String rentplaceid) {
		this.rentplaceid = rentplaceid;
	}
	public int getReturndate() {
		return returndate;
	}
	public void setReturndate(int returndate) {
		this.returndate = returndate;
	}
	public String getReturnplaceid() {
		return returnplaceid;
	}
	public void setReturnplaceid(String returnplaceid) {
		this.returnplaceid = returnplaceid;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getHelmetid() {
		return helmetid;
	}
	public void setHelmetid(String helmetid) {
		this.helmetid = helmetid;
	}

}