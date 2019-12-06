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
							<th>Specialisation</th>
							<th>Session</th>
							<th>Credits</th>
						</tr>

					</thead>
					<tbody>
						<tr class="warning no-result">
							<td colspan="5"><i class="fa fa-warning"></i> No result</td>
						</tr>
						<tr>
							<th scope="row">COMP5206</th>
							<td>Information Technologies and Systems</td>
							<td>#management,#foundation,#BI</td>
							<td>S2C</td>
							<td>6</td>
						</tr>
						<tr>
							<th scope="row">COMP5427</th>
							<td>Usability Engineering</td>
							<td>#UX#UI#prototyping#usability</td>
							<td>S2C</td>
							<td>6</td>
						</tr>
						<tr>
							<th scope="row">COMP5206</th>
							<td>Information Technologies and Systems</td>
							<td>#management,#foundation,#BI</td>
							<td>S2C</td>
							<td>6</td>
						</tr>
						<tr>
							<th scope="row">COMP5427</th>
							<td>Usability Engineering</td>
							<td>#UX#UI#prototyping#usability</td>
							<td>S2C</td>
							<td>6</td>
						</tr>
					</tbody>

				</table>
			</div>
		</section>
	</div>

</body>
</html>
