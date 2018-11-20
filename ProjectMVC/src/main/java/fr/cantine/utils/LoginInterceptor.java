package fr.cantine.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	// Abstract adapter class for the AsyncHandlerInterceptor interface,
	// for simplified implementation of pre-only/post-only interceptors.

	private List<String> ignoreList;

	public List<String> getIgnoreList() {
		return ignoreList;
	}

	public void setIgnoreList(List<String> ignoreList) {
		this.ignoreList = ignoreList;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String requestedUrl = request.getRequestURI();
		boolean urlAIgnorer = false;
		
		// l'URL demand�e est-elle dans la liste de urls � ignorer?
		for (String urlIgoree : ignoreList) {
			// l'url cherch� correspond � usl � ignorer
			if (requestedUrl.contains(urlIgoree)) {
				urlAIgnorer = true;
				break;// ici, on va sortir du for.�ol
			}
		}
		
		// if "false", si ce n'est pas une url � ignorer (typiquement/login) 
		if(!urlAIgnorer) {
			Object user = request.getSession().getAttribute("user");

			if (user == null) {
				request.getRequestDispatcher("/login").forward(request, response);
//				response.sendRedirect(request.getScheme()+ "://"
//					+ request.getServerName() + ":"
//					+ request.getServerPort()
//					+ request.getContextPath() + "/login");
			}
			
		}

		
		return true;// on accepte passer la suite
	}

}
