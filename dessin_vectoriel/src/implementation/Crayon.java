package implementation;

import java.awt.Color;
import abstraction.Chemin;
/**
 * <b>Un Crayon d�fini la couleur et l'�paisseur d'une figure</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Chemin#getCrayon()
 */
public class Crayon {
	/**
	 * L'�paisseur est repr�sent� par un entier
	 * @see Crayon#getEpaisseur()
	 * @see Crayon#setEpaisseur(int)
	 */
	private int epaisseur;
	
	/**
	 * La couleur est repr�sent�e par une Color
	 * @see Color
	 * @see Crayon#getCouleur()
	 * @see Crayon#setCouleur(Color)
	 */
	private Color couleur;
	
	/**
	 * Par d�faut le crayon a une �paisseur de 2 et est noir
	 */
	public static Crayon CRAYON_DEFAUT = new Crayon(2, Color.BLACK);
	
	/**
	 * Le constructeur du Crayon prend en param�tre une �paisseur et une couleur
	 * @param epaisseur
	 * 	epaisseur
	 * @param couleur
	 * 	couleur
	 */
	public Crayon(int epaisseur, Color couleur) {
		super();
		this.epaisseur = epaisseur;
		this.couleur = couleur;
	}

	/**
	 * @return L'�paisseur du Crayon
	 * @see Crayon#epaisseur
	 */
	public int getEpaisseur() {
		return epaisseur;
	}

	/**
	 * Change l'�paisseur du Crayon
	 * @param epaisseur
	 * 	epaisseur
	 * @see Crayon#epaisseur
	 */
	public void setEpaisseur(int epaisseur) {
		this.epaisseur = epaisseur;
	}

	/**
	 * @return La couleur du Crayon
	 * @see Crayon#couleur
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * Change la couleur du Crayon
	 * @param couleur
	 * 	couleur
	 * @see Crayon#couleur
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
}