package au.usyd.courseAdvisor.testController;


import au.usyd.courseAdvisor.controller.LoginController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


public class TestController {
	
	       
	private MockMvc mockMvc;

	@Before(value = "")
	public void setUp() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setPrefix("/WEB-INF/jsp/login/");
	    viewResolver.setSuffix(".jsp");
	    mockMvc = MockMvcBuilders.standaloneSetup(new LoginController()).setViewResolvers(viewResolver).build();
	}

	@Test
	public void testLogin() throws Exception {
	    this.mockMvc.perform(get("/login"))
	            .andExpect(status().isOk())
	            .andExpect(view().name("login"))
	            .andDo(print());


}

	private ResultHandler print() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
