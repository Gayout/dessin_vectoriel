package interpreteur.svg;

import java.awt.Color;

import implementation.Cercle;
import implementation.Crayon;
import implementation.Position;

public class CercleSVG extends Cercle{

	public CercleSVG() {
		super();
	}
	
	public CercleSVG(Cercle cercle){
		this(cercle.getCentre(), cercle.getRayon(), cercle.isRempli());
		this.setCrayon(cercle.getCrayon());
	}
	
	public CercleSVG(Position centre, int rayon, boolean isRempli) {
		super(centre, rayon, isRempli);
	}

public String generateCode(){
		
		String code = "<circle cx=\"" + this.getCentre().getX()
				+ "\" cy=\"" + this.getCentre().getY()
				+ "\" r=\""+ this.getRayon()+"\" ";
		
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
