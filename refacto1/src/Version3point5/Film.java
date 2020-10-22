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
	
}