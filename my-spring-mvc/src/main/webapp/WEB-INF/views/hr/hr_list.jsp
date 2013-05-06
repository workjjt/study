<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>직원 관리 프로그램</title>
<link rel="stylesheet" type="text/css" media="screen" href="/mvc/resources/jqury-ui/jquery-ui-1.10.3.custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/mvc/resources/jqGrid/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/mvc/resources/jqGrid/plugins/ui.multiselect.css" />
<!--link rel="stylesheet" type="text/css" media="screen" href="/mvc/resources/jqGrid/plugins/searchFilter.css" -->


<script src="http://code.jquery.com/jquery-1.9.1.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="/mvc/resources/jqury-ui/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
<!-- script src="/mvc/resources/jqGrid/plugins/grid.addons.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/plugins/grid.postext.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/plugins/grid.setcolumns.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/plugins/jquery.contextmenu.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/plugins/jquery.searchFilter.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/plugins/jquery.tablednd.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/plugins/ui.multiselect.js" type="text/javascript"></script>
<script src="/mvc/resources/jqGrid/plugins/jquery.tablednd.js" type="text/javascript"></script-->

<script type="text/javascript">
	$(window.document).ready(function(){		
		$("#hr").jqGrid({
			url: 'http://localhost:8088/mvc/hr/list/jsonp',
			datatype: 'json',
			mtype: 'get',
			colNames: ['사번','이름', '이름', '이메일', '전화번호', '입사일', '직무번호',
		               '급여', '커미션','매니저', '부서번호'],
			colModel: [
			    {name: 'employeeId', index: 'employee_id', width: 50, align: 'center'},
			    {name: 'firstName', index: 'first_name', width: 100, align: 'center'},
			    {name: 'lastName', index: 'last_name', width: 100, align: 'center'},
			    {name: 'email', index: 'email', width: 100, align: 'center'},
			    {name: 'phoneNumber', index: 'phone_number', width: 150, align: 'center'},
			    {name: 'hireDate', index: 'hire_date', width: 100, align: 'center'},
			    {name: 'jobId', index: 'job_id', width: 100, align: 'center'},
			    {name: 'salary', index: 'salary', width: 100, align: 'center'},
			    {name: 'commissionPct', index: 'commission_pct', width: 40, align: 'center'},
			    {name: 'managerId', index: 'manager_id', width: 40, align: 'center'},
			    {name: 'departmentId', index: 'department_id', width: 40, align: 'center'}
			],
			rowNum: 10,
			autowidth: true,
		   	pager: '#pager3',
		   	//multiselect: true,
		   	rownumbers: true,
		   	sortname: 'employee_id',
		    viewrecords: true,
		    shrinkToFit: true,
		    sortorder: "asc",
		    sortable: true,
		    cellEdit: true,  //true 일 경우, 틀고정(Frozen Column)기능 불가
			height: "250",
			caption: '직원 명단',	//캡션이 헤더를 가린다.
			onSortCol: function (index, columnIndex, sortOrder) {
				//return 'stop';
		    }
		});
		jQuery("#hr").jqGrid('navGrid','#pager3',{excel:true,edit:true,view:true,add:true,del:true,refresh:true});
		
		$(window).resize(function(){
			//alert($(this).width());
	        $("#hr").setGridWidth($(this).width()-20); 
	    });
	
	});

</script>
</head>
<body>
	<h1>jqgrid 예제- 오라클 HR 사용, JSON 데이터로 변환</h1>
	<table id="hr"></table>
	<div id="pager3"></div>
</body>
</html>
