package auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.operations.AuthLogin;
import auth.operations.AuthLogout;

/**
 * Servlet implementation class Auth
 */
//@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("operation") == null) {
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("/authPage.jsp");
			dispatcher.forward(request, response);*/
			try {
				response.sendRedirect("authPage.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if ( request.getParameter("operation").equals("login") ) {
			request.removeAttribute("operation");
			AuthLogin authLogin = new AuthLogin();
			authLogin.execute(request, response);
		}
		else if ( request.getParameter("operation").equals("logout") ) {
			request.removeAttribute("operation");
			AuthLogout authLogout = new AuthLogout();
			authLogout.execute(request, response);
		}
		
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
