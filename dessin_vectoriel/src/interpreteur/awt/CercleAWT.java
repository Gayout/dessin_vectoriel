package interpreteur.awt;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.border.StrokeBorder;

import implementation.Cercle;
import implementation.Position;

public class CercleAWT extends Frame{

	private Cercle cercle;


	public CercleAWT(Cercle cercle) throws HeadlessException {
		super();
		this.cercle = cercle;
	}


	public Cercle getCercle() {
		return cercle;
	}



	public void setCercle(Cercle cercle) {
		this.cercle = cercle;
	}



	public void paint(Graphics g) {
		Position c = cercle.getCentre();
		int x = c.getX();
		int y = c.getY();
		int r = cercle.getRayon();
		Color color = cercle.getCrayon().getCouleur();
		int epaisseur = cercle.getCrayon().getEpaisseur();
		
		Shape r1 = new Ellipse2D.Float(x, y, r, r);
		
		Graphics2D ga = (Graphics2D)g;
		ga.setPaint(color);
		ga.setStroke(new BasicStroke((epaisseur)));
		if(cercle.isRempli())
			ga.fill(r1);
		//ga.drawOval(c.getX()-r, c.getY()-r ,2*r, 2*r);
        ga.draw(r1);
	}

}
