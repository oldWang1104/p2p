package com.julend.p2p.interfaces.pc;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * PC端请求服务器的入口
 * 
 * @throws IOException
 */
@Controller
@RequestMapping("/pc")
public class PcController{
	
	private Log log = LogFactory.getLog(PcController.class);
	/**
	 * app端请求服务器的入口
	 * 
	 * @throws IOException
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Set<String> keys = request.getParameterMap().keySet();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 委托应用程序处理接口参数，参数不包括 _s, _t 等安全变量
		Map<String, String> parameters = new HashMap<String, String>();
		for (String t_key : keys) {
			if (t_key.equals("_s") || t_key.equals("_t")) {
				continue;
			}
			parameters.put(t_key,
					URLDecoder.decode(request.getParameter(t_key), "utf-8"));
		}

		String result = "";
		PcController app = new PcController();
		// 调用接口
		try {
			result = app.delegateHandleRequest(parameters);
			// 判断返回JSON还是JSONP格式
			if (request.getParameter("callback") != null) {
				result = request.getParameter("callback") + "(" + result + ")";
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("应用程序的代理回调程序遇到异常，详细原因是：" + e.getMessage());
			return app.getJsonErro("-3","应用程序的代理回调程序遇到异常，详细原因是：" + e.getMessage());
		}
		return result;
	}

	/**
	 * 根据opt的值调用相对应的方法
	 * 
	 * @param parameters
	 * @return
	 * @throws RuntimeException
	 */
	@SuppressWarnings("unchecked")
	public String delegateHandleRequest(Map<String, String> parameters)
			throws Exception {
		// 通过OPT反射得到调用方法
		Class c = PcRequestData.class;
		Object object = c.newInstance();
		Method method = c.getDeclaredMethod(parameters.get("OPT"), Map.class);
		return method != null ? method.invoke(object, parameters)+"" : "无方法";
	}

	/**
	 * 拼装JSON错误信息并输出
	 * 
	 * @param error
	 * @param msg
	 * @return
	 */
	@ResponseBody
	public String getJsonErro(String error, String msg) throws Exception {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("error", error);
		jsonMap.put("msg", msg);
		
		return JSONObject.fromObject(jsonMap).toString();
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Date getLongGoneDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, -30);
		return calendar.getTime();
	}
}
