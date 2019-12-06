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
<body>

	<div id="contentRight">
		<section class="lowerSection">
			<div class="tableBox">
				<h4 class="custom-underline h4-underline">RECOMMENDED COURSES</h4>
				<input type="text" class="search form-control"
					placeholder="Search Course...">
				<table id="recommended-course-table"
					class="table table-hover table-bordered results">
					<thead>
						<tr>
							<th>Code</th>
							<th>Name</th>
							<th>Interest</th>
							<th>Session</th>
							<th>Credits</th>
						</tr>

					</thead>
					<tbody>
						<tr class="warning no-result">
							<td colspan="5"><i class="fa fa-warning"></i> No result</td>
						</tr>
						<a href="<c:url value="/"/>">
						
						<c:forEach var="completedCourse" items="${recommendedCourse}">
							<tr>
								<td>${completedCourse.code}</td>
								<td><a href="/courseAdvisor/coursedetails.htm/<c:out value='${completedCourse.code}'/>">${completedCourse.courseName}</a></td>
								<td>${completedCourse.interest}</td>
								<td>${completedCourse.session}</td>
								<td>${completedCourse.credits}</td>
							</tr>
					</c:forEach>
					</tbody>

				</table>
			</div>
		</section>
	</div>

</body>
</html>
