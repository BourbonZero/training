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

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home(Model model){
		model.addAttribute(new Login());
		return "home";
	}

	@RequestMapping(value = "/a" ,method = RequestMethod.GET)
	public String a(){
		System.out.println(institutionService.recordScore("000",1,60));
		return "register";
	}

	@RequestMapping(value = "/",method = RequestMethod.POST)
	public String login(Login login){
		if (login.getRole().equals( "user")){
			User user = userService.loginUser(login.getLoginid(), login.getPassword());
			if (user!=null){
				return "redirect: /user";
			}
		}else if (login.getRole() == "institution"){

		}else if(login.getRole() == "manager"){

		}
		return "register";
	}

	@RequestMapping(value = "register")
	public String user(){
		return "register";
	}
}
