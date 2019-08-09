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

/**
 * Servlet implementation class GoodsType
 */
@WebServlet("/goodsType.action")
public class GoodsTypeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoodsTypeAction() {
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
		case "front":
			front(request, response);
			break;
		case "add":
			add(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		case "goodsGet":
			goodsGet(request, response);
			break;
		case "edit":
			edit(request, response);
			break;

		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		com.woniu.po.GoodsType gt = new com.woniu.po.GoodsType();

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解析请求对象
		List<FileItem> items;

		try {
			items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					String fieldName = item.getFieldName();
					if (fieldName.equals("gtid")) {
						gt.setGtid(Integer.parseInt(item.getString()));

					} else if (fieldName.equals("gtname")) {
						gt.setGtname(item.getString("utf-8"));

					} else if (fieldName.equals("gtdescript")) {
						gt.setGtdescript(item.getString("utf-8"));

					} else if (fieldName.equals("gtforetypeno")) {
						gt.setGtforetypeno(Integer.parseInt(item.getString()));

					} else if (fieldName.equals("softdelete")) {
						gt.setSoftdelete(Integer.parseInt(item.getString()));

					}

				} else {
					com.woniu.po.GoodsType g2 =DAOFactory.getGoodsTypeDAO().findOne(gt.getGtid());
					
					String fileName = item.getName();
					String dirStr = request.getServletContext().getRealPath("/upload");
					String newFileName=g2.getGtpic().substring(g2.getGtname().lastIndexOf("/")+1);
					

					System.out.println(dirStr);

					File file = new File(dirStr,newFileName);
					item.write(file);
					gt.setGtpic(g2.getGtpic());

				}

			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DAOFactory.getGoodsTypeDAO().update(gt);
		response.sendRedirect("goodsType.action?method=list");

	}

	private void goodsGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer gtid = Integer.parseInt(request.getParameter("gtid"));
		request.setAttribute("goodsType", DAOFactory.getGoodsTypeDAO().findOne(gtid));
		request.getRequestDispatcher("edit.jsp").forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer gtid = Integer.parseInt(request.getParameter("gtid"));
		com.woniu.po.GoodsType goodstype = DAOFactory.getGoodsTypeDAO().findOne(gtid);
		String dirStr = request.getServletContext().getRealPath("/");
		File file = new File(dirStr + goodstype.getGtpic());
		file.delete();
		DAOFactory.getGoodsTypeDAO().delete(gtid);
		response.sendRedirect("goodsType.action?method=list");

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		com.woniu.po.GoodsType gt = new com.woniu.po.GoodsType();

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解析请求对象
		List<FileItem> items;

		try {
			items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (item.isFormField()) {
					String fieldName = item.getFieldName();
					if (fieldName.equals("gtid")) {
						gt.setGtid(Integer.parseInt(item.getString()));

					} else if (fieldName.equals("gtname")) {
						gt.setGtname(item.getString("utf-8"));

					} else if (fieldName.equals("gtdescript")) {
						gt.setGtdescript(item.getString("utf-8"));

					} else if (fieldName.equals("gtforetypeno")) {
						gt.setGtforetypeno(Integer.parseInt(item.getString()));

					} else if (fieldName.equals("softdelete")) {
						gt.setSoftdelete(Integer.parseInt(item.getString()));

					}

				} else {
					String fileName = item.getName();
					String dirStr = request.getServletContext().getRealPath("/upload");
					String newName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));

					System.out.println(dirStr);

					File file = new File(dirStr + File.separator + newName);
					item.write(file);
					gt.setGtpic("upload/" + newName);

				}

			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DAOFactory.getGoodsTypeDAO().save(gt);
		response.sendRedirect("goodsType.action?method=list");

	}

	private void front(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list", DAOFactory.getGoodsTypeDAO().findAll());
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list", DAOFactory.getGoodsTypeDAO().findAll());
		// 跳转页面
		request.getRequestDispatcher("backindex.jsp").forward(request, response);

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
