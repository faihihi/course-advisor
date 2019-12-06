<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@ include file="/WEB-INF/jsp/components/framework.jsp"%>
<html>
<head>
<title>ELEC5619 Group Project 11 - Course Advisor</title>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/surveyGraph.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/feedbackGraph.js" />"></script>
</head>
<body>

	<div id="contentRight">
		<h4><span style="color: 58A9E5; font-weight: bold">${courseCode}</span> :
			${courseName}
		</h4>
			<section id="courseDetailPage" class="lowerSection">
				<div class="tableBox">
					<h4 class="custom-underline h4-underline">Course Details</h4>
					<p>${courseDescription}</p>
					<p>Lecturer : ${lectureName}</p>
					<p>Specialisation : ${specialisation}</p>
					<button class="fullDetailBtn">
						FULL DETAILS <i
							class="fas fa-arrow-circle-right"></i>
					</button>
				</div>
			</section>
			<br> <br>

			<section id="ex" class="lowerSection">
				<div class="tableBox">
					<h4 class="custom-underline h4-underline">Feedback</h4>
					<br>

					<div id="overall" class="statBox">
						<p class="statTitle custom-underline">Overall Ratings</p>
						<i class="fas fa-star"></i>
						<p class="statNumber">${courseRating}/ 5</p>
					</div>

					<div id="recent" class="statBox">
						<p class="statTitle custom-underline">Recent Reviews</p>
						<div class="surveyMessage">${surveyMessage}</div>
					</div>

					<br>
					<div id="overview" class="statBox">
						<p class="statTitle custom-underline">Feedback Overview</p>

						<!-- The Modal -->
						<div id="feedbackModal" class="modal" style="${modalStyle}">

							<!-- Modal content -->
							<div class="modal-content">
								<div class="modalTopBar">
									Course Feedback : <span class="close">&times;</span>
								</div>
								<div class="surveyquestion">

									<p>
										Q1: Overall, I was satisfied with the quality of teaching by
										the teacher(s). <br>
									</p>
									<div class="single-coursereview">
										<div id="feedbackChart" class="chart">
											<canvas id="myChart1"></canvas>
										</div>
									</div>
									<p>
										Q2: The work has been intellectually rewarding.<br>
									</p>
								</div>
							</div>

						</div>
						
						<div id="reviewChart" class="chart">
							<canvas id="myChart"></canvas>
						</div>
						
						<button id="fullFBbtn" class="fullFeedbackBtn">
							<a href="<c:url value="feedbackmodal.htm"/>">VIEW FULL
								FEEDBACK<i class="fas fa-arrow-circle-right"></i>
							</a>
						</button>

						

						<p class="statTitle custom-underline">Survey Questions</p>
						<br> <br> Q1: Overall, I was satisfied with the quality
						of teaching by the teacher(s). <br> Q2: The work has been
						intellectually rewarding. <br> Q3: I developed relevant
						critical and analytical thinking skills.<br> Q4: I have had
						good access to valuable learning resources. <br> Q5: The
						assessment tasks challenged me to learn.<br> Q6: I have been
						guided by helpful feedback on my learning.<br> Q7: I
						developed my ability to practically apply knowledge of the
						field(s) I am studying<br> Q8: I developed my ability to
						think independently about problems.<br> Q9: I developed my
						ability to work effectively with digital and online tools and
						information<br> Q10: I developed my capacity to respond
						constructively to challenge.<br>
					</div>


					<br>
				</div>
			</section>


	</div>

</body>
</html>
