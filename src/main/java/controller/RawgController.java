package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.rawg.RAWGSearch;
import aiss.resources.RawgResource;

/**
 * Servlet implementation class RawgController
 */
public class RawgController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(RawgController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RawgController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Search for description in RAWG
		log.log(Level.FINE, "Searching description videogames in RAWG whose title contain " + query);
		RawgResource game = new RawgResource();
		RAWGSearch gameResults = game.getGame(query);
		
		if(gameResults!=null) {
			rd=request.getRequestDispatcher("/success.jsp");
			request.setAttribute("game", gameResults.getDescription());
		}else {
			log.log(Level.SEVERE, "RAWG object: " + gameResults);
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
