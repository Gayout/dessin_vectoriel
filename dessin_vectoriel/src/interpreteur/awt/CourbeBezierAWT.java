package interpreteur.awt;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Shape;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import exception.BezierException;
import implementation.CourbeBezier;
import implementation.Position;

public class CourbeBezierAWT 
extends JFrame
{

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

	public List<Shape> shape() {
		List<Shape> shapes = new ArrayList<Shape>();

		List<Position> pos = courbeBezier.getSommets();

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

			shapes.add(r1);
			if(!courbeBezier.isOuvert()){
				Shape r2 = new Line2D.Float(pos.get(0).getX(), pos.get(0).getY(), pos.get(pos.size()-1).getX(), pos.get(pos.size()-1).getY());
				shapes.add(r2);
			}

		} catch (BezierException e) {
			e.printStackTrace();
		}
		return shapes;
	}

	public void paint(Graphics g) {

		Color color = courbeBezier.getCrayon().getCouleur();
		int epaisseur = courbeBezier.getCrayon().getEpaisseur();
		Shape r1 = this.shape().get(0);

		Graphics2D ga = (Graphics2D)g;
		ga.setPaint(color);
		ga.setStroke(new BasicStroke((epaisseur)));

		if(courbeBezier.isRempli())
			ga.fill(r1);
		ga.draw(r1);

		if(!courbeBezier.isOuvert()){
			Shape r2= this.shape().get(1);
			ga.draw(r2);
		}

	}

}