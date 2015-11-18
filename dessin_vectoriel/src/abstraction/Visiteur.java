package abstraction;

import implementation.*;

public interface Visiteur {
	
	void visit(Dessin dessin);
	void visit(Cercle cercle);
	void visit(CourbeBezier courbeBezier);
	void visit(Ellipse ellipse);
	void visit(Polygone polygone);
	void visit(Rectangle rectangle);
	void visit(Segment segment);
	void visit(Texte texte);
}
