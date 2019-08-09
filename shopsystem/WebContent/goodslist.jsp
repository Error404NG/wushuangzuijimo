<%@ page language="java" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
th {
	text-align: center;
}

button {
	width: 100%;
}
</style>



</head>
<body>
<a href="goodsType.action?method=list">商品类型管理</a>
<a href="goodsAll.do">商品管理</a>
<a href="role.action?method=list">角色管理</a>
<a href="login.action?method=list">用户管理</a>
<a href="order.action?method=list">订单管理</a>
		<center><caption><h1>商品管理</h1></caption></center>
	<table width="800" border="1"
		class="table table-striped table-hover table-condensed table-borered ">

		<tr>

			<th>编号</th>
			<th>名称</th>
			<th>价格</th>
			<th>库存</th>
			<th>图片</th>
			<th>描述</th>
			<th>类型</th>
			<th>软删除</th>
			<th>编辑</th>
			<th>删除</th>


		</tr>

		<c:forEach items="${list }" var="u" varStatus="i">

			<tr>
				<th>${i.index+1 }</th>
				<th>${u.gname }</th>
				<th>${u.gprice }元</th>
				<th>${u.ginventory }</th>
				<th><img src="${u.gpic }" width="50" /></th>
				<th>${u.gdescribe }</th>
				<th>${u.gtid }</th>
				<th>${u.gtid }</th>
				<th><a href="goodsEdit.do?id=${u.gid }"><button class="btn btn-warning">编辑</button></a></th>
				<th><a href="goods.action?method=delete&gid=${u.gid }"><button class="btn btn-danger">删除</button></a></th>

			</tr>


		</c:forEach>














	</table>
	<a href="goods.action?method=addForm">添加商品</a>



</body>
</html>