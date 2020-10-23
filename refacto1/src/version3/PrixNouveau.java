package version3;


public class PrixNouveau extends Prix {
	@Override
	public double getMontant(Location location) {
		double montant=0;
		montant += location.getNbJours() * 3;
		return montant;
	}
}
