package admin.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commands.Command;
import dao.NewsFeedDAO;
import data.NewsData;

public class Command_EditNewsWrite extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		NewsFeedDAO dao = NewsFeedDAO.getNewsFeedDAO();
		
		NewsData newsData = new NewsData();
		
		newsData.setId(request.getParameter("id"));
		newsData.setIdcat(request.getParameter("idcat"));
		newsData.setName(request.getParameter("name"));
		newsData.setAuthor(request.getParameter("author"));
		newsData.setDate( request.getParameter("date") );
		newsData.setTime( request.getParameter("time") );
		newsData.setAnnotation(request.getParameter("annotation"));
		newsData.setMaintext(request.getParameter("maintext"));

		dao.updateNews(newsData);
		
		try {
			response.sendRedirect("adminController");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
