package com.woniu.dao;

import java.util.List;

import com.woniu.po.Goods;
import com.woniu.po.Role;

public class RoleDAO {
	
	
	BaseDAO <Role> dd  = new BaseDAO<>();
	
	
	
	
	public void save(Role role) {
		String sql ="insert into role values(?,?,?)";
		Object [] objs = {role.getRid(),role.getRname(),role.getSoftdelete()};
		
		dd.update(sql, objs);
		
	}
	public void delete(Integer rid) {
		String sql ="delete from role where rid =?";
		Object [] objs = {rid};
		
		dd.update(sql, objs);
		
	}
	
	public List<Role> findAll(){
		
		
		String sql ="select * from role";
		Object[] objs = {};
		List<Role> role =dd.select(sql, objs, Role.class);
		return role;
		
	}
	public Role findOne(Integer rid) {
		// TODO Auto-generated method stub
		String sql ="select * from role where rid=?";
		Object[] objs = {rid};
		List<Role> role =dd.select(sql, objs, Role.class);
		return role.size()==0?null:role.get(0);

	}
	public void update( Role role) {
		
		String sql ="update role set rname=?,softdelete=? where rid=?";
		Object [] objs = {role.getRname(),role.getSoftdelete(),role.getRid()};
		dd.update(sql, objs);
		
	}

	
			
	

}
