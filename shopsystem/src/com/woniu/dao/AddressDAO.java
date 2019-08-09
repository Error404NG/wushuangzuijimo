package com.woniu.dao;

import java.util.List;

import com.woniu.po.Address;

public class AddressDAO {
	
	
	BaseDAO <Address> dd  = new BaseDAO<>();
	
	
	
	
	public void save(Address address) {
		String sql ="insert into address values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object [] objs = {address.getAid(),address.getLid(),address.getAname(),address.getAtelephoneno(),address.getAprovince(),address.getAcity(),address.getAcounty(),address.getAtown(),address.getAddressinfos(),address.getUpdatetime(),address.getCreatetime(),address.getSoftdelete()};
		
		
		dd.update(sql, objs);
		
	}
	public void delete(Integer aid) {
		String sql ="delete from address where aid =?";
		Object [] objs = {aid};
		
		dd.update(sql, objs);
		
	}
	
	public List<Address> findAll(){
		
		
		String sql ="select * from address";
		Object[] objs = {};
		List<Address> address =dd.select(sql, objs, Address.class);
		return address;
		
	}
	public Address findOne(Integer aid) {
		// TODO Auto-generated method stub
		String sql ="select * from address where aid=?";
		Object[] objs = {aid};
		List<Address> address =dd.select(sql, objs, Address.class);
		return address.size()==0?null:address.get(0);

	}
	public void update(Address address) {
		
		String sql ="update address set lid=?, aname=?, atelephoneno=?, aprovince=?, acity=?,acounty=?,atown=?,addressinfos=?updatetime=?,createtime=?,softdelete=? where aid=?";
		Object [] objs = {address.getLid(),address.getAname(),address.getAtelephoneno(),address.getAprovince(),address.getAcity(),address.getAcounty(),address.getAtown(),address.getAddressinfos(),address.getUpdatetime(),address.getCreatetime(),address.getSoftdelete(),address.getAid()};
		dd.update(sql, objs);
		
	}

	
			
	

}
