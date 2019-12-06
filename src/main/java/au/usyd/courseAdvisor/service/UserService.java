package au.usyd.courseAdvisor.service;

import java.util.List;

import au.usyd.courseAdvisor.model.Login;
import au.usyd.courseAdvisor.model.Survey;
import au.usyd.courseAdvisor.model.User;
import au.usyd.courseAdvisor.model.Course;
import au.usyd.courseAdvisor.model.UserCompletedCourse;;

public interface UserService {

  void register(User user);
  
  List<UserCompletedCourse> getCompletedCourses(String userId );
  
  UserCompletedCourse getCreditPoints(String userId );
  
  User getUserDetails(String userId);

  User validateUser(Login login);
  
  int update(User user);
  
  List<Course> getRecommendedCourses(String interest);

  int addSurveyFeedback(Survey survey);
  
   Course getCourseDetails(String code);
}
