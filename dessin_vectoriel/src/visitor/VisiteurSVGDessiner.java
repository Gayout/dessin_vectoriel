package visitor;

import abstraction.Dessin;
import abstraction.Visiteur;
import implementation.*;
import interpreteur.svg.*;

public class VisiteurSVGDessiner implements Visiteur{

	private String code;
	
	
	public VisiteurSVGDessiner() {
		super();
		code = "<?xml version=\"1.0\" standalone=\"no\"?>\n"
				+ "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
				+ "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"500\" height=\"500\" >\n</svg>";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public void visit(Dessin dessin) {
	}

	@Override
	public void visit(Cercle cercle) {
		code = code.substring(0, code.length()-6);
		CercleSVG cercleSVG= cercle.creerCercleSVG();
		code += "\t"+cercleSVG.generateCode();
		code += "\n</svg>";
	}

	@Override
	public void visit(CourbeBezier courbeBezier) {
		code = code.substring(0, code.length()-6);
		CourbeBezierSVG courbeBezierSVG= courbeBezier.creerCourbeBezierSVG();
		code += "\t"+courbeBezierSVG.generateCode();
		code += "\n</svg>";		
	}

	@Override
	public void visit(Ellipse ellipse) {
		code = code.substring(0, code.length()-6);
		EllipseSVG ellipseSVG= ellipse.creerEllipseSVG();
		code += "\t"+ellipseSVG.generateCode();
		code += "\n</svg>";		
	}

	@Override
	public void visit(Polygone polygone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Rectangle rectangle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Segment segment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Texte texte) {
		// TODO Auto-generated method stub
		
	}

}
