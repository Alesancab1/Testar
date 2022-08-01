package aiss.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.rawg.RAWGSearch;

public class RawgResource {
	
	private static final Logger log = Logger.getLogger(RawgResource.class.getName());
	
	public RAWGSearch getGame(String query) throws UnsupportedEncodingException {
		
		String uri = "https://api.rawg.io/api/games/" + URLEncoder.encode(query, "UTF-8");
		
		log.log(Level.FINE, "RAWG URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
		RAWGSearch rawgSearch = cr.get(RAWGSearch.class);
		
		return rawgSearch;
		
	}

}
