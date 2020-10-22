package Version3point5;
public class Location {
	private Film unFilm;
	private int nbJours;
	
	public Location(Film unFilm, int nbJours) {
		this.unFilm = unFilm;
		this.nbJours = nbJours;
	}

	public int getNbJours() {
		return this.nbJours;
	}

	public Film getFilm() {
		return this.unFilm;
	}
	
	
	// Montant du correspond au montant qui sera du après calcul des tarif
	public double getMontant() {
		double montantDu=0;
		switch (getFilm().getCodePrix()) {
		case Film.NORMAL:
			montantDu += 2;
			if (getNbJours() > 2) 
				montantDu += (getNbJours() - 2) * 1.5;
			break;
		case Film.NOUVEAUTE:
			montantDu += getNbJours() * 3;
			break;
		case Film.ENFANT:
			montantDu += 1.5;
			if (getNbJours() > 3)
				montantDu += (getNbJours() - 3) * 1.5;
			break;
		case Film.COFFRETSERIESTV:
			montantDu += getNbJours() * 0.5;
			break;
		case Film.CINEPHILE:
			montantDu += 2;
			if (getNbJours() > 1) 
				montantDu += (getNbJours() - 1) *4;
			break;
	
		}
		return montantDu;
	}

	public int getPointFidelites() {
		int pointsFidelites = 0;
		// ajout des points de fidélité
		if((getFilm().getCodePrix() != Film.COFFRETSERIESTV)&&(getFilm().getCodePrix() != Film.CINEPHILE))
		pointsFidelites++;
		
		// ajout d'un bonus pour les nouveautés louées depuis au moins deux jours
		if ((getFilm().getCodePrix() == Film.NOUVEAUTE) && getNbJours() > 1) 
			pointsFidelites++;
		
		// ajout d'un bonus pour les CINEPHILE louées  moins de 2 jours
		if ((getFilm().getCodePrix() == Film.CINEPHILE) && getNbJours() <2) 
		    pointsFidelites+=3;
		return pointsFidelites;
	}
	
}