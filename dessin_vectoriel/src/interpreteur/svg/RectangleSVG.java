package interpreteur.svg;


import implementation.Rectangle;
import implementation.Position;
/**
 * <b>RectangleSVG est une classe d'interprétation en SVG. Elle interpréte la classe Rectangle.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Rectangle
 *
 */
public class RectangleSVG extends Rectangle{
	/**
	 * Constructeur Vide
	 */
	public RectangleSVG() {
		super();
	}
	/**
	 * Constructeur par recopie
	 * @param rectangle
	 * 	rectangle
	 */
	public RectangleSVG(Rectangle rectangle){
		this(rectangle.getHautGauche(), rectangle.getWidth(), rectangle.getHeight(), rectangle.isRempli());
		this.setCrayon(rectangle.getCrayon());
	}

	/**
	 * Constructeur complet
	 * @param hautGauche
	 * 	position
	 * @param width
	 * 	largeur
	 * @param height
	 * 	hauteur
	 * @param isRempli
	 * 	remplissage
	 */
	public RectangleSVG(Position hautGauche, int width, int height, boolean isRempli) {
		super(hautGauche, width, height, isRempli);
	}

	/**
	 * @return Transforme la figure en sa représentation svg.
	 */
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
