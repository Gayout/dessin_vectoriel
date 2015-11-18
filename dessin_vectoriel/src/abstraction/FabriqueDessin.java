package abstraction;

import java.util.List;

import implementation.Position;

public interface FabriqueDessin<T> {
	public default T creerCercle(Position centre, int rayon, boolean rempli){
		return null;
	}
	public default T creerEllipse(Position centre, int gdAxe, int petitAxe, long angleAbsGdAxe, boolean rempli){
		return null;
	}
	public default T creerCourbeBezier(List<Position> pointControle, boolean rempli) {
		return null;
	}
	public default T creerDessinComposite(List<Dessin> dessins) {
		return null;
	}
	public default T creerPolygone(List<Position> sommets, boolean ouvert, boolean rempli) {
		return null;
	}
	public default T creerSegment(Position p1, Position p2) {
		return null;
	}
	public default T creerRectangle(Position hautGauche, int width, int height, boolean isRempli) {
		return null;
	}
}
