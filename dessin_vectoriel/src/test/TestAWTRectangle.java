package test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import abstraction.Dessin;
import implementation.Rectangle;
import implementation.Position;
import interpreteur.awt.RectangleAWT;
import interpreteur.svg.RectangleSVG;

public class TestAWTRectangle {


	public static void main(String args[]) 
	{

		List<Position> sommets = new ArrayList<Position>();

		Position p = (new Position(100,100));

		Rectangle Rectangle = new Rectangle(p, 250,100,true);

		RectangleAWT RectangleAWT= Rectangle.creerRectangleAWT(); 
		RectangleAWT.addWindowListener(
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent we)
					{
						System.exit(0);
					}
				}
				);

		RectangleAWT.setSize(400, 400);
		RectangleAWT.setVisible(true);
	}
}
