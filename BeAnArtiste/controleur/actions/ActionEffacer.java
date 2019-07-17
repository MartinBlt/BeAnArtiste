package fr.eseo.i1.gpi.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauDessin;

public class ActionEffacer extends AbstractAction {
	
	public static final String NOM_ACTION = "Effacer tout";
	
	public PanneauDessin panneauDessin = null;
	
	public ActionEffacer(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(JOptionPane.showConfirmDialog(	this.panneauDessin, 
											"Effacer tout ?", 
											NOM_ACTION, 
											JOptionPane.YES_NO_OPTION,
											JOptionPane.WARNING_MESSAGE) == 0) {
			//Supprime les vues dans vuesFormes
			int nbFormes = panneauDessin.getVueFormes().size();
			for(int i = 0 ; i < nbFormes ; i++) {
				panneauDessin.getVueFormes().remove(0);
			}
			
			int nbFormesSupprimees = panneauDessin.getVueFormesSupprimee().size();
			for(int i = 0 ; i < nbFormesSupprimees ; i++) {
				panneauDessin.getVueFormesSupprimee().remove(0);
			}
			panneauDessin.repaint();
		}
	}
	
}
