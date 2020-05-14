<%@page import="java.util.HashMap"%>
<%@page import="java.util.Arrays"%>
<%@page import="model.data.SubjectDto"%>
<%@page import="model.data.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ include file="initializer.jsp" %>

<%

	if(request.getAttribute("login") != null || request.getParameter("sid") != null) {
		subjectController = (SubjectController)Optional.ofNullable(session.getAttribute("sessionSubjectController"))
				.orElse(new SubjectController((String)session.getAttribute("sessionUser")));
		session.setAttribute("sessionSubjectController", subjectController);
		
		subjectMap = subjectController.readSubject();
		session.setAttribute("sessionSubjectMap", subjectMap);
		
		subjectNamesList = Optional.ofNullable(subjectController.getSubjectNames())
				.orElse(new ArrayList<String>(Arrays.asList("---")));
		session.setAttribute("sessionSubjectNamesList", subjectNamesList);
		
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SubjectView</title>
<style type="text/css">

	.subjectView {
		width: 380px;
		height: 17px;
		font-size: 12px;
	}
	
		.subjectView > .top > div.index {
			display: inline-block;
			border: 0.5px solid black;
		}
		
		.subjectView > .contents > div.sub {
			display: inline-block;
			margin: 0 0.5px 0 0.5px;
		}

</style>
</head>
<body>
	<div class="menu subjectView">
		<div class="top">
			<div class="index rownum" style="width: 15px">#</div>
			<div class="index color" style="width: 10px">&nbsp;</div>
			<div class="index sid" style="width: 40px" >SID</div>
			<div class="index subject" style="width: 60px" >subject</div>
			<div class="index teacher" style="width: 60px" >teacher</div>
			<div class="index desc" style="width: 170px" >description</div>
		</div>
		<div class="contents">
			<% if(subjectMap != null && session.getAttribute("sessionUser") != null) {
				for(int i = 1; i <= subjectMap.size(); i++) {
					%><div class="sub rownum" style="width: 15px"><%=i %></div>
					<div class="sub color" style="width: 10px; background-color: <%=subjectMap.get(i).getColorTag()%>">&nbsp;</div>
					<div class="sub sid" style="width: 40px" ><%=String.valueOf(subjectMap.get(i).getSid()) %> </div>
					<div class="sub subject" style="width: 60px" ><%=subjectMap.get(i).getSubjectName() %> </div>
					<div class="sub teacher" style="width: 60px" ><%=subjectMap.get(i).getTeacher() %>.</div>
					<div class="sub desc" style="width: 170px" ><%=subjectMap.get(i).getDesc() %>.</div>
				<%}
			} %>
		</div>
	</div>
</body>
</html>