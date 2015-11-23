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
 * </p>
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
	 */
	void visit(Dessin dessin);
	
	/**
	 * La visite d'un Cercle
	 * @see Cercle#accept(Visiteur)
	 * @param cercle
	 */
	void visit(Cercle cercle);
	
	/**
	 * La visite d'une Courbe de Bézier
	 * @see CourbeBezier#accept(Visiteur)
	 * @param courbeBezier
	 */
	void visit(CourbeBezier courbeBezier);
	
	/**
	 * La visite d'une Ellipse
	 * @see Ellipse#accept(Visiteur)
	 * @param ellipse
	 */
	void visit(Ellipse ellipse);
	
	/**
	 * La visite d'un Polygone
	 * @see Polygone#accept(Visiteur)
	 * @param polygone
	 */
	void visit(Polygone polygone);
	
	/**
	 * La visite d'un Rectangle
	 * @see Rectangle#accept(Visiteur)
	 * @param rectangle
	 */
	void visit(Rectangle rectangle);
	
	/**
	 * La visite d'un Segment 
	 * @see Segment#accept(Visiteur)
	 * @param segment
	 */
	void visit(Segment segment);
	
	/**
	 * La visite d'un Texte
	 * @see Texte#accept(Visiteur)
	 * @param texte
	 */
	void visit(Texte texte);
}
