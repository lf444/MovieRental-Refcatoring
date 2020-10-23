package version4;

public class Location {
	private Film unFilm;
	private int nbJours;

	public Location(Film unFilm, int nbJours) {
		this.setUnFilm(unFilm);
		this.nbJours = nbJours;
	}

	public int getNbJours() {
		return this.nbJours;
	}

	public Film getFilm() {
		return this.getUnFilm();
	}

	public Film getUnFilm() {
		return unFilm;
	}

	public void setUnFilm(Film unFilm) {
		this.unFilm = unFilm;
	}

	public double getMontant() {
		return unFilm.getMontant(nbJours);
	}
	public int getFidelite() {
		return unFilm.getPoint(nbJours);
	}
}

