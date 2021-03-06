package controller.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import controller.listes.JControllerListCourbe;
import view.MainView;

public class JControllerDeleteCourbe implements ActionListener {
	private MainView parent;
	private Application application;
	
	public JControllerDeleteCourbe (MainView parent, Application application) {
		this.parent = parent;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int choix = JOptionPane.showConfirmDialog(parent, "Confirmez-vous la suppression ?", "Supprimer", 0, 3);
		if(choix == 0) {
			try {
				int i = JControllerListCourbe.branchToIndice(this.application.getCourbes(), this.application.getCourbeSelected());
				this.application.removeDessin(this.application.getCourbes().get(i-1));
				this.application.removeCourbe(i-1);
				this.application.setCourbeSelected(null);
			}
			catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(parent, "Impossible de supprimer", "Error!", 0);
			}
		}
	}
}