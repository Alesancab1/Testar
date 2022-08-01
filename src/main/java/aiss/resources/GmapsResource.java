package aiss.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.gmaps.MapSearch;


public class GmapsResource {
	
	private static final String GMAPS_API_KEY = "AIzaSyC6RovvwFYHa67lZcHUM_KRqxkHPbJpHxk";
	private static final Logger log = Logger.getLogger(GmapsResource.class.getName());
	
	public MapSearch getLocation(String query) throws UnsupportedEncodingException {
		
		String uri = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=videogamestore+in+" + URLEncoder.encode(query, "UTF-8") +
				"&key=" + GMAPS_API_KEY;
		
		ClientResource cr = new ClientResource(uri);
		MapSearch mapSearch = cr.get(MapSearch.class);
		
		return mapSearch;
	}

}
