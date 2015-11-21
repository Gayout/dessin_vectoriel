package test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import abstraction.Dessin;
import implementation.Ellipse;
import implementation.Position;
import interpreteur.awt.EllipseAWT;

public class TestAWTEllipse {

	public static void main(String args[]) 
	{
		Ellipse ellipse= new Ellipse(new Position(200,200), 200, 100, 45, Dessin.REMPLI);
		
		EllipseAWT ellipseAWT = ellipse.creerEllipseAWT(); 
		ellipseAWT.addWindowListener(
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent we)
					{
						System.exit(0);
					}
				}
				);

		ellipseAWT.setSize(400, 400);
		ellipseAWT.setVisible(true);
	}
}
