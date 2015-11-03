package implementation;

import abstraction.Dessin;

public class Cercle extends Ellipse {

	public Cercle(Position centre, int rayon, boolean isRempli) {
		super(new Position(centre.getX(), centre.getY()), rayon, rayon, 0, isRempli);
	}

	public Cercle() {
		super();
	}

	public int getRayon() {
		if (super.getGdAxe() == super.getPetitAxe()) {
			return super.getGdAxe();
		}
		else {
			return 0;
		}
	}

	public void setRayon(int rayon) {
		super.setGdAxe(rayon);
		super.setPetitAxe(rayon);
	}

	@Override
	public Dessin creerCercle(Position centre, int rayon, boolean rempli) {
		return new Cercle(centre, rayon, rempli);
	}
}
