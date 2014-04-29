package auth.operations;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NewsFeedDAO;
import data.UserData;

public class AuthLogin{
       

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String afterLoginRedirect = "admin/adminController";
		
		NewsFeedDAO dao = NewsFeedDAO.getNewsFeedDAO();
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		
		UserData user = dao.getUser(request.getParameter("email"));
		if (user != null && user.getPass().equals(request.getParameter("pass"))) {
			
			if (request.getAttribute("loginFailedMsg") != null) {
				request.removeAttribute("loginFailedMsg");
			}
			
			session.setAttribute("userData", user);
			request.setAttribute("authorizated", "true");
			try {
				response.sendRedirect(afterLoginRedirect);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			request.setAttribute("loginFailedMsg", "Error. May be, Login or Password incorrect. Try again, please.");
			dispatcher = request.getRequestDispatcher("authPage.jsp");
			try {
				dispatcher.forward(request, response);
			} 
			catch (ServletException e) {System.out.print("AuthLogin: dispatcher.forward failed"); e.printStackTrace(); }
			catch (IOException e) { System.out.print("AuthLogin: dispatcher.forward failed"); e.printStackTrace(); }
		}
		
		
		
	}

}
