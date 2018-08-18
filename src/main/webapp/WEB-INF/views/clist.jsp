<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact List -Contact Application</title>
<s:url var="url_css" value="/static/css/style.css"/>
 <link href="${url_css}" rel="stylesheet" type="text/css"/>
</head>
<s:url var="url_bg" value="/static/images/smiles_joy_sadness.jpg"/>
<body background="${url_bg}" style="background-size: 100% 125%">
  
  <table class="tab1" border="1" style="margin-bottom: 50px;margin-top: 40px;" width="81%" align="center">
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
     <h1>Contact List</h1>
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
        <th>SELECT</th>
        <th>SNO</th>
        <th>Contact Id</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email </th>
        <th>Address </th>
        <th>Remark </th>
        <th>Action </th>
       </tr>
       <c:if test="${empty contactlist}">
        <tr>
         <td colspan="8" class="error" align="center">No Record Present.</td>
        </tr>
       </c:if>
       <c:forEach var="c" items="${contactlist}" varStatus="st">
        <tr>
         <td align="center"><input type="checkbox" name="cid" value="${c.contactId}"></td>
         <td>${st.count}</td>
         <td>${c.contactId}</td>
         <td>${c.name}</td>
         <td>${c.phone}</td>
         <td>${c.email}</td>
         <td>${c.address}</td>
         <td>${c.remark}</td>
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