package interpreteur.awt;

import java.awt.*;

import java.awt.geom.Path2D;
import java.util.List;

import implementation.Polygone;
import implementation.Position;
/**
 * <b>PolygoneAWT est une classe d'interprétation en AWT. Elle interpréte la classe Polygone.</b>
 * @author Aurore Claude/Quentin Gayout
 * @see Polygone
 *
 */
public class PolygoneAWT 
//décommenter pour tester
//extends Frame
{

	/**
	 * Une PolygoneAWT est défini par une Polygone
	 * @see Polygone
	 * @see PolygoneAWT#getPolygone()
	 * @see PolygoneAWT#PolygoneAWT(Polygone)
	 * @see PolygoneAWT#setPolygone(Polygone)
	 */
	private Polygone polygone;

	/**
	 * Constructeur complet
	 * @param polygone
	 * 	polygone
	 */
	public PolygoneAWT(Polygone polygone) 
			//throws HeadlessException 
	{
		super();
		this.polygone = polygone;
	}

	/**
	 * @see PolygoneAWT#polygone
	 * @return Polygone
	 */
	public Polygone getPolygone() {
		return polygone;
	}

	/**
	 * Change de Polygone
	 * @see PolygoneAWT#polygone
	 * @param polygone
	 * 	polygone
	 */
	public void setPolygone(Polygone polygone) {
		this.polygone = polygone;
	}

	/**
	 * @return Transforme polygone en une Shape dessinable dans une Frame
	 */
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

	/*
	 * Méthode de test
	 */
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
