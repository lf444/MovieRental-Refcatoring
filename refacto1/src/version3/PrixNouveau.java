package version3;


public class PrixNouveau extends Prix {
	
	@Override
	public double getMontant(int nbJours) {
		double montant=0;
		montant += nbJours * 3;
		return montant;
	}
	
	
	@Override
	public int getPointFidelites(int nbJours) {
		if (nbJours > 1) {
			return 2;
		}else{
			return 1;
		}
	}
}
