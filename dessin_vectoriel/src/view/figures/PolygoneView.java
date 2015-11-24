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
import controller.menuFigures.JControllerButtonContinuePolygone;
import implementation.Polygone;
import view.MainView;

public class PolygoneView extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int TITLE_SIZE = 25;
	public static final int CATEGORY_SIZE = 15;
	public static final int TEXT_SIZE = 20;

	private Application application;
	private JTextField nombrePoints;
	private JCheckBox ferme;
	private JCheckBox rempli;

	public PolygoneView (MainView parent, boolean edition, Application application) {
		super(parent, "Créer un polygone", true);
		
		this.application = application;
		
		this.ferme = new JCheckBox("fermée");
		this.ferme.setFont(new Font(this.ferme.getFont().getName(), Font.ITALIC, TEXT_SIZE));
		
		this.nombrePoints = new JTextField(2);
		this.nombrePoints.setFont(new Font(this.nombrePoints.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		
		this.rempli = new JCheckBox("remplie");
		this.rempli.setFont(new Font(this.rempli.getFont().getName(), Font.ITALIC, TEXT_SIZE));
		
		if (edition) {
			Polygone pAncien = this.application.getPolygoneSelected();
			boolean fermeAncien = !pAncien.isOuvert();
			boolean rempliAncien = pAncien.isRempli();
			int nbrePointsAncien = pAncien.getSommets().size();
			
			this.ferme.setSelected(fermeAncien);
			this.rempli.setSelected(rempliAncien);
			this.nombrePoints.setText(""+nbrePointsAncien);
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

		JPanel panelFerme = new JPanel(new BorderLayout());
		JLabel titleF = new JLabel("Figure ");
		titleF.setFont(new Font(titleF.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelFerme.add(titleF, BorderLayout.WEST);
		
		JPanel panelValeurF = new JPanel();
		panelValeurF.add(this.ferme);
		panelValeurF.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		panelFerme.add(panelValeurF, BorderLayout.CENTER);
		panelFerme.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 5));
		
		JPanel panelPoints = new JPanel(new BorderLayout());
		JLabel titleP = new JLabel("Nombre de points ");
		titleP.setFont(new Font(titleP.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelPoints.add(titleP, BorderLayout.WEST);
		
		JPanel panelValeurP = new JPanel();
		panelValeurP.add(this.nombrePoints);
		panelValeurP.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		panelPoints.add(panelValeurP, BorderLayout.CENTER);
		panelPoints.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 5));
		
		JPanel panelRempli = new JPanel(new BorderLayout());
		JLabel titleR = new JLabel("Figure ");
		titleR.setFont(new Font(titleR.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelRempli.add(titleR, BorderLayout.WEST);
		
		JPanel panelValeurR = new JPanel();
		panelValeurR.add(this.rempli);
		panelValeurR.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		panelRempli.add(panelValeurR, BorderLayout.CENTER);
		panelRempli.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 5));
		
		panel.add(panelFerme);
		panel.add(panelPoints);
		panel.add(panelRempli);
		
		JPanel panelContinuer = new JPanel();
		JButton continuer = new JButton("Continuer");
		this.getRootPane().setDefaultButton(continuer);
		JControllerButtonContinuePolygone controlPolygone = new JControllerButtonContinuePolygone(this.application, this, edition, this.rempli.isSelected(), this.ferme.isSelected());
		continuer.addActionListener(controlPolygone);
		
		panelContinuer.add(continuer);
		panelContinuer.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
		panel.add(panelContinuer);
		
		this.getContentPane().add(panel);
		this.pack();
		super.setLocationRelativeTo(parent);
	}

	public JTextField getNombrePoints() {
		return nombrePoints;
	}

	public void setNombrePoints(JTextField nombrePoints) {
		this.nombrePoints = nombrePoints;
	}

	public JCheckBox getFerme() {
		return ferme;
	}

	public void setFerme(JCheckBox ferme) {
		this.ferme = ferme;
	}
}