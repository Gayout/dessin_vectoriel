package interpreteur.awt;

import java.awt.*;
import java.awt.geom.Line2D;

import implementation.Segment;
/**
 * <b>SegmentAWT est une classe d'interpr�tation en AWT. Elle interpr�te la classe Segment.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Segment
 *
 */
public class SegmentAWT 
//d�commenter pour tester
//extends Frame
{

	/**
	 * Une SegmentAWT est d�fini par une Segment
	 * @see Segment
	 * @see SegmentAWT#getSegment()
	 * @see SegmentAWT#SegmentAWT(Segment)
	 * @see SegmentAWT#setSegment(Segment)
	 */
	private Segment segment;

	/**
	 * Constructeur complet
	 * @param segment
	 * 	segment
	 */
	public SegmentAWT(Segment segment) 
	//throws HeadlessException 
	{
		super();
		this.segment = segment;
	}

	/**
	 * @see SegmentAWT#segment
	 * @return Segment
	 */
	public Segment getSegment() {
		return segment;
	}

	/**
	 * Change de Segment
	 * @see SegmentAWT#segment
	 * @param segment
	 * 	segment
	 */
	public void setSegment(Segment segment) {
		this.segment = segment;
	}

	/**
	 * @return Transforme courbe en une Shape dessinable dans une Frame
	 */
	public Shape shape(){
		int x1 = segment.getDepart().getX();
		int y1 = segment.getDepart().getY();
		int x2 = segment.getArrivee().getX();
		int y2 = segment.getArrivee().getY();

		Shape r1 = new Line2D.Float(x1,y1,x2,y2);

		return r1;
	}

	/*
	 * Methode de test
	 */
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
