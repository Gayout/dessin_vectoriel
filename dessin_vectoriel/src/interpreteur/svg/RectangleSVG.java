package interpreteur.svg;

import java.awt.Color;

import implementation.Rectangle;
import implementation.Crayon;
import implementation.Position;

public class RectangleSVG extends Rectangle{

	public RectangleSVG() {
		super();
	}

	public RectangleSVG(Position hautGauche, int width, int height, boolean isRempli) {
		super(hautGauche, width, height, isRempli);

		this.setCrayon(new Crayon(2, Color.cyan));

	}

	public String generateCode(){

		String code = "<rect x=\"" + this.getHautGauche().getX()
				+ "\" y=\"" + this.getHautGauche().getY()
				+ "\" width=\""+ this.getWidth()
				+ "\" height=\""+ this.getHeight()+"\" ";

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
