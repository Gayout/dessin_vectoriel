package implementation;

import java.awt.Font;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.Visiteur;
import interpreteur.awt.TexteAWT;
import interpreteur.svg.TexteSVG;
/**
 * <b>Texte est une classe qui implémente Chemin.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Chemin
 */
public class Texte extends Chemin {
	
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
	 * @see Texte#setPolice(String)
	 * @see Texte#Texte(int, String, Font, Position)
	 */
	private String police;
	
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
	 * 		taille de police
	 * @param texte
	 * 		valeur du texte
	 * @param police
	 * 		police
	 * @param htGauche
	 * 		position du texte
	 */
	public Texte(int taillePolice, String texte, String police, Position htGauche) {
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
	 * 		taille de police
	 */
	public void setTaillePolice(int taillePolice) {
		this.taillePolice = taillePolice;
	}
	/**
	 * @see Texte#police
	 * @return La police
	 */
	public String getPolice() {
		return police;
	}

	/**
	 * Change la police
	 * @see Texte#police
	 * @param police
	 * 		Police
	 */
	public void setPolice(String police) {
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
	 * 		valeur du texte
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
	 * 		position du texte
	 */
	public void setHtGauche(Position htGauche) {
		this.htGauche = htGauche;
	}

	/**
	 * Accepte la visite
	 * @param visiteur
	 * 		visiteur
	 * @see Visiteur
	 * @see Visiteur#visit(Texte)
	 * @see Dessin#accept(Visiteur)
	 */
	@Override
	public void accept(Visiteur visiteur) {
		visiteur.visit(this);
	}

	/**
	 * @return False. Un texte n'est jamais rempli
	 */
	@Override
	public boolean isRempli() {
		return false;
	}

	/**
	 * Ne fait rien, Un texte n'est pas rempli
	 * @param b
	 * 	remplissage
	 */
	@Override
	public void setRempli(boolean b) {
	}

	/**
	 * @return Un texte interprété en SVG
	 * @see TexteSVG
	 */
	public TexteSVG creerTexteSVG(){
		return new TexteSVG(this);
	}

	/**
	 * @return Un texte interprété en SVG
	 * @see TexteSVG
	 */
	public TexteAWT creerTexteAWT() {
		return new TexteAWT(this);
	}
}
