<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>직원 관리 프로그램</title>
<link rel="stylesheet" type="text/css" media="screen" href="/mvc/resources/jqury-ui/jquery-ui-1.10.3.custom.min.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/mvc/resources/jqGrid/css/ui.jqgrid.css" />

<script src="http://code.jquery.com/jquery-1.9.1.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="/mvc/resources/jqury-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(window.document).ready(function(){
		$("#list").jqGrid({
			url: 'http://apis.daum.net/socialpick/search?output=json',
			datatype: 'jsonp',
			mtype: 'get',
			colNames: ['순위', '소셜픽키워드', '이슈', '요약문', '검색수',
			          '트윗수', '결과', '순위', '카테고리'],
			colModel: [
			    {name: 'rank', index: 'rank', width: 40, align: 'center'},
			    {name: 'keyword', index: 'keyword', width: 100, align: 'left'},
			    {name: 'link', index: 'link', width: 100, align: 'left'},
			    {name: 'content', index: 'count', width: 200, align: 'left'},
			    {name: 'count', index: 'count', width: 100, align: 'center'},
			    {name: 'quotation_cnt', index: 'quotation_cnt', width: 100, align: 'center'},
			    {name: 'comment_cnt', index: 'comment_cnt', width: 100, align: 'center'},
			    {name: 'rank_diff', index: 'rank_diff', width: 100, align: 'center'},
			    {name: 'category', index: 'category', width: 100, align: 'center'},
			],
			caption: '다음소셜픽',
			jsonReader:{
				repeatitmes: false,
				id: "rank",
				root: function(obj) { return obj.socialpick.item; },
				page: function(obj) { return 1;},
				total: function(obj) {return 1;},
				records: function(obj) {return obj.socialpick.item.length;}
			}
		});
		
		$("#hr").jqGrid({
			url: 'http://localhost:8088/mvc/hr/list/json',
			datatype: 'json',
			mtype: 'get',
			colModel: [
			    {name: 'employeeId', index: 'employeeId', width: 40, align: 'center'},
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
			caption: '다음소셜픽'
			
		});
	});
</script>
</head>
<body>
	<h1>직원 명부</h1>
	
	<table id="list"></table>
	<br>
	<table id="hr"></table>

</body>
</html>
