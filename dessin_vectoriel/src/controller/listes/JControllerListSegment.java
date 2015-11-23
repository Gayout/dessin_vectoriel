package controller.listes;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import implementation.Segment;
import view.MainView;

public class JControllerListSegment implements Observer, ListSelectionListener {
	private MainView parent;

	public JControllerListSegment(MainView parent) {
		this.parent = parent;
		Vector<String> data = new Vector<String>();
		for(Segment s : this.parent.getSegments()) {
			data.add("Depart ("+s.getDepart().getX()+","+s.getDepart().getY()+") - Arrivée ("+s.getArrivee().getX()+","+s.getArrivee().getY()+")");
		}
		data.add(0, "-");

	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
