package version4;

public abstract class Prix {
	public abstract double getMontant(int nbJours);
	
	public  int getPointFidelites(int nbJours) {
		return 1;
	}
}
