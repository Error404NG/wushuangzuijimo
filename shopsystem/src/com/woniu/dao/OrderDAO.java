package com.woniu.dao;

import java.util.List;

import com.woniu.po.Login;
import com.woniu.po.Order;


public class OrderDAO {
	
	
	BaseDAO <Order> dd  = new BaseDAO<>();
	
	
	
	
	public void save(Order order) {
		String sql ="insert into orde values(?,?,?,?,?,?,?,?,?)";
		Object [] objs = {order.getOid(),order.getOrderno(),order.getPayno(),order.getLid(),order.getAid(),order.getState(),order.getUpdatetime(),order.getCreatetime(),order.getSoftdelete()};
		
		
		dd.update(sql, objs);
		
	}
	public void delete(Integer oid) {
		String sql ="delete from orde where oid =?";
		Object [] objs = {oid};
		
		dd.update(sql, objs);
		
	}
	
	public List<Order> findAll(){
		
		
		String sql ="select * from orde";
		Object[] objs = {};
		List<Order> order =dd.select(sql, objs, Order.class);
		return order;
		
	}
	public Order findOne(Integer oid) {
		// TODO Auto-generated method stub
		String sql ="select * from orde where oid=?";
		Object[] objs = {oid};
		List<Order> order =dd.select(sql, objs, Order.class);
		return order.size()==0?null:order.get(0);

	}
	public void update(Order order) {
		
		String sql ="update orde set orderno=?,payno=?,lid=?,aid=?,state=?,updatetime=?,createtime=?,softdelete=? where oid=?";
		Object [] objs = {order.getOrderno(),order.getPayno(),order.getLid(),order.getAid(),order.getState(),order.getUpdatetime(),order.getCreatetime(),order.getSoftdelete(),order.getOid()};
		dd.update(sql, objs);
		
	}
	public Order findOidByOrderno(String orderno) {
		String sql ="select * from orde where orderno =?";
		Object[] objs = {orderno};
		List<Order> order =dd.select(sql, objs, Order.class);
		return order.size()==0?null:order.get(0);
		
		
		
		
	}
	public List<Order> findOrderByUid(Integer aid){
		
		String sql = "select * from orde where aid=? ";
		Object[] objs = {aid};
		System.out.println(objs);
		return dd.select(sql, objs, Order.class);
		
		
	}
	
	
			
	

}
