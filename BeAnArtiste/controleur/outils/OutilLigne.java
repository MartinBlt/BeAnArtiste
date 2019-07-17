package fr.eseo.i1.gpi.artiste.controleur.outils;

import fr.eseo.i1.gpi.artiste.modele.formes.Ligne;
import fr.eseo.i1.gpi.artiste.vue.formes.VueForme;
import fr.eseo.i1.gpi.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme {

	@Override
	protected VueForme creerVueForme() {
		Ligne ligne;
		if(super.estDoubleClick()) {
			ligne = new Ligne(super.getDebut());
		} else {
			ligne = new Ligne(	super.getDebut(), 
								super.getFin().getAbscisse() - super.getDebut().getAbscisse() , 
								super.getFin().getOrdonnee() - super.getDebut().getOrdonnee());
		}
		
		ligne.setCouleur(this.getPanneauDessin().getCouleurCourante());
		
		VueForme vueLigne = new VueLigne(ligne);
		return vueLigne;
	}
}
