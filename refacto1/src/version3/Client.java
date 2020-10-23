package version3;
import java.util.Vector;
import java.util.Iterator;

public class Client {
	private String nom;
	private Vector<Location> locations = new Vector<Location>();
	
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

		Iterator<Location> forEach = locations.iterator();
		String result = "Situation du client: " + getNom() + "\n";		
		while (forEach.hasNext()) {
			Location each = (Location) forEach.next();	
			// mise en forme location
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(each.getFilm().getPrix(each.getNbJours())) + "\n";
		}
		
		// ajout récapitulatif client
		result += "Total de " + String.valueOf(getMontantTotal()) + "\n";
		result += "Vous gagnez " + String.valueOf(getPointFidelitesTotal()) + " points de fidélité\n";
		
		return result;
	}
	
	
	private double getMontantTotal() {
		double montant=0;
		for(Location each: locations) {
			montant+= each.getUnFilm().getPrix(each.getNbJours())	;
		}
		
		return montant;
	}
	
	public int getPointFidelitesTotal() {
		int point =0;
		for(Location each: locations) {
			point+=  each.getUnFilm().getPoint(each.getNbJours());
		}
		return point;
	}
	



}