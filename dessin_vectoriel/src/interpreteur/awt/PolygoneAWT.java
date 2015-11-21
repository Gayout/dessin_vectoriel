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
import implementation.Polygone;
import implementation.Position;

public class PolygoneAWT extends Frame{

	private Polygone polygone;


	public PolygoneAWT(Polygone polygone) throws HeadlessException {
		super();
		this.polygone = polygone;
	}


	public Polygone getPolygone() {
		return polygone;
	}



	public void setPolygone(Polygone polygone) {
		this.polygone = polygone;
	}



	public void paint(Graphics g) {
		List<Position> pos = polygone.getSommets();
		int size = pos.size();
		int[] x = new int[size];
		int[] y = new int [size];
		
		for(int i=0; i<size; i++){
			x[i] = pos.get(i).getX();
			y[i] = pos.get(i).getY();
		}
		

		Color color = polygone.getCrayon().getCouleur();
		int epaisseur = polygone.getCrayon().getEpaisseur();
		Shape r1 = new Path2D.Float();
		((Path2D) r1).moveTo(x[0],y[0]);

		for(int i=0; i<size; i++)
			((Path2D) r1).lineTo(x[i],y[i]);
		
		if(!polygone.isOuvert())
			((Path2D) r1).lineTo(x[0],y[0]);

		Graphics2D ga = (Graphics2D)g;
		ga.setPaint(color);
		ga.setStroke(new BasicStroke((epaisseur)));
		
		if(polygone.isRempli())
			ga.fill(r1);
		ga.draw(r1);

	}

}
