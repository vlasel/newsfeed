package admin.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commands.Command;
import dao.NewsFeedDAO;
import data.MenuSection;
import data.NewsData;

public class Command_DeleteNews extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		NewsFeedDAO dao = NewsFeedDAO.getNewsFeedDAO();
		
		String id = request.getParameter("id");
		MenuSection menuSection = new MenuSection();
		
		menuSection.setId(id);
		menuSection.setValue(dao.getNews(id).getName());
		
		for(NewsData subPage: dao.getNewsByCat(id)) {
			menuSection.addSubsection(subPage.getId(), subPage.getName());
		}
		
		
		request.setAttribute("menuSection", menuSection);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/adminDelete.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
