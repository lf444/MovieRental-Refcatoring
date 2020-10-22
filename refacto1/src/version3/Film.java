package version3;

public class Film {
	public static final int ENFANT = 2;
	public static final int NOUVEAUTE = 1;
	public static final int NORMAL = 0;
	private Prix prix;
	
	private String titre;
	private int codePrix;
	
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
			case 0:
				this.prix=new PrixNormal();
					break;
			case 1:
				this.prix=new PrixNouveau();
				
				break;
			case 2:
				this.prix=new PrixEnfant();
				break;
		}
	}

	public int getCodePrix() {
		return this.codePrix;
	}
	

	public int getPointFidelites(Location location) {
		int pointsFidelites=0;
		// ajout des points de fidélité
		pointsFidelites++;
		
		// ajout d'un bonus pour les nouveautés louées depuis au moins deux jours
		if ((location.getFilm().getCodePrix() == Film.NOUVEAUTE) && location.getNbJours() > 1) 
			pointsFidelites++;
		return pointsFidelites;
	}


	
}