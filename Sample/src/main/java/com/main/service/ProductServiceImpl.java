package com.main.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.main.dao.ProductDao;
import com.main.vo.ProductVo;


@Service(value = "productservice")
public class ProductServiceImpl implements ProductService {

	@Resource(name = "productDao")
	private ProductDao productDao;

	////////////////////////////////공통
	@Override
	public int selectTotalCount(Map<String, Object> keyword) {
		// TODO Auto-generated method stub
		return productDao.selectTotalCount(keyword);
	}
	
	////////////////////////////fashion
	@Override
	public List<ProductVo> selectFashionList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<ProductVo> productList = null;
		
		productList = productDao.selectFashionList(map);
		
		return productList;
	}

	@Override
	public int insertfashion(ProductVo fashionvo) {
		// TODO Auto-generated method stub
		return productDao.insertfashion(fashionvo);
	}

	@Override
	public ProductVo selectfashiondetail(Integer seq_id) {
		// TODO Auto-generated method stub
		return productDao.selectfashiondetail(seq_id);
	}

	@Override
	public String deletefashion(Integer seq_id) {
		// TODO Auto-generated method stub
		return productDao.deletefashion(seq_id);
	}

	@Override
	public void updatefashion(ProductVo productvo) {
		// TODO Auto-generated method stub
		productDao.updatefashion(productvo);
	}

	@Override
	public void updatemakeup(ProductVo productvo) {
		// TODO Auto-generated method stub
		productDao.updatemakeup(productvo);
	}

//	@Override
//	public void updatecoupon(ProductVo productvo) {
//		// TODO Auto-generated method stub
//		productDao.updatecoupon(productvo);
//	}

	@Override
	public void updatecoupon(Map<String, Object> map) {
		// TODO Auto-generated method stub
		productDao.updatecoupon(map);
	}

	@Override
	public void productnameupdate(ProductVo productvo) {
		// TODO Auto-generated method stub
		productDao.productnameupdate(productvo);
	}
}