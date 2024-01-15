package com.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.vo.ProductVo;


@Service(value = "productDao")
public class ProductDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	///////////공통
	public int selectTotalCount(Map<String, Object> keyword) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("productDao.selectTotalCount", keyword);
	}
	/////////////fashion
	public List<ProductVo> selectFashionList(Map<String, Object> map) {
		return sqlSession.selectList("productDao.selectFashionList", map);
	}

	public int insertfashion(ProductVo fashionvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("productDao.insertfashion", fashionvo);
	}

	public ProductVo selectfashiondetail(Integer seq_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("productDao.selectfashiondetail",seq_id);
	}

	public String deletefashion(Integer seq_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("productDao.deletefashion", seq_id);
	}

	public void updatefashion(ProductVo productvo) {
		// TODO Auto-generated method stub
		sqlSession.update("productDao.updateFashion", productvo);
	}
	//////////////////makeup
	public List<ProductVo> selectMakupList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("productDao.selectMakupList", map);
	}
	public void updatemakeup(ProductVo productvo) {
		// TODO Auto-generated method stub
		sqlSession.update("productDao.updatemakeup", productvo);
	}
	public void updatecoupon(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update("productDao.updatecoupon", map);
	}
	public void productnameupdate(ProductVo productvo) {
		// TODO Auto-generated method stub
		sqlSession.update("productDao.productnameupdate", productvo);
	}

}
