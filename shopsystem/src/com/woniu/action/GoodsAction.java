package com.woniu.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.woniu.dao.DAOFactory;
import com.woniu.po.Goods;
import com.woniu.po.PageBean;

/**
 * Servlet implementation class GoodsType
 */
@WebServlet("/goods.action")
public class GoodsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 声明一个method参数从界面上获取
		String method = request.getParameter("method") == null ? "" : request.getParameter("method");
		switch (method) {

		case "list":
			list(request, response);
			break;
	
		case "addForm":
			addForm(request, response);
			break;
		case "add":
			add(request, response);
			break;
		case "getGoodsByGtid":
			getGoodsByGtid(request, response);
			break;
		case "changeState":
			changeState(request, response);
			break;
		case "goodsGet":
			goodsGet(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
			

		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer gid = Integer.parseInt(request.getParameter("gid"));
		System.out.println(gid);			
		Goods goods = DAOFactory.getGoodsDAO().findOne(gid);
		
		
		
		
		
	
		
		/*String dir = request.getServletContext().getRealPath("/"+goods.getGpic());
		File file = new File(dir);
		if(file.exists()) {
			file.delete();
			
		}
		System.out.println(dir);*/
		DAOFactory.getGoodsDAO().delete(gid);
		response.sendRedirect("goods.action?method=list");
		
	}

	private void goodsGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer gid = Integer.parseInt(request.getParameter("gid"));
		Goods goods = DAOFactory.getGoodsDAO().findOne(gid);
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("goodinfo.jsp").forward(request, response);
		
		
		
		
		
	}

	private void addForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list", DAOFactory.getGoodsTypeDAO().findAll());
		request.getRequestDispatcher("goodsAdd.jsp").forward(request, response);
		
	}

	private void changeState(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer gid = Integer.parseInt(request.getParameter("gid"));
		Goods goods =DAOFactory.getGoodsDAO().findOne(gid);
		goods.setGsoftdel(goods.getGsoftdel()==0?1:0);
		DAOFactory.getGoodsDAO().update(goods);
		response.sendRedirect("goods.action?method=list");
		
		
	}

	private void getGoodsByGtid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Integer gtid = Integer.parseInt(request.getParameter("gtid"));
		PageBean pb = new PageBean();
		pb.setPageNum(1);
		if(request.getParameter("pageNum")!=null) {
			pb.setPageNum(Integer.parseInt(request.getParameter("pageNum")));
			
		}
		pb.setPageRow(10);
		List<Goods> all = DAOFactory.getGoodsDAO().findAllByType(gtid);
		pb.setCountRow(all.size());
		pb.setCountPage(pb.getCountRow()%pb.getPageRow()==0?pb.getCountRow()/pb.getPageRow():pb.getCountRow()/pb.getPageRow()+1);
		List<Goods> list =DAOFactory.getGoodsDAO().findAllByType(gtid, pb);
		request.setAttribute("list", list);
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("goodsListByType.jsp").forward(request, response);
		
		
		
		
	}

	



	
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		com.woniu.po.Goods goods = new com.woniu.po.Goods();

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解析请求对象
		List<FileItem> items;

		try {
			items = upload.parseRequest(request);
			for (FileItem item : items) {
				if(item.isFormField()){
					String fieldName = item.getFieldName();
					switch(fieldName){
						case "gid":
							goods.setGid(Integer.parseInt(item.getString()));
							break;
						case "gname":
							goods.setGname(item.getString("utf-8"));
							break;
						case "gprice":
							goods.setGprice(Double.parseDouble(item.getString()));
							break;
						case "ginventory":
							goods.setGinventory(Integer.parseInt(item.getString()));
							break;
						case "gdescribe":
							goods.setGdescribe(item.getString("utf-8"));
							break;
						case "gtid":
							goods.setGtid(Integer.parseInt(item.getString()));
							break;
						case "gsoftdel":
							goods.setGsoftdel(Integer.parseInt(item.getString()));
							break;
					}

				} else {
					String fileName = item.getName();
					
					String newName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
					String dirStr = request.getServletContext().getRealPath("/upload");
					/*System.out.println(dirStr);*/

					File file = new File(dirStr + File.separator + newName);
					item.write(file);
					goods.setGpic("upload/" + newName);

				}

			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DAOFactory.getGoodsDAO().save(goods);
		response.sendRedirect("goods.action?method=list");

	}


	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list", DAOFactory.getGoodsDAO().findAll());
		// 跳转页面
		request.getRequestDispatcher("goodslist.jsp").forward(request, response);

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
