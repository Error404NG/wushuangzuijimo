package com.woniu.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.woniu.dao.AddressDAO;
import com.woniu.dao.RoleDAO;
import com.woniu.po.Address;
import com.woniu.po.Role;

class AddressDAOTest {

	@Test
	void test() {
		
		AddressDAO dd = new AddressDAO();
		List<Address> address =dd.findAll();
		
		for(Address c : address) {
			System.out.println(c);
			
		}
		
		
	}
	@Test
	void testfind() {
		
		RoleDAO dd = new RoleDAO();
		
		List<Role> role = dd.findAll();
		
		for(Role c : role) {
			System.out.println(c);
			
		}
		
		
	}

}
