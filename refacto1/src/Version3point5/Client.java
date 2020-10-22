package Version3point5;
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
		double totalDu = 0;
		int pointsFidelites = 0;
		Iterator<Location> forEach = locations.iterator();
		String result = "Situation du client: " + getNom() + "\n";
		
		while (forEach.hasNext()) {			
			Location each = (Location) forEach.next();							
			pointsFidelites = each.getPointFidelites();
			
			// mise en forme location
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(each.getMontant()) + "\n";
			totalDu = each.getMontant();			
		}
		
		// ajout récapitulatif client
		result += "Total de " + String.valueOf(totalDu) + "\n";
		result += "Vous gagnez " + String.valueOf(pointsFidelites) + " points de fidélité\n";
		
		return result;
	}

	public String situationHTML() {
		double totalDu = 0;
		int pointsFidelites = 0;
		Iterator<Location> forEach = locations.iterator();
		String result = "<html><p>Situation du client: " + getNom() + "\n";
		
		while (forEach.hasNext()) {
			double du = 0;
			Location each = (Location) forEach.next();
			
			du = each.getMontant();
			
			
			pointsFidelites = each.getPointFidelites();
			
			// mise en forme location
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(du) + "\n";
			totalDu += du;
		}
		
		// ajout récapitulatif client
		result += "Total de " + String.valueOf(totalDu) + "\n";
		result += "Vous gagnez " + String.valueOf(pointsFidelites) + " points de fidélité\n<p/></html>";
		
		return result;
	}

}