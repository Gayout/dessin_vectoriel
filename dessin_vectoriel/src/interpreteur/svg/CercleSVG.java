package interpreteur.svg;


import implementation.Cercle;
import implementation.Position;
/**
 * <b>CercleSVG est une classe d'interprétation en SVG. Elle interpréte la classe Cercle.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Cercle
 *
 */
public class CercleSVG extends Cercle{

	/**
	 * Constructeur Vide
	 */
	public CercleSVG() {
		super();
	}

	/**
	 * Constructeur par recopie
	 * @param cercle
	 * 	cercle
	 */
	public CercleSVG(Cercle cercle){
		this(cercle.getCentre(), cercle.getRayon(), cercle.isRempli());
		this.setCrayon(cercle.getCrayon());
	}

	/**
	 * Constructeur complet
	 * @param centre
	 * 	centre
	 * @param rayon
	 * 	rayon
	 * @param isRempli
	 * 	remplissage
	 */
	public CercleSVG(Position centre, int rayon, boolean isRempli) {
		super(centre, rayon, isRempli);
	}

	/**
	 * @return Transforme la figure en sa représentation svg.
	 */
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
