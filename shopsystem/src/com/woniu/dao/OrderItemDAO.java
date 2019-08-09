package com.woniu.dao;

import java.util.List;

import com.woniu.po.Order;
import com.woniu.po.OrderItem;


public class OrderItemDAO {
	
	
	BaseDAO <OrderItem> dd  = new BaseDAO<>();
	
	
	
	
	public void save(OrderItem orderitem) {
		String sql ="insert into orderitem values(?,?,?,?,?,?,?)";
		Object [] objs = {orderitem.getOiid(),orderitem.getOid(),orderitem.getGname(),orderitem.getGprice(),orderitem.getGpic(),orderitem.getOicount(),orderitem.getSoftdelete()};
		
		
		dd.update(sql, objs);
		
	}
	public void delete(Integer oiid) {
		String sql ="delete from orderitem where ooid =?";
		Object [] objs = {oiid};
		
		dd.update(sql, objs);
		
	}
	
	public Object findAll(){
		
		
		String sql ="select * from orderitem";
		Object[] objs = {};
		return dd.select(sql, objs, OrderItem.class);
		
		
	}
	public OrderItem findOne(Integer oiid) {
		// TODO Auto-generated method stub
		String sql ="select * from orderitem where oiid=?";
		Object[] objs = {oiid};
		List<OrderItem> orderitem =dd.select(sql, objs, OrderItem.class);
		return orderitem.size()==0?null:orderitem.get(0);
		

	}
	public void update(OrderItem orderitem) {
		
		String sql ="update orderitem set oid=?,gname=?,gprice=?,gpic=?,oicount=?,softdelete=? where oiid=?";
		Object [] objs = {orderitem.getOid(),orderitem.getGname(),orderitem.getGprice(),orderitem.getGpic(),orderitem.getOicount(),orderitem.getSoftdelete(),orderitem.getOiid()};
		dd.update(sql, objs);
		
	}

	
			
	

}
