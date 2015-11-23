package controller.menuFigures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;
import view.figures.SegmentView;

public class JControllerButtonFiguresSegment implements ActionListener {
	private MainView fenetre;
	private boolean edition;
	
	public JControllerButtonFiguresSegment (MainView fenetre, boolean edition) {
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SegmentView sv = new SegmentView(this.fenetre, this.edition);
		sv.setVisible(true);
	}
}