package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;
import view.figures.CarreView;

public class JControllerButtonFiguresCarre implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	
	public JControllerButtonFiguresCarre (MainView fenetre, boolean edition) {
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CarreView cv = new CarreView(this.fenetre, this.edition);
		cv.setVisible(true);
	}
}