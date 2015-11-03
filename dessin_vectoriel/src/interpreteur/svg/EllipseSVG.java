package interpreteur.svg;

import implementation.Crayon;
import implementation.Ellipse;
import implementation.Position;

public class EllipseSVG extends Ellipse {
	private String code;

	public EllipseSVG() {
		super();
		this.code = "";
	}

	public EllipseSVG(Position centre, int gdAxe, int petitAxe, long angleAbsGdAxe, boolean isRempli) {
		super(centre, gdAxe, petitAxe, angleAbsGdAxe, isRempli);
		
		int rx = ((this.getAngleAbsGdAxe()%180) < 45) ? this.getGdAxe() : this.getPetitAxe(); 
		int ry = ((this.getAngleAbsGdAxe()%180) >= 45) ? this.getGdAxe() : this.getPetitAxe();
	
		this.setCrayon(new Crayon(2, "black"));
		
		this.code = "<ellipse cx=\"" + this.getCentre().getX()
				+ "\" cy=\"" + this.getCentre().getY()
				+ "\" rx=\""+rx
				+ "\" ry="+"\"" + ry +"\" ";
		
		this.code += "style=\"stroke:" 
				+ this.getCrayon().getCouleur() + "; stroke-width:"
				+ this.getCrayon().getEpaisseur() + ";\" />";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String generateCode(){
		return this.getCode();
	}
}
