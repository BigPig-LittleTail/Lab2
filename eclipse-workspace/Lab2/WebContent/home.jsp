<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>按作者查找</title>
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

#soft {
	top: 200px;
	background-color: #800080;
}


#contact {
    top: 260px;
    background-color: #555
}

input[type=text], select, textarea {
    width: 20%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
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
   <h1>按作者姓名查询书籍</h1>
   <form action="searchresult" method = "post">
      <input type="text" id ="Inputname" name="Inputname" placeholder = "请输入作者姓名.."/>
      <input type="submit" value="查找" />
   </form>
</div>
</html>