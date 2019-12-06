package au.usyd.courseAdvisor.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.courseAdvisor.dao.UserDao;
import au.usyd.courseAdvisor.model.Course;
import au.usyd.courseAdvisor.model.User;
import au.usyd.courseAdvisor.model.UserCompletedCourse;
import au.usyd.courseAdvisor.service.UserService;

@Controller
public class RegistrationController {
	private static final String menuBg = "background-color: #5C6879";
	private static final String collapseMenu = "visibility: collapse";
	
  @Autowired
  public UserService userService;
  
  @Autowired
	private UserDao userDao;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());

    return mav;
  }

  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("user") User user) {
    userService.register(user);
		    
    ModelAndView mav = new ModelAndView();
    if(user.getOccupation().matches("FacultyMember")) {
    	mav = new ModelAndView("course");
    	mav.addObject("userName", user.getFirstname()+ " " +user.getLastname());
    	mav.addObject("homeMenu", collapseMenu);
    	mav.addObject("feedbackMenu", collapseMenu);
    	mav.addObject("courseMenu", menuBg);
    	
    	List<Course> recommendedCourse = userDao.getRecommendedCourses(user.getSpecialisation());
    	mav.addObject("recommendedCourse", recommendedCourse);

    } else {
        mav = new ModelAndView("welcome");
        mav.addObject("userName", user.getFirstname()+ " " +user.getLastname());
    }
    return mav;
  }
}
