package interpreteur.awt;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import implementation.Ellipse;
import implementation.Position;
/**
 * <b>Ellipse est une classe d'interprétation en AWT. Elle interpréte la classe Ellipse.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Ellipse
 *
 */
public class EllipseAWT
// décommenter pour tester
//extends Frame
{

	/**
	 * Une EllipseAWT est défini par une Ellipse
	 * @see Ellipse
	 * @see EllipseAWT#getEllipse()
	 * @see EllipseAWT#EllipseAWT(Ellipse)
	 * @see EllipseAWT#setEllipse(Ellipse)
	 */
	private Ellipse ellipse;

	/**
	 * Constructeur complet
	 * @param ellipse
	 * 	ellipse
	 */
	public EllipseAWT(Ellipse ellipse)
			//throws HeadlessException
	{
		super();
		this.ellipse = ellipse;
	}

	/**
	 * @see EllipseAWT#ellipse
	 * @return Ellipse
	 */
	public Ellipse getEllipse() {
		return ellipse;
	}

	/**
	 * Change l'ellipse
	 * @see EllipseAWT#ellipse
	 * @param ellipse
	 * 	ellipse
	 */
	public void setEllipse(Ellipse ellipse) {
		this.ellipse = ellipse;
	}

	/**
	 * @return Transforme ellipse en une Shape dessinable dans une Frame
	 */
	public Shape shape(){
		Position c = ellipse.getCentre();
		int x = c.getX();
		int y = c.getY();
		int width = ellipse.getGdAxe();
		int height = ellipse.getPetitAxe();

		Shape r1 = new Ellipse2D.Float(x-width, y-height, 2*width, 2*height);
		
		return r1;
	}
	
	/*
	 * Methode utilisée pour tester
	 */
	public void paint(Graphics g) {
		Position c = ellipse.getCentre();
		int x = c.getX();
		int y = c.getY();
		int width = ellipse.getGdAxe();
		int height = ellipse.getPetitAxe();
		long angle =ellipse.getAngleAbsGdAxe();

		Shape r1 = this.shape();
		
		Graphics2D ga = (Graphics2D)g;
		ga.rotate(Math.toRadians(angle),x+ width / 2,  y+height / 2);
		ga.setPaint(Color.red);
		ga.setStroke(new BasicStroke((5)));
		if(ellipse.isRempli())
			ga.fill(r1);
		ga.draw(r1);

	}
}
