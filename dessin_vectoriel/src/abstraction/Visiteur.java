package abstraction;

import implementation.*;
import visitor.*;
/**
 * <b>Visiteur est une interface qui a le rôle de visiteur. Elle permet de créer les services utilisés par les Dessins.</b>
 * <p>
 * Ces services peuvent être:
 * <ul>
 * <li>Un VisiteurAWTDessiner</li>
 * <li>Un VisiteurSVGDessiner</li>
 * </ul>
 * @see VisiteurAWTDessiner
 * @see VisiteurSVGDessiner
 * @author Aurore Claude/Quentin Gayout
 *
 */
public interface Visiteur {
	/**
	 * La visite d'un Dessin
	 * @see Dessin#accept(Visiteur)
	 * @param dessin
	 * 	dessin
	 */
	void visit(Dessin dessin);

	/**
	 * La visite d'un Cercle
	 * @see Cercle#accept(Visiteur)
	 * @see VisiteurAWTDessiner#visit(Cercle)
	 * @see VisiteurSVGDessiner#visit(Cercle)
	 * @param cercle
	 * 	cercle
	 */
	void visit(Cercle cercle);

	/**
	 * La visite d'une Courbe de Bézier
	 * @see CourbeBezier#accept(Visiteur)
	 *  @see VisiteurAWTDessiner#visit(CourbeBezier)
	 * @see VisiteurSVGDessiner#visit(CourbeBezier)
	 * @param courbeBezier
	 * 	courbeBezier
	 */
	void visit(CourbeBezier courbeBezier);

	/**
	 * La visite d'une Ellipse
	 * @see Ellipse#accept(Visiteur)
	 * @see VisiteurAWTDessiner#visit(Ellipse)
	 * @see VisiteurSVGDessiner#visit(Ellipse)
	 * @param ellipse
	 * 	ellipse
	 */
	void visit(Ellipse ellipse);

	/**
	 * La visite d'un Polygone
	 * @see Polygone#accept(Visiteur)
	 * @see VisiteurAWTDessiner#visit(Polygone)
	 * @see VisiteurSVGDessiner#visit(Polygone)
	 * @param polygone
	 * 	polygone
	 */
	void visit(Polygone polygone);

	/**
	 * La visite d'un Rectangle
	 * @see Rectangle#accept(Visiteur)
	 * @see VisiteurAWTDessiner#visit(Rectangle)
	 * @see VisiteurSVGDessiner#visit(Rectangle)
	 * @param rectangle
	 * 	rectangle
	 */
	void visit(Rectangle rectangle);

	/**
	 * La visite d'un Segment 
	 * @see Segment#accept(Visiteur)
	 * @see VisiteurAWTDessiner#visit(Segment)
	 * @see VisiteurSVGDessiner#visit(Segment)
	 * @param segment
	 * 	segment
	 */
	void visit(Segment segment);

	/**
	 * La visite d'un Texte
	 * @see Texte#accept(Visiteur)
	 * @see VisiteurAWTDessiner#visit(Texte)
	 * @see VisiteurSVGDessiner#visit(Texte)
	 * @param texte
	 * 	texte
	 */
	void visit(Texte texte);
}
