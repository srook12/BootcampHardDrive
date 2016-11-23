package com.ssa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssa.entities.Major;

@Controller
public class WebsiteController {
	
	boolean firstTime = true;
	Map<Integer, String> messages = new HashMap<Integer, String>();
	
	public void loadMessages() {
		messages.put(1, "Restart the computer");
		messages.put(2, "Unplug the router");
		messages.put(3, "Re-install the application");
		messages.put(4, "Update your password");
		messages.put(5, "Reformat the hard drive");
		
		firstTime = false;
	}
	
	@RequestMapping("/help")
	public ModelAndView help(HttpServletRequest request, ModelAndView mv) {
	
		if(firstTime) {
			loadMessages();
		}
		
		if(request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			String message = messages.get(id);
			
			mv.addObject("id", id);
			mv.addObject("desc", messages.get(id));
			
			System.out.println("Id of " + id + " has the message value of " + message);
		}
		
		
		mv.setViewName("help");
		return mv;
	}
	
	@RequestMapping("/data")
	public ModelAndView data(HttpServletRequest request, ModelAndView mv) {
		if(request.getParameter("id") != null) {
			
			ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
			Major pd=(Major) context.getBean("major");
			
			System.out.println(pd);
			
		}
		
		System.out.println("In data");
		
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("about");
		return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView home(HttpServletRequest request, ModelAndView mv) {
		if(request.getParameter("name") != null) {
			mv.addObject("name", request.getParameter("name"));
		}
		
		mv.setViewName("home");
		return mv;
	}
}
