CREATE DATABASE IF NOT EXISTS myusers;   /* Create Database*/
USE myusers;

DROP TABLE IF EXISTS `myusers`.`users`;          /*Create Table users*/
CREATE TABLE `myusers`.`users` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `displayFirstName` VARCHAR(45) NOT NULL,
  `displayLastName` VARCHAR(45) NULL,
  `specialisation` VARCHAR(45)  NULL,
  `interest` VARCHAR(45) NULL,
  `careerObjective` VARCHAR(45) NULL,
  `occupation` VARCHAR(45) NULL,
  `faculty` VARCHAR(45)  NULL,
  PRIMARY KEY (`username`));
  
/*Insert Values into Users table  */
  
INSERT INTO USERS VALUES ('sourabh123', 'Sourabh@123', 'Sourabh', 'Sinha', 'ssin6556@uni.sydney.edu.au', 'Sourav', 'Sinha', 'Data Analytics',  'Data Visualisation', 'Data Analyst', 'Student', 'School of Computer Science');
INSERT INTO USERS VALUES ('kshitiz123', 'Kshitiz@123', 'Kshitiz', 'Bhargava', 'kbha5940@uni.sydney.edu.au', 'Kshitiz', 'Bhargava', 'Software Engineering',  'Mobile Computing', 'Android Developer', 'Student', 'School of Arts & Science');
INSERT INTO USERS VALUES ('fai123', 'Fai@123', 'Jinvara', 'Vesvijak', 'jves0423@uni.sydney.edu.au', 'Fai', 'Vesvijak', 'Software Engineering',  'Web Application', 'Full Stack Developer', 'Student', 'Masters of IT/IT Mgmt');
INSERT INTO USERS VALUES ('domi123', 'Domi@123', 'Domi', 'Johnson', 'djoh3615@uni.sydney.edu.au', 'Domi', 'Johnson', 'IT Management', 'Project Management', 'Project Manager', 'Student', 'Supra');
INSERT INTO USERS VALUES ('test123', 'Test@123', 'Test', 'Test', 'test@uni.sydney.edu.au', 'Test', 'Test', 'Data Security', 'Change Management', 'Change Manager', 'Student', 'Business');
INSERT INTO USERS VALUES ('wang123', 'Wang@123', 'Yetong', 'Wang', 'ywan2540@uni.sydney.edu.au', 'Yetong', 'Wang', 'Software Engineering',  'Web Application', 'Full Stack Developer', 'Student', 'Law');
INSERT INTO USERS VALUES ('test456', 'Test@456', 'Test', 'Test', 'testP@uni.sydney.edu.au', 'Test', 'Test', '', '', '', '', 'Professor');

/* Create Table User_Course*/
CREATE TABLE USER_COURSE (username VARCHAR(32) not NULL,
						  code VARCHAR(32) not NULL,
						  courseName VARCHAR(255),
						  occurrence VARCHAR(32), 
						  yearOfCompletion int,
						  session VARCHAR(32), 
						  completedCredits int,
						  remainingCredits int,
						  credits int);
						  
/* Insert Values into User_Course table*/ 

INSERT INTO USER_COURSE VALUES ('sourabh123', 'COMP54279', 'Usability Engineering', 'ND-CC', 2019, 'S2C', 18, 78,  6);
INSERT INTO USER_COURSE VALUES ('sourabh123', 'COMP5427', 'Project Management in IT', 'ND-CC', 2019, 'S2C', 18, 78,  6);
INSERT INTO USER_COURSE VALUES ('kshitiz123', 'COMP5427', 'Project Management in IT', 'ND-CC', 2019, 'S1C', 18, 78,  6);
INSERT INTO USER_COURSE VALUES ('kshitiz123', 'COMP5347', 'Web Application Development', 'ND-CC', 2019, 'S1C', 18, 78,  6);
INSERT INTO USER_COURSE VALUES ('kshitiz123', 'COMP9103', 'Software Development in Java', 'ND-CC', 2019, 'S1C', 18, 78,  6);
INSERT INTO USER_COURSE VALUES ('fai123', 'ISYS5070', 'Change Management in IT', 'ND-CC', 2019, 'S2C', 12, 84,  6)		;
INSERT INTO USER_COURSE VALUES ('wang123', 'COMP9103', 'Software Development in Java', 'ND-CC', 2019, 'S2C', 12, 84,  6);
INSERT INTO USER_COURSE VALUES ('wang123', 'ISYS5070', 'Change Management in IT', 'ND-CC', 2019, 'S2C', 12, 84,  6);
INSERT INTO USER_COURSE VALUES ('domi123', 'COMP5206', 'Information Technologies and System', 'ND-CC', 2019, 'S2C', 6, 90,  6);
INSERT INTO USER_COURSE VALUES ('test123', 'COMP5318', 'Machine Learning', 'ND-CC', 2019, 'S1C', 6, 90,  6);
INSERT INTO USER_COURSE VALUES ('sourabh123', 'COMP5206', 'Information Technologies and Systems', 'ND-CC', 2019, 'S2C', 24, 72,  6);

