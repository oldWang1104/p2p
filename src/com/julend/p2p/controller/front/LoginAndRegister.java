package com.julend.p2p.controller.front;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.julend.p2p.model.User;
import com.julend.p2p.service.IUserService;

@Controller
@RequestMapping("/front/loginAndregister")
public class LoginAndRegister {
	
	@Resource(name="userService")
	private IUserService userService;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response){
		return new ModelAndView();
	}
	
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse response){
		return new ModelAndView();
	}
	
	@RequestMapping("/checkUser")
	public ModelAndView checkUser(HttpServletRequest request,
			HttpServletResponse response,User paramUser){
		System.out.println(paramUser);
		ModelAndView mv = new ModelAndView();
		User user = null;
		try{
			user = userService.checkUser(paramUser);
			System.out.println();
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(user == null){
			mv.setViewName("/front/loginAndregister/login");
		}else{
			mv.setViewName("/front/home/login");
		}		
		return mv;
	}
	
}
