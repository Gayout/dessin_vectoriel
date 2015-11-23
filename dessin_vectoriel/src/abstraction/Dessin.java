package abstraction;
/**
 * <b>Dessin est la plus haute couche du patron Composite</b>
 * <p>
 * Un Dessin est une interface qui �tends la Fabrique de Dessin et qui permet la visite de Visiteurs
 * </p>
 * <p>
 * Dessin est impl�ment� ensuite par :
 * <ul>
 * <li>Un Dessin Vide</li>
 * <li>Un Dessin Composite</li>
 * <li>Un Chemin</li>
 * </ul>
 * </p>
 * @see Chemin
 * @see DessinVide
 * @see DessinComposite
 * @author Aurore Claude/Quentin Gayout
 *
 */
public interface Dessin extends FabriqueDessin<Dessin>{
	
	/** 
	 * L'�num�ration des possibilit�s pour une figure d'�tre ouverte ou ferm�e
	 */
	public static final boolean OUVERT = true;
	public static final boolean FERME = false;
	
	/**
	 * L'�num�ration des possibilit�s pour une figure d'�tre vide ou rempli
	 */
	public static final boolean REMPLI = true;
	public static final boolean VIDE = false;
	
	public void accept(Visiteur visiteur);
	
}