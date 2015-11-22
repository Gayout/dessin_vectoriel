package interpreteur.awt;

import java.awt.*;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import implementation.Rectangle;

public class RectangleAWT extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rectangle rectangle;


	public RectangleAWT(Rectangle rectangle) throws HeadlessException {
		super();
		this.rectangle = rectangle;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public Shape shape(){
		int x = rectangle.getHautGauche().getX();
		int y = rectangle.getHautGauche().getY();
		int w = rectangle.getWidth();
		int h = rectangle.getHeight();


		Shape r1 = new Rectangle2D.Float(x,y,w,h);
		return r1;
	}
	
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
