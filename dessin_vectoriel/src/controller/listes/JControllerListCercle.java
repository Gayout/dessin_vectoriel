package controller.listes;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import abstraction.Application;
import implementation.Cercle;
import view.MainView;

public class JControllerListCercle implements Observer, ListSelectionListener {
	private MainView parent;
	private JList<String> list;
	private Application application;

	public JControllerListCercle(MainView parent, JList<String> list, Application application) {
		this.parent = parent;
		this.list = list;
		this.application = application;
		Vector<String> data = new Vector<String>();
		for(Cercle c : this.application.getCercles()) {
			data.add("Centre ("+c.getCentre().getX()+","+c.getCentre().getY()+") - rayon "+c.getRayon());
		}
		data.add(0, "-");

		this.list.setListData(data);
		this.list.setSelectedIndex(0);
		this.parent.setListCercles(list);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if ((this.list.getSelectedIndex() != -1) && !((String)this.list.getSelectedValue()).equals("-")) {
			this.application.setCercleSelected(this.application.getCercles().get(this.list.getSelectedIndex() - 1));
		}
		else {
			if (this.list.getSelectedIndex() != -1) {
				this.application.setCercleSelected(null);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Integer iMessage = (Integer)arg1;
		if(iMessage == Application.MODIFY_CERCLES) {
			Vector<String> data = new Vector<String>();
			for(Cercle c : this.application.getCercles()) {
				data.add("Centre ("+c.getCentre().getX()+","+c.getCentre().getY()+") - rayon "+c.getRayon());
			}
			data.add(0, "-");
			list.setListData(data);
			this.parent.setListCercles(list);
		}
		if(iMessage == Application.MODIFY_CERCLE_SELECTED || iMessage == Application.MODIFY_CERCLES) {
			if (this.application.getCercleSelected() != null ){
				this.list.setSelectedIndex(Integer.valueOf(branchToIndice(this.application.getCercles(), this.application.getCercleSelected())));
			}
			else {
				this.list.setSelectedIndex(0);
			}
			this.list.ensureIndexIsVisible(this.parent.getListCercles().getSelectedIndex());
			this.list.repaint();
		}
	}

	public static int branchToIndice (Vector<Cercle> cercles, Cercle c) {
		boolean aret = false;
		int size = cercles.size();
		int i;
		for(i=0; i<size && !aret; i++) {
			aret = cercles.get(i).equals(c);
		}
		if (aret) {
			return i--;
		}
		else {
			return -1;
		}
	}
}