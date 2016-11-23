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
	
	@RequestMapping("/students/student_list")
	public ModelAndView student_list(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("student_list");
		return mv;
	}
	
	@RequestMapping("/students/student_details")
	public ModelAndView student_details(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("student_details");
		return mv;
	}
	
	@RequestMapping("/majors/major_list")
	public ModelAndView major_list(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("major_list");
		return mv;
	}
	
	@RequestMapping("/majors/major_details")
	public ModelAndView major_details(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("major_details");
		return mv;
	}
	
}
