package admin.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commands.Command;
import dao.NewsFeedDAO;
import data.CategoryData;
import data.MenuSection;
import data.NewsData;

public class Command_Show extends Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		NewsFeedDAO dao = NewsFeedDAO.getNewsFeedDAO();
		
		CategoryData catData;
		NewsData newsData;
		
		MenuSection menuSection;
		List<MenuSection> menu = new ArrayList<MenuSection>();
		
		List<CategoryData> listCategories = dao.getCategoryList();
		Iterator<CategoryData> catIterator = listCategories.iterator();
		
		List<NewsData> listNews;
		Iterator<NewsData> newsIterator;
		
		
		while(catIterator.hasNext())
		{
			catData = catIterator.next();
			menuSection = new MenuSection();
			
			menuSection.setId(catData.getId());
			menuSection.setValue(catData.getName());
			
			listNews = dao.getNewsByCat(catData.getId());
			newsIterator = listNews.iterator();
			
			while(newsIterator.hasNext())
			{
				newsData = newsIterator.next();
				menuSection.addSubsection(newsData.getId(), newsData.getName());
			}
			menu.add(menuSection);
		}
		
		request.setAttribute("menu", menu);
		
		
		
		
		
		
		String viewby = request.getParameter("viewby");
		if (viewby != null) {
			if ( viewby.equals("category")) {
				listNews = dao.getNewsByCat(request.getParameter("id"));
				request.setAttribute("listNews", listNews);
			}
		}
		else {
			listNews = dao.getNewsList();
			request.setAttribute("listNews", listNews);
		}
		
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/adminMain.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
