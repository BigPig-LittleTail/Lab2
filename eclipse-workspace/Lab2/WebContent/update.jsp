<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新</title>
<style>
#mySidenav a {
    position: absolute;
    left: -80px;
    transition: 0.3s;
    padding: 15px;
    width: 140px;
    text-decoration: none;
    font-size: 20px;
    color: white;
    border-radius: 0 5px 5px 0;
}

#mySidenav a:hover {
    left: 0;
}

#about {
    top: 20px;
    background-color: #4CAF50;
}

#blog {
    top: 80px;
    background-color: #2196F3;
}

#projects {
    top: 140px;
    background-color: #f44336;
}

#contact {
    top: 260px;
    background-color: #555
}
#soft {
	top: 200px;
	background-color: #800080;
}

#customers
  {
  font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  width:100%;
  border-collapse:collapse;
  }

#customers td, #customers th 
  {
  font-size:1em;
  border:1px solid #98bf21;
  padding:3px 7px 2px 7px;
  }

#customers th 
  {
  font-size:1.1em;
  text-align:left;
  padding-top:5px;
  padding-bottom:4px;
  background-color:#A7C942;
  color:#ffffff;
  }

#customers tr.alt td 
  {
  color:#000000;
  background-color:#EAF2D3;
  }


</style>
</head>

<div id="mySidenav" class="sidenav">
  <s:url id = "allbook"  action = "allbooks">
  </s:url>
  <s:a href="%{allbook}" id="about">全部图书</s:a>
  <a href="home.jsp" id="blog">按作者姓名查询</a>
<a href="addbook.jsp" id="projects">添加图书</a>
    <s:url id = "update"  action = "update">
  </s:url>
  <s:a href="%{update}" id="soft"> 更新图书</s:a>
  <s:url id = "returnhome"  action = "returnhome">
  </s:url>
  <s:a href="%{returnhome}" id="contact">返回首页</s:a>
</div>


<div style="margin-left:100px;">
   <h2 align="center"> 全部图书信息</h2>
   
 
<table id = "customers" border=1 align="center">
 <tr> 
  <th>ISBN</th><th>Title</th><th>AuthorID</th><th>Publisher</th><th>PublishDate</th><th>Price</th><th>操作</th>
  </tr>
  	<s:iterator id = "book"  value = "#books" >
	<tr>
	<form action = "submitupdate" method = "post">
		<td><s:property value = "#book.ISBN"/>	</td>
		<td><input type = "text" name = "Title" value = "<s:property value = "#book.Title"/>" ></td>
		
		
		<td><input type = "text" name = "AuthorID" value = "<s:property value = "#book.AuthorID"/>"></td>
		
		
		
		<td><input type = "text" name = "Publisher" value = "<s:property value = "#book.Publisher"/>"></td>
		<td><input type = "text" name = "PublishDate" value = "<s:property value = "#book.PublishDate"/>"></td>
		<td><input type = "text" name = "Price" value = "<s:property value = "#book.Price"/>"></td>
		<td><input type = "hidden" name = "ISBN" value = "<s:property value = "#book.ISBN"/>"><input type="submit" value="更新" /></td>
		</form>
		</tr>
		</s:iterator>
		</table>
		
</div>

</html>