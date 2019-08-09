package com.woniu.dao;

import java.util.List;

import com.woniu.po.Goods;
import com.woniu.po.PageBean;

public class GoodsDAO {
	BaseDAO<Goods> bd=new BaseDAO();
	public  void save(Goods goods) {
		String sql="insert into goods values(?,?,?,?,?,?,?,?)";
		Object[] objs= {goods.getGid(),goods.getGname(),goods.getGprice(),goods.getGinventory(),goods.getGpic(),goods.getGdescribe(),goods.getGtid(),goods.getGsoftdel()};
		bd.update(sql, objs);
	}
	public Goods findOne(Integer gid) {
		String sql="select * from goods where gid=?";
		Object[] objs= {gid};
		List<Goods> goodsList=bd.select(sql, objs, Goods.class);
		return goodsList.size()==0?null:goodsList.get(0);
	}
	public void delete(Integer gid) {
		String sql = "delete from goods where gid=?";
		Object[] objs = {gid};
		bd.update(sql, objs);
		
	}
	public List<Goods> findAll() {
		String sql = "select * from goods";
		Object[] objs = {};
		return bd.select(sql, objs, Goods.class);
	}
	public List<Goods> findAllByType(Integer gtid) {
		String sql = "select * from goods where gtid=?";
		Object[] objs = {gtid};
		return bd.select(sql, objs, Goods.class);
	}
	public List<Goods> findAllByType(Integer gtid,PageBean pb) {
		String sql = "select * from goods where gtid=? limit ?,?";
		Object[] objs = {gtid,(pb.getPageNum()-1)*pb.getPageRow(),pb.getPageRow()};
		return bd.select(sql, objs, Goods.class);
	}
	public void update(Goods goods) {
		String sql = "update goods set gname=?,gprice=?,ginventory=?,gpic=?,gdescribe=?,gtid=?,gsoftdel=? where gid=?";
		Object[] objs = {goods.getGname(),goods.getGprice(),goods.getGinventory(),goods.getGpic(),goods.getGdescribe(),goods.getGtid(),goods.getGsoftdel(),goods.getGid()};
		bd.update(sql, objs);
	}
}
