package fr.eseo.i1.gpi.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JCheckBox;

import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissage extends AbstractAction {
	
	public static final String NOM_ACTION = "Remplissage";
	
	public PanneauDessin panneauDessin = null;

	public ActionChoisirRemplissage(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		JCheckBox modeRemplissage = (JCheckBox) event.getSource();
        
		if (modeRemplissage.isSelected()) {
            this.panneauDessin.setModeRemplissage(true);
        } else {
        	this.panneauDessin.setModeRemplissage(false);
        }
	}
}
