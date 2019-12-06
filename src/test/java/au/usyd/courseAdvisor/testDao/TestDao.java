package au.usyd.courseAdvisor.testDao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import au.usyd.courseAdvisor.dao.UserDao;
import au.usyd.courseAdvisor.model.Login;
import au.usyd.courseAdvisor.model.User;
import au.usyd.courseAdvisor.service.UserService;

public class TestDao {
	  @Autowired
	  UserService userService;
	  private User user;
	  private Login login;
	  
	  Login loginObj = new Login("sourabh123", "Sourabh@123");
	  
	  User userobj= new User("sourabh123", "Sourabh@123", "Sourabh", "Sinha", "ssin6556@uni.sydney.edu.au", "Sourav", "Sinha", "Data Analytics",  "Data Visualisation", "Data Analyst", "Student", "School of Computer Science");
	  @Test
	    public void testRegisterUser() {
		  
		  User user1 = userService.validateUser(login);
	    	 Assert.assertEquals(user1, userobj);
	       
	    }
	

}