package version3;

public class PrixNormal extends Prix {
	@Override
	public double getMontant(Location location) {
		double montant=2;
		if (location.getNbJours() > 2) 
			montant += (location.getNbJours() - 2) * 1.5;
		return montant;
	}
}
