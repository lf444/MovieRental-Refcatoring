package version3;

public abstract class PointFideliteNouveau extends PointFidelite {


	
	@Override
	public int getPointFidelites(Location location) {
		if (location.getNbJours() > 1) {
			return 2;
		}else{
			return 1;
		}
	}
	

}
