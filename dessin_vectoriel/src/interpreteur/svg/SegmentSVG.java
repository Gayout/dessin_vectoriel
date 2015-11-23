package interpreteur.svg;

import implementation.Position;
import implementation.Segment;
/**
 * <b>SegmentAWT est une classe d'interprétation en SVG. Elle interpréte la classe Segment.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Segment
 *
 */
public class SegmentSVG extends Segment {
	/**
	 * Constructeur Vide
	 */
	public SegmentSVG() {
		super();
	}

	/**
	 * Constructeur par recopie
	 * @param segment
	 * 	segment
	 */
	public SegmentSVG(Segment segment){
		this(segment.getDepart(), segment.getArrivee());
		this.setCrayon(segment.getCrayon());
	}

	/**
	 * Constructeur complet
	 * @param p1
	 * 	depart
	 * @param p2
	 * 	arrivee
	 */
	public SegmentSVG(Position p1, Position p2) {
		super(p1, p2);
	}

	/**
	 * @return Transforme la figure en sa représentation svg.
	 */
	public String generateCode(){

		String code = "<line x1=\"" + this.getDepart().getX()
				+ "\" y1=\"" + this.getDepart().getY()
				+ "\" x2=\""+this.getArrivee().getX()
				+ "\" y2="+"\"" + this.getArrivee().getY() +"\" ";

		code += "style=\"stroke: rgb(" 
				+ this.getCrayon().getCouleur().getRed()
				+ ", " + this.getCrayon().getCouleur().getGreen()
				+ ", " + this.getCrayon().getCouleur().getBlue()+ ")"
				+ "; stroke-width:" + this.getCrayon().getEpaisseur() + ";";
		code+= "\" />";

		return code;
	}

}
