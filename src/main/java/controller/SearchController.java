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
import aiss.model.youtube.YoutubeSearch;
import aiss.resources.RawgResource;
import aiss.resources.YoutubeResource;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SearchController.class.getName());

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
    }
     
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		//Search for Videos in Youtube
		log.log(Level.FINE, "Searching for Youtube videos that contain" + query);
		YoutubeResource ytr = new YoutubeResource();
		YoutubeSearch youtubeResults = ytr.getVideo(query);
		
		
		// Search for description in RAWG
				log.log(Level.FINE, "Searching description videogames in RAWG whose title contain " + query);
				RawgResource game = new RawgResource();
				RAWGSearch gameResults = game.getGame(query);
				
				
		
		if(youtubeResults!= null && gameResults!=null){
			
			request.setAttribute("game", gameResults.getDescription());
			request.setAttribute("videos", youtubeResults.getItems());
			rd = request.getRequestDispatcher("/success.jsp");
			
		}else {
			log.log(Level.SEVERE, "RAWG object: " + gameResults);
			log.log(Level.SEVERE,"Youtube object: "+youtubeResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
