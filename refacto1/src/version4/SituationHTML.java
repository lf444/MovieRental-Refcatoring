package version4;

public class SituationHTML extends Situation {

	@Override
	public String headerString(Client client) {
		
		return "<H1> Situation du client: " + client.getNom() + "</H1><P>\n";	
	}

	@Override
	public String eachRentalString(Location location) {
	
		return  "\t" + location.getFilm().getTitre() + "\t" + String.valueOf(location.getUnFilm().getMontant(location.getNbJours())) + "<BR>\n";
	}

	@Override
	public String footerString(Client client) {
		
		String result = "<P>Total de " + String.valueOf(client.getMontantTotal()) + "<P>\n";
		result += "Vous gagnez " + String.valueOf(client.getPointFidelitesTotal()) + " points de fidélité<P>\n";
		return result;
	}
}
