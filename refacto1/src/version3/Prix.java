package version3;

public abstract class Prix {

	private int prix;

	public Prix(int prix) {
		this.prix=prix;
	}

	public int getPrix() {
		return prix;
	} 

	public abstract double getMontant(Location location);

}
