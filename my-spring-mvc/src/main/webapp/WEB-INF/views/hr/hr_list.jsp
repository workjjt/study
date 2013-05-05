<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>직원 관리 프로그램</title>
<link rel="stylesheet" type="text/css" media="screen" href="/mvc/resources/jqury-ui/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/mvc/resources/jqGrid/css/ui.jqgrid.css" />


<script src="http://code.jquery.com/jquery-1.9.1.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="/mvc/resources/jqury-ui/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>

<script type="text/javascript">
	$(window.document).ready(function(){		
		$("#hr").jqGrid({
			url: 'http://localhost:8088/mvc/hr/list/json',
			datatype: 'json',
			mtype: 'get',
			colModel: [
			    {name: 'employeeId', index: 'employeeId', width: 100, align: 'center'},
			    {name: 'firstName', index: 'lastName', width: 200, align: 'center'},
			    {name: 'lastName', index: 'lastName', width: 200, align: 'center'},
			    {name: 'email', index: 'email', width: 200, align: 'center'},
			    {name: 'phoneNumber', index: 'phoneNumber', width: 200, align: 'center'},
			    {name: 'hireDate', index: 'hireDate', width: 200, align: 'center'},
			    {name: 'jobId', index: 'jobId', width: 40, align: 'center'},
			    {name: 'salary', index: 'salary', width: 100, align: 'center'},
			    {name: 'commissionPct', index: 'commissionPct', width: 100, align: 'center'},
			    {name: 'managerId', index: 'managerId', width: 40, align: 'center'},
			    {name: 'departmentId', index: 'departmentId', width: 40, align: 'center'}
			],
			rowNum:10,
		   	pager: '#pager3',
		   	sortname: 'employeeId',
		    viewrecords: false,
		    sortorder: "desc",
			height: "210",
			multiselect: true,
			caption: '직원 명단'
		});
		jQuery("#hr").jqGrid('navGrid','#pager3',{edit:false,add:false,del:false});
	});
</script>
</head>
<body>
	<h1>jqgrid 예제- 오라클 HR 사용, JSON 데이터로 변환</h1>
	<table id="hr"></table>
	<div id="pager3"></div>
</body>
</html>
