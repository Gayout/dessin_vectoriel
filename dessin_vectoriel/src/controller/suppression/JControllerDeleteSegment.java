package controller.suppression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import abstraction.Application;
import controller.listes.JControllerListSegment;
import view.MainView;

public class JControllerDeleteSegment implements ActionListener {
	private MainView parent;
	private Application application;
	
	public JControllerDeleteSegment (MainView parent, Application application) {
		this.parent = parent;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int choix = JOptionPane.showConfirmDialog(parent, "Confirmez-vous la suppression ?", "Supprimer", 0, 3);
		if(choix == 0) {
			try {
				int i = JControllerListSegment.branchToIndice(this.application.getSegments(), this.application.getSegmentSelected());
				this.application.removeDessin(this.application.getSegments().get(i-1));
				this.application.removeSegment(i-1);
				this.application.setSegmentSelected(null);
			}
			catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(parent, "Impossible de supprimer", "Error!", 0);
			}
		}
	}
}
