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
<style type="text/css">
th{
	text-align: center;


}
button{
	width: 100%;
}
</style>


</head>
<body>

<a href="goodsType.action?method=list">商品类型管理</a>
<a href="goods.action?method=list">商品管理</a>
<a href="role.action?method=list">角色管理</a>
<a href="login.action?method=list">用户管理</a>
<a href="order.action?method=list">订单管理</a>

<center><h1><caption>商品类型管理</caption></h1></center>
<table width="800" border="1"
		class="table table-striped table-hover table-condensed table-borered ">

		<tr>
		<th>序号</th>
		<th>类型名称</th>
		<th>类型图片</th>
		<th>类型描述</th>
		<th>类型前置</th>
		<th>软删除</th>
		<th>编辑</th>
		<th>删除</th>
		

		</tr>

		<c:forEach items="${list }" var="u" varStatus="i">

			<tr>
				<th>${i.index+1 }</th>
				<th>${u.gtname }</th>
				<th><img src="${u.gtpic }" width="50" /></th>
				<th>${u.gtdescript }</th>
				<th>${u.gtforetypeno }</th>
				<th>${u.softdelete }</th>
				
				
				
		
				<th><a href="goodsType.action?method=goodsGet&gtid=${u.gtid }"><button class="btn btn-warning">编辑</button></a></th>
				<th><a href="goodsType.action?method=delete&gtid=${u.gtid }"><button class="btn btn-danger">删除</button></a></th>

			</tr>


		</c:forEach>

		</table>
		<a href="goodsTypeAdd.jsp">添加类型</a>

</body>
</html>