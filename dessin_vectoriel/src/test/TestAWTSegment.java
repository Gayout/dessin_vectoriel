package test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import abstraction.Dessin;
import implementation.Segment;
import implementation.Position;
import interpreteur.awt.SegmentAWT;
import interpreteur.svg.SegmentSVG;

public class TestAWTSegment {


	public static void main(String args[]) 
	{


		Position d = (new Position(100,100));
		Position a = (new Position(200,200));

		Segment Segment = new Segment(d,a);

		SegmentAWT SegmentAWT= Segment.creerSegmentAWT(); 
		SegmentAWT.addWindowListener(
				new WindowAdapter()
				{
					public void windowClosing(WindowEvent we)
					{
						System.exit(0);
					}
				}
				);

		SegmentAWT.setSize(400, 400);
		SegmentAWT.setVisible(true);
	}
}
