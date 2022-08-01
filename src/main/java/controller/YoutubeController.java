package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.youtube.YoutubeSearch;
import aiss.resources.YoutubeResource;

/**
 * Servlet implementation class YoutubeController
 */
public class YoutubeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(YoutubeController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YoutubeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Search for videos in YouTube
	    log.log(Level.FINE, "Searching for YouTube videos whose title contain " + query);
		YoutubeResource videos = new YoutubeResource();
		YoutubeSearch videoResults = videos.getVideo(query);

		if (videoResults!=null){
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("videos", videoResults.getItems());
		} else {
			log.log(Level.SEVERE, "YouTube object: " + videoResults);
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
