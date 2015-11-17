package interpreteur.svg;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import implementation.Crayon;
import implementation.Polygone;
import implementation.Position;

public class PolygoneSVG extends Polygone {
	
	public PolygoneSVG() {
		super();
	}

	public PolygoneSVG(boolean rempli, List<Position> sommets, boolean ouvert) {
		super(rempli, sommets, ouvert);
		
		this.setCrayon(new Crayon(2, Color.yellow));
	}

	public String generateCode(){
		
		List<Position> sommets = this.getSommets();
		
		int red = this.getCrayon().getCouleur().getRed();
		int green = this.getCrayon().getCouleur().getGreen();
		int blue = this.getCrayon().getCouleur().getBlue();

		
		String code = "<"+ (this.isOuvert() ? "polyline" : "polygon") +" points=\"";
		
		for(Position p : sommets){
			code += p.getX()+","+p.getY()+" ";
		}
		
		code += "\" style=\"stroke: rgb(" 
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

		code+= " />";
		
		return code;
	}

}
