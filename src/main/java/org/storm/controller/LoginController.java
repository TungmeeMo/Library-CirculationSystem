package org.storm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.storm.pojo.User;
import org.storm.service.IUserService;

@Controller
@SessionAttributes("currUser")
@RequestMapping("")
public class LoginController {
	@Resource
	private IUserService userService;

	@RequestMapping("/login")
	public String toLogin() {
		return "login";
	}
    
	@RequestMapping("/login/action")
	public String loginAction(ModelMap model, HttpSession session){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int id = this.userService.getIdByUsername(userDetails.getUsername());
		User user = new User();
		user = this.userService.getUserById(id);
		model.addAttribute("currUser", user);
		
		if(null != session.getAttribute("currUser")){
			User user1 = new User();
			user1 = (User)session.getAttribute("currUser");
			System.out.println(user1.getUserName() + "已经放入到session中");
		}
		/*Enumeration<String> e = session.getAttributeNames();
		while(e.hasMoreElements()){
			Object object = new Object();
			object = e.nextElement();
			if(object instanceof User){
				User user1 = new User();
				user1 = (User)object;
				System.out.println(user1.getUserName() + "已经放入到session中");
			}
		}*/
		return "password";
	}
	
	@RequestMapping("/login/home")
	public String login(@RequestParam String userName, @RequestParam String passWord, Model model) {
		List<User> userList = this.userService.login(userName, passWord);
		if (userList.size() > 0)
			model.addAttribute("user", userList.get(0));
		return "home";
	}

	@RequestMapping("/password")
	public String toPassword() {
		return "password";
	}

	@RequestMapping("/password/save")
	public String pwdToSave(HttpServletRequest request,HttpSession session, Model model, String password) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int id = this.userService.getIdByUsername(userDetails.getUsername());

		// 改密码
		User user = new User();
		user = (User)session.getAttribute("currUser");
		user.setPassword(password);
		userService.updateUser(user);

		return "password";
	}

}
