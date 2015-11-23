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

import controller.sauvegarde.JControllerSaveCarre;
import view.MainView;

public class CarreView extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int TITLE_SIZE = 25;
	public static final int CATEGORY_SIZE = 15;
	public static final int TEXT_SIZE = 20;
	
	private JTextField xG;
	private JTextField yG;
	private JTextField cote;
	private JCheckBox rempli;
	
	public CarreView (MainView parent, boolean edition) {
		super(parent, "Créer un carré", true);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		JPanel panelCarre = new JPanel();
		panelCarre.setLayout(new BoxLayout(panelCarre,BoxLayout.Y_AXIS));
		
		JPanel panelCote = new JPanel(new BorderLayout());
		JLabel titleC = new JLabel("Coté ");
		titleC.setFont(new Font(titleC.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelCote.add(titleC, BorderLayout.WEST);
		this.cote = new JTextField(4);
		this.cote.setFont(new Font(this.cote.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		JPanel panelValeurC = new JPanel();
		panelValeurC.add(this.cote);
		panelValeurC.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		panelCote.add(panelValeurC, BorderLayout.CENTER);
		panelCote.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 5));
		
		JPanel panelGauche = new JPanel(new BorderLayout());
		JPanel panelCoordonnees = new JPanel();
		panelCoordonnees.setLayout(new BoxLayout(panelCoordonnees,BoxLayout.X_AXIS));
		JPanel panelX = new JPanel(new BorderLayout());
		JLabel x = new JLabel("Abscisse ");
		x.setFont(new Font(x.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelX.add(x, BorderLayout.WEST);
		this.xG = new JTextField(4);
		this.xG.setFont(new Font(this.xG.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		JPanel panelValeurX = new JPanel();
		panelValeurX.add(this.xG);
		panelValeurX.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelX.add(panelValeurX, BorderLayout.CENTER);
		panelX.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		
		JPanel panelY = new JPanel(new BorderLayout());
		JLabel y = new JLabel("Ordonnée ");
		y.setFont(new Font(y.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelY.add(y, BorderLayout.WEST);
		this.yG = new JTextField(4);
		this.yG.setFont(new Font(this.yG.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		JPanel panelValeurY = new JPanel();
		panelValeurY.add(this.yG);
		panelValeurY.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelY.add(panelValeurY, BorderLayout.CENTER);
		panelY.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panelCoordonnees.add(panelX);
		panelCoordonnees.add(panelY);
		panelCoordonnees.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		JLabel titleG = new JLabel("Coordonnées haut gauche");
		titleG.setFont(new Font(titleG.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelGauche.add(titleG, BorderLayout.NORTH);
		panelGauche.add(panelCoordonnees, BorderLayout.CENTER);
		panelGauche.setBorder(BorderFactory.createEmptyBorder(5, 5, 20, 5));
		
		JPanel panelRempli = new JPanel(new BorderLayout());
		JLabel titleR = new JLabel("Figure ");
		titleR.setFont(new Font(titleR.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelRempli.add(titleR, BorderLayout.WEST);
		this.rempli = new JCheckBox("remplie");
		this.rempli.setFont(new Font(this.rempli.getFont().getName(), Font.ITALIC, TEXT_SIZE));
		JPanel panelValeurR = new JPanel();
		panelValeurR.add(this.rempli);
		panelValeurR.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		panelRempli.add(panelValeurR, BorderLayout.CENTER);
		panelRempli.setBorder(BorderFactory.createEmptyBorder(15, 5, 15, 5));
		
		panel.add(panelCote);
		panel.add(panelGauche);
		panel.add(panelRempli);
		
		JPanel panelSave = new JPanel();
		JButton save = new JButton("Enregistrer");
		JControllerSaveCarre controlCarre = new JControllerSaveCarre(parent, this, this.rempli.isSelected());
		save.addActionListener(controlCarre);
		this.getRootPane().setDefaultButton(save);
		panelSave.add(save);
		panelSave.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
		panel.add(panelSave);
		
		this.getContentPane().add(panel);
		this.pack();
		super.setLocationRelativeTo(parent);
	}

	public JTextField getxG() {
		return xG;
	}

	public void setxG(JTextField xG) {
		this.xG = xG;
	}

	public JTextField getyG() {
		return yG;
	}

	public void setyG(JTextField yG) {
		this.yG = yG;
	}

	public JTextField getCote() {
		return cote;
	}

	public void setCote(JTextField cote) {
		this.cote = cote;
	}
}