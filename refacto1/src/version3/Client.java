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
		double TotalDu = 0;
		int TotaFidelite = 0;
		Iterator<Location> forEach = locations.iterator();
		String result = "Situation du client: " + getNom() + "\n";
		
		while (forEach.hasNext()) {
			Location each = (Location) forEach.next();
			
			// ajout point de fideliter
			TotaFidelite += each.unFilm.getPointFidelites(each);	
			// mise en forme location
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(each.unFilm.getMontant(each)) + "\n";
			TotalDu += each.unFilm.getMontant(each);		
		}
		
		// ajout récapitulatif client
		result += "Total de " + String.valueOf(TotalDu) + "\n";
		result += "Vous gagnez " + String.valueOf(TotaFidelite) + " points de fidélité\n";
		
		return result;
	}
	
	



}