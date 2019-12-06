
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
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
</head>



<body id="initialPage">

	<div class="wrapper">
		<div id="contentLeftInitial">
			<img id="homepagePic" class="picture" alt="home page pic"
				src="resources/images/Sydney-University-2.jpg">
		</div>


		<div id="contentRightInitial">
			<div id="tbHomepage" class="tableBox">
				<p id="welcome1" class="welcompage-custom1">WELCOME TO</p>
				<p class="welcompage-custom2">COURSE ADVISOR</p>
				
				<p id="errorresult"></p>

				<form:form id="regForm" modelAttribute="user"
					action="registerProcess" method="post">
					<div id="regInputWrapper">
					<div class="wrap-input100 validate-input username-input" data-validate = "Enter username">
						<form:input path="username" name="username" id="username" class="input100 loginrequired" placeholder="Username" type="text"/>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<form:input path="password" name="password" id="password" class="input100 loginrequired" placeholder="Password" type="password"/>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100" data-validate="Enter Email">
						<form:input path="email" name="email" id="email" class="input100 loginrequired" placeholder="Email" type="email"/>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 inline-input" data-validate="Enter First Name">
						<form:input path="firstname" name="firstname" id="firstname" class="input100 loginrequired" placeholder="First name" type="text"/>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 inline-input" data-validate="Enter Last Name">
						<form:input path="lastname" name="lastname" id="lastname" class="input100 loginrequired" placeholder="Last name" type="text"/>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 address-input" data-validate="Enter Address">
						<form:input path="address" name="address" id="address" class="input100" placeholder="Address" type="text"/>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100" data-validate="Enter Phone">
						<form:input path="phone" name="phone" id="phone" class="input100" placeholder="Phone" type="text"/>
						<span class="focus-input100"></span>
					</div> 



					<div class="profileForm">
						<br>
						
						<p>Are you a Faculty Member?</p>
						<form:select path="occupation" name="occupation">
							<form:option value="FacultyMember">Faculty Member</form:option>
						</form:select>
						
						<p>FACULTY</p>
						<div class="wrap-input100 inline-input" data-validate="Enter Faculty">
						<form:input path="faculty" name="faculty" id="faculty" class="input100 loginrequired" placeholder="Name of your Faculty" type="text"/>
						<span class="focus-input100"></span>
					</div>
						
						<p>SPECIALISATION</p>
						<form:select path="specialisation" name="specialisation">
							<form:option value="Software Engineering">Software Engineering</form:option>
							<form:option value="Data Analytics">Data Analytics</form:option>
							<form:option value="Data Security">Data Security</form:option>
							<form:option value="IT Management">IT Management</form:option>
						</form:select>
						
						<p>INTEREST</p>
						<form:select path="interest" name="userInterest">
							<form:option value="Cloud Computing">Cloud Computing</form:option>
							<form:option value="Mobile Development">Mobile Development</form:option>
							<form:option value="web development">Web Development</form:option>
							<form:option value="machine learning">Machine Learning</form:option>
						</form:select>

						<p>CAREER OBJECTIVE</p>
						<form:select path="careerObjective" name="careerObjective">
							<form:option value="Cloud Computing">Cloud Computing</form:option>
							<form:option value="Mobile Development">Mobile Development</form:option>
							<form:option value="Web Development">Web Development</form:option>
							<form:option value="Machine Learning">Machine Learning</form:option>
						</form:select>
					</div>
					</div>

					

				<form:button id="register" name="register" class="saveBtn"
					type="submit" form="regForm" value="Submit">
					<div>SAVE</div>
					<img src="resources/images/login.png" />
				</form:button>
				
				</form:form>


			</div>
		</div>
	</div>

</body>
</html>