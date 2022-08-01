package aiss.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.youtube.CommentYT;
import aiss.model.youtube.YoutubeSearch;



public class YoutubeResource {

	private static final String YOUTUBE_API_KEY = "AIzaSyC6RovvwFYHa67lZcHUM_KRqxkHPbJpHxk";
	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());
	private final String URL_COMMENT = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&key=";
	private String access_token;
	
	public YoutubeResource(String access_token) {
		this.access_token = access_token;
	}
	
	public YoutubeResource() {
		this.access_token=null;
	}
	/**
	 * 
	 * @param param
	 * @return comments
	 * @throws UnsupportedEncodingException
	 */


	
	public CommentYT insertComment(CommentYT comentario) {
		ClientResource cr = null;
		CommentYT comment = null;
		
		try {
			
			cr = new ClientResource(URL_COMMENT);
			
			ChallengeResponse challengeResponse = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
			challengeResponse.setRawValue(access_token);
			cr.setChallengeResponse(challengeResponse);
			
			
			
			comment = cr.post(comentario,CommentYT.class);
			
			
			
		}catch (ResourceException e) {
			log.warning("Error when inserting file: "+cr.getResponse().getStatus());
			// TODO: handle exception
			
		}
		return comment;
	}
	

	public YoutubeSearch getVideo(String query) throws UnsupportedEncodingException {
		
		
		String uri = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=" + URLEncoder.encode(query, "UTF-8") + 
				"trailer" + "&maxResults=1" + "&key=" + YOUTUBE_API_KEY;
		
		//String uri = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=%QUERY+trailer" +
		//"&key=" + YOUTUBE_API_KEY;
		
		log.log(Level.FINE, "YouTube URI: " + uri);
		

		ClientResource cr = new ClientResource(uri);
		YoutubeSearch youtubeSearch = cr.get(YoutubeSearch.class);
		
		return youtubeSearch;
		
	}
/*		try {
			cr = new ClientResource(URL_YOUTUBE.replace("%QUERY", query).replace("%APIKEY", APIKEY));
			res = cr.get(SearchVideos.class);
			log.log(Level.FINE, "Búsqueda de vídeos de " + query + " realizada correctamente.");
		} catch (ResourceException e) {
			log.log(Level.WARNING, "Error al obtener los vídeos: " + cr.getResponse().getStatus());
			throw e;
		}
		return res;
	}*/

}
