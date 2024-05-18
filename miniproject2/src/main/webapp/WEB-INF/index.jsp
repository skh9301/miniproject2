<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Spring MVC 게시판</title>
	<title>스프링 게시판</title>	
	<link href="resources/bootstrap/bootstrap.min.css" rel="stylesheet" >
	<link rel="stylesheet" type="text/css" href="resources/css/member.css" />		
    <style>      	
    </style>
	<script src="resources/js/jquery-3.2.1.min.js"></script>
	<script src="resources/js/formcheck.js"></script>
	<script src="resources/js/member.js"></script>
</head>
<body>
	<div class="container">
		<%@ include file="template/header.jsp" %>
		<jsp:include page="${ param.body }" />
	</div>
    <script src="resources/bootstrap/bootstrap.bundle.min.js"></script>	

</body>
</html>