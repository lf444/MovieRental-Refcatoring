package version4;



public class Film {


	public static final int ENFANT = 2;
	public static final int NOUVEAUTE = 1;
	public static final int NORMAL = 0;
	public static final int CINEPHILE = 3;
	public static final int  COFFRETSERIESTV = 4;

	private String titre;
	private int codePrix;
	private Prix prix;

	public Film(String titre, int codePrix) {
		this.titre = titre;
		this.codePrix = codePrix;
		this.setCodePrix(codePrix);
	}

	public String getTitre() {
		return this.titre;
	}

	public void setCodePrix(int codePrix) {
		switch(codePrix) {
		case NORMAL:
			this.prix = new PrixNormal();
			break;
		case NOUVEAUTE:
			this.prix = new PrixNouveau();
			break;			
		case ENFANT:
			this.prix = new PrixEnfant();
			break;
		case COFFRETSERIESTV:
			this.prix = new PrixCoffret();
			break;
		case CINEPHILE:
			this.prix = new PrixCinephile();
		}
	}


	public int getCodePrix() {
		return this.codePrix;
	}



	int getPointFidelites(Location location) {
		int pointsFidelites = 0;
		// ajout des points de fidélité
		if ((location.getFilm().getCodePrix() != Film.COFFRETSERIESTV) && (location.getFilm().getCodePrix() != Film.CINEPHILE))
			pointsFidelites++;

		// ajout d'un bonus pour les nouveautés louées depuis au moins deux jours
		if ((location.getFilm().getCodePrix() == Film.NOUVEAUTE) && location.getNbJours() > 1)
			pointsFidelites++;

		// ajout d'un bonus pour les CINEPHILE louées moins de 2 jours
		if ((location.getFilm().getCodePrix() == Film.CINEPHILE) && location.getNbJours() < 2)
			pointsFidelites += 3;
		return pointsFidelites;
	}

	public double getMontant(int nbJours) {
		return prix.getMontant(nbJours);
	}

	public int getPoint(int nbJours) {
		return prix.getPointFidelites(nbJours);

	}

}