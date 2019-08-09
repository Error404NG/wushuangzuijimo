package com.woniu.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.dao.DAOFactory;
import com.woniu.po.Goods;

/**
 * Servlet implementation class ShopCareAction
 */
@WebServlet("/shopcar.action")
public class ShopCareAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopCareAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method) {
		case "list":
			list(request, response);
			break;
		case "add":
			add(request, response);
			break;
		case "remove":
			remove(request, response);
			break;

		}

	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer gid = Integer.parseInt(request.getParameter("gid"));
		Map<Integer, Integer> carts = (Map<Integer, Integer>) request.getSession().getAttribute("carts");
		carts.remove(gid);
		request.getSession().setAttribute("carts", carts);
		response.sendRedirect("shopcar.action?method=list");//重定向
		
		
	
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("123");
		Integer gid = Integer.parseInt(request.getParameter("gid"));
		Integer num = 1;
		if (request.getParameter("num") != null) {
			num = Integer.parseInt(request.getParameter("num"));

		}
		Map<Integer, Integer> carts = (Map<Integer, Integer>) request.getSession().getAttribute("carts");

		if (carts == null) {
			carts = new HashMap<Integer, Integer>();

		}
		Integer temp = carts.get(gid);

		if (temp == null) {
			carts.put(gid, num);

		} else {
			carts.put(gid, num + temp);

		}
		//通过添加 商品到map集合中
		request.getSession().setAttribute("carts", carts);

	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取 集合 carts中的内容
		Map<Integer, Integer> carts = (Map<Integer, Integer>) request.getSession().getAttribute("carts");
		if (carts == null) {
			carts = new HashMap<Integer, Integer>();

		}
		Set<Integer> keys = carts.keySet();

		Iterator<Integer> it = keys.iterator();

		Map<Goods, Integer> goodsList = new HashMap<Goods, Integer>();

		while (it.hasNext()) {
			Integer key = it.next();
			Goods goods = DAOFactory.getGoodsDAO().findOne(key);
			Integer num = carts.get(key);
			goodsList.put(goods, num);

		}
		request.setAttribute("goodsMap", goodsList);
		
		request.getRequestDispatcher("shopcar.jsp").forward(request, response);

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
