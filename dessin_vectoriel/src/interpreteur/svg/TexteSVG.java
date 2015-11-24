package interpreteur.svg;

import implementation.Position;
import implementation.Texte;
/**
 * <b>TexteSVG est une classe d'interprétation en SVG. Elle interpréte la classe Texte.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Texte
 *
 */
public class TexteSVG extends Texte {
	/**
	 * Constructeur Vide
	 */
	public TexteSVG() {
		super();
	}

	/**
	 * Constructeur par recopie
	 * @param texte
	 * 	Texte
	 */
	public TexteSVG(Texte texte){
		this(texte.getTaillePolice(), texte.getTexte(), texte.getPolice(), texte.getHtGauche());
	}

	/**
	 * Constructeur complet
	 * @param taillePolice
	 * 	taille
	 * @param texte
	 * 	texte
	 * @param police
	 * 	police
	 * @param htGauche
	 * 	position
	 */
	public TexteSVG(int taillePolice, String texte, String police, Position htGauche) {
		super(taillePolice,texte,police,htGauche);
	}

	/**
	 * @return Transforme le texte en sa représentation svg.
	 */
	public String generateCode(){

		String code = "<text x=\"" + this.getHtGauche().getX()
				+ "\" y=\"" + this.getHtGauche().getY()
				+ "\" font-family=\""+this.getPolice()
				+ "\" font-size="+"\"" + this.getTaillePolice() +"\" ";

		code += "style=\"stroke: rgb(" 
				+ this.getCrayon().getCouleur().getRed()
				+ ", " + this.getCrayon().getCouleur().getGreen()
				+ ", " + this.getCrayon().getCouleur().getBlue()+ ")"
				+ ";\"";
		code+= ">" + this.getTexte()+"</text>";

		return code;
	}

}
