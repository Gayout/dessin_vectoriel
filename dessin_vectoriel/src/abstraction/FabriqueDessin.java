package abstraction;

import java.util.List;

import implementation.Position;

public interface FabriqueDessin<T> {
	public default T creerCercle(Position centre, int rayon, boolean rempli){
		return null;
	}
	public default T creerCourbeBezier(boolean rempli, List<Position> pointControle) {
		return null;
	}
	public default T creerDessinComposite(List<Dessin> dessins) {
		return null;
	}
	public default T creerPolygone(boolean rempli, List<Position> sommets, boolean ouvert) {
		return null;
	}
	public default T creerSegment(Position p1, Position p2) {
		return null;
	}
}
