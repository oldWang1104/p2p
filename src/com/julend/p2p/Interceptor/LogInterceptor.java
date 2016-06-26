package com.julend.p2p.Interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.julend.p2p.constant.Constants;

public class LogInterceptor extends HandlerInterceptorAdapter {
	
	private static Log logger1 = LogFactory.getLog("dailyFile");
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		if (url.indexOf("/images") == -1) {
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			String ip = "";
			String remoteAddr = request.getRemoteAddr();
			String encryString = "";
			String userId = "";
			String registerId = "";
			if (null != request.getSession().getAttribute(Constants.USER_SESSION_KEY)) {
				encryString = request.getSession().getId();
				
				
				//userId = Cache.get("front_" + encryString) + "";
				//registerId = Cache.get("register_" + encryString) + "";
			}
			logger1.fatal("url=" + url + "ts=" + time + "ip=" + ip
					+ "sessionid=" + encryString + "remoteAddr="
					+ remoteAddr + "userid=" + userId + "registerId="
					+ registerId);
		}
		return super.preHandle(request, response, handler);
	}
}
