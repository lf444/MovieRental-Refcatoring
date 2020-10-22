package version3;

public class PrixNouveau extends Prix {
	
	public PrixNouveau() {
		super(1);
	
	}

	public static final int NOUVEAUTE = 1;

	@Override
	public double getMontant(Location location) {
		double montantDu=0;
		montantDu += location.getNbJours() * 3;
		return montantDu;
	}

	
}
