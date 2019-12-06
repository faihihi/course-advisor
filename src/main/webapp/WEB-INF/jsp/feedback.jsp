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
		<div id="feedbackPage">
			<section class="upperSection">
				<div class="statBox">
					<p class="statTitle custom-underline">Completion Status</p>
					<i class="fas fa-list-ul"></i>
					<p class="statNumber">75%</p>
				</div>
				<div class="statBox statBoxRight">
					<p class="statTitle"></p>
					<img src="<c:url value="/resources/images/modern-education-system.jpg"/>" />
					<p class="statNumber"></p>
				</div>
			</section>

			<section class="lowerSection">
				
				<div class="tableBox">
					<h4 class="custom-underline h4-underline">COMPLETED COURSES</h4>
					<input type="text" class="search form-control"
						placeholder="Search Course...">
					<table id="recommended-course-table"
						class="table table-hover table-bordered results">
						<thead>
							<tr>
								<th>Code</th>
								<th>Name</th>
								<th>Session</th>
								<th>Credits</th>
								<th>Survey Status</th>
							</tr>

						</thead>
						<tbody>
						
						<c:forEach var="completedCourse" items="${completedCourses}">
		<tr>
								<td>${completedCourse.code}</td>
								<td><a href="/courseAdvisor/coursedetails.htm/<c:out value='${completedCourse.code}'/>">${completedCourse.courseName}</a>
								
								</td>
								<td>${completedCourse.session}</td>
								<td>${completedCourse.credits}</td>
								<td>
								<div class="surveyBtn start" style="${completedCourse.notCompleteStatusStyle}">
								<a href="feedback/modal-part1/<c:out value='${completedCourse.courseName}'/>/<c:out value='${completedCourse.code}'/>">View Form<i
											class="fas fa-chevron-circle-right"></i></a>			
								
									</div>
									
									<div class="surveyBtn complete" style="${completedCourse.completeStatusStyle}">
								<a href="#">Completed</a>			
								
									</div>
									
									
									
									
									</td>
							</tr>
					</c:forEach>
						
						</tbody>

					</table>
				</div>
			
								</section>
			
			
			
			<!-- Trigger/Open The Modal -->


			<!-- Modal part 1 -->
			<div id="surveyModal" class="modal" style="${modalOneStyle}">
			

				<!-- Modal content -->
				<div class="modal-content">
					<div class="modalTopBar">
						<span style="color: 58A9E5; font-weight: bold; font-size:23px">Course
							Feedback</span> : ${courseCode}  ${courseName} <span class="close">&times;</span>
					</div>

					<div class="surveyquestion">
					
					<form id="feedbackForm" action="feedbackResponse" method="post">
				
						<div class="questionSection">
							<p>Q1: Overall, I was satisfied with the quality of teaching
								by the teacher(s).</p>
							<label class="radio"> <input type="radio" name="q1"
								value="1"> <span>Strongly Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q1" value="2"> <span>Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q1" value="3"> <span>Neutral</span>
							</label> <label class="radio"> <input type="radio"
								name="q1" value="4"> <span>Agree</span>
							</label> <label class="radio"> <input type="radio"
								name="q1" value="5"> <span>Strongly Agree</span>
							</label>
						</div>
						<div class="questionSection">
							<p>Q2: The work has been intellectually rewarding.</p>
							<label class="radio"> <input type="radio" name="q2"
								value="1"> <span>Strongly Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q2" value="2"> <span>Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q2" value="3"> <span>Neutral</span>
							</label> <label class="radio"> <input type="radio"
								name="q2" value="4"> <span>Agree</span>
							</label> <label class="radio"> <input type="radio"
								name="q2" value="5"> <span>Strongly Agree</span>
							</label>
						</div>
						<div class="questionSection">
							<p>Q3: I developed relevant critical and analytical thinking
								skills.</p>
							<label class="radio"> <input type="radio" name="q3"
								value="1"> <span>Strongly Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q3" value="2"> <span>Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q3" value="3"> <span>Neutral</span>
							</label> <label class="radio"> <input type="radio"
								name="q3" value="4"> <span>Agree</span>
							</label> <label class="radio"> <input type="radio"
								name="q3" value="5"> <span>Strongly Agree</span>
							</label>
						</div>
						<div class="questionSection">
							<p>Q4: I have had good access to valuable learning resources.</p>
							<label class="radio"> <input type="radio" name="q4"
								value="1"> <span>Strongly Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q4" value="2"> <span>Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q4" value="3"> <span>Neutral</span>
							</label> <label class="radio"> <input type="radio"
								name="q4" value="4"> <span>Agree</span>
							</label> <label class="radio"> <input type="radio"
								name="q4" value="5"> <span>Strongly Agree</span>
							</label>
						</div>
						<div class="questionSection">
							<p>Q5: The assessment tasks challenged me to learn.</p>
							<label class="radio"> <input type="radio" name="q5"
								value="1"> <span>Strongly Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q5" value="2"> <span>Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q5" value="3"> <span>Neutral</span>
							</label> <label class="radio"> <input type="radio"
								name="q5" value="4"> <span>Agree</span>
							</label> <label class="radio"> <input type="radio"
								name="q5" value="5"> <span>Strongly Agree</span>
							</label>
						</div>
						<div class="questionSection">
							<p>Q6: I have been guided by helpful feedback on my learning.</p>
							<label class="radio"> <input type="radio" name="q6"
								value="1"> <span>Strongly Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q6" value="2"> <span>Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q6" value="3"> <span>Neutral</span>
							</label> <label class="radio"> <input type="radio"
								name="q6" value="4"> <span>Agree</span>
							</label> <label class="radio"> <input type="radio"
								name="q6" value="5"> <span>Strongly Agree</span>
							</label>
						</div>
						<div class="questionSection">
							<p>Q7: I developed my ability to practically apply knowledge
								of the field(s)</p>
							<label class="radio"> <input type="radio" name="q7"
								value="1"> <span>Strongly Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q7" value="2"> <span>Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q7" value="3"> <span>Neutral</span>
							</label> <label class="radio"> <input type="radio"
								name="q7" value="4"> <span>Agree</span>
							</label> <label class="radio"> <input type="radio"
								name="q7" value="5"> <span>Strongly Agree</span>
							</label>
						</div>
						<div class="questionSection">
							<p>Q8: I developed my ability to think independently about
								problems.</p>
							<label class="radio"> <input type="radio" name="q8"
								value="1"> <span>Strongly Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q8" value="2"> <span>Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q8" value="3"> <span>Neutral</span>
							</label> <label class="radio"> <input type="radio"
								name="q8" value="4"> <span>Agree</span>
							</label> <label class="radio"> <input type="radio"
								name="q8" value="5"> <span>Strongly Agree</span>
							</label>
						</div>
						<div class="questionSection">
							<p>Q9: I developed my ability to work effectively with
								digital and online tools and information.</p>
							<label class="radio"> <input type="radio" name="q9"
								value="1"> <span>Strongly Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q9" value="2"> <span>Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q9" value="3"> <span>Neutral</span>
							</label> <label class="radio"> <input type="radio"
								name="q9" value="4"> <span>Agree</span>
							</label> <label class="radio"> <input type="radio"
								name="q9" value="5"> <span>Strongly Agree</span>
							</label>
						</div>
						<div class="questionSection">
							<p>Q10: I developed my capacity to respond constructively to
								challenge.</p>
							<label class="radio"> <input type="radio" name="q10"
								value="1"> <span>Strongly Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q10" value="2"> <span>Disagree</span>
							</label> <label class="radio"> <input type="radio"
								name="q10" value="3"> <span>Neutral</span>
							</label> <label class="radio"> <input type="radio"
								name="q10" value="4"> <span>Agree</span>
							</label> <label class="radio"> <input type="radio"
								name="q10" value="5"> <span>Strongly Agree</span>
							</label>
						</div>
						
						<div class="questionSection">
							<p>Do you have any message about this course for other prospective students?</p>
							<textarea name="q11" rows="4" cols="50" placeholder="Ex. Your experience, advice, recommendation"></textarea>
						</div>
						
						<p id="errorresult">${message}</p>
					
					<button id="feedbackform-btn" class="saveBtn" type="submit" form="feedbackForm" value="Submit">
					<div>SAVE</div>
					<img src="<c:url value="/resources/images/login.png"/>" />
					</button>
						
						</form>
						
						
					</div>
				</div>

			</div>
			
			
			<!-- Modal part 2 -->
			<div id="surveyModal2" class="modal" style="${modalTwoStyle}">
				<!-- Modal content -->
				<div class="modal-content">
					<div class="modalTopBar">
						<span style="color: 58A9E5; font-weight: bold; font-size:23px">Course
							Feedback</span> :  ${courseCode}  ${courseName}  <span class="close">&times;</span>
					</div>
					<div class="surveyquestion">
						<h4>Your overall ratings:<span style="font-size:30px"> ${userRating}/10${modalOverallRating}</span></h4>
						<p style="margin-top: -25px">Note: automatically calculated based on your responses of the previous questions</p>
						
						<a href="<c:url value="/feedback.htm"/>">
						<button class="saveBtn" type="submit" form="userSetting"
					value="Submit">
					<div>Back to Feedback</div>
					<img src="<c:url value="/resources/images/login.png"/>" />
				</button>
						</a>
						
					</div>
				</div>

			</div>


		</div>

	</div>

</body>
</html>
