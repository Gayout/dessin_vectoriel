package interpreteur.svg;

import java.util.List;

import implementation.Polygone;
import implementation.Position;
/**
 * <b>PolugoneAWT est une classe d'interprétation en SVG. Elle interpréte la classe Polygone.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Polygone
 *
 */
public class PolygoneSVG extends Polygone {
	/**
	 * Constructeur Vide
	 */
	public PolygoneSVG() {
		super();
	}
	/**
	 * Constructeur par recopie
	 * @param polygone
	 * 	polygone
	 */
	public PolygoneSVG(Polygone polygone){
		this(polygone.getSommets(), polygone.isOuvert(), polygone.isRempli());
		this.setCrayon(polygone.getCrayon());
	}
	
	/**
	 * Constructeur complet
	 * @param sommets
	 * 	somments
	 * @param ouvert
	 * 	ouverture
	 * @param rempli
	 * 	remplissage
	 */
	public PolygoneSVG( List<Position> sommets, boolean ouvert, boolean rempli) {
		super(sommets, ouvert, rempli);
	}

	/**
	 * @return Transforme la figure en sa représentation svg.
	 */
	public String generateCode(){
		
		List<Position> sommets = this.getSommets();
		
		int red = this.getCrayon().getCouleur().getRed();
		int green = this.getCrayon().getCouleur().getGreen();
		int blue = this.getCrayon().getCouleur().getBlue();

		
		String code = "<"+ (this.isOuvert() ? "polyline" : "polygon") +" points=\" ";
		
		for(Position p : sommets){
			code += p.getX()+","+p.getY()+" ";
		}
		
		code += "\" style=\"stroke: rgb(" 
				+ red
				+ ", " + green
				+ ", " + blue + ")"
				+ "; stroke-width:" + this.getCrayon().getEpaisseur() + "; ";
		if(!this.isRempli())
			code += "fill: none;\"";
		else
			code += "fill : rgb(" 
				+ red
				+ ", " + green
				+ ", " + blue + ");\"";

		code+= " />";
		
		return code;
	}

}
