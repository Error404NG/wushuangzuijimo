package com.woniu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.dao.DAOFactory;
import com.woniu.po.Login;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserAction
 */
@WebServlet("/login.action")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method") == null ? "" : request.getParameter("method");

		switch (method) {
		case "reg":
			reg(request, response);
			break;
		case "login":
			login(request, response);
			break;
		case "exit":
			exit(request, response);
			break;
		case "loginajax":
		loginajax(request,response);
		break;

		}

	}

	private void loginajax(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String lname=request.getParameter("lname");
		String lpwd = request.getParameter("lpwd");
		
		Login u = new Login();
		u.setLname(lname);
		u.setLpwd(lpwd);
		
		Login loginuser=DAOFactory.getLoginDAO().login(u);
		
		
		String message="{'result':'no'}";
		if(loginuser!=null) {
			request.getSession().setAttribute("loginuser", loginuser);
			JSONObject json = JSONObject.fromObject(loginuser);
			message = json.toString();
			
			
		}
		PrintWriter pw = response.getWriter();
		pw.println(message);
		pw.flush();
		pw.close();
		
		
		
		
		
	}

	private void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("loginuser");
		response.sendRedirect("goodsType.action?method=front");

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String lname = request.getParameter("lname");
		String lpwd = request.getParameter("lpwd");
		Login u = new Login();
		u.setLname(lname);
		u.setLpwd(lpwd);
		Login loginuser = DAOFactory.getLoginDAO().login(u);
		if (loginuser != null) {
			request.getSession().setAttribute("loginuser", loginuser);

		}
		response.sendRedirect("goodsType.action?method=front");

	}

	private void reg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String lname = request.getParameter("lname");
		String lpwd = request.getParameter("lpwd");
		Login u = new Login();
		u.setCreatedtime(new Date());
		u.setSoftdelete(1);
		u.setLname(lname);
		u.setLpwd(lpwd);
		u.setRid(2);
		DAOFactory.getLoginDAO().save(u);
		response.sendRedirect("goodsType.action?method=front");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
