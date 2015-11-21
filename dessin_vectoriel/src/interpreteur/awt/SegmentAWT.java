package interpreteur.awt;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.QuadCurve2D;
import java.util.List;

import exception.BezierException;
import implementation.Segment;
import implementation.Position;

public class SegmentAWT extends Frame{

	private Segment segment;


	public SegmentAWT(Segment segment) throws HeadlessException {
		super();
		this.segment = segment;
	}


	public Segment getSegment() {
		return segment;
	}



	public void setSegment(Segment segment) {
		this.segment = segment;
	}



	public void paint(Graphics g) {
		int x1 = segment.getDepart().getX();
		int y1 = segment.getDepart().getY();
		int x2 = segment.getArrivee().getX();
		int y2 = segment.getArrivee().getY();


		Color color = segment.getCrayon().getCouleur();
		int epaisseur = segment.getCrayon().getEpaisseur();

		Shape r1 = new Line2D.Float(x1,y1,x2,y2);

		Graphics2D ga = (Graphics2D)g;
		ga.setPaint(color);
		ga.setStroke(new BasicStroke((epaisseur)));

		ga.draw(r1);

	}

}
