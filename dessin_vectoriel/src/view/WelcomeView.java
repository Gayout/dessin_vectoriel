package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.sauvegarde.JControllerSaveWelcome;

public class WelcomeView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int TITLE_SIZE = 25;
	public static final int CATEGORY_SIZE = 15;
	public static final int TEXT_SIZE = 20;
	
	private JTextField largeur;
	private JTextField hauteur;
	
	public WelcomeView () {
		super("Bienvenue");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		JPanel panelWelcome = new JPanel(new BorderLayout());
		
		JPanel panelCoordonnees = new JPanel();
		panelCoordonnees.setLayout(new BoxLayout(panelCoordonnees,BoxLayout.X_AXIS));
		JPanel panelX = new JPanel(new BorderLayout());
		JLabel x = new JLabel("Largeur (dx) ");
		x.setFont(new Font(x.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelX.add(x, BorderLayout.WEST);
		this.largeur = new JTextField(4);
		this.largeur.setFont(new Font(this.largeur.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		JPanel panelValeurX = new JPanel();
		panelValeurX.add(this.largeur);
		panelValeurX.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelX.add(panelValeurX, BorderLayout.CENTER);
		panelX.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		
		JPanel panelY = new JPanel(new BorderLayout());
		JLabel y = new JLabel("Hauteur (dy) ");
		y.setFont(new Font(y.getFont().getName(), Font.ITALIC, CATEGORY_SIZE));
		panelY.add(y, BorderLayout.WEST);
		this.hauteur = new JTextField(4);
		this.hauteur.setFont(new Font(this.hauteur.getFont().getName(), Font.PLAIN, TEXT_SIZE));
		JPanel panelValeurY = new JPanel();
		panelValeurY.add(this.hauteur);
		panelValeurY.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		panelY.add(panelValeurY, BorderLayout.CENTER);
		panelY.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		panelCoordonnees.add(panelX);
		panelCoordonnees.add(panelY);
		panelCoordonnees.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		JLabel titleD = new JLabel("Taille Image (Pixel)");
		titleD.setFont(new Font(titleD.getFont().getName(), Font.BOLD, TITLE_SIZE));
		panelWelcome.add(titleD, BorderLayout.NORTH);
		panelWelcome.add(panelCoordonnees, BorderLayout.CENTER);
		panelWelcome.setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
		
		panel.add(panelWelcome);
		
		JPanel panelContinuer = new JPanel();
		JButton continuer = new JButton("Continuer");
		this.getRootPane().setDefaultButton(continuer);
		panelContinuer.add(continuer);
		panelContinuer.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
		JControllerSaveWelcome controlWelcome = new JControllerSaveWelcome(this);
		continuer.addActionListener(controlWelcome);
		panel.add(panelContinuer);
		
		this.getContentPane().add(panel);
		this.setVisible(true);
		this.pack();
	}

	public JTextField getLargeur() {
		return largeur;
	}

	public void setLargeur(JTextField largeur) {
		this.largeur = largeur;
	}

	public JTextField getHauteur() {
		return hauteur;
	}

	public void setHauteur(JTextField hauteur) {
		this.hauteur = hauteur;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WelcomeView fenetre = new WelcomeView();
	}
}
