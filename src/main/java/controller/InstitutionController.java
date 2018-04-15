package controller;

import entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.InstitutionService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Bourbon
 * @date 2018/4/15
 * @description
 */
@Controller
@RequestMapping("/institution/")
@SessionAttributes("id")
public class InstitutionController {

	@Autowired
	private InstitutionService institutionService;

	@RequestMapping("{id}")
	public ModelAndView info(@PathVariable String id, Model model){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("institution/institution");
		model.addAttribute("id",id);
		modelAndView.addObject("institution",institutionService.findInstitution(Integer.parseInt(id)));
		return modelAndView;
	}

	@RequestMapping("changeInfo")
	public String changeInfo(){
		return "/institution/info";
	}

	@RequestMapping("setInfo")
	public String setInfo(@SessionAttribute int id, String info){
		institutionService.changeInstitution(id, info);
		return "redirect:/institution/"+ id;
	}

	@RequestMapping("course")
	public ModelAndView course(@SessionAttribute String id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("institution/course");
		modelAndView.addObject("courses", institutionService.lookoverOrders(Integer.parseInt(id)));
		return modelAndView;
	}

	@RequestMapping("publishCourse")
	public String publishCourse(){
		return "institution/publishCourse";
	}

	@RequestMapping(value = "addCourse", method = RequestMethod.POST)
	public String addCourse(@SessionAttribute String id, String courseName, String info, int weekNum, int classesPerWeek,
	                        int bigClassNum, double bigClassPrice, int smallClassNum, double smallClassPrice, String beginTime){
		Course course = new Course();
		course.setCoursename(courseName);
		course.setInfo(info);
		course.setWeekNum(weekNum);
		course.setClassesPerWeek(classesPerWeek);
		course.setBigClassNum(bigClassNum);
		course.setBigClassPrice(bigClassPrice);
		course.setSmallClassNum(smallClassNum);
		course.setSmallClassPrice(smallClassPrice);
		course.setBeginTime(LocalDate.parse(beginTime, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		course.setInstitutionid(Integer.parseInt(id));
		institutionService.publishCourse(course);
		return "redirect:/institution/course";
	}

	@RequestMapping("offline")
	public String offline(@SessionAttribute String id, String userid, String courseid, String classType){
		institutionService.createOfflineOrder(userid, Integer.parseInt(courseid), classType);
		return "redirect:/institution/"+ id;
	}
}
