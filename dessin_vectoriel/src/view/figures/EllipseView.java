package view.figures;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import abstraction.Application;
import controller.sauvegarde.JControllerSaveEllipse;
import implementation.Ellipse;
import view.MainView;

public class EllipseView extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int TITLE_SIZE = 25;
	public static final int CATEGORY_SIZE = 15;
	public static final int TEXT_SIZE = 20;
	
	private Application application;
	private JTextField xC;
	private JTextField yC;
	private JTextField gdAxe;
	private JTextField ptiAxe;
	private JTextField angle;
	private JCheckBox rempli;
	
	public EllipseView (MainView parent, boolean edition, Application application) {
		super(parent, "Créer une ellipse", true);
		
		this.application = application;
		
		this.gdAxe = new JTextField(4);
		this.gdAxe.setFont(new Font(this.gdAxe.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		this.ptiAxe = new JTextField(4);
		this.ptiAxe.setFont(new Font(this.ptiAxe.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		this.yC = new JTextField(4);
		this.yC.setFont(new Font(this.yC.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		this.xC = new JTextField(4);
		this.xC.setFont(new Font(this.xC.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		this.angle = new JTextField(3);
		this.angle.setFont(new Font(this.angle.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		this.rempli = new JCheckBox("remplie");
		this.rempli.setFont(new Font(this.rempli.getFont().getName(), Font.ITALIC, TEXT_SIZE));
		
		if (edition) {
			Ellipse eAncien = this.application.getEllipseSelected();
			int gdAxeAncien = eAncien.getGdAxe();
			int ptiAxeAncien = eAncien.getPetitAxe();
			int xCAncien = eAncien.getCentre().getX();
			int yCAncien = eAncien.getCentre().getY();
			long angleAncien = eAncien.getAngleAbsGdAxe();
			boolean rempliAncien = eAncien.isRempli();
			
			this.gdAxe.setText(""+gdAxeAncien);
			this.ptiAxe.setText(""+ptiAxeAncien);
			this.xC.setText(""+xCAncien);
			this.yC.setText(""+yCAncien);
			this.angle.setText(""+angleAncien);
			this.rempli.setSelected(rempliAncien);
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		JPanel panelEllipse = new JPanel();
		panelEllipse.setLayout(new BoxLayout(panelEllipse,BoxLayout.Y_AXIS));
		
		JPanel panelAxes = new JPanel(new BorderLayout());
		JPanel panelCoordonneesA = new JPanel();
		panelCoordonneesA.setLayout(new BoxLayout(panelCoordonneesA,BoxLayout.X_AXIS));
		JPanel panelGd = new JPanel(new BorderLayout());
		JLabel gd = new JLabel("Grand axe ");
		gd.setFont(new Font(gd.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelGd.add(gd, BorderLayout.WEST);
		
		JPanel panelValeurGd = new JPanel();
		panelValeurGd.add(this.gdAxe);
		panelValeurGd.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelGd.add(panelValeurGd, BorderLayout.CENTER);
		panelGd.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		
		JPanel panelPti = new JPanel(new BorderLayout());
		JLabel pti = new JLabel("Petit axe ");
		pti.setFont(new Font(pti.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelPti.add(pti, BorderLayout.WEST);
		
		JPanel panelValeurPti = new JPanel();
		panelValeurPti.add(this.ptiAxe);
		panelValeurPti.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelPti.add(panelValeurPti, BorderLayout.CENTER);
		panelPti.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panelCoordonneesA.add(panelGd);
		panelCoordonneesA.add(panelPti);
		panelCoordonneesA.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		JLabel titleA = new JLabel("Axes ");
		titleA.setFont(new Font(titleA.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelAxes.add(titleA, BorderLayout.NORTH);
		panelAxes.add(panelCoordonneesA, BorderLayout.CENTER);
		panelAxes.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
		
		JPanel panelCentre = new JPanel(new BorderLayout());
		JPanel panelCoordonnees = new JPanel();
		panelCoordonnees.setLayout(new BoxLayout(panelCoordonnees,BoxLayout.X_AXIS));
		JPanel panelX = new JPanel(new BorderLayout());
		JLabel x = new JLabel("Abscisse ");
		x.setFont(new Font(x.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelX.add(x, BorderLayout.WEST);
	
		JPanel panelValeurX = new JPanel();
		panelValeurX.add(this.xC);
		panelValeurX.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelX.add(panelValeurX, BorderLayout.CENTER);
		panelX.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		
		JPanel panelY = new JPanel(new BorderLayout());
		JLabel y = new JLabel("Ordonnée ");
		y.setFont(new Font(y.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelY.add(y, BorderLayout.WEST);
	
		JPanel panelValeurY = new JPanel();
		panelValeurY.add(this.yC);
		panelValeurY.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelY.add(panelValeurY, BorderLayout.CENTER);
		panelY.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panelCoordonnees.add(panelX);
		panelCoordonnees.add(panelY);
		panelCoordonnees.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		JLabel titleC = new JLabel("Coordonnées du centre");
		titleC.setFont(new Font(titleC.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelCentre.add(titleC, BorderLayout.NORTH);
		panelCentre.add(panelCoordonnees, BorderLayout.CENTER);
		panelCentre.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
		
		JPanel panelAngle = new JPanel(new BorderLayout());
		JLabel titleD = new JLabel("Angle GdAxe / Absc. ");
		titleD.setFont(new Font(titleD.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelAngle.add(titleD, BorderLayout.WEST);
		JLabel titleDe = new JLabel("°");
		titleDe.setFont(new Font(titleDe.getFont().getName(), Font.BOLD, TEXT_SIZE));
		panelAngle.add(titleDe, BorderLayout.EAST);
		
		JPanel panelValeurD = new JPanel();
		panelValeurD.add(this.angle);
		panelValeurD.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		panelAngle.add(panelValeurD, BorderLayout.CENTER);
		panelAngle.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
		
		JPanel panelRempli = new JPanel(new BorderLayout());
		JLabel titleR = new JLabel("Figure ");
		titleR.setFont(new Font(titleR.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelRempli.add(titleR, BorderLayout.WEST);
		
		JPanel panelValeurR = new JPanel();
		panelValeurR.add(this.rempli);
		panelValeurR.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		panelRempli.add(panelValeurR, BorderLayout.CENTER);
		panelRempli.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 5));
		
		panel.add(panelAxes);
		panel.add(panelCentre);
		panel.add(panelAngle);
		panel.add(panelRempli);
		
		JPanel panelSave = new JPanel();
		JButton save = new JButton("Enregistrer");
		JControllerSaveEllipse controlEllipse = new JControllerSaveEllipse(this.application, this, this.rempli.isSelected(), edition);
		save.addActionListener(controlEllipse);
		this.getRootPane().setDefaultButton(save);
		panelSave.add(save);
		panelSave.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
		panel.add(panelSave);
		
		this.getContentPane().add(panel);
		this.pack();
		super.setLocationRelativeTo(parent);
	}

	public JTextField getxC() {
		return xC;
	}

	public void setxC(JTextField xC) {
		this.xC = xC;
	}

	public JTextField getyC() {
		return yC;
	}

	public void setyC(JTextField yC) {
		this.yC = yC;
	}

	public JTextField getGdAxe() {
		return gdAxe;
	}

	public void setGdAxe(JTextField gdAxe) {
		this.gdAxe = gdAxe;
	}

	public JTextField getPtiAxe() {
		return ptiAxe;
	}

	public void setPtiAxe(JTextField ptiAxe) {
		this.ptiAxe = ptiAxe;
	}

	public JTextField getAngle() {
		return angle;
	}

	public void setAngle(JTextField angle) {
		this.angle = angle;
	}
}