package admin.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commands.Command;
import dao.NewsFeedDAO;
import data.NewsData;

public class Command_EditNews extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		NewsFeedDAO dao = NewsFeedDAO.getNewsFeedDAO();
		
		NewsData newsData = dao.getNews(request.getParameter("id"));
		
		request.setAttribute("categoryList", dao.getCategoryList());
		request.setAttribute("newsdata", newsData);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/adminEdit.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
