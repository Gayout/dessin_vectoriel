package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abstraction.Application;
import view.MainView;
import view.figures.CarreView;

public class JControllerButtonFiguresCarre implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	private Application application;
	
	public JControllerButtonFiguresCarre (MainView fenetre, boolean edition, Application application) {
		this.fenetre = fenetre;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CarreView cv = new CarreView(this.fenetre, this.edition, this.application);
		cv.setVisible(true);
	}
}