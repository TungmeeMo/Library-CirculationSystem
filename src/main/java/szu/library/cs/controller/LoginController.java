package szu.library.cs.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import szu.library.cs.pojo.Staff;
import szu.library.cs.service.IStaffService;

@Controller
@SessionAttributes("currUser")
@RequestMapping("")
public class LoginController {
	@Resource
	private IStaffService userService;

	@RequestMapping("/login")
	public String toLogin() {
		System.out.println("toLogin function.");
		return "login";
	}
    
	@RequestMapping("/login/action")
	public String loginAction( String username, String password,ModelMap model, HttpServletResponse response, HttpSession session){
		
			Staff staff = userService.getByUsername(username);
			try{
				if (null != password && staff.getPassword().equals(password)){//login success
					model.addAttribute("currUser", staff);
					session.setAttribute("currUser", staff);
					model.put("message", "login success.");
					return "home";
				}
				model.put("message", "用户名或者密码错误！");
				return "error";
				
			}catch(Exception e){
				e.printStackTrace();
				model.put("message", "login error.");
				return "error";
				
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
		
	}
	
//	@RequestMapping("/login/home")
//	public String login(@RequestParam String userName, @RequestParam String passWord, Model model) {
//		List<User> userList = this.userService.login(userName, passWord);
//		if (userList.size() > 0)
//			model.addAttribute("user", userList.get(0));
//		return "home";
//	}

	@RequestMapping("/password")
	public String toPassword() {
		return "password";
	}

	@RequestMapping("/password/save")
	public String pwdToSave(HttpServletRequest request,HttpSession session, Model model, String password) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// 改密码
		Staff staff = (Staff)session.getAttribute("currUser");
		staff.setPassword(password);
		userService.updateByPrimaryKeySelective(staff);
		return "password";
	}

}
