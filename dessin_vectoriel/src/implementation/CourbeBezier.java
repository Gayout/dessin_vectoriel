package implementation;

import java.util.List;

import abstraction.Dessin;
import abstraction.Visiteur;
import interpreteur.svg.CourbeBezierSVG;

public class CourbeBezier extends Polygone {

	public CourbeBezier(List<Position> sommets, boolean ouvert, boolean rempli) {
		super(sommets, ouvert, rempli);
	}

	public CourbeBezier(List<Position> pointControle, boolean rempli) {
		super(pointControle, true, rempli);
	}

	public CourbeBezier() {
		super();
	}

	@Override
	public Dessin creerCourbeBezier(List<Position> pointControle, boolean rempli) {
		return new CourbeBezier(pointControle, rempli);
	}
	
	@Override
	public Dessin creerPolygone(List<Position> sommets, boolean ouvert, boolean rempli) {
		return null;
	}
	
	public CourbeBezierSVG creerCourbeBezierSVG() {
		return new CourbeBezierSVG(this);
	}
	
	@Override
	public void accept(Visiteur visiteur) {
		visiteur.visit(this);
	}
}
