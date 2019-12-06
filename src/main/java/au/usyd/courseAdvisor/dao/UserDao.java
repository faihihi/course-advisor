package au.usyd.courseAdvisor.dao;

import java.util.List;

import au.usyd.courseAdvisor.model.Login;
import au.usyd.courseAdvisor.model.Survey;
import au.usyd.courseAdvisor.model.User;
import au.usyd.courseAdvisor.model.Course;
import au.usyd.courseAdvisor.model.UserCompletedCourse;

public interface UserDao {

  public void register(User user);

  public User validateUser(Login login);
  
  public List<UserCompletedCourse> getCompletedCourses(String userId );
  
  public UserCompletedCourse getCreditPoints(String userId );
  
  public User getUserDetails(String userId );
  
  public int update(User user);
  
  public List<Course> getRecommendedCourses(String interest);
  
  public Course getCourseDetails(String code);
  
  public int addSurveyFeedback(Survey survey);
  
  public boolean getSurveyStatus(String userId, String code);
  
  public float getCourseOverallRating(String code);
  
  public String getLatestComment(String code);

}
