package com.main.vo;

public class HeartVo {

    private String user_id;
    
    private Integer seq_id;
    
    private Integer heart;
    
    private Integer heart_count;
    
    private String product_name;
    
    private String product_selection;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Integer getSeq_id() {
		return seq_id;
	}

	public void setSeq_id(Integer seq_id) {
		this.seq_id = seq_id;
	}

	public Integer getHeart() {
		return heart;
	}

	public void setHeart(Integer heart) {
		this.heart = heart;
	}

	public Integer getHeart_count() {
		return heart_count;
	}

	public void setHeart_count(Integer heart_count) {
		this.heart_count = heart_count;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_selection() {
		return product_selection;
	}

	public void setProduct_selection(String product_selection) {
		this.product_selection = product_selection;
	}

	@Override
	public String toString() {
		return "HeartVo [user_id=" + user_id + ", seq_id=" + seq_id + ", heart=" + heart + ", heart_count="
				+ heart_count + ", product_name=" + product_name + ", product_selection=" + product_selection + "]";
	}
}