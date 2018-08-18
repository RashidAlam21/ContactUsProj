<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:url var="logout_url" value="/logout"></s:url>
<c:if test="${sessionScope.userId==null}">
  <%---User is not yet logged in : Guest Menu --%>
  <s:url var="url_reg_form" value="/reg_form "></s:url>
  <s:url var="url_login_form" value="/index "></s:url>
  <a href="#">Home</a> |<a href="${url_reg_form}">Registration</a> |<a href="${url_login_form}">Login</a> | <a href="#">About</a> | <a href="#">Help</a>
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role==1}">
  <%---Admin is logged in : Admin Menu --%>
  <s:url var="url_ulist" value="/admin/users"></s:url>
  <s:url var="url_home" value="/admin/dashboard"></s:url>
  <a href="${url_home}">Home</a> | <a href="${url_ulist}">User List</a> | <a href="${logout_url}">Logout</a>
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role==2}">
   <s:url var ="url_home" value="/user/dashboard"></s:url>
   <s:url var ="url_cform" value="/user/contact_form"></s:url>
   <s:url var ="url_clist" value="/user/clist"></s:url>
  <%---General User is not yet logged in : User Menu --%>
  <a href="${url_home}">Home</a> | <a href="${url_cform}">Add Contact</a> | <a href="${url_clist}">Contact List</a> | <a href="${logout_url}">Logout</a>
</c:if>
