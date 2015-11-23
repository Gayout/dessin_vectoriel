package implementation;

import java.awt.Font;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.Visiteur;
/**
 * <b>Texte est une classe qui implémente Chemin.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Chemin
 */
public class Texte implements Dessin {
	
	/**
	 * Un Texte est défini par la taille de sa Police
	 * @see Texte#getTaillePolice()
	 * @see Texte#setTaillePolice(int)
	 * @see Texte#Texte(int, String, Font, Position)
	 */
	private int taillePolice;
	
	/**
	 * Un Texte est défini par son texte
	 * @see Texte#getTexte()
	 * @see Texte#setTexte(String)
	 * @see Texte#Texte(int, String, Font, Position)
	 */
	private String texte;
	
	/**
	 * Un Texte est défini par sa Police
	 * @see Texte#getPolice()
	 * @see Texte#setPolice(Font)
	 * @see Texte#Texte(int, String, Font, Position)
	 */
	private Font police;
	
	/**
	 * Un Texte est défini par son coin haut-gauche
	 * @see Position
	 * @see Texte#getHtGauche()
	 * @see Texte#setHtGauche(Position)
	 * @see Texte#Texte(int, String, Font, Position)
	 */
	private Position htGauche;

	/**
	 * Constructeur vide
	 */
	public Texte() {
		super();
	}

	/**
	 * Constructeur complet
	 * @param taillePolice
	 * @param texte
	 * @param police
	 * @param htGauche
	 */
	public Texte(int taillePolice, String texte, Font police, Position htGauche) {
		super();
		this.taillePolice = taillePolice;
		this.police = police;
		this.texte = texte;
		this.htGauche = htGauche;
	}

	/**
	 * @see Texte#taillePolice
	 * @return La taille de police
	 */
	public int getTaillePolice() {
		return taillePolice;
	}

	/**
	 * Change la taille de police
	 * @see Texte#taillePolice
	 * @param taillePolice
	 */
	public void setTaillePolice(int taillePolice) {
		this.taillePolice = taillePolice;
	}
	/**
	 * @see Texte#police
	 * @return La police
	 */
	public Font getPolice() {
		return police;
	}

	/**
	 * Change la police
	 * @see Texte#police
	 * @param police
	 */
	public void setPolice(Font police) {
		this.police = police;
	}

	/**
	 * @see Texte#texte
	 * @return La valeur du texte
	 */
	public String getTexte() {
		return texte;
	}

	/**
	 * Change la valeur du texte
	 * @see Texte#texte
	 * @param texte
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}

	/**
	 * @see Position
	 * @see Texte#htGauche
	 * @return Le coin haut-gauche du texte
	 */
	public Position getHtGauche() {
		return htGauche;
	}

	/**
	 * Change le coin haut-gauche du texte
	 * @see Position
	 * @see Texte#htGauche
	 * @param htGauche
	 */
	public void setHtGauche(Position htGauche) {
		this.htGauche = htGauche;
	}

	/**
	 * Accepte la visite
	 * @param visiteur
	 * @see Visiteur
	 * @see Visiteur#visit(Texte)
	 * @see Dessin#accept(Visiteur)
	 */
	@Override
	public void accept(Visiteur visiteur) {
		visiteur.visit(this);
	}
}
