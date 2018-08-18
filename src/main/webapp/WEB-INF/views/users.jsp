<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List -Contact Application</title>
<s:url var="url_css" value="/static/css/style.css"/>
 <link href="${url_css}" rel="stylesheet" type="text/css"/>
  <s:url var="url_jqlib" value="/static/js/jquery-3.3.1.min.js"></s:url>
 <script src="${url_jqlib }"></script>
 <script type="text/javascript">
    function changeStatus(uid,lstatus) {
		alert(uid+" , "+lstatus);
		$.ajax({
			url : 'change_status',
			data: { userId:uid, loginStatus:lstatus},
			success : function(data){
				alert(data);
			}
		})
	}
 </script>
</head>
<s:url var="url_bg" value="/static/images/smiles_joy_sadness.jpg"/>
<body background="${url_bg}" style="background-size: 100% 125%">
  
  <table class="tab1" border="1"  width="81%" align="center">
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
     <h1>Users List</h1>
     <a href='<s:url value="/user/clistExcelExport"/>'>Export Excel Data</a>&nbsp;&nbsp;&nbsp;
     <a href='<s:url value="/user/clistPDFExport"></s:url>'>Export PDF Data</a>
     <c:if test="${param.act eq 'sv'}">
      <p class="success">Contact Saved Successfully.</p>
     </c:if>
     <c:if test="${param.act eq 'del'}">
      <p class="success">Contact Deleted Successfully.</p>
     </c:if>
    
     <table width="100%">
      <tr>
       <td align="right">
        <form action='<s:url value="/user/contact_search"/>'>
         <input type="text" value="${param.freeText}" name="freeText" placeholder="Enter Text To Search.">
         <button>find</button>
        </form>
        <br>
       </td>
      </tr>
     </table>
     <form action='<s:url value="/user/bulk_cdelete"></s:url>'>
      <button>Delete Selected Record</button>
       <br>
      <table border="1" cellpadding="5">
       <br/>
       <tr>
<!--         <th>SELECT</th> -->
        <th>SNO</th>
        <th>User Id</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email </th>
        <th>Address </th>
        <th>Username </th>
        <th>Status </th>
       </tr>
       <c:if test="${empty userlist}">
        <tr>
         <td colspan="8" class="error" align="center">No Record Present.</td>
        </tr>
       </c:if>
       <c:forEach var="usr" items="${userlist}" varStatus="st">
        <tr>
<%--          <td align="center"><input type="checkbox" name="cid" value="${c.contactId}"></td> --%>
         <td>${st.count}</td>
         <td>${usr.userId}</td>
         <td>${usr.name}</td>
         <td>${usr.phone}</td>
         <td>${usr.email}</td>
         <td>${usr.address}</td>
         <td>${usr.loginName}</td>
         <td>
          <select id="id_${usr.userId}" onchange="changeStatus(${usr.userId},$(this).val())">
           <option value="1">Active</option>
           <option value="2">Blocked</option>
          </select>
          <script type="text/javascript">
           $("#id_${usr.userId}").val("${usr.loginStatus}");
          </script>
<%--           ${usr.loginStatus} --%>
         </td>
         <s:url var="url_del" value="/user/del_contact">
          <s:param name="cid" value="${c.contactId}"/>
         </s:url>
         <s:url var="url_edit" value="/user/edit_contact">
          <s:param name="cid" value="${c.contactId}"/>
         </s:url>
         <td><a href="${url_edit}">edit</a> | <a href="${url_del}">delete</a></td>
        </tr>
       </c:forEach>
      </table>
     </form>
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