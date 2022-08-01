package controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;

import aiss.resources.SpotifyResource;
import aiss.model.spotify.Song;
import aiss.model.spotifyalbum.AlbumSearch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class spotifyGetSongController extends HttpServlet{
	
	private static final long serialVersionUID = -6818025976353856770L;
    private static final Logger log = Logger.getLogger(spotifyGetSongController.class.getName());


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	
    String accessToken = (String) req.getSession().getAttribute("Spotify-token");
	String nombre = req.getParameter("searchQuery");
    
			
			
		if (accessToken != null && !"".equals(accessToken)) {

        SpotifyResource spResource = new SpotifyResource(accessToken);
        AlbumSearch songBuscada = spResource.getSong(nombre);

        if (songBuscada != null && songBuscada.getClass() != null) {
            req.setAttribute("song", songBuscada.getAlbums().getItems());


            req.getRequestDispatcher("/spotifyalbum.jsp").forward(req, resp);
        } else {
            log.warning("no songs available for this title");
         
        }
        } else {
            log.info("Trying to access Spotify without an access token, redirecting to OAuth servlet");
            req.getRequestDispatcher("/AuthController/Spotify").forward(req, resp);
        }
    }
	
	
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }

}

	


