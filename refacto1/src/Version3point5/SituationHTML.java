package Version3point5;

import java.util.Iterator;

public class SituationHTML implements Situation{

	@Override
	public String situa(Client client) {

		Iterator<Location> forEach = client.getLocations().iterator();
		String result = "<html><p>Situation du client: " + client.getNom() + "\n";
		
		while (forEach.hasNext()) {

			Location each = (Location) forEach.next();
			
			
			// mise en forme location
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(each.getFilm().getMontant(each)) + "\n";
			
		}
		
		// ajout récapitulatif client
		result += "Total de " + String.valueOf(getMontantTotal(client)) + "\n";
		result += "Vous gagnez " + String.valueOf(getPointFidelitesTotal(client)) + " points de fidélité\n<p/></html>";
		
		return result;
	}

	
	
	private Double getMontantTotal(Client client) {
		double montant=0;
		for(Location each:client.getLocations()) {
			montant+=each.getFilm().getMontant(each);
		}
		return montant;
	}
	
	private int getPointFidelitesTotal(Client client) {
		int point=0;
		for(Location each: client.getLocations()) {
			point += each.getFilm().getPointFidelite(each);
		}
		return point;
	}
}