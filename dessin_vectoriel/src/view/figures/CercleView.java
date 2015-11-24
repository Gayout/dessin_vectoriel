package view.figures;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

import abstraction.Application;
import controller.sauvegarde.JControllerSaveCercle;
import implementation.Cercle;
import view.MainView;

public class CercleView extends JDialog {
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
	private JTextField r;
	private JCheckBox rempli;
	
	public CercleView (MainView parent, boolean edition, Application application) {
		super(parent, "Créer un cercle", true);
		
		this.application = application;
		
		this.r = new JTextField(4);
		this.r.setFont(new Font(this.r.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		this.xC = new JTextField(4);
		this.xC.setFont(new Font(this.xC.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		this.yC = new JTextField(4);
		this.yC.setFont(new Font(this.yC.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		this.rempli = new JCheckBox("remplie");
		this.rempli.setFont(new Font(this.rempli.getFont().getName(), Font.ITALIC, TEXT_SIZE));
		
		if (edition) {
			Cercle cAncien = this.application.getCercleSelected();
			int rAncien = cAncien.getRayon();
			int xCAncien = cAncien.getCentre().getX();
			int yCAncien = cAncien.getCentre().getY();
			boolean rempliAncien = cAncien.isRempli();
			
			this.r.setText(""+rAncien);
			this.xC.setText(""+xCAncien);
			this.yC.setText(""+yCAncien);
			this.rempli.setSelected(rempliAncien);
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		JPanel panelCercle = new JPanel();
		panelCercle.setLayout(new BoxLayout(panelCercle,BoxLayout.Y_AXIS));
		
		JPanel panelRayon = new JPanel(new BorderLayout());
		JLabel titleR = new JLabel("Rayon ");
		titleR.setFont(new Font(titleR.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelRayon.add(titleR, BorderLayout.WEST);
		
		JPanel panelValeurR = new JPanel();
		panelValeurR.add(this.r);
		panelValeurR.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		panelRayon.add(panelValeurR, BorderLayout.CENTER);
		panelRayon.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 5));
		
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
		panelCentre.setBorder(BorderFactory.createEmptyBorder(5, 5, 20, 5));
		
		JPanel panelRempli = new JPanel(new BorderLayout());
		JLabel titleRe = new JLabel("Figure ");
		titleRe.setFont(new Font(titleRe.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelRempli.add(titleRe, BorderLayout.WEST);
		
		JPanel panelValeurRe = new JPanel();
		panelValeurRe.add(this.rempli);
		panelValeurRe.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		panelRempli.add(panelValeurRe, BorderLayout.CENTER);
		panelRempli.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 5));
		
		panel.add(panelRayon);
		panel.add(panelCentre);
		panel.add(panelRempli);
		
		JPanel panelSave = new JPanel();
		JButton save = new JButton("Enregistrer");
		JControllerSaveCercle controlCercle = new JControllerSaveCercle(this.application, this, this.rempli.isSelected(), edition);
		save.addActionListener(controlCercle);
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

	public JTextField getR() {
		return r;
	}

	public void setR(JTextField r) {
		this.r = r;
	}
	
}