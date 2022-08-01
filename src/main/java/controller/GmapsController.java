package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.gmaps.MapSearch;
import aiss.resources.GmapsResource;


/**
 * Servlet implementation class GmapsController
 */
public class GmapsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GmapsController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GmapsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Search for videos in GoogleMaps
	    log.log(Level.FINE, "Searching for GoogleMaps videogames store whose city contain " + query);
		GmapsResource store = new GmapsResource();
		MapSearch storeResults = store.getLocation(query);
		
		if (storeResults!=null){
			rd = request.getRequestDispatcher("/GoogleMapsSuccess.jsp");
			request.setAttribute("stores", storeResults.getResults());
		} else {
			log.log(Level.SEVERE, "GMaps object: " + storeResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
