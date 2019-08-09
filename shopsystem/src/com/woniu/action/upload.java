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

@WebServlet("/upload.do")
public class upload extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public upload(){
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Goods goods = new Goods();
		goods.setGid(null);
		
		//设置磁盘文件信息
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//上传文件生成
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//解析请求对象中的表单信息
		
		try {
			List<FileItem> items = upload.parseRequest(req);
			String dirStr = req.getServletContext().getRealPath("/upload");
			System.out.println(dirStr);
			
			
			
			for(FileItem item:items) {
				//判断是普通表单元素还是上传元素
				
				if(item.isFormField()) {
					String fieldName = item.getFieldName();
					if(fieldName.equals("gname")) {
						goods.setGname(item.getString("utf-8"));
						
					}else if(fieldName.equals("gprice")) {
						goods.setGprice(Double.parseDouble(item.getString()));
						
					}
					
				}else {
					String fName = item.getName();
					fName = UUID.randomUUID()+fName.substring(fName.lastIndexOf("."));
					//System.out.println(fName);
					File file = new File(dirStr,fName);
					item.write(file);
					goods.setGpic("/upload/"+fName);
					
				}
			
				
				
			}
			System.out.println(goods);
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(goods);
		DAOFactory.getGoodsDAO().save(goods);
		resp.sendRedirect("goodsAll.do");
		
		
		
		
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		
	}
	
	
	
	
	
	

}
