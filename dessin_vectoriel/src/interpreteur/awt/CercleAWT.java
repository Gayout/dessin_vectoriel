package interpreteur.awt;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import implementation.Cercle;
import implementation.Position;
/**
 * <b>CercleAWT est une classe d'interprétation en AWT. Elle interpréte la classe Cercle.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Cercle
 *
 */
public class CercleAWT 
// décommnter pour tester TestAWTCercle
//extends Frame
{

	/**
	 * Un CercleAWT est défini par un Cercle
	 * @see Cercle
	 * @see CercleAWT#getCercle()
	 * @see CercleAWT#CercleAWT(Cercle)
	 * @see CercleAWT#setCercle(Cercle)
	 */
	private Cercle cercle;


	/**
	 * Constructeur complet
	 * @param cercle
	 * 	cercle
	 */
	public CercleAWT(Cercle cercle) 
	// décoder pour tester TestAWTCercle
	//throws HeadlessException 
	{
		super();
		this.cercle = cercle;
	}


	/**
	 * @see CercleAWT#cercle
	 * @return Cercle
	 */
	public Cercle getCercle() {
		return cercle;
	}


	/**
	 * Change de cercle
	 * @see CercleAWT#cercle
	 * @param cercle
	 * 	cercle
	 */
	public void setCercle(Cercle cercle) {
		this.cercle = cercle;
	}

	/**
	 * @return Transforme cercle en une Shape dessinable dans une Frame
	 */
	public Shape shape() {

		Position c = cercle.getCentre();
		int x = c.getX();
		int y = c.getY();
		int r = cercle.getRayon();

		Shape r1 = new Ellipse2D.Float(x-r, y-r, 2*r, 2*r);

		return r1;
	}

	/*
	 * Méthode utilisé pour tester TestAWTCercle
	 */
	public void paint(Graphics g) {

		Color color = cercle.getCrayon().getCouleur();
		int epaisseur = cercle.getCrayon().getEpaisseur();

		Shape r1 = this.shape();

		Graphics2D ga = (Graphics2D)g;
		ga.setPaint(color);
		ga.setStroke(new BasicStroke((epaisseur)));
		if(cercle.isRempli())
			ga.fill(r1);
		//ga.drawOval(c.getX()-r, c.getY()-r ,2*r, 2*r);
		ga.draw(r1);
	}

}
