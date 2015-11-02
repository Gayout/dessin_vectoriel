package abstraction;

import java.util.List;

import implementation.Position;

public interface FabriqueDessin<T> {
	T creerCercle(Position centre, int rayon, boolean rempli);
	T creerCourbeBezier(boolean rempli, List<Position> pointControle);
	T creerDessinVide();
	T creerDessinComposite(List<Dessin> dessins);
	T creerPolygone(boolean rempli, List<Position> sommets);
	T creerSegment(Position p1, Position p2);
}
