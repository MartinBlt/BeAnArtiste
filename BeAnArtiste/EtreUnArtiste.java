package fr.eseo.i1.gpi.artiste;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauDessin;

/**
 * ETRE UN ARTISTE
 * 
 * Application permettant la création de dessin simpliste.
 * D'après le cahier des charges :
 * 	- Création de forme (Ligne, Ellipse, Cercle, Etoile)
 * 	- Choisir le remplissage et la couleur d'une forme
 * 	- Selection pour afficher les infos de la forme
 * 	- Supprimer toutes les formes d'un coup
 * 
 * RAJOUT :
 * 	- Ajout de forme (Rectangle, Carré)
 * 	- Ajout de l'outil textuel (choix police, taille)
 * 	- Ajout d'un carré de visibilité rapide de la couleur en cours
 * 	- Ajout bouton UNDO/REDO
 * 	- Ajout bouton EXPORTER pour exporter son dessin en JPEG (il est sauvegarder dans le dossier du programme)
 * 	- Ajout DEPLACEMENT d'une forme quand elle est sélectionnée (avec un glissé déposé)
 * 	- Ajout d'un menu de modification d'un forme avec CLIC DROITE sur une forme selectionnée
 * 
 * @author Martin Blot
 * @version 1.0
 * @since 03/05/2019
 */
public class EtreUnArtiste {
	public static void main(String[] arg) {
		JFrame f = new JFrame("Etre un Artiste");
		f.setSize(new Dimension(10,10));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Création du panneau de dessin
		PanneauDessin panneauDessin = new PanneauDessin();
		
		//Création du panneau d'outils
		PanneauBarreOutils barreOutils = new PanneauBarreOutils(panneauDessin);
		
		//Ajout des panneaux dans la frame
		f.getContentPane().add(panneauDessin);
		f.getContentPane().add(barreOutils, BorderLayout.EAST);
		f.pack();
		
		//Centrer l'affichage
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
		
		//Bloquer le rezise de la fenetre
		f.setResizable(false);
		
		//Affichage
		f.setVisible(true);
		
		
		//Affichage POPUP pour expliquer les extensions
		String message = "Application embarquant l'ensemble du cahier des charges plus des extensions :"
				+ "\n"
				+ "\n- Ajout de forme (Rectangle, Carré)"
				+ "\n- Ajout de l'outil textuel (choix police, taille)"
				+ "\n- Ajout d'un carré de visibilité rapide de la couleur en cours"
				+ "\n- Ajout bouton UNDO/REDO"
				+ "\n- Ajout bouton EXPORTER pour exporter son dessin en JPEG (il est sauvegarder dans le dossier du programme)"
				+ "\n- Ajout DEPLACEMENT d'une forme quand elle est sélectionnée (avec un glissé déposé)"
				+ "\n- Ajout d'un menu de modification d'un forme avec CLIC DROITE sur une forme selectionnée"
				+ "\n"
				+ "\n Martin Blot";
		JOptionPane.showMessageDialog(f, message, "Bienvenue dans \"Etre un Artiste\"", JOptionPane.INFORMATION_MESSAGE);
	}
}
