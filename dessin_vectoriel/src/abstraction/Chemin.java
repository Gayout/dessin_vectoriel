package abstraction;

import implementation.*;

/**
 * <b>Chemin est une classe abstraite qui implemente l'interface Dessin</b>
 * <p>
 * Un Chemin possède un crayon et est une figure qui est implémentée par :
 * <ul>
 * <li>Un Cercle</li>
 * <li>Une Courbe de Bézier</li>
 * <li>Une Ellipse</li>
 * <li>Un Polygone</li>
 * <li>Un Rectangle</li>
 * <li>Un Segment</li>
 * <li>Un Texte</li>
 * </ul>
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
public abstract class Chemin implements Dessin{
	
	/**
	 * @see Chemin#getCrayon()
	 * @see Chemin#setCrayon(Crayon)
	 */
	private Crayon crayon= Crayon.CRAYON_DEFAUT;
	
	/**
	 * @see Chemin#crayon
	 * @return Le crayon avec sa couleur et son epaisseur
	 */
	public Crayon getCrayon() {
		return crayon;
	}
	/**
	 * @see Chemin#crayon
	 * @param crayon
	 * 		Change le crayon
	 */
	public void setCrayon(Crayon crayon) {
		this.crayon = crayon;
	}
	/**
	 * 
	 * @return Un boolean déclarant s'il faut ou non remplir la figure
	 */
	public abstract boolean isRempli();
	/**
	 * 
	 * @param b
	 * 		Autorise ou non le remplissage
	 */
	public abstract void setRempli(boolean b);
}