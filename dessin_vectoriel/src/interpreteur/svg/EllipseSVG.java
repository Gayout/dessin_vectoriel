package interpreteur.svg;

import java.awt.Color;

import implementation.Crayon;
import implementation.Ellipse;
import implementation.Position;

public class EllipseSVG extends Ellipse {

	public EllipseSVG() {
		super();
	}

	public EllipseSVG(Position centre, int gdAxe, int petitAxe, long angleAbsGdAxe, boolean isRempli) {
		super(centre, gdAxe, petitAxe, angleAbsGdAxe, isRempli);
		
		this.setCrayon(new Crayon(2, Color.yellow));
	}

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
