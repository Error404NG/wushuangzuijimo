package com.woniu.dao;

import java.util.List;

import com.woniu.po.GoodsType;

public class GoodsTypeDAO {
	
	
	BaseDAO <GoodsType> dd  = new BaseDAO<>();
	
	
	
	
	public void save(GoodsType goodsType) {
		String sql ="insert into goodsType values(?,?,?,?,?,?)";
		Object [] objs = {goodsType.getGtid(),goodsType.getGtname(),goodsType.getGtpic(),goodsType.getGtdescript(),goodsType.getGtforetypeno(),goodsType.getSoftdelete()};
		
		dd.update(sql, objs);
		
	}
	public void delete(Integer gtid) {
		String sql ="delete from goodsType where gtid =?";
		Object [] objs = {gtid};
		
		dd.update(sql, objs);
		
	}
	
	public List<GoodsType> findAll(){
		
		
		String sql ="select * from goodsType";
		Object[] objs = {};
		List<GoodsType> goodsType =dd.select(sql, objs, GoodsType.class);
		return goodsType;
		
	}
	public GoodsType findOne(Integer gtid) {
		// TODO Auto-generated method stub
		String sql ="select * from goodsType where gtid=?";
		Object[] objs = {gtid};
		List<GoodsType> goodsType =dd.select(sql, objs, GoodsType.class);
		return goodsType.size()==0?null:goodsType.get(0);

	}
	public void update( GoodsType goodsType) {
		
		String sql ="update goodsType set gtname=?,gtpic=?,gtdescript=?,gtforetypeno=?,softdelete=? where gtid=?";
		Object [] objs = {goodsType.getGtname(),goodsType.getGtpic(),goodsType.getGtdescript(),goodsType.getGtforetypeno(),goodsType.getSoftdelete(),goodsType.getGtid()};
		dd.update(sql, objs);
		
	}

	
			
	

}
