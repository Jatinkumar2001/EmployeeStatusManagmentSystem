package com.employeeinout.homecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("WorkForceManagment")
public class HomeController 
{
	@RequestMapping("/")
     public String getHomeView()
     {
    	 return "Home/home";
     }
}
