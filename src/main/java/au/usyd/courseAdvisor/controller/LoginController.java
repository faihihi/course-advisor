package au.usyd.courseAdvisor.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.courseAdvisor.model.Course;
import au.usyd.courseAdvisor.model.Login;
import au.usyd.courseAdvisor.model.Survey;
import au.usyd.courseAdvisor.model.User;
import au.usyd.courseAdvisor.model.UserCompletedCourse;
import au.usyd.courseAdvisor.service.UserService;
import au.usyd.courseAdvisor.dao.UserDao;
import au.usyd.courseAdvisor.controller.HomeController;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String menuBg = "background-color: #5C6879";
	private static final String noDisplay = "display: none";
	private static final String displayModal = "display: block";
	private static final String collapseMenu = "visibility: collapse";
	private String username;
	private String interest;
	private String displayname;
	private String completedCourseName;
	private String completedCourseCode;
	private String userImgUrl;
	
  @Autowired
  UserService userService;
  
  @Autowired
	private UserDao userDao;


  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());

    return mav;
  }

  @SuppressWarnings("unused")
@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("login") Login login) {
    ModelAndView mav = null;
	
    User user = userService.validateUser(login);
    username = user.getUsername();
    displayname = user.getFirstname() + " " + user.getLastname();
    if(user == null) {
    	mav = new ModelAndView("login");
        mav.addObject("message", "Username or Password is wrong!!");
    } else {
        if(user.getOccupation().matches("FacultyMember")) {
        	mav = new ModelAndView("course");
        	mav.addObject("userName", displayname);
        	mav.addObject("homeMenu", collapseMenu);
        	mav.addObject("feedbackMenu", collapseMenu);
        	mav.addObject("courseMenu", menuBg);
        	
        	List<Course> recommendedCourse = userDao.getRecommendedCourses(user.getSpecialisation());
        	mav.addObject("recommendedCourse", recommendedCourse);

        } else {
        	interest = user.getSpecialisation();
        	List<UserCompletedCourse> listCourse = userDao.getCompletedCourses(user.getUsername());
            UserCompletedCourse c = userService.getCreditPoints(user.getUsername());
            
            mav = new ModelAndView("welcome");
            mav.addObject("homeMenu", menuBg);
     		mav.addObject("pageTitle", "Dashboard");
            mav.addObject("userName", displayname);
            mav.addObject("creditPoints", c.getCompletedCredits());
            mav.addObject("remainigPoints", c.getRemainingCredits());
            mav.addObject("completedCourses", listCourse);
        }
    	
    }

    return mav;
  }
  
	@RequestMapping(value = "feedback/modal-part1/{completedCourse}/{code}", method = RequestMethod.GET)
	public ModelAndView openModal(ModelAndView model, @PathVariable("completedCourse") String completedCourse,  @PathVariable("code") String code) {
		model.addObject("feedbackMenu", menuBg);
		model.addObject("pageTitle", "Feedback Survey");
		model.addObject("modalOneStyle", displayModal);
		model.addObject("userName", displayname);
		completedCourseName=completedCourse;
		completedCourseCode=code;
		List<UserCompletedCourse> listCourse = userDao.getCompletedCourses(username);
		for(int i=0;i<listCourse.size();i++) {
			  boolean surveyStatus = userDao.getSurveyStatus(username, listCourse.get(i).getCode());
			  if(surveyStatus) {
				  listCourse.get(i).setNotCompleteStatusStyle(noDisplay);
			  } else {
				  listCourse.get(i).setCompleteStatusStyle(noDisplay);
			  }
		  }
		
		  model.addObject("completedCourses", listCourse);
		  model.addObject("courseName", completedCourse);
		  model.addObject("courseCode", code);
		  model.setViewName("feedback");

			return model;
	}
  
  @RequestMapping(value = "course.htm", method = RequestMethod.GET)
 	public String course(Locale locale, Model model) {
	  User currentUser = userDao.getUserDetails(username);
	  if(currentUser.getOccupation().matches("FacultyMember")) {
		  model.addAttribute("homeMenu", collapseMenu);
		  model.addAttribute("feedbackMenu", collapseMenu);
		  model.addAttribute("courseMenu", menuBg);
      	
      	List<Course> recommendedCourse = userDao.getRecommendedCourses(currentUser.getSpecialisation());
      	model.addAttribute("recommendedCourse", recommendedCourse);

      } else {
    	model.addAttribute("courseMenu", menuBg);
   		List<Course> recommendedCourse = userDao.getRecommendedCourses(interest);
   		model.addAttribute("recommendedCourse", recommendedCourse);
    	  
      }

 		model.addAttribute("pageTitle", "Course & Rating");
 		model.addAttribute("userName", displayname);
 		
 		return "course";
 	}
  

  @RequestMapping(value = "home", method = RequestMethod.GET)
 	public ModelAndView home(Locale locale, ModelAndView model) {
 		 UserCompletedCourse c = userService.getCreditPoints(username);
 		List<UserCompletedCourse> listCourse = userDao.getCompletedCourses(username);
 	   
 		model = new ModelAndView("welcome");
 		model.addObject("homeMenu", menuBg);
		model.addObject("pageTitle", "Dashboard");
		model.addObject("userName", displayname);
 		model.addObject("creditPoints", c.getCompletedCredits());
 		model.addObject("remainigPoints", c.getRemainingCredits());
 		model.addObject("completedCourses", listCourse);
 		return model;
 	}
  
  @RequestMapping(value = "feedback.htm", method = RequestMethod.GET)
	public String feedback(Locale locale, Model model) {
		model.addAttribute("feedbackStyle", menuBg);
		model.addAttribute("pageTitle", "Feedback Survey");
		model.addAttribute("userName", displayname);
		
		  List<UserCompletedCourse> listCourse = userDao.getCompletedCourses(username);
		  //loop through listcourse, if the course survey status is completed, then set survey status in UserCompleted one
		  for(int i=0;i<listCourse.size();i++) {
			  boolean surveyStatus = userDao.getSurveyStatus(username, listCourse.get(i).getCode());
			  if(surveyStatus) {
				  listCourse.get(i).setNotCompleteStatusStyle(noDisplay);
			  } else {
				  listCourse.get(i).setCompleteStatusStyle(noDisplay);
			  }
		  }
		  model.addAttribute("completedCourses", listCourse);
		return "feedback";
	}
  
  @RequestMapping(value = "updateUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@RequestParam(value ="username",  required = false) String userName, @RequestParam(value ="name",  required = false) String name,
			@RequestParam(value ="email",  required = false) String email, @RequestParam(value ="interest",  required = false) String interest, ModelAndView mv) {

		System.out.println("in update");
		User user = new User();
		user.setUsername(userName);
		user.setFirstname(name);
		user.setEmail(email);
		user.setInterest(interest);
		
		displayname = name;

		int counter = userDao.update(user);

		if (counter > 0) {
			mv.addObject("msg", "Student records updated against student id: " + user.getFirstname());
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		 UserCompletedCourse c = userService.getCreditPoints(username);
	 		List<UserCompletedCourse> listCourse = userDao.getCompletedCourses(username);
	 	   
	 		
	 		mv.addObject("userName", displayname);
	 		mv.addObject("pageTitle", "Dashboard");
	 		mv.addObject("homeMenu", menuBg);
	 		mv.addObject("remainigPoints", c.getRemainingCredits());
	 		mv.addObject("creditPoints", c.getCompletedCredits());
	 		mv.addObject("completedCourses", listCourse);
		mv.setViewName("welcome");

		return mv;
	}
  
  
	@RequestMapping(value = "feedback/modal-part1/{f}/feedbackResponse", method = RequestMethod.POST)
	public ModelAndView feedbackResponse(@RequestParam(value = "q1",  required = false) String q1, @RequestParam(value = "q2",  required = false) String q2,
			@RequestParam(value = "q3",  required = false) String q3, @RequestParam(value = "q4",  required = false) String q4, @RequestParam(value = "q5",  required = false) String q5, @RequestParam(value = "q6",  required = false) String q6,
			@RequestParam(value = "q7",  required = false) String q7, @RequestParam(value = "q8",  required = false) String q8, @RequestParam(value = "q11",  required = false) String q11,  @RequestParam(value = "q9",  required = false) String q9, @RequestParam(value = "q10",  required = false) String q10, 
			ModelAndView model) {
		model.addObject("feedbackMenu", menuBg);
		model.addObject("pageTitle", "Feedback Survey");
		model.addObject("modalTwoStyle", displayModal);
		model.addObject("userName", displayname);
		
		model.addObject("courseCode", completedCourseCode);
		model.addObject("courseName", completedCourseName);
	System.out.println("in controoll");
			int totalValue=0;
			int counter=0;
			if(q1 != null)
			{
				totalValue= totalValue + Integer.parseInt(q1);
				counter++;
			}
			if(q2 != null)
			{
				totalValue=totalValue + Integer.parseInt(q2);
				counter++;
			}
			
			if(q3 != null)
			{
				totalValue= totalValue+ Integer.parseInt(q3);
				counter++;
			}
			if(q4 != null)
			{	totalValue=totalValue + Integer.parseInt(q4);
				counter++;
			}
			if(q5 != null)
			{
				totalValue= totalValue+ Integer.parseInt(q5);
				counter++;
			}
			if(q6 != null)
			{
				totalValue= totalValue+ Integer.parseInt(q6);
				counter++;
			}
			if(q7 != null)
			{
				totalValue= totalValue+ Integer.parseInt(q7);
				counter++;
			}
			if(q8 != null)
			{
				totalValue= totalValue+ Integer.parseInt(q8);
				counter++;
			}
			if(q9 != null)
			{
				totalValue=totalValue + Integer.parseInt(q9);
				counter++;
			}
			if(q10 != null)
			{
				totalValue= totalValue+ Integer.parseInt(q10);
				counter++;
			}
			
			System.out.println("counter"+ counter);
			System.out.println(totalValue);
			
			float avergae=totalValue/10;
			
		
		
			Survey survey = new Survey();
			survey.setUsername(username);
			survey.setCode(completedCourseCode);
			survey.setAvgScore(avergae);
			survey.setCompletionStatus(counter);
			survey.setComment(q11);
			if(counter == 10)
			{
				survey.setFeedbackStatus(true);
			}
			userDao.addSurveyFeedback(survey);
		  List<UserCompletedCourse> listCourse = userDao.getCompletedCourses(username);
		  for(int i=0;i<listCourse.size();i++) {
			  boolean surveyStatus = userDao.getSurveyStatus(username, listCourse.get(i).getCode());
			  if(surveyStatus) {
				  listCourse.get(i).setNotCompleteStatusStyle(noDisplay);
			  } else {
				  listCourse.get(i).setCompleteStatusStyle(noDisplay);
			  }
		  }
		  model.addObject("completedCourses", listCourse);
		  model.addObject("userRating", avergae);
		  
		model.setViewName("feedback");

		return model;
		
	}

	
	@RequestMapping(value = "setting.htm", method = RequestMethod.GET)
	public String setting(Locale locale, Model model) {
		User currentUser = userDao.getUserDetails(username);
		  if(currentUser.getOccupation().matches("FacultyMember")) {
			  model.addAttribute("homeMenu", collapseMenu);
			  model.addAttribute("feedbackMenu", collapseMenu);
			  model.addAttribute("courseMenu", menuBg);

	      } else {
	    	  model.addAttribute("homeStyle", menuBg);
	      }
		  
		model.addAttribute("pageTitle", "User Setting");
		model.addAttribute("userName", displayname);

	    User user = userService.getUserDetails(username);
		model.addAttribute("firstName", user.getFirstname());
		model.addAttribute("lastName", user.getLastname());
		model.addAttribute("faculty", user.getFaculty());
		model.addAttribute("specialization", user.getSpecialisation());
		model.addAttribute("email", user.getEmail());
		
		return "setting";
	}
	
	@RequestMapping(value = "coursedetails.htm/{code}", method = RequestMethod.GET)
	public ModelAndView courseDetail(ModelAndView model, @PathVariable("code") String code) {
		User currentUser = userDao.getUserDetails(username);
		  if(currentUser.getOccupation().matches("FacultyMember")) {
			  model.addObject("homeMenu", collapseMenu);
			  model.addObject("feedbackMenu", collapseMenu);
			  model.addObject("courseMenu", menuBg);
	      } else {
	    	  model.addObject("courseStyle", menuBg);
	      }
	
		Course c = userService.getCourseDetails(code);
		
		
		model.addObject("pageTitle", "Course Details");
		System.out.println("in course details");
		model.addObject("courseCode", code);
		model.addObject("courseName",c.getCourseName());
		model.addObject("courseDescription",c.getCourseDetails());
		model.addObject("specialisation",c.getInterest());
		model.addObject("courseRating",c.getOverallRating());
		model.addObject("surveyMessage",c.getReviewComment());
		model.addObject("lectureName", c.getFacultyName());
		
		model.addObject("userName", displayname);
		model.setViewName("courseDetail");
		
		model.addObject("courseRating", userDao.getCourseOverallRating(code));
		model.addObject("surveyMessage", userDao.getLatestComment(code));

		return model;
		
	}
	
}
