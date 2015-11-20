package interpreteur.awt;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import implementation.Ellipse;
import implementation.Position;

public class EllipseAWT extends Frame{

	private Ellipse ellipse;

	public EllipseAWT(Ellipse ellipse) throws HeadlessException {
		super();
		this.ellipse = ellipse;
	}

	public Ellipse getEllipse() {
		return ellipse;
	}

	public void setEllipse(Ellipse ellipse) {
		this.ellipse = ellipse;
	}

	public void paint(Graphics g) {

		Position c = ellipse.getCentre();
		int x = c.getX();
		int y = c.getY();
		int width = ellipse.getGdAxe();
		int height = ellipse.getPetitAxe();
		long angle =ellipse.getAngleAbsGdAxe();

		Shape r1 = new Ellipse2D.Float(x, y, width, height);

		Graphics2D ga = (Graphics2D)g;
		ga.rotate(Math.toRadians(angle),x+ width / 2,  height / 2);
		ga.setPaint(Color.red);
		ga.setStroke(new BasicStroke((5)));
		if(ellipse.isRempli())
			ga.fill(r1);
		ga.draw(r1);

	}
}
