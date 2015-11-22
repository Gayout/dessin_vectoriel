package test;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import abstraction.Dessin;
import abstraction.DessinComposite;
import implementation.Cercle;
import implementation.CourbeBezier;
import implementation.Crayon;
import implementation.Ellipse;
import implementation.Polygone;
import implementation.Position;
import implementation.Rectangle;
import implementation.Segment;
import visitor.VisiteurAWTDessiner;

public class TestVisiteurAWT {

	public static void main(String[] args) {
		VisiteurAWTDessiner visiteur = new VisiteurAWTDessiner();

		visiteur.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});

		DessinComposite dessin = new DessinComposite();

		/******CERCLE******/
		Cercle cercle = new Cercle(new Position(150,150), 100, Dessin.VIDE);
		cercle.setCrayon(new Crayon(2, Color.cyan));



		/******COURBE BEZIER*******/
		List<Position> sommets = new ArrayList<Position>();

		sommets.add(new Position(100,100));
		sommets.add(new Position(200,200));
		sommets.add(new Position(300,100));
		sommets.add(new Position(300,200));

		CourbeBezier courbeBezier = new CourbeBezier(sommets, Dessin.OUVERT, Dessin.REMPLI);
		courbeBezier.setCrayon(new Crayon(2,Color.yellow));



		/******ELLIPSE*******/
		Ellipse ellipse = new Ellipse(new Position(250,250),50,30,30,Dessin.VIDE);
		ellipse.setCrayon(new Crayon(10, Color.red));



		/******POLYGONE*******/
		Polygone polygone = new Polygone(sommets, true, false);
		polygone.getCrayon().setEpaisseur(6);



		/******RECTANGLE*******/
		Rectangle rectangle = new Rectangle(new Position(40,140), 290,250,false);
		rectangle.setCrayon(new Crayon(2, Color.green));;



		/******SEGMENT*******/
		Segment ligne = new Segment(new Position(0,0), new Position(100, 200));
		ligne.setCrayon(new Crayon(1, Color.orange));

		dessin.addDessin(cercle);
		dessin.addDessin(courbeBezier);
		dessin.addDessin(ellipse);
		dessin.addDessin(polygone);
		dessin.addDessin(rectangle);
		dessin.addDessin(ligne);

		dessin.accept(visiteur);

	}

}
