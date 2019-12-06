<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@ include file="/WEB-INF/jsp/components/framework.jsp"%>
<html>
<head>
<title>ELEC5619 Group Project 11 - Course Advisor</title>

</head>
<body id="main">

	
	<div id="contentRight">
		<div id="dashboardSection">
<%-- 		<P>  The time on the server is ${style}. </P>
 --%>
			<section class="upperSection">
				<div class="statBox">
					<p class="statTitle custom-underline">Your Credits</p>
					<i class="fas fa-graduation-cap"></i>
					<p class="statNumber">${creditPoints}</p>
				</div>
				<div class="statBox">
					<p class="statTitle custom-underline">Remaining Credits</p>
					<i class="fas fa-chalkboard"></i>
					<p class="statNumber">${remainigPoints}</p>
				</div>
				<div class="statBox statBoxRight">
					<p class="statTitle">
						FIND<br>COURSE
					</p>
					<img src="resources/images/search-icon.png" /> 
					<p class="statNumber"></p>
				</div>
			</section>


			<section class="lowerSection">
				<div class="tableBox">
					<h4 class="custom-underline h4-underline">COMPLETED COURSES</h4>

					
					
					
					
					<table class="table table-striped">
			<thead>
				<tr>
								<th>Code</th>
								<th>Name</th>
								<th>Occurrence</th>
								<th>Year</th>
								<th>Session</th>
								<th>Credits</th>
				</tr>
			</thead>

<c:forEach var="completedCourse" items="${completedCourses}">
		<tr>
								<td>${completedCourse.code}</td>
								<td><a href="/courseAdvisor/coursedetails.htm/<c:out value='${completedCourse.code}'/>">${completedCourse.courseName}</a>
								<td>${completedCourse.occurrence}</td>
								<td>${completedCourse.yearOfCompletion}</td>
								<td>${completedCourse.session}</td>
								<td>${completedCourse.credits}</td>
							</tr>
					</c:forEach>
					</table>
				</div>
			</section>
		</div>
	</div>
	</div>

</body>
</html>
