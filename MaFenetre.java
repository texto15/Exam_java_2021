import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MaFenetre extends JFrame {
	
	JPanel pan1;
	JPanel panBouton;
	JLabel label;
	JLabel label2;
	ZoneDessin dessin=new ZoneDessin(); 
	
	public MaFenetre() { //On initialise tout les parametres de la fenetre
		this.setTitle("Dessin");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan1=new JPanel();
		panBouton=creeBoutons();
		this.setContentPane(pan1);
		pan1.setLayout(new BorderLayout());
		label=new JLabel("TP4");
		pan1.add(label, BorderLayout.NORTH);
		pan1.add(dessin, BorderLayout.CENTER);
		pan1.add(panBouton, BorderLayout.SOUTH);
		this.setVisible(true);
		}

	private JPanel creeBoutons() {
		// cr�� un panel avec des �l�ments align�s � gauche
		final JPanel panel =new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		// cr�ation du bouton ajouter
		final JButton ajouter = new JButton("+");
		final JButton trier = new JButton("Tri");
		final JButton retirer = new JButton("-");
		final JRadioButton cercle = new JRadioButton("Cercle");//On cr�e les boutons radio
		final JRadioButton carre = new JRadioButton("Carre");
		final ButtonGroup groupe = new ButtonGroup();//On les ajoute au bouton groupe pour qu'un se d�sactive lorsque l'autre s'active
		groupe.add(cercle);
		groupe.add(carre);
		// cr�ation d�une action pour ajouter dans la liste
		ActionAjouter actionAjout = new ActionAjouter(dessin);
		ActionTrier actionTri = new ActionTrier(dessin);
		ActionRetirer actionRetir = new ActionRetirer(dessin);
		ActionCercle actionCercle = new ActionCercle(dessin);//On d�finit les actions des boutons radios
		ActionCarre actionCarre = new ActionCarre(dessin);
		// affectation de cette action au bouton
		ajouter.addActionListener(actionAjout);
		trier.addActionListener(actionTri);
		retirer.addActionListener(actionRetir);
		cercle.addActionListener(actionCercle);
		carre.addActionListener(actionCarre);
		// ajout du bouton dans la fenetre
		panel.add(ajouter);
		panel.add(trier);
		panel.add(retirer);
		panel.add(cercle);
		panel.add(carre);
		return panel;
		}
	
	

	public static void main(String[] args) {
		MaFenetre F= new MaFenetre();
	}
	
}
//Deschamps Guillaume