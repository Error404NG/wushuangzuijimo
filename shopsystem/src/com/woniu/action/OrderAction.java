package com.woniu.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.woniu.dao.DAOFactory;
import com.woniu.po.Address;
import com.woniu.po.Goods;
import com.woniu.po.Login;
import com.woniu.po.Order;
import com.woniu.po.OrderItem;
import com.woniu.util.Utils;

/**
 * Servlet implementation class OrderAction
 */
@WebServlet("/order.action")
public class OrderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method =request.getParameter("method");
		switch(method) {
		case "add":
			add(request,response);
			break;
		case "del":
			del(request,response);
			break;
		case "list":
			list(request,response);
			break;
		case "orderList":
			orderList(request,response);
			break;
			
		
		}
		
		
		
	}

	private void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("orderList", DAOFactory.getOrderDAO().findOrderByUid(((Login)request.getSession().getAttribute("loginuser")).getLid()));
		request.setAttribute("orderItemList", DAOFactory.getOrderItemDAO().findAll());
		request.getRequestDispatcher("allorder.jsp").forward(request, response);
		
		
		
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<Integer, Integer> carts = (Map<Integer, Integer>) request.getSession().getAttribute("carts");
		if(carts==null) {
			carts = new HashMap<Integer, Integer>();
			
			
		}
		Set<Integer> keys = carts.keySet();
		
		Iterator<Integer> it =keys.iterator();
		
		Map<Goods, Integer> goodsList = new HashMap<>();
		while(it.hasNext()) {
			Integer key =it.next();
			Goods goods = DAOFactory.getGoodsDAO().findOne(key);
			Integer num = carts.get(key);
			goodsList.put(goods, num);
			
			
		}
		request.setAttribute("goodsMap", goodsList);
		
		Long l = Utils.getTime();
		request.setAttribute("l", l);
		
		
		
		List<Address> addList = DAOFactory.getAddressDAO().findAll();
		request.setAttribute("list", addList);
		request.getRequestDispatcher("order.jsp").forward(request, response);
		
		
		
		
	}

	private void del(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//添加订单
		
		String orderno=request.getParameter("orderno");
		System.out.println(orderno);
		Integer aid = Integer.parseInt(request.getParameter("aid"));
		System.out.println(aid);
		
		Integer lid = ((Login) request.getSession().getAttribute("loginuser")).getLid();
		
		
		System.out.println(lid);
		
		
		Order order=  new Order(null, orderno, "", lid, aid, 1, null, new Date(), 1);
		
		DAOFactory.getOrderDAO().save(order);
		System.out.println("--------------");

		
		
/*		System.out.println(orderno);
*/		
		
		
		
		//添加订单项
		Order o = DAOFactory.getOrderDAO().findOidByOrderno(orderno);
		System.out.println(o.toString());
		
		Map<Integer, Integer> carts = (Map<Integer, Integer>) request.getSession().getAttribute("carts");
		
		Set<Integer> keys = carts.keySet();

		Iterator<Integer> it = keys.iterator();
		
		while (it.hasNext()) {
			Integer gid = it.next();
			Integer num =carts.get(gid);
			Goods goods =DAOFactory.getGoodsDAO().findOne(gid);
			
			OrderItem orderitem = new OrderItem(null, o.getOid(), goods.getGname(), goods.getGprice(), goods.getGpic(), num, 1);
			DAOFactory.getOrderItemDAO().save(orderitem);
		}
		
		
		response.sendRedirect("order.action?method=orderList");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
