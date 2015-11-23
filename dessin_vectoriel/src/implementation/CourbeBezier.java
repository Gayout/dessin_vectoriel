package implementation;

import java.util.List;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.FabriqueDessin;
import abstraction.Visiteur;
import interpreteur.awt.CourbeBezierAWT;
import interpreteur.awt.PolygoneAWT;
import interpreteur.svg.CourbeBezierSVG;
import interpreteur.svg.PolygoneSVG;
/**
 * <b>CourbeBezier est une classe qui implémente Chemin. Elle étant polygone</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Chemin
 * @see Polygone
 */
public class CourbeBezier extends Polygone {

	/**
	 * Le Constructeur complet de CourbeBezier prend une liste de points de controle, déclare la courbe ouverte ou fermée et remplie ou vide
	 * @param centre
	 * @param rayon
	 * @param isRempli
	 */
	public CourbeBezier(List<Position> sommets, boolean ouvert, boolean rempli) {
		super(sommets, ouvert, rempli);
	}

	/**
	 * Constructeur d'une courbe par défaut ouverte
	 * @param pointControle
	 * @param rempli
	 */
	public CourbeBezier(List<Position> pointControle, boolean rempli) {
		super(pointControle, true, rempli);
	}

	/**
	 * Constructeur vide.
	 */
	public CourbeBezier() {
		super();
	}

	/**
	 * La fabrique d'une courbe de Bezier
	 * @see FabriqueDessin#creerCourbeBezier(List, boolean)
	 * @see CourbeBezier#CourbeBezier(List, boolean)
	 */
	@Override
	public Dessin creerCourbeBezier(List<Position> pointControle, boolean rempli) {
		return new CourbeBezier(pointControle, rempli);
	}

	/**
	 * La fabrique d'un polygone ne doit être faite que dans la classe Polygone.
	 * @see FabriqueDessin#creerPolygone(List, boolean, boolean)
	 * @see Polygone#creerPolygone(List, boolean, boolean)
	 */
	@Override
	public Dessin creerPolygone(List<Position> sommets, boolean ouvert, boolean rempli) {
		return null;
	}

	/**
	 * @return Une courbe interprétée en SVG
	 * @see CourbeBezierSVG
	 */
	public CourbeBezierSVG creerCourbeBezierSVG() {
		return new CourbeBezierSVG(this);
	}

	/**
	 * @return Une courbe interprétée en AWT
	 * @see CourbeBezierSVG
	 */
	public CourbeBezierAWT creerCourbeBezierAWT() {
		return new CourbeBezierAWT(this);
	}

	/**
	 * @return Null. Un polygone ne s'interprête que dans la classe Polygone
	 * @see Polygone#creerPolygoneSVG()
	 */
	@Override
	public PolygoneSVG creerPolygoneSVG() {
		return null;
	}

	/**
	 * @return Null. Un polygone ne s'interprête que dans la classe Polygone
	 * @see Polygone#creerPolygoneAWT()
	 */
	@Override
	public PolygoneAWT creerPolygoneAWT() {
		return null;
	}

	/**
	 * Accepte la visite
	 * @param visiteur
	 * @see Visiteur
	 * @see Visiteur#visit(CourbeBezier)
	 * @see Dessin#accept(Visiteur)
	 */
	@Override
	public void accept(Visiteur visiteur) {
		visiteur.visit(this);
	}


}
