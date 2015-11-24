package view.figures;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import abstraction.Application;
import controller.sauvegarde.JControllerSaveSegment;
import implementation.Segment;
import view.MainView;

public class SegmentView extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int TITLE_SIZE = 25;
	public static final int CATEGORY_SIZE = 15;
	public static final int TEXT_SIZE = 20;
	
	private Application application;
	private JTextField xD;
	private JTextField yD;
	private JTextField xA;
	private JTextField yA;
	
	public SegmentView (MainView parent, boolean edition, Application application) {
		super(parent, "Créer un trait", true);
		
		this.application = application;
		
		this.xD = new JTextField(4);
		this.xD.setFont(new Font(this.xD.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		this.yD = new JTextField(4);
		this.yD.setFont(new Font(this.yD.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		this.xA = new JTextField(4);
		this.xA.setFont(new Font(this.xA.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		this.yA = new JTextField(4);
		this.yA.setFont(new Font(this.yA.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		if (edition) {
			Segment sAncien = this.application.getSegmentSelected();
			int xDAncien = sAncien.getDepart().getX();
			int yDAncien = sAncien.getDepart().getY();
			int xAAncien = sAncien.getArrivee().getX();
			int yAAncien = sAncien.getArrivee().getY();
			
			this.xD.setText(""+xDAncien);
			this.yD.setText(""+yDAncien);
			this.xA.setText(""+xAAncien);
			this.yA.setText(""+yAAncien);
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		JPanel panelSegment = new JPanel();
		panelSegment.setLayout(new BoxLayout(panelSegment,BoxLayout.Y_AXIS));
		
		JPanel panelDepart = new JPanel(new BorderLayout());
		JPanel panelCoordonneesD = new JPanel();
		panelCoordonneesD.setLayout(new BoxLayout(panelCoordonneesD,BoxLayout.X_AXIS));
		JPanel panelXD = new JPanel(new BorderLayout());
		JLabel xD = new JLabel("Abscisse ");
		xD.setFont(new Font(xD.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelXD.add(xD, BorderLayout.WEST);
		
		JPanel panelValeurX = new JPanel();
		panelValeurX.add(this.xD);
		panelValeurX.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelXD.add(panelValeurX, BorderLayout.CENTER);
		panelXD.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		
		JPanel panelYD = new JPanel(new BorderLayout());
		JLabel yD = new JLabel("Ordonnée ");
		yD.setFont(new Font(yD.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelYD.add(yD, BorderLayout.WEST);
		
		JPanel panelValeurYD = new JPanel();
		panelValeurYD.add(this.yD);
		panelValeurYD.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelYD.add(panelValeurYD, BorderLayout.CENTER);
		panelYD.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panelCoordonneesD.add(panelXD);
		panelCoordonneesD.add(panelYD);
		panelCoordonneesD.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		JLabel titleD = new JLabel("Coordonnées départ");
		titleD.setFont(new Font(titleD.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelDepart.add(titleD, BorderLayout.NORTH);
		panelDepart.add(panelCoordonneesD, BorderLayout.CENTER);
		panelDepart.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
		
		JPanel panelArrivee = new JPanel(new BorderLayout());
		JPanel panelCoordonneesA = new JPanel();
		panelCoordonneesA.setLayout(new BoxLayout(panelCoordonneesA,BoxLayout.X_AXIS));
		JPanel panelXA = new JPanel(new BorderLayout());
		JLabel xA = new JLabel("Abscisse ");
		xA.setFont(new Font(xA.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelXA.add(xA, BorderLayout.WEST);
		
		JPanel panelValeurXA = new JPanel();
		panelValeurXA.add(this.xA);
		panelValeurXA.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelXA.add(panelValeurXA, BorderLayout.CENTER);
		panelXA.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		
		JPanel panelYA = new JPanel(new BorderLayout());
		JLabel yA = new JLabel("Ordonnée ");
		yA.setFont(new Font(yA.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelYA.add(yA, BorderLayout.WEST);
	
		JPanel panelValeurYA = new JPanel();
		panelValeurYA.add(this.yA);
		panelValeurYA.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelYA.add(panelValeurYA, BorderLayout.CENTER);
		panelYA.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panelCoordonneesA.add(panelXA);
		panelCoordonneesA.add(panelYA);
		panelCoordonneesA.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		JLabel titleA = new JLabel("Coordonnées arrivée");
		titleA.setFont(new Font(titleA.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelArrivee.add(titleA, BorderLayout.NORTH);
		panelArrivee.add(panelCoordonneesA, BorderLayout.CENTER);
		panelArrivee.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
		
		panel.add(panelDepart);
		panel.add(panelArrivee);
		
		JPanel panelSave = new JPanel();
		JButton save = new JButton("Enregistrer");
		this.getRootPane().setDefaultButton(save);
		JControllerSaveSegment saveSegment = new JControllerSaveSegment(this, application, edition);
		save.addActionListener(saveSegment);
		panelSave.add(save);
		panelSave.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
		panel.add(panelSave);
		
		this.getContentPane().add(panel);
		this.pack();
		super.setLocationRelativeTo(parent);
	}

	public JTextField getxD() {
		return xD;
	}

	public void setxD(JTextField xD) {
		this.xD = xD;
	}

	public JTextField getyD() {
		return yD;
	}

	public void setyD(JTextField yD) {
		this.yD = yD;
	}

	public JTextField getxA() {
		return xA;
	}

	public void setxA(JTextField xA) {
		this.xA = xA;
	}

	public JTextField getyA() {
		return yA;
	}

	public void setyA(JTextField yA) {
		this.yA = yA;
	}
}
