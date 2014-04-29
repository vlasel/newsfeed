package admin;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

//import util.LoggerMy;
import admin.commands.Command_AddNews;
import admin.commands.Command_AddNewsWrite;
import commands.Command;
import admin.commands.Command_DeleteNews;
import admin.commands.Command_DeleteNewsWrite;
import admin.commands.Command_EditNews;
import admin.commands.Command_EditNewsWrite;
import admin.commands.Command_Show;

/**
 * Servlet implementation class adminController
 */
//@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = request.getParameter("operation");
		
		Command com = null;
		
		if(operation == null) {
			com = new Command_Show();
		}
		else if(operation.equals("addnews")) {
			com = new Command_AddNews();
		} 
		else if(operation.equals("addnewswrite")) {
			com = new Command_AddNewsWrite();
		}
		else if(operation.equals("editnews")) {
			com = new Command_EditNews();
		} 
		else if(operation.equals("editnewswrite")) {
			com = new Command_EditNewsWrite();
		}
		else if(operation.equals("deletenews")) {
			com = new Command_DeleteNews();
		} 
		else if(operation.equals("deletenewswrite")) {
			com = new Command_DeleteNewsWrite();
		}
		else com = new Command_Show();
		
			com.execute(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
