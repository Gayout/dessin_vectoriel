package implementation;

import java.util.List;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.DessinVide;
import abstraction.Visiteur;

public class Cercle implements Chemin {

	private Position centre;
	private int rayon;
	private boolean rempli;
	
	public Cercle(Position centre, int rayon, boolean rempli) {
		super();
		this.centre = centre;
		this.rayon = rayon;
		this.rempli = rempli;
	}

	public Cercle() {
		super();
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
	}

	@Override
	public Position getPosition() {
		return centre;
	}

	@Override
	public void setPosition(Position p) {
		centre = p;
	}

	@Override
	public boolean isRempli() {
		return rempli;
	}

	@Override
	public void setRempli(boolean b) {
		rempli = b;
	}

	@Override
	public void dessiner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remplir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserer(Dessin d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void etiqueter(String m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dessin creerCercle(Position centre, int rayon, boolean rempli) {
		return new Cercle(centre, rayon, rempli);
	}

	@Override
	public Dessin creerCourbeBezier(boolean rempli, List<Position> pointControle) {
		return null;
	}

	@Override
	public Dessin creerDessinComposite(List<Dessin> dessins) {
		return null;
	}

	@Override
	public Dessin creerPolygone(boolean rempli, List<Position> sommets) {
		return null;
	}

	@Override
	public Dessin creerSegment(Position p1, Position p2) {
		return null;
	}
}
