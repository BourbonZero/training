package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.AdministratorService;

/**
 * @author Bourbon
 * @date 2018/4/16
 * @description
 */
@Controller
@RequestMapping("/administrator")
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;

	@RequestMapping("info")
	public ModelAndView info(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("administrator/administrator");
		return modelAndView;
	}

	@RequestMapping("user")
	public ModelAndView user(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("administrator/user");
		modelAndView.addObject("users", administratorService.lookoverUsers());
		return modelAndView;
	}

	@RequestMapping("institution")
	public ModelAndView institution(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("administrator/institution");
		modelAndView.addObject("institutions", administratorService.lookoverInstitutions());
		return modelAndView;
	}

	@RequestMapping("order")
	public ModelAndView order(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("administrator/order");
		modelAndView.addObject("orders",administratorService.lookoverOrders());
		return modelAndView;
	}

	@RequestMapping("distribute")
	public String distribute(){
		administratorService.distributePay();
		return "redirect:/administrator/order";
	}

	@RequestMapping("check/{id}")
	public String check(@PathVariable int id){
		administratorService.checkAddInstitution(id);
		return "redirect:/administrator/institution";
	}

	@RequestMapping("logout")
	public String logout(){
		return "redirect:/";
	}
}
