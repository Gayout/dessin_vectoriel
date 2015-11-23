package implementation;

import abstraction.Chemin;
import abstraction.Dessin;
import abstraction.FabriqueDessin;
import abstraction.Visiteur;
import interpreteur.awt.SegmentAWT;
import interpreteur.svg.SegmentSVG;
/**
 * <b>Segment est une classe qui implémente Chemin.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Chemin
 */
public class Segment extends Chemin{
	
	/**
	 * Un Segment est défini par son départ
	 * @see Position
	 * @see Segment#getDepart()
	 * @see Segment#setDepart(Position)
	 * @see Segment#Segment(Position, Position)
	 * @see Segment#creerSegment(Position, Position)
	 */
	private Position depart;
	
	/**
	 * Un Segment est défini par son arrivée
	 * @see Position
	 * @see Segment#getArrivee()
	 * @see Segment#setArrivee(Position)
	 * @see Segment#Segment(Position, Position)
	 * @see Segment#creerSegment(Position, Position)
	 */
	private Position arrivee;
	
	/**
	 * Constructeur complet
	 * @param p1
	 * @param p2
	 */
	public Segment(Position p1, Position p2){
		this.depart=p1;
		this.arrivee=p2;
	}
	
	/**
	 * Constructeur vide
	 */
	public Segment(){
		super();
	}
	
	/**
	 * @see Position
	 * @see Segment#depart
	 * @return Le depart du segment
	 */
	public Position getDepart() {
		return depart;
	}
	
	/**
	 * @see Position
	 * Change le départ du segment
	 * @see Segment#depart
	 * @param depart
	 */
	public void setDepart(Position depart) {
		this.depart = depart;
	}

	/**
	 * @see Position
	 * Change l'arrivee du segment
	 * @see Segment#arrivee
	 * @param arrivee
	 */
	public void setArrivee(Position arrivee) {
		this.arrivee = arrivee;
	}

	/**
	 * @see Position
	 * @see Segment#arrivee
	 * @return L'arrivee du segment
	 */
	public Position getArrivee() {
		return arrivee;
	}
	
	/**
	 * @return False. Un segment n'est jamais rempli
	 */
	@Override
	public boolean isRempli() {
		return false;
	}

	/**
	 * Ne fait rien, Un segment n'est pas rempli
	 * @param b
	 */
	@Override
	public void setRempli(boolean b) {
	}
	
	/**
	 * La fabrique d'un segment
	 * @see FabriqueDessin#creerSegment(Position, Position)
	 * @see Segment#Segment(Position, Position)
	 */
	@Override
	public Dessin creerSegment(Position p1, Position p2) {
		return new Segment(p1, p2);
	}
	
	/**
	 * @return Un segment interprété en SVG
	 * @see SegmentSVG
	 */
	public SegmentSVG creerSegmentSVG(){
		return new SegmentSVG(this);
	}
	
	/**
	 * @return Un segment interprété en AWT
	 * @see SegmentAWT
	 */
	public SegmentAWT creerSegmentAWT() {
		return new SegmentAWT(this);
	}

	/**
	 * Accepte la visite
	 * @param visiteur
	 * @see Visiteur
	 * @see Visiteur#visit(Segment)
	 * @see Dessin#accept(Visiteur)
	 */
	@Override
	public void accept(Visiteur visiteur) {
		visiteur.visit(this);
	}
}
