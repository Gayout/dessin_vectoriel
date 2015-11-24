package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abstraction.Application;
import view.MainView;
import view.figures.CercleView;

public class JControllerButtonFiguresCercle implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	private Application application;
	
	public JControllerButtonFiguresCercle (MainView fenetre, boolean edition, Application application) {
		this.fenetre = fenetre;
		this.edition = edition;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CercleView cv = new CercleView(this.fenetre, this.edition, this.application);
		cv.setVisible(true);
	}
}