//package aiss.model.resources;
//
//import static org.junit.Assert.*;
//
//import java.io.UnsupportedEncodingException;
//
//import org.junit.Test;
//
//import aiss.model.googleMaps2.Search;
//import aiss.model.googlemaps.Localizacion;
//import aiss.resources.GoogleMapsResource;
//
//
//public class gmapLocation {
//	
//	
//Double lat = 37.38;
//Double lng=-5.9731698;
//
//	@Test
//	public void getSearchTest() throws UnsupportedEncodingException {
//		Double lat = 37.38;
//		Double lng=-5.9731698;
//		GoogleMapsResource resource= new GoogleMapsResource();
//		Search busqueda= resource.getSearch(lat, lng);
//		
//		assertNotNull("La búsqueda da nulo", busqueda);
//		assertNotNull("La búsqueda da nulo", busqueda.getResults());
//		System.out.println("The search for " + lat+lng + " returned " + busqueda.getResults().size() + " tiendas.");
//		
//
//	}
//	
//	@Test
//	public void getcoordenadas() throws UnsupportedEncodingException {
//		
//		GoogleMapsResource gmres= new GoogleMapsResource();
//		Localizacion localo= gmres.getLocalizacion();
//		
//		Double lat= localo.getLocation().getLat();
//		Double lng= localo.getLocation().getLng();
//		
//		assertNotNull("La búsqueda da nulo", lat);
//		assertNotNull("La búsqueda da nulo", lng);
//		System.out.println("La latitud es"+lat);
//		System.out.println("La long es"+ lng);
//		
//		
//		
//	}
//	
//	
//	
//	
//	
//	
//
//}
