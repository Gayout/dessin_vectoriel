package visitor;


import abstraction.Dessin;
import abstraction.Visiteur;
import implementation.*;
import interpreteur.svg.*;
/**
 * <b>VisiteurSVGDessiner visite les dessins, les interpréte en AWT et code en SVG dans sa variable d'instance "code"</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Visiteur
 */
public class VisiteurSVGDessiner implements Visiteur{

	/**
	 * Un VisiteurSVGDessiner est défini par une String de code
	 * @see VisiteurSVGDessiner#getCode()
	 * @see VisiteurSVGDessiner#setCode(String)
	 */
	private String code;
	
	/**
	 * Constructeur sans paramètre
	 */
	public VisiteurSVGDessiner() {
		super();
		code = "<?xml version=\"1.0\" standalone=\"no\"?>\n"
				+ "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
				+ "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"500\" height=\"500\" >\n</svg>";
	}

	/**
	 * @see VisiteurSVGDessiner
	 * @return le code svg
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Change de code svg
	 * @see VisiteurSVGDessiner#code
	 * @param code
	 * 	code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Pour la visite d'un DessinVide, il ne se passe rien
	 * @see Visiteur#visit(Dessin)
	 */
	@Override
	public void visit(Dessin dessin) {
	}

	/**
	 * Pour la visite d'un cercle
	 * @see Visiteur#visit(Cercle)
	 */
	@Override
	public void visit(Cercle cercle) {
		code = code.substring(0, code.length()-6);
		CercleSVG cercleSVG= cercle.creerCercleSVG();
		code += "\t"+cercleSVG.generateCode();
		code += "\n</svg>";
	}

	/**
	 * Pour la visite d'une courbeBezier
	 * @see Visiteur#visit(CourbeBezier)
	 */
	@Override
	public void visit(CourbeBezier courbeBezier) {
		code = code.substring(0, code.length()-6);
		CourbeBezierSVG courbeBezierSVG= courbeBezier.creerCourbeBezierSVG();
		code += "\t"+courbeBezierSVG.generateCode();
		code += "\n</svg>";		
	}

	/**
	 * Pour la visite d'une Ellipse
	 * @see Visiteur#visit(Ellipse)
	 */
	@Override
	public void visit(Ellipse ellipse) {
		code = code.substring(0, code.length()-6);
		EllipseSVG ellipseSVG= ellipse.creerEllipseSVG();
		code += "\t"+ellipseSVG.generateCode();
		code += "\n</svg>";		
	}

	/**
	 * Pour la visite d'un Polygone
	 * @see Visiteur#visit(Polygone)
	 */
	@Override
	public void visit(Polygone polygone) {
		code = code.substring(0, code.length()-6);
		PolygoneSVG polygoneSVG= polygone.creerPolygoneSVG();
		code += "\t"+polygoneSVG.generateCode();
		code += "\n</svg>";			
	}
	
	/**
	 * Pour la visite d'un rectangle
	 * @see Visiteur#visit(Rectangle)
	 */
	@Override
	public void visit(Rectangle rectangle) {
		code = code.substring(0, code.length()-6);
		RectangleSVG rectangleSVG= rectangle.creerRectangleSVG();
		code += "\t"+rectangleSVG.generateCode();
		code += "\n</svg>";			
	}

	/**
	 * Pour la visite d'un segment
	 * @see Visiteur#visit(Segment)
	 */
	@Override
	public void visit(Segment segment) {
		code = code.substring(0, code.length()-6);
		SegmentSVG segmentSVG= segment.creerSegmentSVG();
		code += "\t"+segmentSVG.generateCode();
		code += "\n</svg>";			
	}
	/**
	 * Pour la visite d'un texte
	 * @see Visiteur#visit(Texte)
	 */
	@Override
	public void visit(Texte texte) {
		code = code.substring(0, code.length()-6);
		TexteSVG texteSVG= texte.creerTexteSVG();
		code += "\t"+texteSVG.generateCode();
		code += "\n</svg>";			
	}

}