/*View Table*/
select * from user_course;

/*Create Table Course*/
CREATE TABLE COURSE 
	                  (code VARCHAR(32) not NULL, 
					  courseName VARCHAR(255) not NULL,
					  courseDetails VARCHAR(512),
					  facultyName VARCHAR(32), 
					  interest VARCHAR(512), 
					  session VARCHAR(32), 
					  credits INTEGER, 
					  specialisation VARCHAR(255), 
					  overallRating FLOAT(1), 
					  reviewComment VARCHAR(255), 
					  PRIMARY KEY(code));
					  
					 
/*Insert Values into Course*/
INSERT INTO COURSE VALUES ('COMP9103', 'Software Development in Java','This unit will equip students with foundation of programming concepts that are common to widely used programming languages.','Anaissi Ali', 'Web Application,Mobile Computing,Java', 'S2C', 6,'Software Engineering',0.0,'');
INSERT INTO COURSE VALUES ('INFO5302', 'Database Management Systems', 'This unit of study provides a conceptual and practical introduction to the use of common platforms that manage large relational databases.','Chang Lijun','Web Application,Java,Machine Learning, Data Visualisation', 'S1C', 6, 'Data Analytics',0.0,'');
INSERT INTO COURSE VALUES ('INFO5301','Information Security Management', 'This unit of study gives a broad view of the management aspects of information security.','Thilakarathna Kanchana', 'Change Management,Java', 'S2C', 6, 'Data Security',0.0,'');
INSERT INTO COURSE VALUES ('ISYS5070', 'Change Mangement in IT','This unit of study presents the leading edge of research and practice in change management.','Dr Kuan Kevin', 'Change Management,Project Management' , 'S2C', 6, 'IT Management',0.0,'');
INSERT INTO COURSE VALUES ('INFO5060', 'Data Analytics and Business Intelligence', 'This course provides an overview of Business Intelligence (BI) concepts, technologies and practices.','Dr Kuan Kevin','Web Application,Java,Machine Learning, Data Visualisation', 'S1C', 6, 'Data Analytics',0.0,'');
INSERT INTO COURSE VALUES ('COMP5048', 'Data Visualisation', 'This unit will provide visualisation techniques and fundamental algorithms to achieve good visualisation of abstract information.','Hong SeokHee', 'Web Application,Java,Machine Learning, Data Visualisation', 'S2C', 6, 'Data Analytics',0.0,'');
INSERT INTO COURSE VALUES ('COMP54279', 'Usability Enginerring','This unit will enable students to learn the fundamental concepts, methods and techniques of usability engineering.','Kay Juday', 'Web Application,Mobile Computing,Java', 'S2C', 6,'Software Engineering',0.0,'');


/*Create table survey*/
CREATE TABLE SURVEY (surveyId INTEGER NOT NULL AUTO_INCREMENT, code VARCHAR(32) NOT NULL,username VARCHAR(32) NOT NULL,feedbackStatus BOOLEAN, completionStatus decimal(5,2),avgScore FLOAT(1),comment VARCHAR(512),PRIMARY KEY(surveyId),FOREIGN KEY (code) REFERENCES COURSE(code),FOREIGN KEY (username) REFERENCES USERS(username));