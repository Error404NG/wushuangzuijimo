
package com.woniu.dao;

import java.util.List;

import com.woniu.po.Login;

public class LoginDAO {
	
	
	BaseDAO <Login> dd  = new BaseDAO<>();
	
	
	
	
	public void save(Login login) {
		String sql ="insert into login values(?,?,?,?,?,?,?)";
		Object [] objs = {login.getLid(),login.getLname(),login.getLpwd(),login.getRid(),login.getUpdatetime(),login.getCreatedtime(),login.getSoftdelete()};
		
		
		dd.update(sql, objs);
		
	}
	public void delete(Integer lid) {
		String sql ="delete from login where lid =?";
		Object [] objs = {lid};
		
		dd.update(sql, objs);
		
	}
	
	public List<Login> findAll(){
		
		
		String sql ="select * from login";
		Object[] objs = {};
		List<Login> login =dd.select(sql, objs, Login.class);
		return login;
		
	}
	public Login findOne(Integer lid) {
		// TODO Auto-generated method stub
		String sql ="select * from login where lid=?";
		Object[] objs = {lid};
		List<Login> login =dd.select(sql, objs, Login.class);
		return login.size()==0?null:login.get(0);

	}
	public void update( Login login) {
		
		String sql ="update login set lname=?,lpwd=?,rid=?,updatetime=?,createtime=?,softdelete=? where lid=?";
		Object [] objs = {login.getLname(),login.getLpwd(),login.getRid(),login.getUpdatetime(),login.getCreatedtime(),login.getSoftdelete(),login.getLid()};
		dd.update(sql, objs);
		
	}
	
	public Login login(Login u) {
		String sql ="select * from login where lname =? and lpwd=?";
		Object [] objs = {u.getLname(),u.getLpwd()};
		List<Login> goodsList = dd.select(sql, objs, Login.class);
		return goodsList.size()==0?null:goodsList.get(0);
		
	}

	
			
	

}
