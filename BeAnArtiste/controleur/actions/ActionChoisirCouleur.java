package fr.eseo.i1.gpi.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirCouleur extends AbstractAction {
	
	public static final String NOM_ACTION = "Choisir une couleur";
	//public static final String NOM_ACTION = "Couleur contour";
	
	public PanneauDessin panneauDessin = null;
	
	public ActionChoisirCouleur(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Color couleur = JColorChooser.showDialog(this.panneauDessin, NOM_ACTION, this.panneauDessin.getCouleurCourante());
		if(couleur != null) {
			this.panneauDessin.setCouleurCourante(couleur);
		}
	}
}
