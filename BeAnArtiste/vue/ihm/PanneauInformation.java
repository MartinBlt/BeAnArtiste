package fr.eseo.i1.gpi.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import fr.eseo.i1.gpi.artiste.modele.formes.Forme;

public class PanneauInformation extends JPanel {
	
	public static final int HAUTEUR_PAR_DEFAUT = 30;
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(245, 245, 239);
	
	public Forme forme;
	
	public PanneauInformation() {
		this.setPreferredSize(new Dimension(PanneauDessin.LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
		this.setBackground(COULEUR_FOND_PAR_DEFAUT);
		this.setVisible(false);
	}

	public void afficher(Forme formeSelectionnee, Color couleurFormeSelectionnee) {
		this.removeAll();
		JLabel infoForme = new JLabel(formeSelectionnee.toString());
		JPanel infoCouleur = new JPanel();
		infoCouleur.setPreferredSize(new Dimension(20,20));
		if(formeSelectionnee.isRempli()) {
			infoCouleur.setBackground(couleurFormeSelectionnee);
		} else {
			infoCouleur.setBorder(new LineBorder(couleurFormeSelectionnee));
		}
		this.add(infoForme);
		this.add(infoCouleur);
		this.setVisible(true);
	}
	
	public void reset() {
		this.removeAll();
		this.setVisible(false);
	}
}
