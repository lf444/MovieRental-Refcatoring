package version3;

public class PrixNormal extends Prix {
	@Override
	public double getMontant(int nbJours) {
		double montant=2;
		if (nbJours > 2) 
			montant += (nbJours - 2) * 1.5;
		return montant;
	}

}
