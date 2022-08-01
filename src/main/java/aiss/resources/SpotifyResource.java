package aiss.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.spotify.Song;
import aiss.model.spotifyalbum.AlbumSearch;



public class SpotifyResource {
	
    private static final Logger log = Logger.getLogger(SpotifyResource.class.getName());

    private final String access_token;
    private final String baseURL = "https://api.spotify.com/v1/search";
    private final String tipobanda= "&type=album&limit=1";

    public SpotifyResource(String access_token) {
        this.access_token = access_token;
    }
    
    public AlbumSearch getSong(String query) throws UnsupportedEncodingException{
  
    	String songGetURL = baseURL + "?q="+ URLEncoder.encode(query, "UTF-8") + tipobanda;
        ClientResource cr = new ClientResource(songGetURL);

        ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);

        AlbumSearch bandasonora = null;
        try {
            bandasonora = cr.get(AlbumSearch.class);
            return bandasonora;

        } catch (ResourceException re) {
            log.warning("Error when retrieving Spotify playlists: " + cr.getResponse().getStatus());
            log.warning(songGetURL);
            return null;
        }
    }
    
//    public AlbumSearch getSong(String query) throws UnsupportedEncodingException {
//        String q=URLEncoder.encode(query,"UTF-8");
//        String AlbumGetURL = baseURL + "?q="+q+"&type=album";
//        ClientResource cr = new ClientResource(AlbumGetURL);
//
//        ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
//        chr.setRawValue(access_token);
//        cr.setChallengeResponse(chr);
//
//        AlbumSearch as = null;
//        try {
//            as = cr.get(AlbumSearch.class);
//            return as;
//
//        } catch (ResourceException re) {
//            log.warning("Error when retrieving Spotify album: " + cr.getResponse().getStatus());
//            log.warning(AlbumGetURL);
//            return null;
//        }
//    }
}
    

