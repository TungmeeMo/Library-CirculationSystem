package org.storm.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.storm.pojo.User;
import org.storm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	@RequestMapping("/list")
	public String toGetAll(HttpServletRequest request,Model model){
		List<User> list = this.userService.getAll();
		model.addAttribute("userList",list).addAttribute("user",new User());
		return "list";
	}
	
	@RequestMapping("/add")
    public void toAdd(HttpServletRequest request, HttpServletResponse response,@Valid User user) throws IOException{
        
		user.setPassword("key");
        this.userService.newUser(user);
        
        response.sendRedirect("list");
    }

    @RequestMapping("/update")
    public String toUpdate(HttpServletRequest request, Model model, User user){
        
        this.userService.updateUser(user);
        
        List<User> list = this.userService.getAll();
        model.addAttribute("userList",list)
            .addAttribute("user",user);
        return "list";
    }
    
    @RequestMapping(value = "/update1", method = RequestMethod.GET)
    public String toUpdate(@RequestParam("user") User user,Model model){
    	System.out.println(user.getRoleId());
    	this.userService.updateUser(user);
    	
    	List<User> list = this.userService.getAll();
    	model.addAttribute("userList", list).addAttribute("user", user);
    	
    	return "list";
    }
    
    @RequestMapping("/delete")
    public String todelete(HttpServletRequest request, Model model,Integer id){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        this.userService.deleteUserById(userId);
        
        List<User> list = this.userService.getAll();
        model.addAttribute("userList",list);
        model.addAttribute("user",user);
        return "list";
    }

}
