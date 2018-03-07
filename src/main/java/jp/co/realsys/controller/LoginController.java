package jp.co.realsys.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.StudentModel;
import jp.co.realsys.model.UserModel;
import jp.co.realsys.service.UsersInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(types = { UserModel.class })
public class LoginController {

	@Autowired
	private UsersInfoService userInfoService;

	@ModelAttribute
	public UserModel setUserModel() {
		UserModel form = new UserModel();
		return form;
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping("menu")
	public String menu(HttpSession session) {
		String ss=(String) session.getAttribute("loginname");
		System.out.println(ss+"------------------------------------------");
		if (session.getAttribute("loginname") != null) {
			return "menu";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() throws Exception {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute @Valid UserModel userModel,
			BindingResult result, Model model, HttpSession session)
			throws Exception {

		try {

			if (result.hasErrors()) {
				return "login";
			}
			if (!userInfoService.doCheckUser(userModel)) {
				result.reject("E002");
				return "login";
			} else {
				session.setAttribute("loginname", userModel.getLoginname());
				return "redirect:menu";
			}

		} catch (TaskException e) {
			throw e;
		}

	}

	@RequestMapping("/velocity")
	public String testVelocity( HttpSession httpSession,Model model){
		System.out.println("velocity");
		model.addAttribute("name","小帅");
		final Map<String,String> map = new HashMap<String,String>();
		map.put("name1", "test1");
		map.put("name2", "test2");
		map.put("name3", "test3");
		model.addAttribute("map",map);
		model.addAttribute("students",new StudentModel("1","天皇二代","1990.1.1,","四川本地人"));
		httpSession.setAttribute("Username","小郭and小勇");
		return "velocityIndex";
	}
	@RequestMapping("/velocity2")
	public String  testVelocity2(Model model,HttpSession httpSession){
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		String s= (String) httpSession.getAttribute("sessionUsername");
		System.out.print("ll");
		model.addAttribute("name","Velocity");
		model.addAttribute("ownList",list);
		return "velocitydemo" ;
	}
}
