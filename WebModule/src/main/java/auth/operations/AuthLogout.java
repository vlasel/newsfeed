package auth.operations;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthLogout {
       

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
//		String afterLogoutRedirect = "/"+request.getContextPath()+"/SiteController";
		String afterLogoutRedirect = "SiteController";
		
		HttpSession session = request.getSession();
		if (session.getAttribute("userData") != null) {
			session.removeAttribute("userData");
		}
		
		
		try {
			response.sendRedirect(afterLogoutRedirect);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
