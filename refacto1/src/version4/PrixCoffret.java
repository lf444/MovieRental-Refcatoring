package version4;

public class PrixCoffret extends Prix {

	@Override
	public double getMontant(int nbJours) {
		
		return nbJours * 0.5;
	}
	@Override
	public int getPointFidelites(int nbJours) {
		return 0;
		}
	}


