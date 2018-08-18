<%--
   Document    :  index
   Created on  :  Aug 2, 2018 , 01:58:52 AM
   Author      :  Md Rashid Alam
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login -Contact Application</title>
<s:url var="url_css" value="/static/css/style.css"/>
 <link href="${url_css}" rel="stylesheet" type="text/css"/>
</head>
<s:url var="url_bg" value="/static/images/smiles_joy_sadness.jpg"/>
<body background="${url_bg}" style="background-size: 100% 125%">
  
  <table border="1" width="80%" align="center">
   <tr>
    <td height="80px">
     <!-- Header Area -->
     <jsp:include page="include/header.jsp"/>
    </td>
   </tr>
    <tr>
    <td height="25px">
     <!-- Menu Area -->
      <jsp:include page="include/menu.jsp"/>
    </td>
   </tr>
    <tr>
    <td height="350px" valign="top">
     <!-- Page Content Area -->
     <h3>User Login</h3>
     <c:if test="${err!=null}">
      <p class="error">${err} </p>
     </c:if>
     <c:if test="${param.act eq 'lo'}">
      <p class="success">Logout Successfully! Thanks for using conatact application.</p> 
     </c:if>
     
     <c:if test="${param.act eq 'reg'} ">
      <p class="success">User Registration is successfully inserted.</p>
     </c:if>
     
<%--      <c:otherwise> --%>
<!--       <p class="error">User Registration is not successfully inserted.</p> -->
<%--      </c:otherwise> --%>
     <s:url var="url_login" value="/login"/>
     <f:form action="${url_login}" modelAttribute="command">
      <table border="1">
       <tr>
        <td>Username</td>
        <td><f:input path="loginName"/></td>
       </tr>
       <tr>
        <td>Password</td>
        <td><f:input path="password"/></td>
       </tr>
       <tr>
        <td colspan="2" align="right">
         <button> Login</button><br>
         <a href="reg_form">New User Registration </a>
        </td>
       </tr>
      </table>
     </f:form>
    </td>
   </tr> 
    <tr>
    <td height="25px">
     <!-- Footer Area -->
     <jsp:include page="include/footer.jsp"/>
    </td>
   </tr>
  </table>
</body>
</html>