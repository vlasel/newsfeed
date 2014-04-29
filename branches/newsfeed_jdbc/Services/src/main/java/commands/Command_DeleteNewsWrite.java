package admin.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commands.Command;
import dao.NewsFeedDAO;

public class Command_DeleteNewsWrite extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		NewsFeedDAO dao = NewsFeedDAO.getNewsFeedDAO();
		
		String id = request.getParameter("id");
		
		dao.deleteNews(id);
		dao.deleteNewsByCat(id);
		
		try {
			response.sendRedirect("adminController");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
