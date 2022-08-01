package aiss.model.resources;
import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.youtube.YoutubeSearch;
import aiss.resources.YoutubeResource;

public class YoutubeTest {

	@Test
	public void getvideoTest() throws UnsupportedEncodingException {
		String title = "Minecraft";
		YoutubeResource video = new YoutubeResource();
		YoutubeSearch youtubeSearch = video.getVideo(title);
		
		assertNotNull("La búsqueda devuelve null", youtubeSearch);
		assertNotNull("La búsqueda devuelve null", youtubeSearch.getItems());
		//assertFalse("El número de busquedas encontradas para " + title + " returned " + youtubeSearch.getItems().size()==0);
		
		System.out.println("The search for " + title + " returned " + youtubeSearch.getItems().size() + " videos.");
		
		
	}

}
