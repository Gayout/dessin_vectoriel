package abstraction;

import java.util.List;

import implementation.*;
/**
 * <b>FabriqueDessin est une interface qui a le rôle de fabrique. Elle permet de créer les briques élémentaires d'un Dessin</b>
 * <p>
 * Ces briques élémentaires peuvent être:
 * <ul>
 * <li>Un DessinComposite</li>
 * <li>Un Cercle</li>
 * <li>Une Courbe de Bézier</li>
 * <li>Une Ellipse</li>
 * <li>Un Polygone</li>
 * <li>Un Rectangle</li>
 * <li>Un Segment</li>
 * <li>Un Texte</li>
 * </ul>
 * </p>
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
	 * La fabrique qui sert à créer un Cercle
	 * @see Cercle#creerCercle(Position, int, boolean)
	 * @see Ellipse#creerCercle(Position, int, boolean)
	 * @param centre
	 * @param rayon
	 * @param rempli
	 * @return Par défaut ne retourne rien, elle sera implementé dans la classe Cercle
	 */
	public default T creerCercle(Position centre, int rayon, boolean rempli){
		return null;
	}
	
	/**
	 * La fabrique qui sert à créer une Ellipse
	 * @see Ellipse#creerEllipse(Position, int, int, long, boolean)
	 * @param centre
	 * @param gdAxe
	 * @param petitAxe
	 * @param angleAbsGdAxe
	 * @param rempli
	 * @return Par défaut ne retourne rien, elle sera implementé dans la classe Ellipse
	 */
	public default T creerEllipse(Position centre, int gdAxe, int petitAxe, long angleAbsGdAxe, boolean rempli){
		return null;
	}
	
	/**
	 * @see CourbeBezier#creerCourbeBezier(List, boolean)
	 * La fabrique qui sert à créer une Courbe de Bézier
	 * @param pointControle
	 * @param rempli
	 * @return Par défaut ne retourne rien, elle sera implementé dans la classe CourbeBezier
	 */
	public default T creerCourbeBezier(List<Position> pointControle, boolean rempli) {
		return null;
	}
	
	/**
	 * @see DessinComposite#creerDessinComposite(List)
	 * La fabrique qui sert à créer un DessinComposite
	 * @param dessins
	 * @return Par défaut ne retourne rien, elle sera implementé dans la classe DessinComposite
	 */
	public default T creerDessinComposite(List<Dessin> dessins) {
		return null;
	}
	
	/**
	 * @see Polygone#creerPolygone(List, boolean, boolean)
	 * @see CourbeBezier#creerPolygone(List, boolean, boolean)
	 * La fabrique qui sert à créer un Polygone
	 * @param sommets
	 * @param ouvert
	 * @param rempli
	 * @return Par défaut ne retourne rien, elle sera implementé dans la classe Polygone
	 */
	public default T creerPolygone(List<Position> sommets, boolean ouvert, boolean rempli) {
		return null;
	}
	
	/**
	 * @see Segment#creerSegment(Position, Position)
	 * La fabrique qui sert à créer un Segment
	 * @param p1
	 * 		Le point de départ du segment
	 * @param p2
	 * 		Le point d'arrivée du segment
	 * @return Par défaut ne retourne rien, elle sera implementé dans la classe Segment
	 */
	public default T creerSegment(Position p1, Position p2) {
		return null;
	}
	
	/**
	 * @see Rectangle#creerRectangle(Position, int, int, boolean)
	 * La fabrique qui sert à créer un Rectangle
	 * @param hautGauche
	 * @param width
	 * @param height
	 * @param isRempli
	 * @return Par défaut ne retourne rien, elle sera implementé dans la classe Rectangle
	 */
	public default T creerRectangle(Position hautGauche, int width, int height, boolean isRempli) {
		return null;
	}
}
