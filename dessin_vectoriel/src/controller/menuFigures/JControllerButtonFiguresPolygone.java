package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abstraction.Application;
import view.MainView;
import view.figures.PolygoneView;

public class JControllerButtonFiguresPolygone implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	private Application application;
	
	public JControllerButtonFiguresPolygone (MainView fenetre, boolean edition, Application application) {
		this.fenetre = fenetre;
		this.edition = edition;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PolygoneView pv = new PolygoneView(this.fenetre, this.edition, this.application);
		pv.setVisible(true);
	}
}