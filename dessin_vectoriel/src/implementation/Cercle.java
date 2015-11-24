package implementation;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.FabriqueDessin;
import abstraction.Visiteur;
import interpreteur.awt.CercleAWT;
import interpreteur.svg.CercleSVG;
/**
 * <b>Cercle est une classe qui implémente Chemin.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Chemin
 */
public class Cercle extends Chemin{

	/**
	 * Un Cercle est défini autour de son centre
	 * @see Position
	 * @see Cercle#getCentre()
	 * @see Cercle#setCentre(Position)
	 * @see Cercle#Cercle(Position, int, boolean)
	 * @see Cercle#creerCercle(Position, int, boolean)
	 */
	private Position centre;
	
	/**
	 * Un cercle est défini par un rayon 
	 * @see Cercle#getRayon()
	 * @see Cercle#setRayon(int)
	 * @see Cercle#Cercle(Position, int, boolean)
	 * @see Cercle#creerCercle(Position, int, boolean)
	 */
	private int gdAxe;
	
	/**
	 * Un cercle est rempli ou non 
	 * @see Cercle#isRempli()
	 * @see Cercle#setRempli(boolean)
	 * @see Cercle#Cercle(Position, int, boolean)
	 * @see Cercle#creerCercle(Position, int, boolean)
	 */
	private boolean rempli;

	/**
	 * Le Constructeur complet de Cercle prend une position (centre), un rayon et déclare le cercle rempli ou vide
	 * @param centre
	 * 	position
	 * @param rayon
	 * 	rayon
	 * @param isRempli
	 * 	remplissage
	 */
	public Cercle(Position centre, int rayon, boolean isRempli) {
		this.centre = centre;
		this.gdAxe = rayon;
		this.rempli = isRempli;
	

	}

	/**
	 * Le constructeur vide.
	 */
	public Cercle() {
		super();
	}

	/**
	 * @see Position
	 * @see Cercle#centre
	 * @return Le centre du cercle
	 */
	public Position getCentre() {
		return centre;
	}

	/**
	 * @see Position
	 * Change le centre du Cercle
	 * @see Cercle#centre
	 * @param centre
	 * 	position
	 */
	public void setCentre(Position centre) {
		this.centre = centre;
	}
	
	/**
	 * @see Cercle#gdAxe
	 * @return Le rayon du cercle
	 */
	public int getRayon() {
		return this.gdAxe;
	}

	/**
	 * Change le rayon du Cercle
	 * @see Cercle#gdAxe
	 * @param  rayon
	 * 	rayon
	 */
	public void setRayon(int rayon) {
		this.gdAxe= rayon;
	}

	/**
	 * @see Cercle#rempli
	 * @return L'état du cercle vis à vis du remplissage
	 */
	public boolean isRempli() {
		return rempli;
	}
	
	/**
	 * Change le remplissage du Cercle
	 * @see Cercle#rempli
	 * @param isRempli
	 * 	remplissage
	 */
	public void setRempli(boolean isRempli) {
		this.rempli = isRempli;
	}
	
	/**
	 * La fabrique d'un cercle
	 * @see FabriqueDessin#creerCercle(Position, int, boolean)
	 * @see Cercle#Cercle(Position, int, boolean)
	 */
	@Override
	public Dessin creerCercle(Position centre, int rayon, boolean rempli) {
		return new Cercle(centre, rayon, rempli);
	}
	
	/**
	 * @return Un cercle interprété en SVG
	 * @see CercleSVG
	 */
	public CercleSVG creerCercleSVG() {
		return new CercleSVG(this);
	}
	
	/**
	 * @return Un cercle interprété en AWT
	 * @see CercleAWT
	 */
	public CercleAWT creerCercleAWT(){
		return new CercleAWT(this);
	}
	
	/**
	 * Accepte la visite
	 * @param visiteur
	 * 	visiteur
	 * @see Visiteur
	 * @see Visiteur#visit(Cercle)
	 * @see Dessin#accept(Visiteur)
	 */
	public void accept(Visiteur visiteur){
		visiteur.visit(this);
	}
	
}
