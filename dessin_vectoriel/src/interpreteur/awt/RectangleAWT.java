package interpreteur.awt;

import java.awt.*;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import implementation.Rectangle;
/**
 * <b>RectangleAWT est une classe d'interprétation en AWT. Elle interpréte la classe Rectangle.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Rectangle
 *
 */
public class RectangleAWT 
//decommenter pour tester
//extends Frame
{

	/**
	 * Une RectangleAWT est défini par une Rectangle
	 * @see Rectangle
	 * @see RectangleAWT#getRectangle()
	 * @see RectangleAWT#RectangleAWT(Rectangle)
	 * @see RectangleAWT#setRectangle(Rectangle)
	 */
	private Rectangle rectangle;

	/**
	 * Constructeur complet
	 * @param rectangle
	 * 	rectangle
	 */
	public RectangleAWT(Rectangle rectangle) 
	//throws HeadlessException 
	{
		super();
		this.rectangle = rectangle;
	}

	/**
	 * @see RectangleAWT#rectangle
	 * @return Rectangle
	 */
	public Rectangle getRectangle() {
		return rectangle;
	}

	/**
	 * Change rectangle
	 * @see RectangleAWT#rectangle
	 * @param rectangle
	 * 	rectangle
	 */
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	/**
	 * @return Transforme courbe en une Shape dessinable dans une Frame
	 */
	public Shape shape(){
		int x = rectangle.getHautGauche().getX();
		int y = rectangle.getHautGauche().getY();
		int w = rectangle.getWidth();
		int h = rectangle.getHeight();


		Shape r1 = new Rectangle2D.Float(x,y,w,h);
		return r1;
	}
	/*
	 * Methode de test
	 */
	public void paint(Graphics g) {

		Color color = rectangle.getCrayon().getCouleur();
		int epaisseur = rectangle.getCrayon().getEpaisseur();

		Shape r1 = this.shape();

		Graphics2D ga = (Graphics2D)g;
		ga.setPaint(color);
		ga.setStroke(new BasicStroke((epaisseur)));
		if(rectangle.isRempli())
			ga.fill(r1);

		ga.draw(r1);

	}

}
