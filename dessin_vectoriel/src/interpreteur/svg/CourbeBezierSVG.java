package interpreteur.svg;

import java.util.ArrayList;

import java.util.List;

import implementation.CourbeBezier;
import implementation.Position;

/**
 * <b>CourbeBezierSVG est une classe d'interprétation en SVG. Elle interpréte la classe CourbeBezier.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see CourbeBezier
 *
 */
public class CourbeBezierSVG extends CourbeBezier {
	/**
	 * Constructeur Vide
	 */
	public CourbeBezierSVG() {
		super();
	}
	/**
	 * Constructeur par recopie
	 * @param courbeBezier
	 * 	courbeBezier
	 */
	public CourbeBezierSVG(CourbeBezier courbeBezier){
		this(courbeBezier.getSommets(), courbeBezier.isOuvert(), courbeBezier.isRempli());
		this.setCrayon(courbeBezier.getCrayon());
	}
	/**
	 * Constructeur complet
	 * @param sommets
	 * 	points de controle
	 * @param ouvert
	 * 	ouverture
	 * @param rempli
	 * 	remplissage
	 */
	public CourbeBezierSVG( List<Position> sommets, boolean ouvert, boolean rempli) {
		super(sommets, ouvert, rempli);
	}

	/**
	 * @return Transforme la figure en sa représentation svg.
	 */
	public String generateCode(){
		
		List<Position> sommets = this.getSommets();
		/* On créé une copie car on aura besoin par la suite de supprimer une élément des sommets mais qu'on ne veut pas affecter la variable d'instance de la courbe de Bezier*/
		List<Position> copy = new ArrayList<Position>();
		
		for(Position p : sommets){
			copy.add(p);
		}
		
		int red = this.getCrayon().getCouleur().getRed();
		int green = this.getCrayon().getCouleur().getGreen();
		int blue = this.getCrayon().getCouleur().getBlue();

		
		String code = "<path d = \"M "+ copy.get(0).getX() + " " + copy.get(0).getY()+" ";
		
		code += ((copy.size() < 3) ? "L" : ((copy.size() == 3)? "Q": "C") )+ " ";
		
		copy.remove(0);
		
		for(Position p : copy){
			code += p.getX()+" "+p.getY()+" ";
		}
		
		code += (this.isOuvert()) ? "" : "z";
		
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
