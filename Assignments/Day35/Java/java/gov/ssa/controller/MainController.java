package gov.ssa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@RequestMapping("/")
	public ModelAndView home(HttpServletRequest request, ModelAndView mv) {	
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/student_list")
	public ModelAndView student_list(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("students");
		return mv;
	}
	
	@RequestMapping("/student_details")
	public ModelAndView student_details(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("student_details");
		return mv;
	}
}
