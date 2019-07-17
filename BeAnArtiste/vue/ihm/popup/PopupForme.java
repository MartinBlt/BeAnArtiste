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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import fr.eseo.i1.gpi.artiste.modele.ListeModification;
import fr.eseo.i1.gpi.artiste.modele.formes.Forme;

public class PopupForme extends JDialog {
	
	private Forme forme;
	private JTextField taille, hauteur;
	private JLabel largeurLabel, hauteurLabel;
	private JRadioButton remplissageTrue, remplissageFalse;
	private ListeModification modifications;
	private Color nouvelleCouleur;
	
	public PopupForme(JFrame parent, String titre, boolean modal, Forme forme, Color couleurFormeSelectionnee) {
		super(parent, titre, modal);
		this.setSize(400, 300);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	    this.forme = forme;
	    this.nouvelleCouleur = couleurFormeSelectionnee;
	    this.initComponent();
	}
	
	public ListeModification showPopup() {
		this.setVisible(true);
		return this.modifications;
	}
	
	private void initComponent() {
		//Selection taille
		JPanel panneauTaille = new JPanel();
		panneauTaille.setBackground(Color.white);
		panneauTaille.setPreferredSize(new Dimension(220, 90));
		panneauTaille.setBorder(BorderFactory.createTitledBorder("Taille"));
		DecimalFormat df = new DecimalFormat (); 
		df.setMaximumFractionDigits(0);
		taille = new JTextField(String.valueOf(df.format(this.forme.getLargeur())));
		hauteur = new JTextField(String.valueOf(df.format(this.forme.getHauteur())));
		taille.setPreferredSize(new Dimension(50, 25));
		hauteur.setPreferredSize(new Dimension(50, 25));
	    largeurLabel = new JLabel("Largeur de la forme :");
	    hauteurLabel = new JLabel("Hauteur de la forme :");
	    panneauTaille.add(largeurLabel);
	    panneauTaille.add(taille);
	    panneauTaille.add(hauteurLabel);
	    panneauTaille.add(hauteur);
	    
	    
	    //Selection Remplissage
	    JPanel panneauRemplissage = new JPanel();
	    panneauRemplissage.setBackground(Color.white);
	    panneauRemplissage.setPreferredSize(new Dimension(220, 60));
		panneauRemplissage.setBorder(BorderFactory.createTitledBorder("Remplissage"));
		remplissageTrue = new JRadioButton("Remplie");
		remplissageFalse = new JRadioButton("Vide");
		if(this.forme.isRempli()) {
			remplissageTrue.setSelected(true);
		} else {
			remplissageFalse.setSelected(true);
		}
		ButtonGroup bg = new ButtonGroup();
		bg.add(remplissageTrue);
		bg.add(remplissageFalse);
		panneauRemplissage.add(remplissageTrue);
		panneauRemplissage.add(remplissageFalse);
		
		//Selection Couleur
		JPanel panneauCouleur = new JPanel();
		panneauCouleur.setBackground(Color.white);
		panneauCouleur.setPreferredSize(new Dimension(220, 60));
		panneauCouleur.setBorder(BorderFactory.createTitledBorder("Couleur"));
		JButton boutonChoisirCouleur = new JButton("Choisir nouvelle couleur");
		boutonChoisirCouleur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color couleur = JColorChooser.showDialog(panneauCouleur, "Choisir nouvelle couleur", nouvelleCouleur);
				if(couleur != null) {
					nouvelleCouleur = couleur;
				}
			}
		});
		panneauCouleur.add(boutonChoisirCouleur);
	    
		
		//Création du panneau des outils complets
	    JPanel content = new JPanel();
	    content.setBackground(Color.WHITE);
	    content.add(panneauTaille);
	    content.add(panneauRemplissage);
	    content.add(panneauCouleur);
	    
	    //Gestion des boutons
	    JPanel panneauBoutons = new JPanel();
	   
	    //BOUTON OK
	    JButton okBouton = new JButton("OK");
	    okBouton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				modifications = new ListeModification(getHauteur(), getLargeur(), getRemplissage(), getNouvelleCouleur());
				setVisible(false);
			}
			
			public double getHauteur() {
				double valeur = forme.getHauteur();
				if(!hauteur.getText().equals("")) {
					try {
						valeur = Double.parseDouble(hauteur.getText());
					} catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Veuillez entrer une valeur numérique pour la hauteur", "Erreur Hauteur", JOptionPane.ERROR_MESSAGE);
					}
				}
				return valeur;
			}
			
			public double getLargeur() {
				double valeur = forme.getLargeur();
				if(!taille.getText().equals("")) {
					try {
						valeur = Double.parseDouble(taille.getText());
					} catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Veuillez entrer une valeur numérique pour la largeur", "Erreur Largeur", JOptionPane.ERROR_MESSAGE);
					}
				}
				return valeur;
			}
			
			public boolean getRemplissage() {
				return (remplissageTrue.isSelected());
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
	
	public Color getNouvelleCouleur() {
		return nouvelleCouleur;
	}
	
	public Forme getForme() {
		return forme;
	}
	
	public void setNouvelleCouleur(Color nouvelleCouleur) {
		this.nouvelleCouleur = nouvelleCouleur;
	}
}
