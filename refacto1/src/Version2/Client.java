package Version2;

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
			double du = 0;
			Location each = (Location) forEach.next();

			// determine le montant de chaque location
			switch (each.getFilm().getCodePrix()) {
			case Film.NORMAL:
				du += 2;
				if (each.getNbJours() > 2)
					du += (each.getNbJours() - 2) * 1.5;
				break;
			case Film.NOUVEAUTE:
				du += each.getNbJours() * 3;
				break;
			case Film.ENFANT:
				du += 1.5;
				if (each.getNbJours() > 3)
					du += (each.getNbJours() - 3) * 1.5;
				break;
			case Film.COFFRETSERIESTV:
				du += each.getNbJours() * 0.5;
				break;
			case Film.CINEPHILE:
				du += 2;
				if (each.getNbJours() > 1)
					du += (each.getNbJours() - 1) * 4;
				break;

			}

			// ajout des points de fidélité
			if ((each.getFilm().getCodePrix() != Film.COFFRETSERIESTV)
					&& (each.getFilm().getCodePrix() != Film.CINEPHILE))
				pointsFidelites++;

			// ajout d'un bonus pour les nouveautés louées depuis au moins deux jours
			if ((each.getFilm().getCodePrix() == Film.NOUVEAUTE) && each.getNbJours() > 1)
				pointsFidelites++;

			// ajout d'un bonus pour les CINEPHILE louées moins de 2 jours
			if ((each.getFilm().getCodePrix() == Film.CINEPHILE) && each.getNbJours() < 2)
				pointsFidelites += 3;

			// mise en forme location
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(du) + "\n";
			totalDu += du;
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
		String result = "<H1> Situation du client: " + getNom() + "</H1><P>\n";

		while (forEach.hasNext()) {
			double du = 0;
			Location each = (Location) forEach.next();

			// determine le montant de chaque location
			switch (each.getFilm().getCodePrix()) {
			case Film.NORMAL:
				du += 2;
				if (each.getNbJours() > 2)
					du += (each.getNbJours() - 2) * 1.5;
				break;
			case Film.NOUVEAUTE:
				du += each.getNbJours() * 3;
				break;
			case Film.ENFANT:
				du += 1.5;
				if (each.getNbJours() > 3)
					du += (each.getNbJours() - 3) * 1.5;
				break;
			case Film.COFFRETSERIESTV:
				du += each.getNbJours() * 0.5;
				break;
			case Film.CINEPHILE:
				du += 2;
				if (each.getNbJours() > 1)
					du += (each.getNbJours() - 1) * 4;
				break;

			}

			// ajout des points de fidélité
			if ((each.getFilm().getCodePrix() != Film.COFFRETSERIESTV)
					&& (each.getFilm().getCodePrix() != Film.CINEPHILE))
				pointsFidelites++;

			// ajout d'un bonus pour les nouveautés louées depuis au moins deux jours
			if ((each.getFilm().getCodePrix() == Film.NOUVEAUTE) && each.getNbJours() > 1)
				pointsFidelites++;

			// ajout d'un bonus pour les CINEPHILE louées moins de 2 jours
			if ((each.getFilm().getCodePrix() == Film.CINEPHILE) && each.getNbJours() < 2)
				pointsFidelites += 3;

			// mise en forme location
			result += "\t" + each.getFilm().getTitre() + "\t" + String.valueOf(du) + "<BR>\n";
			totalDu += du;
		}

		// ajout récapitulatif client
		result += "<P>Total de " + String.valueOf(totalDu) + "<P>\n";
		result += "Vous gagnez " + String.valueOf(pointsFidelites) + " points de fidélité<P>\n";

		return result;
	}

}