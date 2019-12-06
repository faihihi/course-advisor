<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:400,400i,600&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/solid.css"
	integrity="sha384-ioUrHig76ITq4aEJ67dHzTvqjsAP/7IzgwE7lgJcg2r7BRNGYSK0LwSmROzYtgzs"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/fontawesome.css"
	integrity="sha384-sri+NftO+0hcisDKgr287Y/1LVnInHJ1l+XC7+FOabmTTIK0HnE2ID+xxvJ21c5J"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/main.js" />"></script>


<div class="container">
	<div id="contentLeft">
		<ul id="leftNavigation">
			<li id="welcomeSec"><div id="course_txt">COURSE</div> <br>
				<div id="advisor_txt">ADVISOR</div> <br></li>
			<li id="homeMenu" style="${homeMenu}"><a href="<c:url value="/home"/>" style="${homeStyle}"><i
					class="fas fa-home leftNavIcon"></i> Home </a></li>
			<li id="courseMenu" style="${courseMenu}"><a href="<c:url value="/course.htm"/>" style="${courseStyle}"><i
					class="fas fa-chalkboard leftNavIcon"></i> Courses & Rating </a></li>
			<li id="surveyMenu" style="${feedbackMenu}"><a href="<c:url value="/feedback.htm"/>" style="${feedbackStyle}"><i
					class="fas fa-poll leftNavIcon"></i> Feedback Survey </a></li>
		</ul>
	</div>

	<div id="rightNavigation">
		<div id="pageTitle">
			<h3>${pageTitle}</h3>
		</div>
		<div id="userProfileSection">
			<img src="<c:url value="/resources/images/fai-test.jpg"/>" id="userImage" />
			<p id="userProfileName">${userName}</p>
			<a href="<c:url value="/setting.htm"/>"><i class="fas fa-cog"></i></a> 
			<!-- <a href="#"><i class="fas fa-envelope"></i></a> --> 
			<a href="mailto:info@course-advisor.com"><i
				class="fas fa-question-circle"></i></a> <a href="#"><i
				class="fas fa-sign-out-alt"></i></a>
		</div>
	</div>