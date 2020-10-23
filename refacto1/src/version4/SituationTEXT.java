package version4;

public class SituationTEXT extends Situation {

	@Override
	public String headerString(Client client) {
		
		return "Situation du client: " + client.getNom() + "\n";	
	}

	@Override
	public String eachRentalString(Location location) {
	
		return  "\t" + location.getFilm().getTitre() + "\t" + String.valueOf(location.getUnFilm().getMontant(location.getNbJours())) + "\n";
	}

	@Override
	public String footerString(Client client) {
		
		String result = "Total de " + String.valueOf(client.getMontantTotal()) + "\n";
		result += "Vous gagnez " + String.valueOf(client.getPointFidelitesTotal()) + " points de fidélité\n";
		return result;
	}

}
