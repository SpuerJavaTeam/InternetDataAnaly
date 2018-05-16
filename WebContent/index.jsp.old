<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>随机生成数据页面</title>
</head>
<script type="text/javascript">
    onload = function () {
         var year=new Date().getFullYear(); //获取当前年份
         
       var datestart = document.getElementById ('datestart');//获取select下拉列表
       for ( var i = 2000; i < year+3; i++)//循环添加2000到当前年份加3年的每个年份依次添加到下拉列表
       {
           var option = document.createElement ('option');
           option.value = i;
           var txt = document.createTextNode (i);
           option.appendChild (txt);
           datestart.appendChild (option);
       }
       
       var dateend = document.getElementById ('dateend');//获取select下拉列表
       for ( var i = 2000; i < year+3; i++)//循环添加2000到当前年份加3年的每个年份依次添加到下拉列表
       {
           var option = document.createElement ('option');
           option.value = i;
           var txt = document.createTextNode (i);
           option.appendChild (txt);
           dateend.appendChild (option);
       }
    }
</script>
<body>

	<form action="datacreator.action">
	选择随机生成数据的条数:
		<select name="datacount">
			<option value="100">100</option>
			<option value="500">500</option>
			<option value="1000">1000</option>
			<option value="2000">2000</option>
			<option value="5000">5000</option>
		</select>
		<br>
	选择随机生成上网数据时段:
	<select id="datestart" name="datestart">
	</select>
	到
	<select id="dateend" name="dateend">
	</select>
	
	<input type="submit" value="提交">
	</form>
</body>
</html>