package controller.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import controller.listes.JControllerListCercle;
import view.MainView;

public class JControllerDeleteCercle implements ActionListener {
	private MainView parent;
	private Application application;
	
	public JControllerDeleteCercle (MainView parent, Application application) {
		this.parent = parent;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int choix = JOptionPane.showConfirmDialog(parent, "Confirmez-vous la suppression ?", "Supprimer", 0, 3);
		if(choix == 0) {
			try {
				int i = JControllerListCercle.branchToIndice(this.application.getCercles(), this.application.getCercleSelected());
				this.application.removeDessin(this.application.getCercles().get(i-1));
				this.application.removeCercle(i-1);
				this.application.setCercleSelected(null);
			}
			catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(parent, "Impossible de supprimer", "Error!", 0);
			}
		}
	}
}