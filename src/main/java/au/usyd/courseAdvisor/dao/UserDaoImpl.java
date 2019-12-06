package au.usyd.courseAdvisor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import au.usyd.courseAdvisor.model.Course;
import au.usyd.courseAdvisor.model.Login;
import au.usyd.courseAdvisor.model.Survey;
import au.usyd.courseAdvisor.model.User;
import au.usyd.courseAdvisor.model.UserCompletedCourse;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void register(User user) {

    String sql = "insert into users values(?,?,?,?,?,?,?,?,?,?,?,?)";

    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
        user.getLastname(), user.getEmail(), user.getDisplayFirstName() ,
        user.getDisplayLastName(), user.getSpecialisation(), user.getInterest(), user.getCareerObjective(), user.getOccupation(),user.getFaculty()});
  }

  public int addSurveyFeedback(Survey survey) {
	  System.out.println("in add");
	  System.out.println(survey.getCode() +  survey.getUsername() + survey.getAvgScore());

		String sql = "INSERT INTO SURVEY(code,username,feedBackStatus,avgScore, completionStatus, comment)VALUES(?,?,?,?,?,?)";
		

		try {
			System.out.println("Logging new survey response");
			int counter = jdbcTemplate.update(sql,
					new Object[] { survey.getCode(), survey.getUsername(), survey.isFeedbackStatus(), survey.getAvgScore() , survey.getCompletionStatus(), survey.getComment()});
			
			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
  
  public boolean getSurveyStatus(String userId, String code) {
	  String sql = "select * from survey where username = '" + userId + "' and code = '"+ code + "';";

	  List<Survey> survey = jdbcTemplate.query(sql, new SurveyMapper());
	  System.out.println("userID:"+userId+ " code:"+ code +" " +  survey.size());
	  
	  if(survey.size() > 0) {
		  System.out.println("survey status " + survey.get(0).getCompletionStatus());
		  return true;
	  } else {
		  return false;
	  }
	}

  public Course getCourseDetails(String code){
	  String sql = "select * from course where code='" + code   + "'";

	  List<Course> courses = jdbcTemplate.query(sql, new CourseMapper());
	    
	    return courses.size() > 0 ? courses.get(0) : null;
  }
  
  public float getCourseOverallRating(String code) {
	  String sql = "select * from survey where code='" + code   + "'";
	  
	  List<Survey> survey = jdbcTemplate.query(sql, new SurveyMapper());
	  float overallRating = 0;
	  for(int i=0;i<survey.size();i++) {
		  overallRating = overallRating + survey.get(i).getAvgScore();
	  }
	  
	  overallRating = overallRating/survey.size();
	  
	  return overallRating;
  }
  
  public String getLatestComment(String code) {
	  String sql = "select * from survey where code='" + code   + "'";
	  List<Survey> survey = jdbcTemplate.query(sql, new SurveyMapper());
	  
	  if(survey.size() > 0) {
		  return survey.get(survey.size()-1).getComment();
	  } else {
		  return "";
	  }
  }
  
  
  public User validateUser(Login login) {

    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
        + "'";

    List<User> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
  

}

  public User getUserDetails (String userId) {

	    String sql = "select * from users where username='" + userId   + "'";

	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	    
	    return users.size() > 0 ? users.get(0) : null;
	  

	}
  
  public List<Course> getRecommendedCourses (String interest) {
	  
	  System.out.println(interest);
	
	    String sql = "  Select * FROM COURSE WHERE specialisation = '" + interest   + "'";

	    System.out.println(sql);
	    List<Course> courses = jdbcTemplate.query(sql, new CourseMapper());
	    
	 System.out.println(courses);
	    return courses;
	  

	}

  
	public int update(User user) {
		String sql = "update  users displayFirstName=?, displayLastName=?, email=? where username=?";

		try {

			int counter = jdbcTemplate.update(sql,
					new Object[] { user.getUsername(), user.getDisplayFirstName(), user.getEmail(), user.getFaculty() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

public List<UserCompletedCourse> getCompletedCourses(String userId) {
	
	String sql = "select * from user_course where username='" + userId + "'";

	List<UserCompletedCourse> userCompletedCourses = jdbcTemplate.query(sql, new RowMapper<UserCompletedCourse>() {

		public UserCompletedCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
			 UserCompletedCourse userCompletedCourse = new UserCompletedCourse();

			  System.out.println(rs.getString("yearOfCompletion"));
			  System.out.println(rs.getString("code"));
			  
			  userCompletedCourse.setUsername(rs.getString("username"));
			  userCompletedCourse.setCode(rs.getString("code"));
			  userCompletedCourse.setCourseName(rs.getString("courseName"));
			  userCompletedCourse.setOccurrence(rs.getString("occurrence"));
			  userCompletedCourse.setYearOfCompletion(rs.getInt("yearOfCompletion"));
			  userCompletedCourse.setSession(rs.getString("session"));
			  userCompletedCourse.setCompletedCredits(rs.getInt("completedCredits"));
			  userCompletedCourse.setRemainingCredits(rs.getInt("remainingCredits"));
			  userCompletedCourse.setCredits(rs.getInt("credits"));
			  return userCompletedCourse;
		}

	});

	return userCompletedCourses;
}


public UserCompletedCourse getCreditPoints(String userId) {


	  String sql = "select * from user_course where username='" + userId + "'";

	  List<UserCompletedCourse> userCompletedCourses = jdbcTemplate.query(sql, new UserCompletedCourseMapper());

	  return userCompletedCourses.get(0);
	}


class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();

    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));   
    user.setDisplayFirstName(rs.getString("displayFirstName"));
    user.setDisplayLastName(rs.getString("displayLastName"));
    user.setSpecialisation(rs.getString("specialisation"));
    user.setInterest(rs.getString("interest"));
    user.setOccupation(rs.getString("occupation"));
    user.setFaculty(rs.getString("faculty"));

    return user;
  }
}


class CourseMapper implements RowMapper<Course> {

	  public Course mapRow(ResultSet rs, int arg1) throws SQLException {
	    Course course = new Course();
	    System.out.println("in impl");
		System.out.println(rs.getString("facultyName"));
		course.setCode(rs.getString("code"));
		course.setCourseName(rs.getString("courseName"));
		course.setCourseDetails(rs.getString("courseDetails"));
		course.setFacultyName(rs.getString("facultyName"));
		course.setInterest(rs.getString("interest"));   
		course.setSession(rs.getString("session"));
		course.setSpecialisation(rs.getString("specialisation"));
		course.setCredits(rs.getInt("credits"));
		course.setOverallRating(rs.getFloat("overallRating"));
		course.setReviewComment(rs.getString("reviewComment"));
		return course;
	  }
	}



class UserCompletedCourseMapper implements RowMapper<UserCompletedCourse> {

	  public UserCompletedCourse mapRow(ResultSet rs, int arg1) throws SQLException {
		  UserCompletedCourse userCompletedCourse = new UserCompletedCourse();

		  System.out.println(rs.getString("yearOfCompletion"));
		  System.out.println(rs.getString("code"));
		  
		  userCompletedCourse.setUsername(rs.getString("username"));
		  userCompletedCourse.setCode(rs.getString("code"));
		  userCompletedCourse.setCourseName(rs.getString("courseName"));
		  userCompletedCourse.setOccurrence(rs.getString("occurrence"));
		  userCompletedCourse.setYearOfCompletion(rs.getInt("yearOfCompletion"));
		  userCompletedCourse.setSession(rs.getString("session"));
		  userCompletedCourse.setCompletedCredits(rs.getInt("completedCredits"));
		  userCompletedCourse.setRemainingCredits(rs.getInt("remainingCredits"));
		  userCompletedCourse.setCredits(rs.getInt("credits"));
		  return userCompletedCourse;
	  }
	}

class SurveyMapper implements RowMapper<Survey>{

	@Override
	public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
		Survey survey = new Survey();
		
		survey.setAvgScore(rs.getFloat("avgScore"));
		survey.setCode(rs.getString("code"));
		survey.setComment(rs.getString("comment"));
		survey.setCompletionStatus(rs.getFloat("completionStatus"));
		survey.setFeedbackStatus(rs.getBoolean("feedbackStatus"));
		survey.setSurveyId(rs.getInt("surveyId"));
		survey.setUsername(rs.getString("username"));
		
		return survey;
	}
	
}

}
