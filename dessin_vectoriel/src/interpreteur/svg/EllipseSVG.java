package interpreteur.svg;

import implementation.Ellipse;
import implementation.Position;
/**
 * <b>EllipseAWT est une classe d'interprétation en SVG. Elle interpréte la classe Ellipse.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Ellipse
 *
 */
public class EllipseSVG extends Ellipse {
	/**
	 * Constructeur Vide
	 */
	public EllipseSVG() {
		super();
	}
	/**
	 * Constructeur par recopie
	 * @param ellipse
	 * 	ellipse
	 */
	public EllipseSVG(Ellipse ellipse){
		this(ellipse.getCentre(), ellipse.getGdAxe(), ellipse.getPetitAxe(), ellipse.getAngleAbsGdAxe(), ellipse.isRempli());
		this.setCrayon(ellipse.getCrayon());
	}
	
	/**
	 * Constructeur complet
	 * @param centre
	 * 	Position
	 * @param gdAxe
	 * 	grand axe
	 * @param petitAxe
	 * 	petit axe
	 * @param angleAbsGdAxe
	 * 	angle
	 * @param isRempli
	 * 	remplissage
	 */
	public EllipseSVG(Position centre, int gdAxe, int petitAxe, long angleAbsGdAxe, boolean isRempli) {
		super(centre, gdAxe, petitAxe, angleAbsGdAxe, isRempli);
	}
	
	/**
	 * @return Transforme la figure en sa représentation svg.
	 */
	public String generateCode(){
		
		int cx = this.getCentre().getX();
		int cy = this.getCentre().getY();
		int rx = this.getGdAxe();
		int ry = this.getPetitAxe();
		
		int red = this.getCrayon().getCouleur().getRed();
		int green = this.getCrayon().getCouleur().getGreen();
		int blue = this.getCrayon().getCouleur().getBlue();

		
		String code = "<ellipse cx=\"" + cx
				+ "\" cy=\"" + cy
				+ "\" rx=\""+ rx
				+ "\" ry="+"\"" + ry +"\" ";
		
		code += "style=\"stroke: rgb(" 
				+ red
				+ ", " + green
				+ ", " + blue + ")"
				+ "; stroke-width:" + this.getCrayon().getEpaisseur() + ";";
		if(!this.isRempli())
			code += "fill: none;\"";
		else
			code += "fill : rgb(" 
				+ red
				+ ", " + green
				+ ", " + blue + ");\"";

		code+= " transform=\"rotate("+this.getAngleAbsGdAxe()+", " + cx + ", " + cy + ")\" ";
		
		code+= " />";
		
		return code;
	}
}
