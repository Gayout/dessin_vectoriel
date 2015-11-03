package implementation;

import abstraction.Chemin;
import abstraction.Dessin;

public class Cercle extends Chemin{

	private Position centre;
	private int gdAxe;
	private boolean rempli;

	
	public Cercle(Position centre, int rayon, boolean isRempli) {
		this.centre = centre;
		this.gdAxe = rayon;
		this.rempli = rempli;
	}

	public Cercle() {
		super();
	}

	public int getRayon() {
		return this.gdAxe;
	}

	public void setRayon(int rayon) {
		this.gdAxe= rayon;
	}

	public boolean isRempli() {
		return rempli;
	}

	public void setRempli(boolean isRempli) {
		this.rempli = isRempli;
	}
	@Override
	public Dessin creerCercle(Position centre, int rayon, boolean rempli) {
		return new Cercle(centre, rayon, rempli);
	}
}
