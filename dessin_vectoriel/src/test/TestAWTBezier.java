package test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import abstraction.Dessin;
import implementation.CourbeBezier;
import implementation.Position;
import interpreteur.awt.CourbeBezierAWT;
import interpreteur.svg.CourbeBezierSVG;

public class TestAWTBezier {


	public static void main(String args[]) 
	{

		List<Position> sommets = new ArrayList<Position>();

		sommets.add(new Position(100,100));
		sommets.add(new Position(200,200));
		sommets.add(new Position(300,100));
		sommets.add(new Position(300,200));

		CourbeBezierSVG courbeBezier = new CourbeBezierSVG(sommets, false, false);

		CourbeBezierAWT courbeBezierAWT= courbeBezier.creerCourbeBezierAWT(); 
		courbeBezierAWT.addWindowListener(
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent we)
					{
						System.exit(0);
					}
				}
				);

		courbeBezierAWT.setSize(400, 400);
		courbeBezierAWT.setVisible(true);
	}
}
