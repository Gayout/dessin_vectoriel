package controller.listes;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import abstraction.Application;
import implementation.CourbeBezier;
import view.MainView;

public class JControllerListCourbe implements Observer, ListSelectionListener {
	private MainView parent;
	private JList<String> list;
	private Application application;
	private JButton mod;
	private JButton sup;

	public JControllerListCourbe(MainView parent, JList<String> list, Application application, JButton mod, JButton sup) {
		this.parent = parent;
		this.list = list;
		this.application = application;
		Vector<String> data = new Vector<String>();
		for(CourbeBezier c : this.application.getCourbes()) {
			data.add("Ferme : \'"+!c.isOuvert()+"\', nombre de points "+c.getSommets().size());
		}
		data.add(0, "-");

		this.mod = mod;
		this.sup = sup;
		if(this.application.getCourbeSelected()==null) {
			this.mod.setEnabled(false);
			this.sup.setEnabled(false);
		}
		
		this.list.setListData(data);
		this.list.setSelectedIndex(0);
		this.parent.setListCourbes(list);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if ((this.list.getSelectedIndex() != -1) && !((String)this.list.getSelectedValue()).equals("-")) {
			this.application.setCourbeSelected(this.application.getCourbes().get(this.list.getSelectedIndex() - 1));
			this.mod.setEnabled(true);
			this.sup.setEnabled(true);
		}
		else {
			if (this.list.getSelectedIndex() != -1) {
				this.application.setCourbeSelected(null);
				this.mod.setEnabled(false);
				this.sup.setEnabled(false);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Integer iMessage = (Integer)arg1;
		if(iMessage == Application.MODIFY_COURBES) {
			Vector<String> data = new Vector<String>();
			for(CourbeBezier c : this.application.getCourbes()) {
				data.add("Ferme : \'"+!c.isOuvert()+"\', nombre de points "+c.getSommets().size());
			}
			data.add(0, "-");
			list.setListData(data);
			this.parent.setListCourbes(list);
		}
		if(iMessage == Application.MODIFY_COURBE_SELECTED || iMessage == Application.MODIFY_COURBES) {
			if (this.application.getCourbeSelected() != null ){
				this.list.setSelectedIndex(Integer.valueOf(branchToIndice(this.application.getCourbes(), this.application.getCourbeSelected())));
			}
			else {
				this.list.setSelectedIndex(0);
			}
			this.list.ensureIndexIsVisible(this.parent.getListCourbes().getSelectedIndex());
			this.list.repaint();
		}
	}

	public static int branchToIndice (Vector<CourbeBezier> courbes, CourbeBezier c) {
		boolean aret = false;
		int size = courbes.size();
		int i;
		for(i=0; i<size && !aret; i++) {
			aret = courbes.get(i).equals(c);
		}
		if (aret) {
			return i--;
		}
		else {
			return -1;
		}
	}	
}