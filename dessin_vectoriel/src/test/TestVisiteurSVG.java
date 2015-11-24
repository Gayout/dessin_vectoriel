package test;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import implementation.Texte;
import visitor.VisiteurSVGDessiner;

public class TestVisiteurSVG {

	public static void main(String[] args) {
		VisiteurSVGDessiner visiteur = new VisiteurSVGDessiner();

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

		CourbeBezier courbeBezier = new CourbeBezier(sommets, Dessin.FERME, Dessin.REMPLI);
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
		
		
		/******TEXTE*******/
		Texte Texte = new Texte(20, "Hello !", Font.SANS_SERIF, new Position(100,100));
		Texte.getCrayon().setCouleur(Color.blue);;
		
		dessin.addDessin(cercle);
		dessin.addDessin(courbeBezier);
		dessin.addDessin(ellipse);
		dessin.addDessin(polygone);
		dessin.addDessin(rectangle);
		dessin.addDessin(ligne);
		dessin.addDessin(Texte);

		dessin.accept(visiteur);

		try {

			File file = new File("visiteur.svg");

			if (!file.createNewFile()){
				System.out.println("File already exist");
				file.delete();
				file = new File("visiteur.svg");
				System.out.println("File is overwrited!");
			}
			else
				System.out.println("File is created!");

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(visiteur.getCode());
			bw.close();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
