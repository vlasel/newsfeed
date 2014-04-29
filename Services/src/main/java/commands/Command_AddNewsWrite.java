package admin.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commands.Command;
import dao.NewsFeedDAO;
import data.NewsData;

public class Command_AddNewsWrite extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		NewsData newsData = new NewsData();
		NewsFeedDAO dao = NewsFeedDAO.getNewsFeedDAO();
		
		newsData.setIdcat(request.getParameter("idcat"));
		newsData.setName(request.getParameter("name"));
		newsData.setAuthor(request.getParameter("author"));
		newsData.setDate( request.getParameter("date") );
		newsData.setTime( request.getParameter("time") );
		newsData.setAnnotation(request.getParameter("annotation"));
		newsData.setMaintext(request.getParameter("maintext"));
		
		dao.addNews(newsData);
		
		
		try {
			response.sendRedirect("adminController");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
