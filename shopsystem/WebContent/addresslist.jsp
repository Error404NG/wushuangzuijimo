<%@ page language="java" 
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
		<center><caption><h1>收货人信息</h1></caption></center>
	<table width="800" border="1"
		class="table table-striped table-hover table-condensed table-borered ">
		
		<tr>
		<th>编号</th>
		<th>商品编号</th>
		<th>收货人姓名</th>
		<th>收货人电话</th>
		<th>省</th>
		<th>市</th>
		<th>区</th>
		<th>镇/街道</th>
		<th>详细地址</th>
		<th>更新时间</th>
		<th>创建时间</th>
		<th>软删除</th>
		<th>编辑</th>
		<th>删除</th>
		
		
		
		
		</tr>
		<c:forEach items="${list }" var ="u" varStatus="i">
		
		<tr>
		<th>${i.index+1 }</th>
		<th>${u.lid }</th>
		<th>${u.aname }</th>
		<th>${u.atelephoneno }</th>
		<th>${u.aprovince }</th>
		<th>${u.acity }</th>
		<th>${u.acounty }</th>
		<th>${u.atown }</th>
		<th>${u.addressinfos }</th>
		<th>${u.updatetime }</th>
		<th>${u.createtime }</th>
		<th>${u.softdelete }</th>
		<th><button class="btn btn-warning">${u.aid }</button></th>
		<th><button class="btn btn-danger">${u.aid }</button></th>
		
		</tr>
		
		
		</c:forEach>
		
		
		
		
		</table>
	


	
</body>
</html>