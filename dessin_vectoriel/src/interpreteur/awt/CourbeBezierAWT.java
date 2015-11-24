package interpreteur.awt;

import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;

import exception.BezierException;
import implementation.CourbeBezier;
import implementation.Position;
/**
 * <b>CourbeBezierAWT est une classe d'interprétation en AWT. Elle interpréte la classe CourbeBezier.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see CourbeBezier
 *
 */
public class CourbeBezierAWT 
//décommenter pour tester TestAWTBezier
//extends Frame
{
	/**
	 * Une CourbeBezierAWT est défini par une CourbeBezier
	 * @see CourbeBezier
	 * @see CourbeBezierAWT#getCourbeBezier()
	 * @see CourbeBezierAWT#CourbeBezierAWT(CourbeBezier)
	 * @see CourbeBezierAWT#setCourbeBezier(CourbeBezier)
	 */
	private CourbeBezier courbeBezier;


	/**
	 * Constructeur complet
	 * @param courbeBezier
	 * 	courbe
	 */
	public CourbeBezierAWT(CourbeBezier courbeBezier) 
			//throws HeadlessException 
	{
		super();
		this.courbeBezier = courbeBezier;
	}

	/**
	 * @see CourbeBezierAWT#courbeBezier
	 * @return Courbe de Bézier
	 */
	public CourbeBezier getCourbeBezier() {
		return courbeBezier;
	}

	/**
	 * Change la courbe
	 * @see CourbeBezierAWT#courbeBezier
	 * @param courbeBezier
	 * 	courbe
	 */
	public void setCourbeBezier(CourbeBezier courbeBezier) {
		this.courbeBezier = courbeBezier;
	}

	/**
	 * @return Transforme courbe en une Shape dessinable dans une Frame
	 */
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

	/*
	 * Méthode pour TestAWTBezier
	 */
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