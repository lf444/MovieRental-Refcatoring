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
			case NORMAL:
				this.prix = new PrixNormal();
			
				
					break;
			case NOUVEAUTE:
				this.prix = new PrixNouveau();
					break;			
			case ENFANT:
				this.prix = new PrixEnfant();
				
				break;
		}
	}

	public int getCodePrix() {
		return this.codePrix;
	}
	


	public double getPrix(int nbJours) {
		return prix.getMontant(nbJours);
	}

	public int getPoint(int nbJours) {
		return prix.getPointFidelites(nbJours);
		
	}

	
}