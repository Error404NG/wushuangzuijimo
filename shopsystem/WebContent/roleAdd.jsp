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
</head>
<body>
	<form action="role.action?method=add" method="post">
		名称:<input name="rname" /> 
		软删除: <input type="radio" name="softdelete"value="1" check="checked" />可用
		 <input type="radio" name="softdelete" value="0" />不可用 <br>

		<button class="btn btn-success">添加角色</button>


	</form>



</body>
</html>