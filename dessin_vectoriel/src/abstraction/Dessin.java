package abstraction;
/**
 * <b>Dessin est la plus haute couche du patron Composite</b>
 * <p>
 * Un Dessin est une interface qui étends la Fabrique de Dessin et qui permet la visite de Visiteurs
 * </p>
 * <p>
 * Dessin est implémenté ensuite par :
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
	 * L'énumération des possibilités pour une figure d'être ouverte ou fermée
	 */
	public static final boolean OUVERT = true;
	public static final boolean FERME = false;
	
	/**
	 * L'énumération des possibilités pour une figure d'être vide ou rempli
	 */
	public static final boolean REMPLI = true;
	public static final boolean VIDE = false;
	
	public void accept(Visiteur visiteur);
	
}