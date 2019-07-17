package fr.eseo.i1.gpi.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauDessin;

public class ActionRedo extends AbstractAction {
	
	public static final String NOM_ACTION = "Redo";
	
	public PanneauDessin panneauDessin = null;
	
	public ActionRedo(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(panneauDessin.getVueFormesSupprimee().size() == 0) {
			JOptionPane.showMessageDialog(	this.panneauDessin, 
					"Retour avant impossible, aucune forme à rajouter", 
					"Retour avant impossible", 
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			panneauDessin.getVueFormes().add(panneauDessin.getVueFormesSupprimee().get(panneauDessin.getVueFormesSupprimee().size()-1));
			panneauDessin.getVueFormesSupprimee().remove(panneauDessin.getVueFormesSupprimee().size()-1);
			panneauDessin.repaint();
		}
	}
}
