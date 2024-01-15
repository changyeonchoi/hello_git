package com.main.service;

import java.util.List;
import java.util.Map;

import com.main.vo.ProductVo;

public interface ProductService {

	///////////공통///////////////
	int selectTotalCount(Map<String, Object> keyword);
	
	////////fahison////////////
	List<ProductVo> selectFashionList(Map<String, Object> map);

	int insertfashion(ProductVo fashionvo);

	ProductVo selectfashiondetail(Integer seq_id);

	String deletefashion(Integer seq_id);

	void updatefashion(ProductVo productvo);


	/////////makeup//////////////

	void updatemakeup(ProductVo productvo);

	void updatecoupon(Map<String, Object> map);

	void productnameupdate(ProductVo productvo);
}
