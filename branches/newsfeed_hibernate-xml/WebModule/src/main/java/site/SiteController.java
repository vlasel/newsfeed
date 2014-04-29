package site;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

//import util.LoggerMy;
import dao.NewsFeedDAO;
import data.CategoryData;
import data.MenuSection;
import data.NewsData;

/**
 * Servlet implementation class SiteController
 */
//@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NewsFeedDAO dao;
    /**
     * Default constructor. 
     */
    public SiteController() {
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	dao = NewsFeedDAO.getNewsFeedDAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = request.getParameter("operation");
		
		
		
		CategoryData catData;
		NewsData newsData;
		
		MenuSection menuSection = null;
		List<MenuSection> menu = new ArrayList<MenuSection>();
		
		
		List<CategoryData> listCategories = dao.getCategoryList();
		Iterator<CategoryData> catIterator = listCategories.iterator();
		
		while(catIterator.hasNext())
		{
			catData = catIterator.next();
			menuSection = new MenuSection();
			
			menuSection.setId(catData.getId());
			menuSection.setValue(catData.getName());
			
			List<NewsData> listNews = dao.getNewsByCat(catData.getId());
			Iterator<NewsData> newsIterator = listNews.iterator();
			
			while(newsIterator.hasNext())
			{
				newsData = newsIterator.next();
				menuSection.addSubsection(newsData.getId(), newsData.getName());
			}
			menu.add(menuSection);
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/siteMain.jsp");
		request.setAttribute("menu", menu);

		
		//################ view ##########################
		
		List<NewsData> newsList = new ArrayList<NewsData>();

		String viewby = request.getParameter("viewby");
		if (viewby == null) {
			newsList = dao.getNewsList();
			request.setAttribute("newsList", newsList);
		} 
		else if ( viewby.equals("category")) {
				newsList = dao.getNewsByCat(request.getParameter("id"));
				request.setAttribute("newsList", newsList);
		}
		else if ( viewby.equals("onenews")) {
			newsList.add( dao.getNews(request.getParameter("id")) );
			request.setAttribute("newsList", newsList);
		}
		

//        request.setAttribute("dao_resource",dao.resource);
		
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
