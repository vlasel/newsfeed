package admin.commands;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commands.Command;
import dao.NewsFeedDAO;

public class Command_AddNews extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		NewsFeedDAO dao = NewsFeedDAO.getNewsFeedDAO();
		
		request.setAttribute("date", DateFormat.getDateInstance(2).format(new Date()) );
		request.setAttribute("time", DateFormat.getTimeInstance(3).format(new Date()) );
		request.setAttribute("categoryList", dao.getCategoryList());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/adminAdd.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
