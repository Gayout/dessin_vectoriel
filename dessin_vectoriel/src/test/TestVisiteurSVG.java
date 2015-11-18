package test;

import java.awt.Color;
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
import implementation.Position;
import interpreteur.svg.CourbeBezierSVG;
import interpreteur.svg.EllipseSVG;
import visitor.VisiteurSVGDessiner;

public class TestVisiteurSVG {

	public static void main(String[] args) {
		VisiteurSVGDessiner visiteur = new VisiteurSVGDessiner();

		DessinComposite dessin = new DessinComposite();

		Cercle cercle = new Cercle(new Position(150,150), 100, Dessin.VIDE);
		cercle.setCrayon(new Crayon(2, Color.cyan));
		
		List<Position> sommets = new ArrayList<Position>();

		sommets.add(new Position(100,100));
		sommets.add(new Position(200,200));
		sommets.add(new Position(300,100));
		sommets.add(new Position(300,200));

		CourbeBezier courbeBezier = new CourbeBezier(sommets, Dessin.FERME, Dessin.REMPLI);
		courbeBezier.setCrayon(new Crayon(2,Color.yellow));

		EllipseSVG ellipse = new EllipseSVG(new Position(250,250),50,30,30,Dessin.VIDE);
		ellipse.setCrayon(new Crayon(10, Color.red));

		dessin.addDessin(cercle);
		dessin.addDessin(courbeBezier);
		dessin.addDessin(ellipse);

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
