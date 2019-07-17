package fr.eseo.i1.gpi.artiste.vue.ihm.popup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import fr.eseo.i1.gpi.artiste.modele.ListeModification;
import fr.eseo.i1.gpi.artiste.modele.formes.Etoile;
import fr.eseo.i1.gpi.artiste.modele.formes.Forme;

public class PopupEtoile extends PopupForme {

	private JTextField taille;
	private JLabel tailleLabel;
	private JRadioButton remplissageTrue, remplissageFalse;
	private ListeModification modifications;
	public static SpinnerNumberModel spinnerNombreBranche;
	public static SpinnerNumberModel spinnerLongueurBranche;
	
	public PopupEtoile(JFrame parent, String titre, boolean modal, Forme forme, Color couleurFormeSelectionnee) {
		super(parent, titre, modal, forme, couleurFormeSelectionnee);
		this.setSize(300, 355);
		this.initComponent();
	}
	
	public ListeModification showPopup() {
		this.setVisible(true);
		return this.modifications;
	}
	
	private void initComponent() {
		//-----------------CHOIX TAILLE-----------------------------------------------------
		JPanel panneauTaille = new JPanel();
		panneauTaille.setBackground(Color.white);
		panneauTaille.setPreferredSize(new Dimension(220, 60));
		panneauTaille.setBorder(BorderFactory.createTitledBorder("Taille"));
		DecimalFormat df = new DecimalFormat (); 
		df.setMaximumFractionDigits(0);
		taille = new JTextField(String.valueOf(df.format(this.getForme().getLargeur())));
		taille.setPreferredSize(new Dimension(50, 25));
	    tailleLabel = new JLabel("Taille de la forme :");
	    panneauTaille.add(tailleLabel);
	    panneauTaille.add(taille);
	    
	    //------------CHOIX REMPLISSAGE-----------------------------------------------------
	    JPanel panneauRemplissage = new JPanel();
	    panneauRemplissage.setBackground(Color.white);
	    panneauRemplissage.setPreferredSize(new Dimension(220, 60));
		panneauRemplissage.setBorder(BorderFactory.createTitledBorder("Remplissage"));
		remplissageTrue = new JRadioButton("Remplie");
		remplissageFalse = new JRadioButton("Vide");
		if(this.getForme().isRempli()) {
			remplissageTrue.setSelected(true);
		} else {
			remplissageFalse.setSelected(true);
		}
		ButtonGroup bg = new ButtonGroup();
		bg.add(remplissageTrue);
		bg.add(remplissageFalse);
		panneauRemplissage.add(remplissageTrue);
		panneauRemplissage.add(remplissageFalse);
		
		//------CHOIX COULEUR-------------------------------------------------------------
		JPanel panneauCouleur = new JPanel();
		panneauCouleur.setBackground(Color.white);
		panneauCouleur.setPreferredSize(new Dimension(220, 60));
		panneauCouleur.setBorder(BorderFactory.createTitledBorder("Couleur"));
		JButton boutonChoisirCouleur = new JButton("Choisir nouvelle couleur");
		boutonChoisirCouleur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color couleur = JColorChooser.showDialog(panneauCouleur, "Choisir nouvelle couleur", getNouvelleCouleur());
				if(couleur != null) {
					setNouvelleCouleur(couleur);
				}
			}
		});
		panneauCouleur.add(boutonChoisirCouleur);
	    
		//----CHOIX NOMBRE BRANCHE-----------------------------------------------------------
		JPanel panneauChoixBranche = new JPanel();
		panneauChoixBranche.setBackground(Color.white);
		panneauChoixBranche.setPreferredSize(new Dimension(220, 82));
		panneauChoixBranche.setBorder(BorderFactory.createTitledBorder("Paramètre des branches"));
		JLabel texteParametreNombre = new JLabel("Nombre de Branche");
		panneauChoixBranche.add(texteParametreNombre);
		int valueNombreBranche = ((Etoile) getForme()).getNombreBranches();
        int minNombreBranche = 3;
        int maxNombreBranche = 15;
        int stepNombreBranche = 1;
        spinnerNombreBranche = new SpinnerNumberModel(valueNombreBranche, minNombreBranche, maxNombreBranche, stepNombreBranche);
        JSpinner jspinnerNombreBranche = new JSpinner(spinnerNombreBranche);
        jspinnerNombreBranche.setName("Nombre de Branche");
        panneauChoixBranche.add(jspinnerNombreBranche);
        JLabel texteParametreLongueur = new JLabel("Longueur des branches");
        panneauChoixBranche.add(texteParametreLongueur);
        double valueLongueurBranche = ((Etoile) getForme()).getLongueurBranche();
        double minLongueurBranche = 0;
        double maxLongueurBranche = 1;
        double stepLongueurBranche = 0.01;
        spinnerLongueurBranche = new SpinnerNumberModel(valueLongueurBranche, minLongueurBranche, maxLongueurBranche, stepLongueurBranche);
        JSpinner jspinnerLongueurBranche = new JSpinner(spinnerLongueurBranche);
        jspinnerLongueurBranche.setPreferredSize(new Dimension(50, 25));
        panneauChoixBranche.add(jspinnerLongueurBranche);
        
        //----GESTION AJOUT DES JPANEL-----------------------------------------------------------
	    JPanel content = new JPanel();
	    content.setBackground(Color.WHITE);
	    content.add(panneauTaille);
	    content.add(panneauRemplissage);
	    content.add(panneauCouleur);
	    content.add(panneauChoixBranche);
	    
	    //Gestion des boutons
	    JPanel panneauBoutons = new JPanel();
	   
	    //BOUTON OK
	    JButton okBouton = new JButton("OK");
	    okBouton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				modifications = new ListeModification(getTaille(), getRemplissage(), getNouvelleCouleur(), getNombreBranche(), getLongueurBranche());
				setVisible(false);
			}
			
			public double getTaille() {
				double valeur = getForme().getHauteur();
				if(!taille.getText().equals("")) {
					try {
						valeur = Double.parseDouble(taille.getText());
					} catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Veuillez entrer une valeur numérique pour la hauteur", "Erreur Hauteur", JOptionPane.ERROR_MESSAGE);
					}
				}
				return valeur;
			}
			
			public boolean getRemplissage() {
				return (remplissageTrue.isSelected());
			}
			
			public int getNombreBranche() {
				return (int) spinnerNombreBranche.getValue();
			}
			
			public double getLongueurBranche() {
				return (double) spinnerLongueurBranche.getValue();
			}
	    });
	    
	    
	    //BOUTON ANNULER
	    JButton annulerBouton = new JButton("Annuler");
	    annulerBouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifications = new ListeModification();
				setVisible(false);
			}
		});
	    
	    //BOUTON SUPRIMER FORME
	    JButton supprimerBouton = new JButton("Supprimer la forme");
	    supprimerBouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modifications = new ListeModification(true);
				setVisible(false);
			}
	    });
	    
	    panneauBoutons.add(okBouton);
	    panneauBoutons.add(annulerBouton);
	    panneauBoutons.add(supprimerBouton);
	    
	    //AJOUT DANS LE JFRAME
	    this.getContentPane().add(content);
	    this.getContentPane().add(panneauBoutons, BorderLayout.SOUTH);
	}
}
