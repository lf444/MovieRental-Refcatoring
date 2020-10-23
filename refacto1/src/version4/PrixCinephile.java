package version4;

public class PrixCinephile extends Prix {

	@Override
	public double getMontant(int nbJours) {
		double montant = 2;
		if (nbJours> 1)
			montant += (nbJours - 1) * 4;
		return montant;
	}
	@Override
	public int getPointFidelites(int nbJours) {
		if (nbJours > 1) {
			return 0;
		}else{
			return 3;
		}
	}
}
