package test;

import java.util.ArrayList;

import org.junit.Assert;

import abstraction.*;
import implementation.*;

public class Test {

	@org.junit.Test
	public void creerCercle() {
		FabriqueDessin<Dessin> fab = new Cercle();

        Assert.assertTrue(fab.creerCercle(new Position(0,0), 0, false) instanceof Cercle); 
	}
	
	@org.junit.Test
	public void creerSegment() {
		FabriqueDessin<Dessin> fab = new Segment();
		System.out.println("/>");
        Assert.assertTrue(fab.creerSegment(null, null) instanceof Segment); 
	}
	
	@org.junit.Test
	public void creerPolygone() {
		FabriqueDessin<Dessin> fab = new Polygone();

		ArrayList<Position> sommets = new ArrayList<Position>();
		sommets.add(new Position(0,0));
		sommets.add(new Position(1, 1));
		
        Assert.assertTrue(fab.creerPolygone( sommets, true, false) instanceof Polygone); 
	}
	
	@org.junit.Test
	public void creerBezier() {
		FabriqueDessin<Dessin> fab = new CourbeBezier();

		ArrayList<Position> ptsCtrl = new ArrayList<Position>();
		ptsCtrl.add(new Position(0,0));
		ptsCtrl.add(new Position(1, 1));
        Assert.assertTrue(fab.creerCourbeBezier(ptsCtrl, false) instanceof CourbeBezier); 
	}
	

}
