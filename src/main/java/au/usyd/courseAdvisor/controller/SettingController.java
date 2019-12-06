package au.usyd.courseAdvisor.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import au.usyd.courseAdvisor.model.Login;
import au.usyd.courseAdvisor.model.User;
import au.usyd.courseAdvisor.model.UserCompletedCourse;
import au.usyd.courseAdvisor.service.UserService;
import au.usyd.courseAdvisor.dao.UserDao;
import au.usyd.courseAdvisor.controller.HomeController;

@Controller
public class SettingController {

		@Autowired
		private UserDao userDao;

		
	}

