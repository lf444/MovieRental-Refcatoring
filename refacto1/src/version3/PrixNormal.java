package version3;

public class PrixNormal extends Prix {

	public PrixNormal() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	private static final int NORMAL = 0;

	@Override
	public double getMontant(Location location) {
		double montantDu=0;
		montantDu += 2;
		if (location.getNbJours() > 2) 
			montantDu += (location.getNbJours() - 2) * 1.5;
		return montantDu;
	}
	



}
