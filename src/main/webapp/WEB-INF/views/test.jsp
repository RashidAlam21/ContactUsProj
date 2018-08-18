<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <s:url var="url_jqlib" value="/static/js/jquery-3.3.1.min.js"></s:url>
 <script src="${url_jqlib }"></script>
 <script>
  $(document).ready(function(){
	  //alert('JQuery is ready and integrated ');
	  $("#id_get_time").click(function(){
		  //alert('Button is clicked')
		  $.ajax({
			  url :'get_time',
			  success : function(data){
				  $("#id_time").html(data);
			  }
		  });
	  });
  });
 </script>
</head>
<body>
<h1>Ajax Test Page</h1>
 <button id="id_get_time">Get Server Time</button>
 <p id="id_time"></p>
</body>
</html>