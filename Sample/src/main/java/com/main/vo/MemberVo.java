package com.main.vo;

public class MemberVo {
	
	//no
	private Integer rnum;
	//pk
	private String seq_id;
	//아이디
	private String user_id;
	//비밀번호
	private String user_pw;
	//이름
	private String user_name;
	//폰번호
	private String user_phone;
	//상태
	private String user_auth;
	//검색
	private String search;
	//주소
	private String user_address;
	
	private String order_count;
	

	
	
	public String getOrder_count() {
		return order_count;
	}
	public void setOrder_count(String order_count) {
		this.order_count = order_count;
	}
	public Integer getRnum() {
		return rnum;
	}
	public void setRnum(Integer rnum) {
		this.rnum = rnum;
	}
	public String getSeq_id() {
		return seq_id;
	}
	public void setSeq_id(String seq_id) {
		this.seq_id = seq_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_auth() {
		return user_auth;
	}
	public void setUser_auth(String user_auth) {
		this.user_auth = user_auth;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	@Override
	public String toString() {
		return "MemberVo [rnum=" + rnum + ", seq_id=" + seq_id + ", user_id=" + user_id + ", user_pw=" + user_pw
				+ ", user_name=" + user_name + ", user_phone=" + user_phone + ", user_auth=" + user_auth + ", search="
				+ search + ", user_address=" + user_address + ", order_count=" + order_count + "]";
	}


	


}
