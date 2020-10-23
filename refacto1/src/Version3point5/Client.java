package Version3point5;
import java.util.Vector;

import java.util.Iterator;

public class Client {
	private String nom;
	private Vector<Location> locations = new Vector<Location>();
	


	private Situation situation;
	
	public Client(String nom,int e) {
		this.nom = nom;
		this.setSituation(e);
	}
	
	public void addLocation(Location location) {
		this.locations.add(location);
	}
	
	public String getNom() {
		return this.nom;
	}
	


	
	
	public Situation getSituation() {
		return situation;
	}

	public void setSituation(int e) {
		switch(e) {
		case 0:
			this.situation= new SituationTEXT();
			break;
		case 1:
			this.situation= new SituationHTML();
			break;
		}
		
	}
	
	public Vector<Location> getLocations() {
		return locations;
	}

}