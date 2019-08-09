package com.woniu.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.dao.DAOFactory;
import com.woniu.po.Goods;

/**
 * Servlet implementation class GoodsAll
 */
@WebServlet("/goodsDelete.do")
public class GoodsDelete extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Integer gid = Integer.parseInt(request.getParameter("gid"));
		Goods goods = DAOFactory.getGoodsDAO().findOne(gid);
		
		
		
	
		
		
		String dir = request.getServletContext().getRealPath("/"+goods.getGpic());
		File file = new File(dir);
		if(file.exists()) {
			file.delete();
			
		}
		System.out.println(dir);
		DAOFactory.getGoodsDAO().delete(gid);
		response.sendRedirect("goodsAll.do");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
