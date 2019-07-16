<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>springMVC</h2>

     <div align="center">
             <table border="1">
                 <tr>
                   <td>用户名</td>
                   <td>用户密码</td>
                 </tr>
                 <c:forEach items="${listUser}" var="u">
                   <tr>
                   <td>${u.userName}</td>
                   <td>${u.password}</td>
                 </tr>
                 </c:forEach>
             </table>
     </div>
</body>
</html>
