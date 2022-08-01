package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.gmaps.MapSearch;
import aiss.resources.GmapsResource;

public class GoogleMapsTest {

	@Test
	public void testGoogleMaps() throws UnsupportedEncodingException {
		
		String localizacion= "Sevilla";
		GmapsResource google= new GmapsResource();
		
		MapSearch busqueda= google.getLocation(localizacion);
		
		assertNotNull("La búsqueda 0 resultado", busqueda.getResults());

		
		
		
	}

}
