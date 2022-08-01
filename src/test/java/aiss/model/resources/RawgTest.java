package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.rawg.RAWGSearch;
import aiss.resources.RawgResource;


public class RawgTest {

	@Test
	public void getGameTest() throws UnsupportedEncodingException {
		String title = "Rayman";
		RawgResource game = new RawgResource();
		RAWGSearch rawgSearch = game.getGame(title);
		
		assertNotNull("La búsqueda devuelve null", rawgSearch);
		assertNotNull("La búsqueda devuelve null", rawgSearch.getDescription());
		//assertFalse("El número de busquedas encontradas para " + title + " returned " + youtubeSearch.getItems().size()==0);
		
		System.out.println("The search for " + title + " returned " + rawgSearch.getDescription() + " description.");
		
	}

}
