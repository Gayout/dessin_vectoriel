package abstraction;

import java.util.List;

import implementation.*;
/**
 * <b>FabriqueDessin est une interface qui a le r�le de fabrique. Elle permet de cr�er les briques �l�mentaires d'un Dessin</b>
 * <p>
 * Ces briques �l�mentaires peuvent �tre:
 * <ul>
 * <li>Un DessinComposite</li>
 * <li>Un Cercle</li>
 * <li>Une Courbe de B�zier</li>
 * <li>Une Ellipse</li>
 * <li>Un Polygone</li>
 * <li>Un Rectangle</li>
 * <li>Un Segment</li>
 * <li>Un Texte</li>
 * </ul>
 * @see DessinComposite
 * @see Cercle
 * @see CourbeBezier
 * @see Ellipse
 * @see Polygone
 * @see Rectangle
 * @see Segment
 * @see Texte
 * @see Dessin
 * @author Aurore Claude/Quentin Gayout
 *
 */
public interface FabriqueDessin<T> {
	/**
	 * La fabrique qui sert � cr�er un Cercle
	 * @see Cercle#creerCercle(Position, int, boolean)
	 * @see Ellipse#creerCercle(Position, int, boolean)
	 * @param centre
	 * 	position
	 * @param rayon
	 * 	rayon
	 * @param rempli
	 * 	remplissage
	 * @return Par d�faut ne retourne rien, elle sera implement� dans la classe Cercle
	 */
	public default T creerCercle(Position centre, int rayon, boolean rempli){
		return null;
	}
	
	/**
	 * La fabrique qui sert � cr�er une Ellipse
	 * @see Ellipse#creerEllipse(Position, int, int, long, boolean)
	 * @param centre
	 * 	position
	 * @param gdAxe
	 * 	grand axe
	 * @param petitAxe
	 * 	petit axe
	 * @param angleAbsGdAxe
	 * 	angle
	 * @param rempli
	 * 	remplissage
	 * @return Par d�faut ne retourne rien, elle sera implement� dans la classe Ellipse
	 */
	public default T creerEllipse(Position centre, int gdAxe, int petitAxe, long angleAbsGdAxe, boolean rempli){
		return null;
	}
	
	/**
	 * @see CourbeBezier#creerCourbeBezier(List, boolean, boolean)
	 * La fabrique qui sert � cr�er une Courbe de B�zier
	 * @param pointControle
	 * 	point de controle
	 * @param ouvert
	 * 	ouverture
	 * @param rempli
	 * 	remplissage
	 * @return Par d�faut ne retourne rien, elle sera implement� dans la classe CourbeBezier
	 */
	public default T creerCourbeBezier(List<Position> pointControle, boolean ouvert, boolean rempli) {
		return null;
	}
	
	/**
	 * @see DessinComposite#creerDessinComposite(List)
	 * La fabrique qui sert � cr�er un DessinComposite
	 * @param dessins
	 * 	dessins
	 * @return Par d�faut ne retourne rien, elle sera implement� dans la classe DessinComposite
	 */
	public default T creerDessinComposite(List<Dessin> dessins) {
		return null;
	}
	
	/**
	 * @see Polygone#creerPolygone(List, boolean, boolean)
	 * @see CourbeBezier#creerPolygone(List, boolean, boolean)
	 * La fabrique qui sert � cr�er un Polygone
	 * @param sommets
	 * 	sommets
	 * @param ouvert
	 * 	ouverture
	 * @param rempli
	 * 	remplissage
	 * @return Par d�faut ne retourne rien, elle sera implement� dans la classe Polygone
	 */
	public default T creerPolygone(List<Position> sommets, boolean ouvert, boolean rempli) {
		return null;
	}
	
	/**
	 * @see Segment#creerSegment(Position, Position)
	 * La fabrique qui sert � cr�er un Segment
	 * @param p1
	 * 		Le point de d�part du segment
	 * @param p2
	 * 		Le point d'arriv�e du segment
	 * @return Par d�faut ne retourne rien, elle sera implement� dans la classe Segment
	 */
	public default T creerSegment(Position p1, Position p2) {
		return null;
	}
	
	/**
	 * @see Rectangle#creerRectangle(Position, int, int, boolean)
	 * La fabrique qui sert � cr�er un Rectangle
	 * @param hautGauche
	 * 	position
	 * @param width
	 * 	largeur
	 * @param height
	 * 	hauteur
	 * @param isRempli
	 * 	remplissage
	 * @return Par d�faut ne retourne rien, elle sera implement� dans la classe Rectangle
	 */
	public default T creerRectangle(Position hautGauche, int width, int height, boolean isRempli) {
		return null;
	}
}
