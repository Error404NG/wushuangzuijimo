package com.woniu.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.dao.DAOFactory;
import com.woniu.po.Role;

/**
 * Servlet implementation class RoleAction
 */
@WebServlet("/role.action")
public class RoleAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		switch(method) {
		case "list":
			list(request,response);
			break;
		case "add":
			add(request,response);
			break;
			
			
			
		
		}
		
		
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String rname = request.getParameter("rname");
		Integer softdelete = Integer.parseInt(request.getParameter("softdelete"));
		Role r = new Role(null,rname,softdelete);
		DAOFactory.getRoleDAO().save(r);
		response.sendRedirect("role.action?method=list");//÷ÿ∂®œÚ
		
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list", DAOFactory.getRoleDAO().findAll());
		request.getRequestDispatcher("roleList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
