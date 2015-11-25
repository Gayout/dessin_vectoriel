package controller.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import controller.listes.JControllerListRectangle;
import view.MainView;

public class JControllerDeleteRectangle implements ActionListener {
	private MainView parent;
	private Application application;
	
	public JControllerDeleteRectangle (MainView parent, Application application) {
		this.parent = parent;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int choix = JOptionPane.showConfirmDialog(parent, "Confirmez-vous la suppression ?", "Supprimer", 0, 3);
		if(choix == 0) {
			try {
				int i = JControllerListRectangle.branchToIndice(this.application.getRectangles(), this.application.getRectangleSelected());
				this.application.removeDessin(this.application.getRectangles().get(i-1));
				this.application.removeRectangle(i-1);
				this.application.setRectangleSelected(null);
			}
			catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(parent, "Impossible de supprimer", "Error!", 0);
			}
		}
	}
}
