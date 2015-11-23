package abstraction;
/**
 * <b>DessinVide est une classe qui fait partie du patron composite, implémente Dessin et qui est le singleton Vide</b>
 * <p>
 * Un DessinVide ne possède aucun instance de Dessin. Son constructeur est privé et il possède une variable static qui correspond au singleton DessinVide.
 * </p>
 * 
 * @see Dessin
 * @author Aurore Claude/Quentin Gayout
 *
 */
public class DessinVide implements Dessin {

	/**
	 * L'unique instance de DessinVide est son singleton "VIDE"
	 */
	public static final DessinVide VIDE = new DessinVide();

	/**
	 * Son constructeur privé qui ne sert qu'à instancer "VIDE"
	 */
	private DessinVide() {
	}
	/**
	 * La fonction hérité de Dessin qui permet la visite d'un visiteur
	 * @see Dessin#accept(Visiteur)
	 * @param visiteur
	 * @see Visiteur
	 */
	@Override
	public void accept(Visiteur visiteur) {
	}

}