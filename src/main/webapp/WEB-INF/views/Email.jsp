<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>New Message</h3>
<form:form action="sent" method="POST" modelAttribute="mailModel" enctype="multipart/form-data">
<pre>
<table>  
 
<tr><td>TO  	  : </td><td><form:input path="to" /></td><td>      CC  	  : <form:input path="cc" /></td></tr>  
<tr><td>SUBJECT   :</td><td><form:input path="sub" /></td><td>      BCC  	  : <form:input path="bcc" /></td>></tr> 
</table>
<table> 
<tr><td>TEXT	  :</td><td><form:textarea path="text" rows="5" cols="64"/></td></tr>  
<tr><td>DOCUMENT  :</td><td><input type="file" name="fileObj"/></td></tr>  
</table>  
  
<input type="submit" value="Send" /> 		
</pre>
</form:form>
<h3>${message}</h3>
</body>
</html>