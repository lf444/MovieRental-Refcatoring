package version4;


public class PrixNouveau extends Prix {
	
	@Override
	public double getMontant(int nbJours) {
		
		return nbJours * 3;
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
