package com.woniu.dao;

public class DAOFactory {
	public static GoodsDAO getGoodsDAO() {
		return new GoodsDAO();
		
		
	}
	public  static RoleDAO getRoleDAO() {
		
		return new RoleDAO();
		
	}
	public static AddressDAO getAddressDAO() {
		
		return new AddressDAO();
	}
	public static GoodsTypeDAO getGoodsTypeDAO() {
	
	return new GoodsTypeDAO();
	}
	public static LoginDAO getLoginDAO() {
		
		return new LoginDAO();
	}
	public static OrderDAO  getOrderDAO() {
		return new OrderDAO();
	}
	public static OrderItemDAO getOrderItemDAO() {
		
		return new OrderItemDAO();
		
	}
	
	
	



}
