package au.usyd.courseAdvisor.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.courseAdvisor.dao.UserDao;
import au.usyd.courseAdvisor.model.User;
import au.usyd.courseAdvisor.model.Course;
import au.usyd.courseAdvisor.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String menuBg = "background-color: #5C6879";
	private static final String noDisplay = "display: none";
	private static final String displayModal = "display: block";
	private String username;
	private String userImgUrl;
	
	  @Autowired
	  UserService userService;
	  
	  @Autowired
		private UserDao userDao;
	
	@RequestMapping(value = "faculty/dashboard.htm", method = RequestMethod.GET)
	public String facultyDashboard(Locale locale, Model model) {
		model.addAttribute("homeMenu", noDisplay);
		model.addAttribute("courseStyle", menuBg);
		model.addAttribute("feedbackMenu", noDisplay);
		model.addAttribute("pageTitle", "Find Courses");
		
		username = "Dr. Prof blah";
		model.addAttribute("userName", username);
		
		return "facultyDashboard";
	}
	
	
//	@RequestMapping(value = "coursedetails.htm/{code}", method = RequestMethod.GET)
//	public ModelAndView courseDetail(ModelAndView model, @PathVariable("code") String code) {
//	
//		Course c = userService.getCourseDetails(code);
//		
//		model.addObject("courseStyle", menuBg);
//		model.addObject("pageTitle", "Course Details");
//		System.out.println("in course details");
//		model.addObject("courseCode", code);
//		model.addObject("courseName",c.getCourseName());
//		model.addObject("courseDescription",c.getCourseDetails());
//		model.addObject("specialisation",c.getInterest());
//		model.addObject("courseRating",c.getOverallRating());
//		model.addObject("surveyMessage",c.getReviewComment());
//		
//		username = "Dr. Prof blah";
//		model.addObject("userName", c.g);
//		model.setViewName("courseDetail");
//
//		return model;
//		
//	}
	
	@RequestMapping(value = "feedbackmodal.htm", method = RequestMethod.GET)
	public String feedbackModal(Locale locale, Model model) {
		model.addAttribute("courseStyle", menuBg);
		model.addAttribute("pageTitle", "Course Details");
		model.addAttribute("modalStyle", displayModal);

		username = "Dr. Prof blah";
		model.addAttribute("userName", username);

		return "courseDetail";
	}
	
}
