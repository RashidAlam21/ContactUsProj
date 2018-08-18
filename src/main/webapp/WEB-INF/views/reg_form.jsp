<%--
   Document    :  reg_form
   Created on  :  Aug 2, 2017 , 21:58:52
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
<title>User Registration -Contact Application</title>
<s:url var="url_css" value="/static/css/style.css"/>
 <link href="${url_css}" rel="stylesheet" type="text/css"/>
 <s:url var="url_jqlib" value="/static/js/jquery-3.3.1.min.js"></s:url>
 <script src="${url_jqlib }"></script>
 <script type="text/javascript">
  $(document).ready(function(){
	 $("#id_check_avail").click(function(){
		$.ajax({
			url : 'check_user_avail',
			data : {username : $("#id_username")},
			success : function(data){
				$("#id_res_div").html(data);
			}
		});
	 }); 
  });
 </script>
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
     <h3>User Registration.</h3>
     <c:if test="${err!=null}">
      <p class="error">${err} </p>
     </c:if>
<%--       <c:if test="${param.act eq 'lo'}"> --%>
<!--       <p class="success">Logout Successfully! Thanks for using conatact application.</p>  -->
<%--      </c:if> --%>
     <s:url var="reg_url" value="/registration"/>
     <f:form action="${reg_url}" modelAttribute="command">
      <table border="1">
      <tr>
        <td>UserId</td>
        <td><f:input path="userId"/></td>
       </tr>
       <tr>
        <td>Name</td>
        <td><f:input path="Name"/></td>
       </tr>
       <tr>
        <td>phone</td>
        <td><f:input path="phone"/></td>
       </tr>
       <tr>
        <td>email</td>
        <td><f:input path="email" /></td>
       </tr>
       <tr>
        <td>address</td>
        <td><f:textarea path="address"/></td>
       </tr>
       <tr>
        <td>Username</td>
        <td>
         <f:input path="loginName" id="id_username"/>
         <button type="button" id="id_check_avail">Check Availability</button>
         <div id="id_res_div" class="error">
         </div>
        </td>
        
       </tr>
       <tr>
        <td>Password</td>
        <td><f:password path="password"/></td>
       </tr>
       <tr>
        <td colspan="2" align="right">
         <button type="submit">Submit</button><br>
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