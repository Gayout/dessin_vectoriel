package implementation;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.FabriqueDessin;
import abstraction.Visiteur;
import interpreteur.awt.CercleAWT;
import interpreteur.awt.EllipseAWT;
import interpreteur.svg.CercleSVG;
import interpreteur.svg.EllipseSVG;
/**
 * <b>Ellipse est une classe qui implémente Chemin. Elle étant cercle</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Chemin
 * @see Cercle
 */
public class Ellipse extends Cercle {
	
	/**
	 * Elle possède en plus des attribut d'un cercle un petitAxe
	 * @see Ellipse#getPetitAxe()
	 * @see Ellipse#setPetitAxe(int)
	 */
	private int petitAxe;
	
	/**
	 * Elle possède en plus des attribut d'un cercle un angle
	 * @see Ellipse#getAngleAbsGdAxe()
	 * @see Ellipse#setAngleAbsGdAxe(long)
	 */
	private long angleAbsGdAxe;
	
	/**
	 * Constructeur vide
	 */
	public Ellipse() {
		super();
	}
	
	/**
	 * Le constructeur complet de l'Ellipse
	 * @param centre
	 * @param gdAxe
	 * @param petitAxe
	 * @param angleAbsGdAxe
	 * @param isRempli
	 */
	public Ellipse(Position centre, int gdAxe, int petitAxe, long angleAbsGdAxe, boolean isRempli) {
		super(centre, gdAxe, isRempli);
		this.petitAxe = petitAxe;
		this.angleAbsGdAxe = angleAbsGdAxe;
	}

	/**
	 * @return Le grand Axe de l'Ellipse qui correspond au rayon du cercle
	 */
	public int getGdAxe() {
		return super.getRayon();
	}

	/**
	 * Change le grandAxe de l'Ellipse
	 * @param gdAxe
	 */
	public void setGdAxe(int gdAxe) {
		super.setRayon(gdAxe);
	}

	/**
	 * @see Ellipse#petitAxe
	 * @return Le petit Axe de l'Ellipse
	 */
	public int getPetitAxe() {
		return petitAxe;
	}

	/**
	 * Change le petit Axe de l'Ellipse
	 * @see Ellipse#petitAxe
	 * @param petitAxe
	 */
	public void setPetitAxe(int petitAxe) {
		this.petitAxe = petitAxe;
	}

	/**
	 * @see Ellipse#angleAbsGdAxe
	 * @return L'angle de l'Ellipse
	 */
	public long getAngleAbsGdAxe() {
		return angleAbsGdAxe;
	}

	/**
	 * Change l'angle de l'Ellipse
	 * @see Ellipse#angleAbsGdAxe
	 * @param angleAbsGdAxe
	 */
	public void setAngleAbsGdAxe(long angleAbsGdAxe) {
		this.angleAbsGdAxe = angleAbsGdAxe;
	}
	
	/**
	 * La fabrique d'une ellipse
	 * @see FabriqueDessin#creerEllipse(Position, int, int, long, boolean)
	 * @see Ellipse#Ellipse(Position, int, int, long, boolean)
	 */
	@Override
	public Ellipse creerEllipse(Position centre, int gdAxe, int petitAxe, long angleAbsGdAxe, boolean rempli){
		return new Ellipse(centre, gdAxe, petitAxe, angleAbsGdAxe,rempli);
	}
	
	/**
	 * La fabrique d'un cercle ne doit être faite que dans la classe Cercle.
	 * @see FabriqueDessin#creerCercle(Position, int, boolean)
	 * @see Cercle#creerCercle(Position, int, boolean)
	 */
	@Override
	public Cercle creerCercle(Position centre, int rayon, boolean rempli){
		return null;
	}
	
	/**
	 * @return Null. Un cercle ne s'interprête que dans la classe Cercle.
	 * @see Cercle#creerCercleSVG()
	 */
	@Override
	public CercleSVG creerCercleSVG() {
		return null;
	}

	/**
	 * @return Null. Un cercle ne s'interprête que dans la classe Cercle.
	 * @see Cercle#creerCercleAWT()
	 */
	@Override
	public CercleAWT creerCercleAWT() {
		return null;
	}
	
	/**
	 * @return Une ellipse interprétée en SVG
	 * @see EllipseSVG
	 */
	public EllipseSVG creerEllipseSVG() {
		return new EllipseSVG(this);
	}

	/**
	 * @return Une ellipse interprétée en AWT
	 * @see EllipseAWT
	 */
	public EllipseAWT creerEllipseAWT() {
		return new EllipseAWT(this);
	}

	/**
	 * Accepte la visite
	 * @param visiteur
	 * @see Visiteur
	 * @see Visiteur#visit(Ellipse)
	 * @see Dessin#accept(Visiteur)
	 */
	@Override
	public void accept(Visiteur visiteur) {
		visiteur.visit(this);
	}
}
