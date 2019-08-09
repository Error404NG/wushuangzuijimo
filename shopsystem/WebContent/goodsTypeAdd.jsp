<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<form action="goodsType.action?method=add" method="post"
		enctype="multipart/form-data">

		类型名称:<input name="gtname" /><br> 类型图片:<input type="file"
			name="gtpic" /><br> 类型描述:<input name="gtdescript" /><br>
		类型前置:<input name="gtforetypeno" /><br> 软删除:<input type="radio"
			name="softdelete" value="1"><br>
		可用 
		<input type="radio" name="softdelete" value="0"><br>
		不可用 

		<button>添加类型</button>
	</form>

</body>
</html>