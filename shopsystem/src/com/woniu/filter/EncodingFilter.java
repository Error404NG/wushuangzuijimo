package com.woniu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter  implements Filter {
	
	String encode;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("�ַ������ʽ������");
		//������������ñ����ʽ
		arg0.setCharacterEncoding("utf-8");
		 //����Ӧ�������ñ����ʽ
		arg1.setCharacterEncoding("utf-8");
		//����������
		//����ִ��
		arg2.doFilter(arg0, arg1);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("����");
		encode = filterConfig.getInitParameter("encode");
		
		
	}

}
