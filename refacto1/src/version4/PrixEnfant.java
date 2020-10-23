package version4;


public class PrixEnfant extends Prix {
	@Override

	public double getMontant(int nbJours) {			
		double montant=1.5;
		if (nbJours > 3)
			montant += (nbJours - 3) * 1.5;
		return montant;
	}


}
