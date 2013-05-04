<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Bootstrap -->
<link href="${contextRoot}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${contextRoot}/resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link href="${contextRoot}/resources/bootstrap/plugin/bootstrap-lightbox.min.css" rel="stylesheet">
<style type="text/css">
body {
	background-color: gray;
}

.explain, .marketing {
	margin: 30px 30px;	
}

.title{
	margin: 10px 10px;
}

hr {
	display: block;
	height: 1px;
	border: 0;
	border-top: 1px solid #ccc;
	margin: 1em 0;
	padding: 0;
}
</style>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="${contextRoot}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${contextRoot}/resources/bootstrap/plugin/bootstrap-lightbox.js"></script>
<script>

var menuName = "${menuName}";

$(document).ready(function() {
	
	//Main Menu Control
	if(menuName == "home"){
		$(".top li:eq(1)").addClass("active");	
	}else if(menuName == "about"){
		$(".top li:eq(2)").addClass("active");
	}else if(menuName == "programming"){
		$(".top li:eq(3)").addClass("active");
	}else if(menuName == "photo"){
		$(".top li:eq(4)").addClass("active");
	}
	
	//Programming Menu Control
	if(menuName == "programming"){
		$(".top li:eq(3)").addClass("active");
		$(".nav-list > li:eq(2)").addClass("active");
	}else if(menuName == "programming_plugin_01"){
		$(".top li:eq(3)").addClass("active");
		$(".nav-list > li:eq(6)").addClass("active");
	}else if(menuName == "programming_javascript_01"){
		$(".top li:eq(3)").addClass("active");
		$(".nav-list > li:eq(10)").addClass("active");
	}
	
});
</script>

</head>

<body>
	<div class="container">
	
<%@ include file="./main_menu.jsp"%>