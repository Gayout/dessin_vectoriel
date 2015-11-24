package controller.listes;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import abstraction.Application;
import implementation.Rectangle;
import view.MainView;

public class JControllerListCarre implements Observer, ListSelectionListener {
	private MainView parent;
	private JList<String> list;
	private Application application;
	private JButton mod;
	private JButton sup;

	public JControllerListCarre(MainView parent, JList<String> list, Application application, JButton mod, JButton sup) {
		this.parent = parent;
		this.list = list;
		this.application = application;
		Vector<String> data = new Vector<String>();
		for(Rectangle c : this.application.getCarres()) {
			data.add("Haut Gauche ("+c.getHautGauche().getX()+","+c.getHautGauche().getY()+") - coté "+c.getWidth());
		}
		data.add(0, "-");

		this.mod = mod;
		this.sup = sup;
		
		if(this.application.getCarreSelected()==null) {
			this.mod.setEnabled(false);
			this.sup.setEnabled(false);
		}
		
		this.list.setListData(data);
		this.list.setSelectedIndex(0);
		this.parent.setListCarres(list);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if ((this.list.getSelectedIndex() != -1) && !((String)this.list.getSelectedValue()).equals("-")) {
			this.application.setCarreSelected(this.application.getCarres().get(this.list.getSelectedIndex() - 1));
			this.mod.setEnabled(true);
			this.sup.setEnabled(true);
		}
		else {
			if (this.list.getSelectedIndex() != -1) {
				this.application.setCarreSelected(null);
				this.mod.setEnabled(false);
				this.sup.setEnabled(false);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Integer iMessage = (Integer)arg1;
		if(iMessage == Application.MODIFY_CARRES) {
			Vector<String> data = new Vector<String>();
			for(Rectangle c : this.application.getCarres()) {
				data.add("Haut Gauche ("+c.getHautGauche().getX()+","+c.getHautGauche().getY()+") - coté "+c.getWidth());
			}
			data.add(0, "-");
			list.setListData(data);
			this.parent.setListCarres(list);
		}
		if(iMessage == Application.MODIFY_CARRE_SELECTED || iMessage == Application.MODIFY_CARRES) {
			if (this.application.getCarreSelected() != null ){
				this.list.setSelectedIndex(Integer.valueOf(branchToIndice(this.application.getCarres(), this.application.getCarreSelected())));
			}
			else {
				this.list.setSelectedIndex(0);
			}
			this.list.ensureIndexIsVisible(this.parent.getListCarres().getSelectedIndex());
			this.list.repaint();
		}
	}

	public static int branchToIndice (Vector<Rectangle> carres, Rectangle c) {
		boolean aret = false;
		int size = carres.size();
		int i;
		for(i=0; i<size && !aret; i++) {
			aret = carres.get(i).equals(c);
		}
		if (aret) {
			return i--;
		}
		else {
			return -1;
		}
	}
}