package com.woniu.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.woniu.dao.GoodsTypeDAO;
import com.woniu.po.GoodsType;

class GoodsTypeDAOTest {

	@Test
	void test() {
			GoodsTypeDAO dd = new GoodsTypeDAO();
			
			List<GoodsType> goodstype = dd.findAll();
			for(GoodsType c : goodstype) {
				
				System.out.println(c);
				
			}
	}

}
