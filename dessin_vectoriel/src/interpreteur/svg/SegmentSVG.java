package interpreteur.svg;

import java.awt.Color;

import implementation.Crayon;
import implementation.Position;
import implementation.Segment;

public class SegmentSVG extends Segment {

	public SegmentSVG() {
		super();
	}
	
	public SegmentSVG(Segment segment){
		this(segment.getDepart(), segment.getArrivee());
		this.setCrayon(segment.getCrayon());
	}

	public SegmentSVG(Position p1, Position p2) {
		super(p1, p2);
	}
	
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
