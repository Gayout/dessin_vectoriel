package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abstraction.Application;
import view.MainView;
import view.figures.TextView;

public class JControllerButtonFiguresText implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	private Application application;
	
	public JControllerButtonFiguresText (MainView fenetre, boolean edition, Application application) {
		this.fenetre = fenetre;
		this.edition = edition;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		TextView iv = new TextView(this.fenetre, this.edition, this.application);
		iv.setVisible(true);
	}
}