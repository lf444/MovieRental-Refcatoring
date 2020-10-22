package Version1;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLocation {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	

	@Test
	public void testFilmNormalDureeInfA3jours() {
		String attendu  = "Situation du client: Thomas\n"
				+ "\tTaxi Driver\t2.0\n"
				+ "Total de 2.0\n"
				+ "Vous gagnez 1 points de fidélité\n";
		
		String test = testSituation("Thomas","Taxi Driver",Film.NORMAL,2);
		
		assertEquals(attendu,test);
	}

	
	
	
	@Test
	public void testFilmNormalDuree3jours() {
		String attendu  = "Situation du client: Thomas\n"
				+ "\tTaxi Driver\t3.5\n"
				+ "Total de 3.5\n"
				+ "Vous gagnez 1 points de fidélité\n";
		
		String test = testSituation("Thomas","Taxi Driver",Film.NORMAL,3);
		
		assertEquals(attendu,test);
	}

	

	@Test
	public void testFilmNouveautelDureeInfA2jours() {
		String attendu  = "Situation du client: Thomas\n"
				+ "\t11 heures 14\t3.0\n"
				+ "Total de 3.0\n"
				+ "Vous gagnez 1 points de fidélité\n";
		
		String test = testSituation("Thomas","11 heures 14",Film.NOUVEAUTE,1);		
		assertEquals(attendu,test);
	}
	
	

	@Test
	public void testFilmNouveautelDureeA2jours() {
		String attendu  = "Situation du client: Thomas\n"
				+ "\t11 heures 14\t12.0\n"
				+ "Total de 12.0\n"
				+ "Vous gagnez 2 points de fidélité\n";
		
		String test = testSituation("Thomas","11 heures 14",Film.NOUVEAUTE,4);		
		assertEquals(attendu,test);
	}
	

	@Test
	public void testFilmEnfantDureeInfA4jours() {
		String attendu  = "Situation du client: Thomas\n"
				+ "\tCendrillon\t1.5\n"
				+ "Total de 1.5\n"
				+ "Vous gagnez 1 points de fidélité\n";
		String test = testSituation("Thomas","Cendrillon",Film.ENFANT,3);		
		assertEquals(attendu,test);
	}
	
	
	
	@Test
	public void testFilmEnfantDureeA4jours() {
		String attendu  = "Situation du client: Thomas\n"
				+ "\tCendrillon\t3.0\n"
				+ "Total de 3.0\n"
				+ "Vous gagnez 1 points de fidélité\n";
		String test = testSituation("Thomas","Cendrillon",Film.ENFANT,4);		
		assertEquals(attendu,test);
	}
	

	@Test
	public void testCumul() {
		String attendu  = "Situation du client: Thomas\n"
				+ "\tTaxi Driver\t2.0\n"
				+ "\t11 heures 14\t3.0\n"
				+ "\tCendrillon\t1.5\n"
				+ "Total de 6.5\n"
				+ "Vous gagnez 3 points de fidélité\n";
		
		Client unClient = new Client("Thomas");
	    testSituationCumul(unClient,"Taxi Driver",Film.NORMAL,2);
		testSituationCumul(unClient,"11 heures 14",Film.NOUVEAUTE,1);		
		testSituationCumul(unClient,"Cendrillon",Film.ENFANT,2);	
		
		String test = unClient.situation();
		
		assertEquals(attendu,test);
	}
	
	

	public String testSituation(String nomClient, String nomFilm, int typeFilm, int nbJours ) {
		Client unClient = new Client(nomClient);
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
		return unClient.situation();
	}
	
	
	public void testSituationCumul(Client unClient, String nomFilm, int typeFilm, int nbJours) {
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
	}
	
	
}
