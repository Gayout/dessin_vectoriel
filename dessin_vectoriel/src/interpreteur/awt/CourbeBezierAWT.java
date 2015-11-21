package interpreteur.awt;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Shape;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.util.List;

import exception.BezierException;
import implementation.CourbeBezier;
import implementation.Position;

public class CourbeBezierAWT  extends Frame{

	private CourbeBezier courbeBezier;


	public CourbeBezierAWT(CourbeBezier courbeBezier) throws HeadlessException {
		super();
		this.courbeBezier = courbeBezier;
	}


	public CourbeBezier getCourbeBezier() {
		return courbeBezier;
	}



	public void setCourbeBezier(CourbeBezier courbeBezier) {
		this.courbeBezier = courbeBezier;
	}



	public void paint(Graphics g) {
		List<Position> pos = courbeBezier.getSommets();

		Color color = courbeBezier.getCrayon().getCouleur();
		int epaisseur = courbeBezier.getCrayon().getEpaisseur();
		try {
			Shape r1;

			if(pos.size()==4)
				r1 = new CubicCurve2D.Float(pos.get(0).getX(), pos.get(0).getY(), pos.get(1).getX(),pos.get(1).getY(),pos.get(2).getX(),pos.get(2).getY(),pos.get(3).getX(),pos.get(3).getY());
			else if (pos.size() == 3)
				r1 = new QuadCurve2D.Float(pos.get(0).getX(), pos.get(0).getY(), pos.get(1).getX(),pos.get(1).getY(),pos.get(2).getX(),pos.get(2).getY());
			else if (pos.size() == 2)
				r1 = new Line2D.Float(pos.get(0).getX(), pos.get(0).getY(), pos.get(1).getX(),pos.get(1).getY());
			else
				throw new BezierException();

			Graphics2D ga = (Graphics2D)g;
			ga.setPaint(color);
			ga.setStroke(new BasicStroke((epaisseur)));
			
			if(courbeBezier.isRempli())
				ga.fill(r1);
			ga.draw(r1);
			
			if(!courbeBezier.isOuvert()){
				Shape r2 = new Line2D.Float(pos.get(0).getX(), pos.get(0).getY(), pos.get(pos.size()-1).getX(), pos.get(pos.size()-1).getY());
				ga.draw(r2);
			}
			
		} catch (BezierException e) {
			e.printStackTrace();
		}
	}

}