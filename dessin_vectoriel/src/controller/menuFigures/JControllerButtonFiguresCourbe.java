package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;
import view.figures.CourbeView;

public class JControllerButtonFiguresCourbe implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	
	public JControllerButtonFiguresCourbe (MainView fenetre, boolean edition) {
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CourbeView cv = new CourbeView(this.fenetre, this.edition);
		cv.setVisible(true);
	}
}