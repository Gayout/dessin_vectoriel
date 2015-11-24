package controller.listes;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import abstraction.Application;
import implementation.Segment;
import view.MainView;

public class JControllerListSegment implements Observer, ListSelectionListener {
	private MainView parent;
	private JList<String> list;
	private Application application;
	private JButton mod;
	private JButton sup;

	public JControllerListSegment(MainView parent, JList<String> list, Application application, JButton mod, JButton sup) {
		this.parent = parent;
		this.list = list;
		this.application = application;
		Vector<String> data = new Vector<String>();
		for(Segment s : this.application.getSegments()) {
			data.add("Depart ("+s.getDepart().getX()+","+s.getDepart().getY()+") - Arrivée ("+s.getArrivee().getX()+","+s.getArrivee().getY()+")");
		}
		data.add(0, "-");

		this.mod = mod;
		this.sup = sup;
		if (this.application.getSegmentSelected()==null) {
			this.mod.setEnabled(false);
			this.sup.setEnabled(false);
		}
		
		this.list.setListData(data);
		this.list.setSelectedIndex(0);
		this.parent.setListSegments(list);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		System.out.println(this.application.getSegmentSelected());
		if ((this.list.getSelectedIndex() != -1) && !((String)this.list.getSelectedValue()).equals("-")) {
			this.application.setSegmentSelected(this.application.getSegments().get(this.list.getSelectedIndex() - 1));
			this.mod.setEnabled(true);
			this.sup.setEnabled(true);
		}
		else {
			if (this.list.getSelectedIndex() != -1) {
				this.application.setSegmentSelected(null);
				this.mod.setEnabled(false);
				this.sup.setEnabled(false);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Integer iMessage = (Integer)arg1;
		if(iMessage == Application.MODIFY_TRAITS) {
			Vector<String> data = new Vector<String>();
			for(Segment s : this.application.getSegments()) {
				data.add("Depart ("+s.getDepart().getX()+","+s.getDepart().getY()+") - Arrivée ("+s.getArrivee().getX()+","+s.getArrivee().getY()+")");
			}
			data.add(0, "-");
			list.setListData(data);
			this.parent.setListSegments(list);
		}
		if(iMessage == Application.MODIFY_TRAIT_SELECTED || iMessage == Application.MODIFY_TRAITS) {
			if (this.application.getSegmentSelected() != null ){
				this.list.setSelectedIndex(Integer.valueOf(branchToIndice(this.application.getSegments(), this.application.getSegmentSelected())));
			}
			else {
				this.list.setSelectedIndex(0);
			}
			this.list.ensureIndexIsVisible(this.parent.getListSegments().getSelectedIndex());
			this.list.repaint();
		}
	}

	public static int branchToIndice (Vector<Segment> segments, Segment s) {
		boolean aret = false;
		int size = segments.size();
		int i;
		Segment sTest;
		for(i=0; i<size && !aret; i++) {
			sTest = segments.get(i);
			aret = ((sTest.getArrivee().getX() == s.getArrivee().getX()) 
					&& (sTest.getArrivee().getY() == s.getArrivee().getY())
					&& (sTest.getDepart().getX() == s.getDepart().getX())
					&& (sTest.getDepart().getY() == s.getDepart().getY()));

		}
		if (aret) {
			return i--;
		}
		else {
			return -1;
		}
	}
	
}
