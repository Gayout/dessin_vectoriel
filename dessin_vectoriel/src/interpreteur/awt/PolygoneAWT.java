package interpreteur.awt;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.List;

import implementation.Polygone;
import implementation.Position;

public class PolygoneAWT extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public Shape shape(){
		List<Position> pos = polygone.getSommets();
		int size = pos.size();
		int[] x = new int[size];
		int[] y = new int [size];
		
		for(int i=0; i<size; i++){
			x[i] = pos.get(i).getX();
			y[i] = pos.get(i).getY();
		}
		

		Shape r1 = new Path2D.Float();
		((Path2D) r1).moveTo(x[0],y[0]);

		for(int i=0; i<size; i++)
			((Path2D) r1).lineTo(x[i],y[i]);
		
		if(!polygone.isOuvert())
			((Path2D) r1).lineTo(x[0],y[0]);
		
		return r1;
	}

	public void paint(Graphics g) {

		Color color = polygone.getCrayon().getCouleur();
		int epaisseur = polygone.getCrayon().getEpaisseur();
		Shape r1 = this.shape();

		Graphics2D ga = (Graphics2D)g;
		ga.setPaint(color);
		ga.setStroke(new BasicStroke((epaisseur)));
		
		if(polygone.isRempli())
			ga.fill(r1);
		ga.draw(r1);

	}

}
