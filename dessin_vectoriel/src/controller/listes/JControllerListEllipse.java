package controller.listes;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import abstraction.Application;
import implementation.Ellipse;
import view.MainView;

public class JControllerListEllipse implements Observer, ListSelectionListener {
	private MainView parent;
	private JList<String> list;
	private Application application;

	public JControllerListEllipse(MainView parent, JList<String> list, Application application) {
		this.parent = parent;
		this.list = list;
		this.application = application;
		Vector<String> data = new Vector<String>();
		for(Ellipse e : this.application.getEllipses()) {
			data.add("Centre ("+e.getCentre().getX()+","+e.getCentre().getY()+") - axes ("+e.getGdAxe()+","+e.getPetitAxe()+")");
		}
		data.add(0, "-");

		this.list.setListData(data);
		this.list.setSelectedIndex(0);
		this.parent.setListEllipses(list);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if ((this.list.getSelectedIndex() != -1) && !((String)this.list.getSelectedValue()).equals("-")) {
			this.application.setEllipseSelected(this.application.getEllipses().get(this.list.getSelectedIndex() - 1));
		}
		else {
			if (this.list.getSelectedIndex() != -1) {
				this.application.setEllipseSelected(null);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Integer iMessage = (Integer)arg1;
		if(iMessage == Application.MODIFY_ELLIPSES) {
			Vector<String> data = new Vector<String>();
			for(Ellipse e : this.application.getEllipses()) {
				data.add("Centre ("+e.getCentre().getX()+","+e.getCentre().getY()+") - axes ("+e.getGdAxe()+","+e.getPetitAxe()+")");
			}
			data.add(0, "-");
			list.setListData(data);
			this.parent.setListEllipses(list);
		}
		if(iMessage == Application.MODIFY_ELLIPSE_SELECTED || iMessage == Application.MODIFY_ELLIPSES) {
			if (this.application.getEllipseSelected() != null ){
				this.list.setSelectedIndex(Integer.valueOf(branchToIndice(this.application.getEllipses(), this.application.getEllipseSelected())));
			}
			else {
				this.list.setSelectedIndex(0);
			}
			this.list.ensureIndexIsVisible(this.parent.getListEllipses().getSelectedIndex());
			this.list.repaint();
		}
	}

	public static int branchToIndice (Vector<Ellipse> ellipses, Ellipse e) {
		boolean aret = false;
		int size = ellipses.size();
		int i;
		for(i=0; i<size && !aret; i++) {
			aret = ellipses.get(i).equals(e);
		}
		if (aret) {
			return i--;
		}
		else {
			return -1;
		}
	}
}