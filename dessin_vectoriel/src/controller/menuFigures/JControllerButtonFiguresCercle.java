package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;
import view.figures.CercleView;

public class JControllerButtonFiguresCercle implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	
	public JControllerButtonFiguresCercle (MainView fenetre, boolean edition) {
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CercleView cv = new CercleView(this.fenetre, this.edition);
		cv.setVisible(true);
	}
}