package com.woniu.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniu.util.jdbcUtil;

public class BaseDAO<T> {
	Connection conn;
	PreparedStatement stat;
	ResultSet rs;
	
	public void update(String sql,Object[] objs) {
		try {
			conn=jdbcUtil.getConn();
			stat=conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++) {
				stat.setObject(i+1, objs[i]);
			}
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtil.closeConn(rs, stat, conn);
		}
	}
	//通用查询方法
	public List<T> select(String sql,Object[] objs,Class c){
		List<T> list=new ArrayList<T>();
		
		try {
			conn=jdbcUtil.getConn();
			stat=conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++) {
				stat.setObject(i+1, objs[i]);
			}
			rs=stat.executeQuery();
			
			while(rs.next()) {
				Object obj=c.newInstance();
				Method[] ms=c.getDeclaredMethods();
				for(Method m:ms) {
					String methodName=m.getName();
					if(methodName.startsWith("set")) {
						String paraName=methodName.substring(3).toUpperCase();
						Class[] cs=m.getParameterTypes();
						if(cs[0]==Double.class) {
							m.invoke(obj, rs.getDouble(paraName));
						}else {
							m.invoke(obj, rs.getObject(paraName));
						}
					}
					
				}
				list.add((T) obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
