package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abstraction.Application;
import view.MainView;
import view.figures.EllipseView;

public class JControllerButtonFiguresEllipse implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	private Application application;
	
	public JControllerButtonFiguresEllipse (MainView fenetre, boolean edition, Application application) {
		this.fenetre = fenetre;
		this.edition = edition;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		EllipseView ev = new EllipseView(this.fenetre, this.edition, this.application);
		ev.setVisible(true);
	}
}