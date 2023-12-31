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
	public ProductVo selectfashiondetail(String seq_id) {
		// TODO Auto-generated method stub
		return productDao.selectfashiondetail(seq_id);
	}

	@Override
	public String deletefashion(String seq_id) {
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
}