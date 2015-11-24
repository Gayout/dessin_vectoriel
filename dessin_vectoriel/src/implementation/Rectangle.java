package implementation;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.FabriqueDessin;
import abstraction.Visiteur;
import interpreteur.awt.RectangleAWT;
import interpreteur.svg.RectangleSVG;
/**
 * <b>Rectangle est une classe qui implémente Chemin.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Chemin
 */
public class Rectangle extends Chemin{

	/**
	 * Un Rectangle est défini par son coin haut-gauche
	 * @see Position
	 * @see Rectangle#getHautGauche()
	 * @see Rectangle#setHautGauche(Position)
	 * @see Rectangle#Rectangle(Position, int, int, boolean)
	 * @see Rectangle#creerRectangle(Position, int, int, boolean)
	 */
	private Position hautGauche;
	
	/**
	 * Un Rectangle est défini par sa largeur
	 * @see Rectangle#getWidth()
	 * @see Rectangle#setWidth(int)
	 * @see Rectangle#Rectangle(Position, int, int, boolean)
	 * @see Rectangle#creerRectangle(Position, int, int, boolean)
	 */
	private int width;
	
	/**
	 * Un Rectangle est défini par sa hauteur
	 * @see Rectangle#getHeight()
	 * @see Rectangle#setHeight(int)
	 * @see Rectangle#Rectangle(Position, int, int, boolean)
	 * @see Rectangle#creerRectangle(Position, int, int, boolean)
	 */
	private int height;
	
	/**
	 * Un Rectangle est défini rempli ou non
	 * @see Rectangle#isRempli()
	 * @see Rectangle#setRempli(boolean)
	 * @see Rectangle#Rectangle(Position, int, int, boolean)
	 * @see Rectangle#creerRectangle(Position, int, int, boolean)
	 */
	private boolean rempli;
	
	/**
	 * Constructeur complet d'un rectangle
	 * @param hautGauche
	 * 	position
	 * @param width
	 * 	largeur
	 * @param height
	 * 	hauteur
	 * @param isRempli
	 * 	remplissage
	 */
	public Rectangle(Position hautGauche, int width, int height, boolean isRempli) {
		this.hautGauche = hautGauche;
		this.width = width;
		this.height = height;
		this.rempli = isRempli;
	}

	/**
	 * Constructeur vide
	 */
	public Rectangle() {
		super();
	}

	/**
	 * @see Rectangle#rempli
	 * @return L'état du rectangle vis à vis du remplissage
	 */
	public boolean isRempli() {
		return rempli;
	}

	/**
	 * Change le remplissage du rectangle
	 * @see Rectangle#rempli
	 * @param isRempli
	 * 	remplissage
	 */
	public void setRempli(boolean isRempli) {
		this.rempli = isRempli;
	}
	
	/**
	 * @see Position
	 * @see Rectangle#hautGauche
	 * @return le coin haut-gauche du rectangle
	 */
	public Position getHautGauche() {
		return hautGauche;
	}
	
	/**
	 * Change le coin du rectangle
	 * @see Position
	 * @see Rectangle#hautGauche
	 * @param hautGauche
	 * 	position
	 */
	public void setHautGauche(Position hautGauche) {
		this.hautGauche = hautGauche;
	}

	/**
	 * @see Rectangle#width
	 * @return La largeur du rectangle
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Change la largeur
	 * @see Rectangle#width
	 * @param width
	 * 	largeur
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @see Rectangle#height
	 * @return La hauteur du rectangle
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Change la hauteur
	 * @see Rectangle#height
	 * @param height
	 * 	hauteur
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * La fabrique d'un rectangle
	 * @see FabriqueDessin#creerRectangle(Position, int, int, boolean)
	 * @see Rectangle#Rectangle(Position, int, int, boolean)
	 */
	@Override
	public Dessin creerRectangle(Position hautGauche, int width, int height, boolean isRempli) {
		return new Rectangle(hautGauche, width, height, isRempli);
	}

	/**
	 * @return Un rectangle interprété en SVG
	 * @see RectangleSVG
	 */
	public RectangleSVG creerRectangleSVG(){
		return new RectangleSVG(this);
	}
	
	/**
	 * @return Un rectangle interprété en AWT
	 * @see RectangleAWT
	 */
	public RectangleAWT creerRectangleAWT() {
		return new RectangleAWT(this);
	}


	/**
	 * Accepte la visite
	 * @param visiteur
	 * 	visiteur
	 * @see Visiteur
	 * @see Visiteur#visit(Rectangle)
	 * @see Dessin#accept(Visiteur)
	 */
	@Override
	public void accept(Visiteur visiteur) {
		visiteur.visit(this);
	}
	
}
