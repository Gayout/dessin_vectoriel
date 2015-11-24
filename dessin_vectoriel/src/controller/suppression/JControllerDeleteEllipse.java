package controller.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import controller.listes.JControllerListEllipse;
import view.MainView;

public class JControllerDeleteEllipse implements ActionListener {
	private MainView parent;
	private Application application;
	
	public JControllerDeleteEllipse (MainView parent, Application application) {
		this.parent = parent;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int choix = JOptionPane.showConfirmDialog(parent, "Confirmez-vous la suppression ?", "Supprimer", 0, 3);
		if(choix == 0) {
			try {
				int i = JControllerListEllipse.branchToIndice(this.application.getEllipses(), this.application.getEllipseSelected());
				this.application.removeEllipse(i-1);
				this.application.setEllipseSelected(null);
			}
			catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(parent, "Impossible de supprimer", "Error!", 0);
			}
		}
	}
}