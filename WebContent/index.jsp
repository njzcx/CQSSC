<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据分析</title>
<script>
window.onload=function() {
	document.getElementById("div").innerText = "${datalist}";
}
</script>
</head>
<body>
	<form action="datacalc.do" method="post">
		<input type="submit"/>
		<div id="div"></div>
	</form>
</body>
</html>