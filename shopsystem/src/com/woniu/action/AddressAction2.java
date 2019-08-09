package com.woniu.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.dao.DAOFactory;
import com.woniu.po.Address;
import com.woniu.po.Login;

/**
 * Servlet implementation class UserAction
 */
@WebServlet("/address.action")
public class AddressAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddressAction() {
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
		case "list":
			list(request, response);
			break;
		case "add":
			add(request, response);
			break;

		}

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String aname = request.getParameter("aname");
		String atelephoneno = request.getParameter("atelephoneno");
		String aprovince = request.getParameter("aprovince");
		String acity = request.getParameter("acity");
		String acounty = request.getParameter("acounty");
		String atown = request.getParameter("atown");
		String addressinfos = request.getParameter("addressinfos");

		Integer lid = ((Login)request.getSession().getAttribute("loginuser")).getLid();
		
		Address address = new Address(null, lid, aname, atelephoneno, aprovince, acity, acounty, atown, addressinfos,
				null, new Date(), 1);

		DAOFactory.getAddressDAO().save(address);

		response.sendRedirect("address.action?method=list");

	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<Address> addList = DAOFactory.getAddressDAO().findAll();
		request.setAttribute("list", addList);
		request.getRequestDispatcher("address.jsp").forward(request, response);

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
