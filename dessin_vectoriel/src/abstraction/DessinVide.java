package abstraction;
/**
 * <b>DessinVide est une classe qui fait partie du patron composite, impl�mente Dessin et qui est le singleton Vide</b>
 * <p>
 * Un DessinVide ne poss�de aucun instance de Dessin. Son constructeur est priv� et il poss�de une variable static qui correspond au singleton DessinVide.
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
	 * Son constructeur priv� qui ne sert qu'� instancer "VIDE"
	 */
	private DessinVide() {
	}
	/**
	 * La fonction h�rit� de Dessin qui permet la visite d'un visiteur
	 * @see Dessin#accept(Visiteur)
	 * @param visiteur
	 * @see Visiteur
	 */
	@Override
	public void accept(Visiteur visiteur) {
	}

}