package au.usyd.courseAdvisor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import au.usyd.courseAdvisor.dao.UserDao;
import au.usyd.courseAdvisor.model.Login;
import au.usyd.courseAdvisor.model.Survey;
import au.usyd.courseAdvisor.model.User;
import au.usyd.courseAdvisor.model.Course;
import au.usyd.courseAdvisor.model.UserCompletedCourse;;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public void register(User user) {
    userDao.register(user);
  }

  public User getUserDetails(String userId) {
	    return userDao.getUserDetails(userId);
	  }
  
  public List<Course> getRecommendedCourses(String interest) {
	    return userDao.getRecommendedCourses(interest);
	  }

  
  public int addSurveyFeedback(Survey survey) {
	    return userDao.addSurveyFeedback(survey);
	  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }
  
  public int update(User user) {
	    return userDao.update(user);
	  }


  public UserCompletedCourse getCreditPoints(String userId) {
	    return userDao.getCreditPoints(userId);
	  }

  public List<UserCompletedCourse> getCompletedCourses(String userId) {
	    return userDao.getCompletedCourses(userId);
	  }
  
  
  public Course getCourseDetails(String code){
	  return userDao.getCourseDetails(code);
  }
  
}
