package test;

import implementation.Cercle;
import implementation.Position;
import visitor.VisiteurSVGDessiner;

public class TestVisiteurSVG {
	
	public static void main(String[] args) {
		VisiteurSVGDessiner visiteur = new VisiteurSVGDessiner();
		
		Cercle cercle = new Cercle(new Position(150,150), 100, true);
		
		cercle.accept(visiteur);
		
		System.out.println(visiteur.getCode());
	}

}
