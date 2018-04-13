package controller;

import entity.Institution;
import entity.Login;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import service.InstitutionService;
import service.UserService;

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

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home(Model model){
		model.addAttribute(new Login());
		return "home";
	}

	@RequestMapping(value = "/a" ,method = RequestMethod.GET)
	public String a(){
		System.out.println(institutionService.loginInstitution(18,"0000"));
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
