package implementation;

import java.util.List;

import abstraction.Dessin;

public class CourbeBezier extends Polygone {

	public CourbeBezier(boolean rempli, List<Position> sommets, boolean ouvert) {
		super(rempli, sommets, ouvert);
	}

	public CourbeBezier(boolean rempli, List<Position> pointControle) {
		super(rempli, pointControle, true);
	}

	public CourbeBezier() {
		super();
	}

	@Override
	public Dessin creerCourbeBezier(boolean rempli, List<Position> pointControle) {
		return new CourbeBezier(rempli, pointControle);
	}
	
	@Override
	public Dessin creerPolygone(boolean rempli, List<Position> sommets, boolean ouvert) {
		return null;
	}
}
