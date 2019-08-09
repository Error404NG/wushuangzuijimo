<%@ page language="java" 
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>商品添加</h1>

<form action="goods.action?method=add" method="post" enctype="multipart/form-data">


	名称:<input name="gname"/><br>
	价格:<input name="gprice"/><br>
	库存:<input name="ginventory"/><br>
	图片:<input type="file" name="gpic"/><br>
	描述:<input name="gdescribe"><br>
	类型:<select name="gtid">	
	<c:forEach items="${list }" var="goodsType">
	
	<option value="${goodsType.gtid }">${goodsType.gtname}</option>
	
	</c:forEach>

	</select><br>
	
	软删除:
	<input  type="radio" name="softdelete" value ="1" checked="checked"/>可用
	<input  type="radio" name="softdelete" value ="0" />不可用
	<br>
	
	<button>添加</button>
	


</form>

</body>
</html>