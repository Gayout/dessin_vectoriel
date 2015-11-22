package interpreteur.awt;

import java.awt.*;
import java.awt.geom.Line2D;

import implementation.Segment;

public class SegmentAWT extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public Shape shape(){
		int x1 = segment.getDepart().getX();
		int y1 = segment.getDepart().getY();
		int x2 = segment.getArrivee().getX();
		int y2 = segment.getArrivee().getY();

		Shape r1 = new Line2D.Float(x1,y1,x2,y2);

		return r1;
	}

	public void paint(Graphics g) {
		Color color = segment.getCrayon().getCouleur();
		int epaisseur = segment.getCrayon().getEpaisseur();

		Shape r1 = this.shape();

		Graphics2D ga = (Graphics2D)g;
		ga.setPaint(color);
		ga.setStroke(new BasicStroke((epaisseur)));

		ga.draw(r1);

	}

}
