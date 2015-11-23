package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;
import view.figures.EllipseView;

public class JControllerButtonFiguresEllipse implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	
	public JControllerButtonFiguresEllipse (MainView fenetre, boolean edition) {
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		EllipseView ev = new EllipseView(this.fenetre, this.edition);
		ev.setVisible(true);
	}
}