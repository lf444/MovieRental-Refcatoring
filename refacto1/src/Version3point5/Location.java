package Version3point5;
public class Location {
	Film unFilm;
	private int nbJours;
	
	public Location(Film unFilm, int nbJours) {
		this.unFilm = unFilm;
		this.nbJours = nbJours;
	}

	public int getNbJours() {
		return this.nbJours;
	}

	public Film getFilm() {
		return this.unFilm;
	}
	
}