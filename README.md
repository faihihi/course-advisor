# Course Advisor

Course Advisor is a web portal for the students from the school of IT at the University of Sydney who needs guidance in selecting units of study during their course enrolment every semester. The project vision is to provide swift and beneficial guidance to students in unit selection anywhere and anytime without squandering time for appointments, session and travelling.

## Features

**Video introducing Course Advisor** : https://www.youtube.com/watch?v=d6zC0sjCoO0

* Recommend courses based on interests and specialisation
* User Account and Settings
* Different Role Access Control for Students and Faculty Members
* Search courses
* View course details, ratings, and feedbacks
* View completed credits, remaining credits, and completed courses (Only for Student)
* Track status of feedback survey completion (Only for Student)
* Able to take feedback for courses taken (Only for Student)

### Login and Registration

<p align="center"><img src="./images/Login.png" width="700"></p>
<p align="center"><img src="./images/Register.png" width="700"></p>

For initial login, user has to set their interest and career objective
<p align="center"><img src="./images/Initial_setting.png" width="700"></p>

User can change their settings later in the User Setting page
<p align="center"><img src="./images/User_setting.png" width="700"></p>

### Dashboard (For student only)
Student can view their completed credits and courses, and the remaining credits to complete their degree in the Dashboard.
<p align="center"><img src="./images/Dashboard.png" width="700"></p>

### Courses & Ratings
Courses shown are recommended courses for users based on their interests and specilisation configured in the user setting.
<p align="center"><img src="./images/Courses_Rating.png" width="700"></p>

Each course detail page contains information related to the course, external link to official webpage with full details, overall ratings, and reviews from students who have taken the course.
<p align="center"><img src="./images/Course_details1.png" height="350"> <img src="./images/Course_details2.png" height="250"></p>

### Feedback Survey (For student only)
Student can view their feedback survey completion status,
<p align="center"><img src="./images/Feedback_survey.png" width="700"></p>

And take the incomplete survey
<p align="center"><img src="./images/Course_feedback.png" width="700"></p>

### Access for Faculty Members
Faculty members account can only access to Courses & Ratings module. They will have no access to dashboard and feedback modules.
<p align="center"><img src="./images/Prof_access.png" width="700"></p>

## Prerequisites
The following applications must be available on the Operating PC to run this project.

* Eclipse JEE with Maven plugin
* JDK 8 or later
* Apache Tomcat v8.5 or later
* MySQL Workbench Version Build 8.0.18

## Installation

1. Clone or download this repository
2. Install and configure Tomcat server on Eclipse IDE
3. Import project to Eclipse as `courseAdvisor`
4. Right click on the project name `courseAdvisor`, in `ProjectExplorer -> Properties -> TargetRuntime -> New -> Apache Tomcat V9.0 -> Finish`

## Configuration

* Configure the Maven Plugin on Eclipse IDE (in case, it's unavailable)
`Click Help -> Install New Software...-> Add Repository -> Set Name as "M2E Eclipse" and Location as "http://download.eclipse.org/technology/m2e/releases"`

* Configure the mySQL WorkBench database with default ID as `root` and Password as `3102`. Default host is `localhost:3306`

* To setup the database, run SQL commands located in `/courseAdvisor/src/main/resources/au.usyd/sql/ddl.sql`

* Configure the localHost of the Server as port `8080`

## Run application
To run the application:
```
Right click on project name courseAdvisor -> Run As -> Run on Server
```

URL to start the Project : http://localhost:8080/courseAdvisor/
