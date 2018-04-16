package controller;

import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import service.AdministratorService;
import service.InstitutionService;
import service.UserService;

import java.time.LocalDate;

/**
 * @author Bourbon
 * @date 2018/4/9
 * @description
 */
@Controller
@RequestMapping({"/"})
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private InstitutionService institutionService;
	@Autowired
	private AdministratorService administratorService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userid, String password, String role) {
		if (role.equals("user")) {
			if (userService.loginUser(userid, password)) {
				return "redirect:/user/" + userid;
			}
		} else if (role.equals("institution")) {
			if (institutionService.loginInstitution(Integer.parseInt(userid), password)) {
				return "redirect:/institution/" + userid;
			}
		} else {
			if (administratorService.checkLogin(userid, password)) {
				return "redirect:/administrator/info";
			}
		}
		return "redirect:/";
	}

	@RequestMapping(value = "userRegister", method = RequestMethod.GET)
	public String userRegister() {
		return "userRegister";
	}

	@RequestMapping(value = "userRegister", method = RequestMethod.POST)
	public String userAdd(String userid, String password, String repeatpassword) {
		if (password.equals(repeatpassword) && userService.registerUser(userid, password)) {
			return "redirect:/user/" + userid;
		}
		return "redirect:/userRegister";
	}

	@RequestMapping(value = "institutionRegister", method = RequestMethod.GET)
	public String institutionRegister(){
		return "institutionRegister";
	}

	@RequestMapping(value = "institutionRegister", method = RequestMethod.POST)
	public ModelAndView institutionAdd(String password, String repeatpassword, String info){
		Institution institution = new Institution();
		institution.setPassword(password);
		institution.setInfo(info);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("institutionRegisterS");
		if (password.equals(repeatpassword)){
			int id = institutionService.registerInstitution(institution);
			modelAndView.addObject("id", id);
			return  modelAndView;
		}
		return modelAndView;
	}
}
