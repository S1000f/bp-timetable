<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.MyCal"%>
<%@ page import="model.InputData" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>forward.jsp</h4>

<%--
	<%
		try {
			String strYear = request.getParameter("year");
			String strMonth = request.getParameter("month");

			int year = Integer.valueOf(strYear);
			int month = Integer.valueOf(strMonth);

			MyCal cal = new MyCal(year, month);
			String firstDay = cal.getFirstDay();

			out.println(firstDay);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		InputData test = new InputData();
		String t1 = test.getYear();
		String t2 = test.getMonth();
		
		out.println(t1);
		out.println(t2);
	%>
	--%>
	
	<hr />
	<jsp:useBean id="InputData" class="model.InputData">
		<jsp:setProperty name="InputData" property="year" />
		<jsp:setProperty name="InputData" property="month" />
		jsp:getproperty >>> [<jsp:getProperty name="InputData" property="year" />]<br />
		jsp:getproperty >>> [<jsp:getProperty name="InputData" property="month" />]
	</jsp:useBean>
	
	<%
	
	InputData init = new InputData();
	String day = init.initMyCal();
	
	out.println(day);
	%>

</body>
</html>