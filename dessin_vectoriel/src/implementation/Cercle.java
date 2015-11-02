package implementation;

import java.util.List;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.DessinVide;
import abstraction.Visiteur;

public class Cercle extends Ellipse {

	public Cercle() {
		super();
	}

	public Cercle(Position centre, int rayon, boolean isRempli) {
		super(new Position(centre.getX()-rayon, centre.getY()-rayon), rayon, rayon, 0, isRempli);
	}

	public int getRayon() {
		if (super.getGdAxe() == super.getPetitAxe()) {
			return super.getGdAxe();
		}
		else {
			return (Integer) null;
		}
	}

	public void setRayon(int rayon) {
		super.setGdAxe(rayon);
		super.setPetitAxe(rayon);
	}

	public Position getCentre() {
		return new Position(super.getHtGauche().getX()+super.getGdAxe(), super.getHtGauche().getY()+super.getGdAxe());
	}

	@Override
	public void setPosition(Position p) {
		
	}

	@Override
	public boolean isRempli() {
		return (Boolean) null;
	}

	@Override
	public void setRempli(boolean b) {
		
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
