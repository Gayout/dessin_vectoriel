package interpreteur.awt;

import java.awt.*;

import implementation.Texte;
/**
 * <b>TexteAWT est une classe d'interprétation en AWT. Elle interpréte la classe Texte.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Texte
 *
 */
public class TexteAWT 
//décommenter pour tester
//extends Frame
{

	/**
	 * Une TexteAWT est défini par une Texte
	 * @see Texte
	 * @see TexteAWT#getTexte()
	 * @see TexteAWT#TexteAWT(Texte)
	 * @see TexteAWT#setTexte(Texte)
	 */
	private Texte texte;

	/**
	 * Constructeur complet
	 * @param texte
	 * 	Texte
	 */
	public TexteAWT(Texte texte) 
	//throws HeadlessException 
	{
		super();
		this.texte = texte;
	}

	/**
	 * @see TexteAWT#texte
	 * @return texte
	 */
	public Texte getTexte() {
		return texte;
	}

	/**
	 * Change de Texte
	 * @see TexteAWT#texte
	 * @param texte
	 * 	Texte
	 */
	public void setTexte(Texte texte) {
		this.texte = texte;
	}

	/*
	 * Methode de test
	 */
	public void paint(Graphics g) {
		String font = ""+texte.getPolice()+"-"+texte.getTaillePolice();

		Graphics2D ga = (Graphics2D)g;
		
		ga.setColor(texte.getCrayon().getCouleur());
		ga.setFont(Font.decode(font));
		
		ga.drawString(texte.getTexte(), texte.getHtGauche().getX(), texte.getHtGauche().getY());

	}

}
