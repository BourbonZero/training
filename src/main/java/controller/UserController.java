package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

/**
 * @author Bourbon
 * @date 2018/4/15
 * @description
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("userid")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/{userid}")
	public ModelAndView info(@PathVariable String userid, Model model){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/user");
		model.addAttribute("userid", userid);
		modelAndView.addObject("user", userService.findInfo(userid));
		return modelAndView;
	}

	@RequestMapping("/cancelVIP")
	public String cancelVIP(@SessionAttribute("userid") String userid){
		User user = userService.findInfo(userid);
		user.setVIP(false);
		user.setViplevel(0);
		userService.setInfo(user);
		return "redirect:/user/"+userid;
	}

	@RequestMapping("/changeInfo")
	public String changeInfo(){
		return "/user/setInfo";
	}

	@RequestMapping("/setInfo")
	public String setInfo(@SessionAttribute("userid") String userid, String info){
		User user = userService.findInfo(userid);
		user.setInfo(info);
		userService.setInfo(user);
		return "redirect:/user/"+userid;
	}

	@RequestMapping("/setAccount")
	public String setAccount(){
		return "/user/setAccount";
	}

	@RequestMapping("/account")
	public String confirmAccount(@SessionAttribute("userid") String userid, String accountid, String password){
		userService.setAccount(userid, accountid, password);
		return "redirect:/user/"+userid;
	}

	@RequestMapping("/exchangePoint")
	public String exchangePoint(@SessionAttribute("userid") String userid){
		userService.exchangePoint(userid);
		return "redirect:/user/"+userid;
	}

	@RequestMapping("/order")
	public ModelAndView order(@SessionAttribute("userid") String userid){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/order");
		modelAndView.addObject("orders", userService.lookoverOrders(userid));
		return modelAndView;
	}

	@RequestMapping("/course")
	public ModelAndView course(@SessionAttribute("userid") String userid){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/course");
		modelAndView.addObject("courses", userService.lookoverCourses());
		return modelAndView;
	}

	@RequestMapping("/myclass")
	public ModelAndView myclass(@SessionAttribute("userid") String userid){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/myclass");
		modelAndView.addObject("myclasses", userService.lookoverMyclasses(userid));
		return  modelAndView;
	}

	@RequestMapping("/submit/{courseid}")
	public String submit(@SessionAttribute("userid") String userid, @PathVariable int courseid,  String classType){
		userService.submitOrder(userid, courseid,classType);
		return "redirect:/user/order";
	}

	@RequestMapping("/pay/{orderid}")
	public String pay(@SessionAttribute("userid") String userid, @PathVariable int orderid){
		userService.payOrder(orderid);
		return "redirect:/user/order";
	}

	@RequestMapping("/cancel/{orderid}")
	public String cancel(@SessionAttribute("userid") String userid, @PathVariable int orderid){
		userService.cancelOrder(orderid);
		return "redirect:/user/order";
	}

	@RequestMapping("/logout")
	public String logout(@SessionAttribute("userid") String userid, SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "redirect:/";
	}
}
