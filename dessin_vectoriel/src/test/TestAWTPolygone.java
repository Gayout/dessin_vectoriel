package test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import implementation.Polygone;
import implementation.Position;
import interpreteur.awt.PolygoneAWT;

public class TestAWTPolygone {


	public static void main(String args[]) 
	{

		List<Position> sommets = new ArrayList<Position>();

		sommets.add(new Position(100,100));
		sommets.add(new Position(200,200));
		sommets.add(new Position(300,100));
		sommets.add(new Position(300,200));

		Polygone Polygone = new Polygone(sommets, false, true);

		PolygoneAWT PolygoneAWT= Polygone.creerPolygoneAWT(); 
		PolygoneAWT.addWindowListener(
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent we)
					{
						System.exit(0);
					}
				}
				);

		PolygoneAWT.setSize(400, 400);
		PolygoneAWT.setVisible(true);
	}
}
