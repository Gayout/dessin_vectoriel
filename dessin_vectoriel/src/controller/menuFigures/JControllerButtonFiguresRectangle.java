package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;
import view.figures.RectangleView;

public class JControllerButtonFiguresRectangle implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	
	public JControllerButtonFiguresRectangle (MainView fenetre, boolean edition) {
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		RectangleView rv = new RectangleView(this.fenetre, this.edition);
		rv.setVisible(true);
	}
}