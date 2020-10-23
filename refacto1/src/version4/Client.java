package version4;

import java.util.Vector;



public class Client {
	private String nom;
	private Vector<Location> locations = new Vector<Location>();
	private SituationTEXT situationTEXT;
	private SituationHTML situationHTML;

	public Vector<Location> getLocations() {
		return locations;
	}

	public Client(String nom) {
		this.nom = nom;
	}

	public void addLocation(Location location) {
		this.locations.add(location);
	}

	public String getNom() {
		return this.nom;
	}

	public String situation() {
		this.situationTEXT = new SituationTEXT();
		return this.situationTEXT.valeur(this);
	}

	public String situationHTML() {
		this.situationHTML = new SituationHTML();
		return this.situationHTML.valeur(this);

	}

	public double getMontantTotal() {
		double montant = 0;
		for (Location each : locations) {
			montant += each.getUnFilm().getMontant(each.getNbJours());
		}

		return montant;
	}

	public int getPointFidelitesTotal() {
		int point = 0;
		for (Location each : locations) {
			point += each.getUnFilm().getPoint(each.getNbJours());
		}
		return point;
	}

}