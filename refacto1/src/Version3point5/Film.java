package Version3point5;

public class Film {
	
	
	public static final int ENFANT = 2;
	public static final int NOUVEAUTE = 1;
	public static final int NORMAL = 0;
	public static final int CINEPHILE = 3;
	public static final int  COFFRETSERIESTV = 4;
	
	private String titre;
	private int codePrix;
	
	public Film(String titre, int codePrix) {
		this.titre = titre;
		this.codePrix = codePrix;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setCodePrix(int codePrix) {
		this.codePrix = codePrix;
	}

	public int getCodePrix() {
		return this.codePrix;
	}

	public double getMontant(Location location) {
		double du =0;
		//determine le montant de chaque location
		switch (location.getFilm().getCodePrix()) {
		case Film.NORMAL:
			du += 2;
			if (location.getNbJours() > 2) 
				du += (location.getNbJours() - 2) * 1.5;
			break;
		case Film.NOUVEAUTE:
			du += location.getNbJours() * 3;
			break;
		case Film.ENFANT:
			du += 1.5;
			if (location.getNbJours() > 3)
				du += (location.getNbJours() - 3) * 1.5;
			break;
		case Film.COFFRETSERIESTV:
			du += location.getNbJours() * 0.5;
			break;
		case Film.CINEPHILE:
			du += 2;
			if (location.getNbJours() > 1) 
				du += (location.getNbJours() - 1) *4;
			break;
	
		}
		return du;
	}

	public int getPointFidelite(Location location) {
		int pointsFidelites=0;
		// ajout des points de fidélité
		if((location.getFilm().getCodePrix() != Film.COFFRETSERIESTV)&&(location.getFilm().getCodePrix() != Film.CINEPHILE))
		pointsFidelites++;
		
		// ajout d'un bonus pour les nouveautés louées depuis au moins deux jours
		if ((location.getFilm().getCodePrix() == Film.NOUVEAUTE) && location.getNbJours() > 1) 
			pointsFidelites++;
		
		// ajout d'un bonus pour les CINEPHILE louées  moins de 2 jours
		if ((location.getFilm().getCodePrix() == Film.CINEPHILE) && location.getNbJours() <2) 
		    pointsFidelites+=3;
		return pointsFidelites;
	}
	
}