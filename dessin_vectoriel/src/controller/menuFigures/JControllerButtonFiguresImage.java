package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;
import view.figures.ImageView;

public class JControllerButtonFiguresImage implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	
	public JControllerButtonFiguresImage (MainView fenetre, boolean edition) {
		this.fenetre = fenetre;
		this.edition = edition;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ImageView iv = new ImageView(fenetre, false);
		iv.setVisible(true);
	}
}