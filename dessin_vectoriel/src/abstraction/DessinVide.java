package abstraction;

import java.util.List;

import implementation.Position;

public class DessinVide implements Dessin {

	public static final DessinVide VIDE = new DessinVide();
	
	public DessinVide() {
	}

	@Override
	public void dessiner() {		
	}

	@Override
	public void remplir() {
	}

	@Override
	public void inserer(Dessin d) {
	}

	@Override
	public void etiqueter(String m) {
	}

	@Override
	public void accept(Visiteur visiteur) {
	}

	@Override
	public Dessin creerCercle(Position centre, int rayon, boolean rempli) {
		return null;
	}

	@Override
	public Dessin creerCourbeBezier(boolean rempli, List<Position> pointControle) {
		return null;
	}

	@Override
	public Dessin creerDessinVide() {
		return VIDE;
	}

	@Override
	public Dessin creerDessinComposite(List<Dessin> dessins) {
		return null;
	}

	@Override
	public Dessin creerPolygone(boolean rempli, List<Position> pointControle) {
		return null;
	}

	@Override
	public Dessin creerSegment(Position p1, Position p2) {
		return null;
	}

}