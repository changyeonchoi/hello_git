package com.main.vo;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class BannerVo {

	private String seq_id;
	
	private String banner_name;
	
	private String file_img;

	private String banner_area;
	
	private String banner_yn;
	
	private String user_id;
	
	private String redate;
	
	private String code;
	
	private String land_url;

	public String getLand_url() {
		return land_url;
	}

	public void setLand_url(String land_url) {
		this.land_url = land_url;
	}

	public String getSeq_id() {
		return seq_id;
	}

	public void setSeq_id(String seq_id) {
		this.seq_id = seq_id;
	}

	public String getBanner_name() {
		return banner_name;
	}

	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}

	public String getFile_img() {
		return file_img;
	}
	public void setFile_img(MultipartFile file, String uploadPath, String file_img) throws IOException {
	    if (file != null && !file.isEmpty()) {
	        // 새로운 파일이 전달된 경우
	        String originalFileName = file.getOriginalFilename();
	        String filePath = uploadPath + originalFileName;
	        file.transferTo(new File(filePath));
	        this.file_img = filePath;
	    } else {
	    	this.file_img = getFile_img();
	    }
	}
	public String getBanner_area() {
		return banner_area;
	}

	public void setBanner_area(String banner_area) {
		this.banner_area = banner_area;
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
		return "BannerVo [seq_id=" + seq_id + ", banner_name=" + banner_name + ", file_img=" + file_img
				+ ", banner_area=" + banner_area + ", banner_yn=" + banner_yn + ", user_id=" + user_id + ", redate="
				+ redate + ", code=" + code + ", land_url=" + land_url + "]";
	}

	
}
