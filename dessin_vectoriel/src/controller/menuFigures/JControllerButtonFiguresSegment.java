package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abstraction.Application;
import view.MainView;
import view.figures.SegmentView;

public class JControllerButtonFiguresSegment implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	private Application application;
	
	public JControllerButtonFiguresSegment (MainView fenetre, boolean edition, Application application) {
		this.fenetre = fenetre;
		this.application = application;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SegmentView sv = new SegmentView(this.fenetre, this.edition, this.application);
		sv.setVisible(true);
	}
}