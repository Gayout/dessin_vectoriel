package test;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import abstraction.Dessin;
import implementation.Cercle;
import implementation.Crayon;
import implementation.Position;
import interpreteur.awt.CercleAWT;

public class TestAWTCercle {

/*
	public static void main(String args[]) 
	{
		Cercle cercle = new Cercle(new Position(0,0), 100, Dessin.REMPLI);
		cercle.setCrayon(new Crayon(5,Color.yellow));
		CercleAWT cercleAWT = cercle.creerCercleAWT(); 
		cercleAWT.addWindowListener(
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent we)
					{
						System.exit(0);
					}
				}
				);

		cercleAWT.setSize(400, 400);
		cercleAWT.setVisible(true);
	}
	*/
}
