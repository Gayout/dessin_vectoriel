package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;
import view.figures.PolygoneView;

public class JControllerButtonFiguresPolygone implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	
	public JControllerButtonFiguresPolygone (MainView fenetre, boolean edition) {
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PolygoneView pv = new PolygoneView(this.fenetre, this.edition);
		pv.setVisible(true);
	}
}