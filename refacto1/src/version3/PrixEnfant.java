package version3;

public class PrixEnfant extends Prix {
	
	public PrixEnfant() {
		super(2);
	
	}

	@Override
	public double getMontant(Location location) {
		double montantDu=0;
		montantDu += 1.5;
		if (location.getNbJours() > 3)
			montantDu += (location.getNbJours() - 3) * 1.5;
		return montantDu;
	}
	
	


	
}
