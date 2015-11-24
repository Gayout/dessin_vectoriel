package abstraction;

import java.util.ArrayList;
import java.util.List;
/**
 * <b>DessinComposite est une classe qui fait partie du patron composite, implémente Dessin et qui n'est pas le singleton Vide</b>
 * <p>
 * Un DessinComposite possède une liste de Dessin qui peuvent être Vide ou Composite.
 * </p>
 * @see DessinVide
 * @see Dessin
 * @author Aurore Claude/Quentin Gayout
 *
 */
public class DessinComposite implements Dessin {

	/**
	 * La liste des Dessins qui compose le dessin composite
	 * @see Dessin
	 * @see DessinComposite#DessinComposite(List)
	 * @see DessinComposite#creerDessinComposite(List)
	 * @see DessinComposite#getDessins()
	 * @see DessinComposite#setDessins(List)
	 */
	private List<Dessin> dessins;

	/**
	 * Le constructeur qui prend en paramètre une liste de dessin
	 * @param dessins
	 * 	dessins
	 * @see Dessin
	 * @see DessinComposite#dessins
	 */
	public DessinComposite(List<Dessin> dessins) {
		super();
		this.dessins = dessins;
	}

	/**
	 * Le constructeur vide
	 */
	public DessinComposite() {
		super();
		this.dessins = new ArrayList<Dessin>();
	}

	/**
	 * @see DessinComposite#dessins
	 * @see Dessin
	 * @return La liste de Dessin qui compose le dessin composite
	 */
	public List<Dessin> getDessins() {
		return dessins;
	}

	/**
	 * Change la liste de Dessin qui compose le dessin composite
	 * @see DessinComposite#dessins
	 * @see Dessin
	 * @param dessins
	 * 	dessins
	 */
	public void setDessins(List<Dessin> dessins) {
		this.dessins = dessins;
	}

	/**
	 * Ajoute un Dessin à la liste de Dessin qui compose le dessin composite
	 * @see Dessin
	 * @param dessin
	 * 	dessin
	 */
	public void addDessin(Dessin dessin){
		this.getDessins().add(dessin);
	}

	/**
	 * Accepte le visiteur pour qu'il effectue son service au sein du dessin composite
	 * @see Visiteur
	 * @param visiteur
	 * 	visiteur
	 * @see Dessin#accept(Visiteur)
	 */
	@Override
	public void accept(Visiteur visiteur) {
		for (Dessin d : dessins)
			d.accept(visiteur);
	}

	/**
	 * La fabrique pour créer un Dessin Composite
	 * @see FabriqueDessin#creerDessinComposite(List)
	 * @see Dessin
	 * @see DessinComposite#dessins
	 * @see DessinComposite#DessinComposite(List)
	 */
	@Override
	public Dessin creerDessinComposite(List<Dessin> dessins) {
		return new DessinComposite(dessins);
	}

}
