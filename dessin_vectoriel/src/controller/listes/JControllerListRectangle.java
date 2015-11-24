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

public class JControllerListRectangle implements Observer, ListSelectionListener {
	private MainView parent;
	private JList<String> list;
	private Application application;
	private JButton mod;
	private JButton sup;

	public JControllerListRectangle(MainView parent, JList<String> list, Application application, JButton mod, JButton sup) {
		this.parent = parent;
		this.list = list;
		this.application = application;
		Vector<String> data = new Vector<String>();
		for(Rectangle r : this.application.getRectangles()) {
			data.add("Haut Gauche ("+r.getHautGauche().getX()+","+r.getHautGauche().getY()+") - largeur "+r.getWidth()+", hauteur "+r.getHeight());
		}
		data.add(0, "-");

		this.mod = mod;
		this.sup = sup;
		if (this.application.getRectangleSelected()==null) {
			this.mod.setEnabled(false);
			this.sup.setEnabled(false);
		}
		
		this.list.setListData(data);
		this.list.setSelectedIndex(0);
		this.parent.setListRectangles(list);
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if ((this.list.getSelectedIndex() != -1) && !((String)this.list.getSelectedValue()).equals("-")) {
			this.application.setRectangleSelected(this.application.getRectangles().get(this.list.getSelectedIndex() - 1));
			this.mod.setEnabled(true);
			this.sup.setEnabled(true);
		}
		else {
			if (this.list.getSelectedIndex() != -1) {
				this.application.setRectangleSelected(null);
				this.mod.setEnabled(false);
				this.sup.setEnabled(false);
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Integer iMessage = (Integer)arg1;
		if(iMessage == Application.MODIFY_RECTANGLES) {
			Vector<String> data = new Vector<String>();
			for(Rectangle r : this.application.getRectangles()) {
				data.add("Haut Gauche ("+r.getHautGauche().getX()+","+r.getHautGauche().getY()+") - largeur "+r.getWidth()+", hauteur "+r.getHeight());
			}
			data.add(0, "-");
			list.setListData(data);
			this.parent.setListRectangles(list);
		}
		if(iMessage == Application.MODIFY_RECTANGLE_SELECTED || iMessage == Application.MODIFY_RECTANGLES) {
			if (this.application.getRectangleSelected() != null ){
				this.list.setSelectedIndex(Integer.valueOf(branchToIndice(this.application.getRectangles(), this.application.getRectangleSelected())));
			}
			else {
				this.list.setSelectedIndex(0);
			}
			this.list.ensureIndexIsVisible(this.parent.getListRectangles().getSelectedIndex());
			this.list.repaint();
		}
	}

	public static int branchToIndice (Vector<Rectangle> rectangles, Rectangle r) {
		boolean aret = false;
		int size = rectangles.size();
		int i;
		for(i=0; i<size && !aret; i++) {
			aret = rectangles.get(i).equals(r);
		}
		if (aret) {
			return i--;
		}
		else {
			return -1;
		}
	}
}