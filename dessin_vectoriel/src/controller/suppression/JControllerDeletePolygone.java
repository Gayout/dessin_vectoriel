package controller.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import controller.listes.JControllerListPolygone;
import view.MainView;

public class JControllerDeletePolygone implements ActionListener {
	private MainView parent;
	private Application application;
	
	public JControllerDeletePolygone (MainView parent, Application application) {
		this.parent = parent;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int choix = JOptionPane.showConfirmDialog(parent, "Confirmez-vous la suppression ?", "Supprimer", 0, 3);
		if(choix == 0) {
			try {
				int i = JControllerListPolygone.branchToIndice(this.application.getPolygones(), this.application.getPolygoneSelected());
				this.application.removeDessin(this.application.getPolygones().get(i-1));
				this.application.removePolygone(i-1);
				this.application.setPolygoneSelected(null);
			}
			catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(parent, "Impossible de supprimer", "Error!", 0);
			}
		}
	}
}