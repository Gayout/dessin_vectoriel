package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abstraction.Application;
import view.MainView;
import view.figures.CourbeView;

public class JControllerButtonFiguresCourbe implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	private Application application;
	
	public JControllerButtonFiguresCourbe (MainView fenetre, boolean edition, Application application) {
		this.fenetre = fenetre;
		this.edition = edition;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CourbeView cv = new CourbeView(this.fenetre, this.edition, this.application);
		cv.setVisible(true);
	}
}