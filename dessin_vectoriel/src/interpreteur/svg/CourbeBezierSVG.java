package interpreteur.svg;

import java.awt.Color;
import java.util.List;

import implementation.CourbeBezier;
import implementation.Crayon;
import implementation.Position;

public class CourbeBezierSVG extends CourbeBezier {
	public CourbeBezierSVG() {
		super();
	}

	public CourbeBezierSVG(CourbeBezier courbeBezier){
		this(courbeBezier.getSommets(), courbeBezier.isOuvert(), courbeBezier.isRempli());
		this.setCrayon(courbeBezier.getCrayon());
	}
	
	public CourbeBezierSVG( List<Position> sommets, boolean ouvert, boolean rempli) {
		super(sommets, ouvert, rempli);
	}

	public String generateCode(){
		
		List<Position> sommets = this.getSommets();
		
		int red = this.getCrayon().getCouleur().getRed();
		int green = this.getCrayon().getCouleur().getGreen();
		int blue = this.getCrayon().getCouleur().getBlue();

		
		String code = "<path d = \"M "+ sommets.get(0).getX() + " " + sommets.get(0).getY()+" ";
		
		code += ((sommets.size() < 3) ? "L" : ((sommets.size() == 3)? "Q": "C") )+ " ";
		
		sommets.remove(0);
		
		for(Position p : sommets){
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
