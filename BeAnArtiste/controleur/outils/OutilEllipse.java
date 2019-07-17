package fr.eseo.i1.gpi.artiste.controleur.outils;

import fr.eseo.i1.gpi.artiste.modele.Coordonnees;
import fr.eseo.i1.gpi.artiste.modele.formes.Ellipse;
import fr.eseo.i1.gpi.artiste.vue.formes.VueEllipse;
import fr.eseo.i1.gpi.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme {

	@Override
	protected VueForme creerVueForme() {
		Ellipse ellipse;
		if(super.estDoubleClick()) {
			ellipse = new Ellipse(super.getDebut());
		} else {
			double debutAbscisse = super.getDebut().getAbscisse();
			double finAbscisse = super.getFin().getAbscisse();
		    double debutOrdonnee = super.getDebut().getOrdonnee();
		    double finOrdonnee = super.getFin().getOrdonnee();
		    ellipse = new Ellipse(new Coordonnees(	Math.min(debutAbscisse, finAbscisse),Math.min(debutOrdonnee, finOrdonnee)),
		                                  			Math.abs(finAbscisse - debutAbscisse),Math.abs(finOrdonnee - debutOrdonnee));
		}
		
		ellipse.setCouleur(this.getPanneauDessin().getCouleurCourante());
		ellipse.setRempli(this.getPanneauDessin().getModeRemplissage());
		VueForme vueEllipse = new VueEllipse(ellipse);
		return vueEllipse;
	}

}
