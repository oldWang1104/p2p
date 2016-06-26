package com.julend.p2p.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.julend.p2p.constant.Constants;
import com.julend.p2p.model.User;

/****
 * 登录拦截器
 * @author wangkai
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private Logger log = Logger.getLogger("dailyFile");
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		if(user == null || user.getId() == 0){
			response.sendRedirect("/LoginAndRegister/default.html");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
