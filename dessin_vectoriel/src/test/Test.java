package test;

import static org.junit.Assert.*;
import abstraction.*;
import exception.*;
import implementation.*;

public class Test {

	@org.junit.Test
	public void creerCercle() {
		FabriqueDessin<Dessin> fab = new Cercle(null,null,null);
	}

}
