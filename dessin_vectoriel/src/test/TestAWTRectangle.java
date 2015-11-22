package test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import implementation.Rectangle;
import implementation.Position;
import interpreteur.awt.RectangleAWT;

public class TestAWTRectangle {


	public static void main(String args[]) 
	{


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
