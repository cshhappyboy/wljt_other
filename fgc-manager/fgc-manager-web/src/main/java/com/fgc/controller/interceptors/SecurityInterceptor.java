package com.fgc.controller.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fgc.controller.user.UserCommon;
import com.pub.model.SessionInfo;
import com.pub.utils.MMCollectionUtil;

/**
 * 权限拦截器
 *  
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月23日
 *
 *   未来离线需求
 */
public class SecurityInterceptor implements HandlerInterceptor{
	
	private List<String> excludeUrls;// 不需要拦截的资源

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		
		if(MMCollectionUtil.isNotEmpty(excludeUrls)){
			for(String excludeUrl : excludeUrls){// 如果要访问的资源是不需要验证的
				if(url.contains(excludeUrl)){
					return true;
				}
			}
		}
		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(UserCommon.SESSION_INFO_NAME);
		if (sessionInfo == null || sessionInfo.getId().equalsIgnoreCase("")) {// 如果没有登录或登录超时
			if(url.equals("/index")||url.equals("/")){
				response.sendRedirect("/login");
			}else{
				response.sendRedirect("/relogin");
			}
			return false;
		}
//		if (!sessionInfo.getResourceList().contains(url)) {// 如果当前用户没有访问此资源的权限
//			request.getRequestDispatcher("/login").forward(request, response);
//			response.sendRedirect("/");
//			return false;
//		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
