package com.main.vo;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;



public class ProductVo {
	
	//pk
	private Integer seq_id;
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
	//코드명
	private String code;
	//등록자ID
	private String user_id;
	//등록일
	private String regdate;
	
	private String file_Path;
	
	private String detailPath;
	
	private int rnum;
	
	private String sale_detail;
	
	private String banner_name;
	
	private String product_seq_id;
	
	private Integer banner_seq_id;
	
	
	
	public Integer getBanner_seq_id() {
		return banner_seq_id;
	}
	public void setBanner_seq_id(Integer banner_seq_id) {
		this.banner_seq_id = banner_seq_id;
	}
	public String getProduct_seq_id() {
		return product_seq_id;
	}
	public void setProduct_seq_id(String product_seq_id) {
		this.product_seq_id = product_seq_id;
	}
	public String getBanner_name() {
		return banner_name;
	}
	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}
	public String getSale_detail() {
		return sale_detail;
	}
	public void setSale_detail(String sale_detail) {
		this.sale_detail = sale_detail;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getFile_img() {
		return file_img;
	}
	public void setFile_img(MultipartFile file, String uploadPath, String file_img) throws IOException {
	    // 만약 전달된 파일이 존재하고 비어있지 않다면
	    if (file != null && !file.isEmpty()) {
	        // 새로운 파일이 전달된 경우

	        // 전달된 파일의 원본 파일명을 가져옴
	        String originalFileName = file.getOriginalFilename();
	        
	        // 파일을 저장할 경로를 지정 (uploadPath + 원본 파일명)
	        String filePath = uploadPath + originalFileName;
	        
	        // 파일을 지정된 경로에 저장
	        file.transferTo(new File(filePath));
	        
	        // 객체 내의 file_img 변수에 저장된 파일 경로를 업데이트
	        this.file_img = filePath;
	    } else {
	        // 전달된 파일이 없거나 비어있는 경우

	        // 기존의 file_img 변수 값을 유지
	        this.file_img = getFile_img();
	    }
	}
	public String getDetail_img() {
		return detail_img;
	}
    public void setDetail_img(MultipartFile file, String uploadPath, String detail_img) throws IOException {
    	if (file != null && !file.isEmpty()) {
    		String originalFileName = file.getOriginalFilename();
    		String detailPath = uploadPath + originalFileName;
    		file.transferTo(new File(detailPath));
    		this.detail_img = detailPath;
    	} else {
    		this.file_img = getDetail_img();
    	}
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
	public String getFilePath() {
		return file_Path;
	}
	public void setFilePath(String file_Path) {
		this.file_Path = file_Path;
	}
	public Integer getSeq_id() {
		return seq_id;
	}
	public void setSeq_id(Integer seq_id) {
		this.seq_id = seq_id;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getProduct_amonut() {
		return product_amount;
	}
	public void setProduct_amonut(String product_amount) {
		this.product_amount = product_amount;
	}
	
	@Override
	public String toString() {
		return "ProductVo [seq_id=" + seq_id + ", banner_title=" + banner_title + ", product_name=" + product_name
				+ ", file_img=" + file_img + ", product_amount=" + product_amount + ", delivery_fee=" + delivery_fee
				+ ", company_name=" + company_name + ", company_phone=" + company_phone + ", detail_img=" + detail_img
				+ ", detail_url=" + detail_url + ", company_yn=" + company_yn + ", code=" + code + ", user_id="
				+ user_id + ", regdate=" + regdate + ", file_Path=" + file_Path + ", detailPath=" + detailPath
				+ ", rnum=" + rnum + ", sale_detail=" + sale_detail + ", banner_name=" + banner_name
				+ ", product_seq_id=" + product_seq_id + ", banner_seq_id=" + banner_seq_id + "]";
	}


	
	
}
