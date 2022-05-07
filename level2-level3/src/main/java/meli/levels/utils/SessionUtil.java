package meli.levels.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class SessionUtil {
	public void destroySession(HttpServletRequest request) {
		if (request != null) {
			request.getSession().invalidate();
		}
	}
}
