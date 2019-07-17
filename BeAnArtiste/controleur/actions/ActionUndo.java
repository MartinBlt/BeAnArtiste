package fr.eseo.i1.gpi.artiste.controleur.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauDessin;

public class ActionUndo extends AbstractAction {

	public static final String NOM_ACTION = "Undo";
	
	public PanneauDessin panneauDessin = null;
	
	public ActionUndo(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(panneauDessin.getVueFormes().size() == 0) {
			JOptionPane.showMessageDialog(	this.panneauDessin, 
											"Retour arrière impossible, aucune forme à supprimer", 
											"Retour arrière impossible", 
											JOptionPane.INFORMATION_MESSAGE);
		} else {
			panneauDessin.getVueFormesSupprimee().add(panneauDessin.getVueFormes().get(panneauDessin.getVueFormes().size()-1));
			panneauDessin.getVueFormes().remove(panneauDessin.getVueFormes().size()-1);
			panneauDessin.repaint();
		}
	}
}
