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
		
		int rx = ((this.getAngleAbsGdAxe()%180) < 45) ? this.getGdAxe() : this.getPetitAxe(); 
		int ry = ((this.getAngleAbsGdAxe()%180) >= 45) ? this.getGdAxe() : this.getPetitAxe();
		
		String code = "<ellipse cx=\"" + this.getCentre().getX()
				+ "\" cy=\"" + this.getCentre().getY()
				+ "\" rx=\""+rx
				+ "\" ry="+"\"" + ry +"\" ";
		
		code += "style=\"stroke: rgb(" 
				+ this.getCrayon().getCouleur().getRed()
				+ ", " + this.getCrayon().getCouleur().getGreen()
				+ ", " + this.getCrayon().getCouleur().getBlue()+ ")"
				+ "; stroke-width:" + this.getCrayon().getEpaisseur() + ";";
		if(!this.isRempli())
			code += "fill: none;";
		else
			code += "fill : rgb(" 
				+ this.getCrayon().getCouleur().getRed()
				+ ", " + this.getCrayon().getCouleur().getGreen()
				+ ", " + this.getCrayon().getCouleur().getBlue()+ ");";
		code+= "\" />";
		
		return code;
	}
}
