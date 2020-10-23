package version4;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestLocationHTML {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	

	@Test
	public void testFilmNormalDureeInfA3jours() {
		String attendu  = "<H1> Situation du client: Thomas</H1><P>\n"
				+ "\tTaxi Driver\t2.0<BR>\n"
				+ "<P>Total de 2.0<P>\n"
				+ "Vous gagnez 1 points de fidélité<P>\n";
		
		String test = testSituation("Thomas","Taxi Driver",Film.NORMAL,2);
		
		assertEquals(attendu,test);
	}

	
	
	
	@Test
	public void testFilmNormalDuree3jours() {
		String attendu  = "<H1> Situation du client: Thomas</H1><P>\n"
				+ "\tTaxi Driver\t3.5<BR>\n"
				+ "<P>Total de 3.5<P>\n"
				+ "Vous gagnez 1 points de fidélité<P>\n";
		
		String test = testSituation("Thomas","Taxi Driver",Film.NORMAL,3);
		
		assertEquals(attendu,test);
	}

	

	@Test
	public void testFilmNouveautelDureeInfA2jours() {
		String attendu  = "<H1> Situation du client: Thomas</H1><P>\n"
				+ "\t11 heures 14\t3.0<BR>\n"
				+ "<P>Total de 3.0<P>\n"
				+ "Vous gagnez 1 points de fidélité<P>\n";
		
		String test = testSituation("Thomas","11 heures 14",Film.NOUVEAUTE,1);		
		assertEquals(attendu,test);
	}
	
	

	@Test
	public void testFilmNouveautelDureeA2jours() {
		String attendu  = "<H1> Situation du client: Thomas</H1><P>\n"
				+ "\t11 heures 14\t12.0<BR>\n"
				+ "<P>Total de 12.0<P>\n"
				+ "Vous gagnez 2 points de fidélité<P>\n";
		
		String test = testSituation("Thomas","11 heures 14",Film.NOUVEAUTE,4);		
		assertEquals(attendu,test);
	}
	

	@Test
	public void testFilmEnfantDureeInfA4jours() {
		String attendu  = "<H1> Situation du client: Thomas</H1><P>\n"
				+ "\tCendrillon\t1.5<BR>\n"
				+ "<P>Total de 1.5<P>\n"
				+ "Vous gagnez 1 points de fidélité<P>\n";
		String test = testSituation("Thomas","Cendrillon",Film.ENFANT,3);		
		assertEquals(attendu,test);
	}
	
	
	
	@Test
	public void testFilmEnfantDureeA4jours() {
		String attendu  = "<H1> Situation du client: Thomas</H1><P>\n"
				+ "\tCendrillon\t3.0<BR>\n"
				+ "<P>Total de 3.0<P>\n"
				+ "Vous gagnez 1 points de fidélité<P>\n";
		String test = testSituation("Thomas","Cendrillon",Film.ENFANT,4);		
		assertEquals(attendu,test);
	}
	
	

	@Test
	public void testFilmCOFFRETSERIESTV() {
		String attendu  = "<H1> Situation du client: Thomas</H1><P>\n"
				+ "\tFFXIV\t2.0<BR>\n"
				+ "<P>Total de 2.0<P>\n"
				+ "Vous gagnez 0 points de fidélité<P>\n";
		String test = testSituation("Thomas","FFXIV",Film.COFFRETSERIESTV,4);		
		assertEquals(attendu,test);
	}
	
	@Test
	public void testFilmCinephileInfA1() {
		String attendu  = "<H1> Situation du client: Thomas</H1><P>\n"
				+ "\tla green ligne\t2.0<BR>\n"
				+ "<P>Total de 2.0<P>\n"
				+ "Vous gagnez 3 points de fidélité<P>\n";
		String test = testSituation("Thomas","la green ligne",Film.CINEPHILE,1);		
		assertEquals(attendu,test);
	}
	
	@Test
	public void testFilmCinephileSupA1() {
		String attendu  = "<H1> Situation du client: Thomas</H1><P>\n"
				+ "\tla green ligne\t6.0<BR>\n"
				+ "<P>Total de 6.0<P>\n"
				+ "Vous gagnez 0 points de fidélité<P>\n";
		String test = testSituation("Thomas","la green ligne",Film.CINEPHILE,2);		
		assertEquals(attendu,test);
	}

	@Test
	public void testCumul() {
		String attendu  = "<H1> Situation du client: Thomas</H1><P>\n"
				+ "\tTaxi Driver\t2.0<BR>\n"
				+ "\t11 heures 14\t3.0<BR>\n"
				+ "\tCendrillon\t1.5<BR>\n"
				+ "\tFFXIV\t2.0<BR>\n"
				+ "\tla green ligne\t2.0<BR>\n"
				+ "<P>Total de 10.5<P>\n"
				+ "Vous gagnez 6 points de fidélité<P>\n";
		
		Client unClient = new Client("Thomas");
	    testSituationCumul(unClient,"Taxi Driver",Film.NORMAL,2);
		testSituationCumul(unClient,"11 heures 14",Film.NOUVEAUTE,1);		
		testSituationCumul(unClient,"Cendrillon",Film.ENFANT,2);	
		testSituationCumul(unClient,"FFXIV",Film.COFFRETSERIESTV,4);	
		testSituationCumul(unClient,"la green ligne",Film.CINEPHILE,1);	
		
		String test = unClient.situationHTML();
		
		assertEquals(attendu,test);
	}
	
	

	public String testSituation(String nomClient, String nomFilm, int typeFilm, int nbJours ) {
		Client unClient = new Client(nomClient);
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
		return unClient.situationHTML();
	}
	
	
	public void testSituationCumul(Client unClient, String nomFilm, int typeFilm, int nbJours) {
		Film unFilm = new Film(nomFilm, typeFilm);
		Location uneLocation = new Location(unFilm, nbJours);
		unClient.addLocation(uneLocation);
	}
	
	
}
