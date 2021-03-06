<%@page import="java.util.HashMap"%>
<%@page import="java.util.Arrays"%>
<%@page import="model.data.SubjectDto"%>
<%@page import="model.data.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ include file="initializer.jsp" %>

<%
	String delete;
	int reloadSubjectView = 0;

	delete = Optional.ofNullable(request.getParameter("delete")).orElse("undefined");	
	if(!delete.equals("undefined")) {
		reloadSubjectView = subjectController.deleteSubject(delete);
		
		planController = (PlanController)Optional.ofNullable(session.getAttribute("sessionPlanController"))
				.orElse(new PlanController((String)session.getAttribute("sessionUser")));
		
		planController.deletePlan(delete);
	}
	
	if(session.getAttribute("sessionUser") != null || request.getParameter("sid") != null || reloadSubjectView == 1) {
		try{
			if(session.getAttribute("sessionID").equals(session.getId())) {
				subjectController = new SubjectController((String)session.getAttribute("sessionUser"));
				session.setAttribute("sessionSubjectController", subjectController);
				
				subjectMap = subjectController.readSubject();
				session.setAttribute("sessionSubjectMap", subjectMap);
			} else {
				subjectController = new SubjectController((String)session.getAttribute("guest"));
				session.setAttribute("sessionSubjectController", subjectController);
				
				subjectMap = subjectController.readSubject();
				session.setAttribute("sessionSubjectMap", subjectMap);
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SubjectView</title>
<style type="text/css">

	.subjectView {
		width: 445px;
		height: 17px;
		font-size: 12px;
	}
	
		.subjectView > .top > div.index {
			display: inline-block;
			border: 0.5px solid black;
		}
		
		.subjectView > .contents > .sub {
			display: inline-block;
			margin: 0 0.5px 0 0.5px;
		}
	
	.hidden {
		display: none;
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
			<% 
			if(subjectMap != null && session.getAttribute("sessionUser") != null) {
				for(int i = 1; i <= subjectMap.size(); i++) {
					%><div class="sub rownum" style="width: 15px"><%=i %></div>
					<div class="sub color" style="width: 10px; background-color: <%=subjectMap.get(i).getColorTag()%>">&nbsp;</div>
					<div class="sub sid" style="width: 40px" ><%=String.valueOf(subjectMap.get(i).getSid()) %> </div>
					<div class="sub subject" style="width: 60px" ><%=subjectMap.get(i).getSubjectName() %> </div>
					<div class="sub teacher" style="width: 60px" ><%=subjectMap.get(i).getTeacher() %>.</div>
					<div class="sub desc" style="width: 170px" ><%=subjectMap.get(i).getDesc() %>.</div>
					<form method="get" action="index.jsp" class="sub">
						<input type="text" name="delete" class="hidden" value="<%=subjectMap.get(i).getSid() %>" />	
						<input type="submit" class="deleteSubmit" value="delete" />
					</form>
					
					<%
				}
			}
			%>
		</div>
	</div>
</body>
</html>