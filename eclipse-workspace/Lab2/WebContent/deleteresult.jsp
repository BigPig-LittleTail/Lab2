<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结果</title>
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
	<h1>操作成功</h1>
	<hr/>
	<p>该姓名作者的剩余书籍如下</p>
	<p><s:property value = "#output"/></p>
	 <s:iterator id = "allbook" value="#books">
	    <s:url id = "url"  action = "bookdetails">
			<s:param name = "ISBN">
				<s:property value = "#allbook.ISBN"/>
			</s:param>
			<s:param name = "AuthorID">
				<s:property value = "AuthorID"/>
			</s:param>
		</s:url>
   		<s:a href = "%{url}"><s:property value = "#allbook.Title" /></s:a><br/><br/>
    </s:iterator>
</div>
</html>