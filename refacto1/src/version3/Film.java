package version3;



public class Film {
	
	public static final int ENFANT = 2;
	public static final int NOUVEAUTE = 1;
	public static final int NORMAL = 0;

	private Prix prix;
	private PointFidelite point;
	
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
		
				this.point= new PointFideliteAutre();
					break;
			case NOUVEAUTE:
				this.prix = new PrixNouveau();
				this.point= new PointFideliteNouveau() {
				};
					break;			
			case ENFANT:
				this.prix = new PrixEnfant();
				this.point= new PointFideliteAutre();
				break;
		}
	}

	public int getCodePrix() {
		return this.codePrix;
	}
	


	public Prix getPrix() {
		return prix;
	}

	public PointFidelite getPoint() {
		return this.point;
		
	}

	
}