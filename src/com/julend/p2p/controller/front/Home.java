package com.julend.p2p.controller.front;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/front/home/")
public class Home {
	
	@RequestMapping(value="index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("----home");
		Enumeration<String> aa = request.getHeaderNames();
		
		String name = "";
		while(aa.hasMoreElements()){
			
			name = aa.nextElement();
			System.out.println("headerName:"+name+"  headerValue:"+request.getHeader(name));
		}
		return new ModelAndView();
	}
}
