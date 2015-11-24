package implementation;

import java.util.List;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.FabriqueDessin;
import abstraction.Visiteur;
import exception.PolygoneVideException;
import interpreteur.awt.PolygoneAWT;
import interpreteur.svg.PolygoneSVG;
/**
 * <b>Polygone est une classe qui implémente Chemin.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Chemin
 */
public class Polygone extends Chemin {

	/**
	 * Un Polygone est défini rempli ou non
	 * @see Polygone#isRempli()
	 * @see Polygone#setRempli(boolean)
	 * @see Polygone#Polygone(List, boolean, boolean)
	 * @see Polygone#creerPolygone(List, boolean, boolean)
	 */
	private boolean rempli;
	
	/**
	 * Un Polygone est défini ouvert ou non
	 * @see Polygone#isOuvert()
	 * @see Polygone#setOuvert(boolean)
	 * @see Polygone#Polygone(List, boolean, boolean)
	 * @see Polygone#creerPolygone(List, boolean, boolean)
	 */
	private boolean ouvert;
	
	/**
	 * Un Cercle est défini par ses sommets
	 * @see Position
	 * @see Polygone#getSommets()
	 * @see Polygone#setSommets(List)
	 * @see Polygone#Polygone(List, boolean, boolean)
	 * @see Polygone#creerPolygone(List, boolean, boolean)
	 */
	private List<Position> sommets;
	
	/** un polygone est défini par ses cotes, mais on le construit en lui donnant tous ses sommets
	 * @param sommets
	 * 	sommets
	 * @param ouvert
	 * 	ouverture
	 * @param rempli
	 * 	remplissage
	 */
	public Polygone(List<Position> sommets, boolean ouvert, boolean rempli) {
		super();
		this.rempli = rempli;
		this.sommets = sommets;
		this.ouvert = ouvert;

		//on regarde si la liste de points a moins de 2 points, si elle en a moins on envoie une erreur
		try{
			if(sommets.size()<2){
				throw new PolygoneVideException();
			}
		}
		catch(PolygoneVideException e){
			e.printStackTrace();
		}
	}

	/**
	 * Constructeur vide
	 */
	public Polygone() {
		super();
	}

	/**
	 * @see Polygone
	 * @see Polygone#sommets
	 * @return Les sommets du polygone
	 */
	public List<Position> getSommets() {
		return sommets;
	}

	/**
	 * @see Polygone
	 * Change les sommets du polygone
	 * @param sommets
	 * 	sommets
	 * @see Polygone#sommets
	 */
	public void setSommets(List<Position> sommets) {
		this.sommets = sommets;
	}

	/**
	 * @see Polygone#ouvert
	 * @return Le fait qu'un Polygone soit ouvert ou non
	 */
	public boolean isOuvert() {
		return ouvert;
	}

	/**
	 * Change l'ouverture d'un polygone
	 * @see Polygone#ouvert
	 * @param ouvert
	 * 	ouverture
	 */
	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
	}

	/**
	 * @see Polygone#rempli
	 * @return Le fait qu'un Polygone soit rempli ou non
	 */
	@Override
	public boolean isRempli() {
		return rempli;
	}

	/**
	 * Change le remplissage d'un polygone
	 * @see Polygone#rempli
	 * @param b
	 * 	remplissage
	 */
	@Override
	public void setRempli(boolean b) {
		rempli = b;
	}
	
	/**
	 * La fabrique d'un polygone
	 * @see FabriqueDessin#creerPolygone(List, boolean, boolean)
	 * @see Polygone#Polygone()
	 */
	@Override
	public Dessin creerPolygone(List<Position> sommets, boolean ouvert, boolean rempli) {
		return new Polygone(sommets, ouvert, rempli);
	}

	/**
	 * @return Un Polygone interprété en SVG
	 * @see PolygoneSVG
	 */
	public PolygoneSVG creerPolygoneSVG() {
		return new PolygoneSVG(this);
	}

	/**
	 * @return Un Polygone interprété en AWT
	 * @see PolygoneAWT
	 */
	public PolygoneAWT creerPolygoneAWT() {
		return new PolygoneAWT(this);
	}

	/**
	 * Accepte la visite
	 * @param visiteur
	 * 	visiteur
	 * @see Visiteur
	 * @see Visiteur#visit(Polygone)
	 * @see Dessin#accept(Visiteur)
	 */
	@Override
	public void accept(Visiteur visiteur) {
		visiteur.visit(this);
	}

}
