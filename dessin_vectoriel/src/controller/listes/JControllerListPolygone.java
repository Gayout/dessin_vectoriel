package controller.listes;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import abstraction.Application;
import implementation.Polygone;
import view.MainView;

public class JControllerListPolygone implements Observer, ListSelectionListener {
	private MainView parent;
	private JList<String> list;
	private Application application;
	private JButton mod;
	private JButton sup;

	public JControllerListPolygone(MainView parent, JList<String> list, Application application, JButton mod, JButton sup) {
		this.parent = parent;
		this.list = list;
		this.application = application;
		Vector<String> data = new Vector<String>();
		for(Polygone p : this.application.getPolygones()) {
			data.add("Ferme : \'"+!p.isOuvert()+"\', nombre de points "+p.getSommets().size());
		}
		data.add(0, "-");

		this.mod = mod;
		this.sup = sup;
		if (this.application.getPolygoneSelected()==null) {
			this.mod.setEnabled(false);
			this.sup.setEnabled(false);
		}
		
		this.list.setListData(data);
		this.list.setSelectedIndex(0);
		this.parent.setListPolygones(list);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if ((this.list.getSelectedIndex() != -1) && !((String)this.list.getSelectedValue()).equals("-")) {
			this.application.setPolygoneSelected(this.application.getPolygones().get(this.list.getSelectedIndex() - 1));
			this.mod.setEnabled(true);
			this.sup.setEnabled(true);
		}
		else {
			if (this.list.getSelectedIndex() != -1) {
				this.application.setPolygoneSelected(null);
				this.mod.setEnabled(false);
				this.sup.setEnabled(false);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Integer iMessage = (Integer)arg1;
		if(iMessage == Application.MODIFY_POLYGONES) {
			Vector<String> data = new Vector<String>();
			for(Polygone p : this.application.getPolygones()) {
				data.add("Ferme : \'"+!p.isOuvert()+"\', nombre de points "+p.getSommets().size());
			}
			data.add(0, "-");
			list.setListData(data);
			this.parent.setListPolygones(list);
		}
		if(iMessage == Application.MODIFY_POLYGONE_SELECTED || iMessage == Application.MODIFY_POLYGONES) {
			if (this.application.getPolygoneSelected() != null ){
				this.list.setSelectedIndex(Integer.valueOf(branchToIndice(this.application.getPolygones(), this.application.getPolygoneSelected())));
			}
			else {
				this.list.setSelectedIndex(0);
			}
			this.list.ensureIndexIsVisible(this.parent.getListPolygones().getSelectedIndex());
			this.list.repaint();
		}
	}

	public static int branchToIndice (Vector<Polygone> polygones, Polygone p) {
		boolean aret = false;
		int size = polygones.size();
		int i;
		for(i=0; i<size && !aret; i++) {
			aret = polygones.get(i).equals(p);
		}
		if (aret) {
			return i--;
		}
		else {
			return -1;
		}
	}
}