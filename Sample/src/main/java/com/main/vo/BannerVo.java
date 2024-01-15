package com.main.vo;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class BannerVo {

	//pk
	private Integer seq_id;
	//상품 pk
	private Integer product_seq_id;
	//배너명
	private String banner_name;
	//파일 이미지
	private String banner_img;
	//노출영역1
	private String banner_area1;
	//노출영역2
	private String banner_area2;
	//노출여부
	private String banner_yn;
	//회원ID
	private String user_id;
	//등록일
	private String redate;
	//CODE
	private String code;
	//랜딩_URL
	private String land_url;
	//할인 금액
	private String sale;
	
	// product data
	//타이틀
	private String banner_title;
	//상품명
	private String product_name;
	//이미지등록
	 private String  file_img;
	//상품가격
	private String product_amount;
	//배송비
	private String delivery_fee;
	//판매업체이름 
	private String company_name;
	//판매업체번호
	private String company_phone;
	//상세정보(IMG)
	private String detail_img;
	//상세정보(URL)
	private String detail_url;
	//노출여부
	private String company_yn;
	//등록일
	private String regdate;
	
	private String file_Path;
	
	private String detailPath;
	
	private int rnum;
	
	private String sale_detail;
	
	private String product_code;
	
	private Integer banner_seq_id;
	
	

	
	

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getBanner_title() {
		return banner_title;
	}

	public void setBanner_title(String banner_title) {
		this.banner_title = banner_title;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getFile_img() {
		return file_img;
	}

	public void setFile_img(String file_img) {
		this.file_img = file_img;
	}

	public String getProduct_amount() {
		return product_amount;
	}

	public void setProduct_amount(String product_amount) {
		this.product_amount = product_amount;
	}

	public String getDelivery_fee() {
		return delivery_fee;
	}

	public void setDelivery_fee(String delivery_fee) {
		this.delivery_fee = delivery_fee;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_phone() {
		return company_phone;
	}

	public void setCompany_phone(String company_phone) {
		this.company_phone = company_phone;
	}

	public String getDetail_img() {
		return detail_img;
	}

	public void setDetail_img(String detail_img) {
		this.detail_img = detail_img;
	}

	public String getDetail_url() {
		return detail_url;
	}

	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}

	public String getCompany_yn() {
		return company_yn;
	}

	public void setCompany_yn(String company_yn) {
		this.company_yn = company_yn;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getFile_Path() {
		return file_Path;
	}

	public void setFile_Path(String file_Path) {
		this.file_Path = file_Path;
	}

	public String getDetailPath() {
		return detailPath;
	}

	public void setDetailPath(String detailPath) {
		this.detailPath = detailPath;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getSale_detail() {
		return sale_detail;
	}

	public void setSale_detail(String sale_detail) {
		this.sale_detail = sale_detail;
	}

	public Integer getBanner_seq_id() {
		return banner_seq_id;
	}

	public void setBanner_seq_id(Integer banner_seq_id) {
		this.banner_seq_id = banner_seq_id;
	}

//	public void setBanner_img(String banner_img) {
//		this.banner_img = banner_img;
//	}

	public Integer getProduct_seq_id() {
		return product_seq_id;
	}

	public void setProduct_seq_id(Integer product_seq_id) {
		this.product_seq_id = product_seq_id;
	}



	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getLand_url() {
		return land_url;
	}

	public void setLand_url(String land_url) {
		this.land_url = land_url;
	}

	public Integer getSeq_id() {
		return seq_id;
	}

	public void setSeq_id(Integer seq_id) {
		this.seq_id = seq_id;
	}

	public String getBanner_name() {
		return banner_name;
	}

	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}

	
	public String getBanner_img() {
		return banner_img;
	}

	public void setBanner_img(MultipartFile file, String uploadPath, String banner_img) throws IOException {
		if (file != null && !file.isEmpty()) {
			// 새로운 파일이 전달된 경우
			String originalFileName = file.getOriginalFilename();
			String filePath = uploadPath + originalFileName;
			file.transferTo(new File(filePath));
			this.banner_img = filePath;
		} else {
			this.banner_img = getBanner_img();
		}
	}


	public String getBanner_area1() {
		return banner_area1;
	}

	public void setBanner_area1(String banner_area1) {
		this.banner_area1 = banner_area1;
	}

	public String getBanner_area2() {
		return banner_area2;
	}

	public void setBanner_area2(String banner_area2) {
		this.banner_area2 = banner_area2;
	}

	public String getBanner_yn() {
		return banner_yn;
	}

	public void setBanner_yn(String banner_yn) {
		this.banner_yn = banner_yn;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRedate() {
		return redate;
	}

	public void setRedate(String redate) {
		this.redate = redate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "BannerVo [seq_id=" + seq_id + ", product_seq_id=" + product_seq_id + ", banner_name=" + banner_name
				+ ", banner_img=" + banner_img + ", banner_area1=" + banner_area1 + ", banner_area2=" + banner_area2
				+ ", banner_yn=" + banner_yn + ", user_id=" + user_id + ", redate=" + redate + ", code=" + code
				+ ", land_url=" + land_url + ", sale=" + sale + ", banner_title=" + banner_title + ", product_name="
				+ product_name + ", file_img=" + file_img + ", product_amount=" + product_amount + ", delivery_fee="
				+ delivery_fee + ", company_name=" + company_name + ", company_phone=" + company_phone + ", detail_img="
				+ detail_img + ", detail_url=" + detail_url + ", company_yn=" + company_yn + ", regdate=" + regdate
				+ ", file_Path=" + file_Path + ", detailPath=" + detailPath + ", rnum=" + rnum + ", sale_detail="
				+ sale_detail + ", product_code=" + product_code + ", banner_seq_id=" + banner_seq_id + "]";
	}



	


}
