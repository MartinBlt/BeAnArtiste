package fr.eseo.i1.gpi.artiste.controleur.outils;

import fr.eseo.i1.gpi.artiste.modele.Coordonnees;
import fr.eseo.i1.gpi.artiste.modele.formes.Rectangle;
import fr.eseo.i1.gpi.artiste.vue.formes.VueForme;
import fr.eseo.i1.gpi.artiste.vue.formes.VueRectangle;

public class OutilRectangle extends OutilForme {
	
	@Override
	protected VueForme creerVueForme() {
		Rectangle rectangle;
		if(super.estDoubleClick()) {
			rectangle = new Rectangle(super.getDebut());
		} else {
			double debutAbscisse = super.getDebut().getAbscisse();
			double finAbscisse = super.getFin().getAbscisse();
		    double debutOrdonnee = super.getDebut().getOrdonnee();
		    double finOrdonnee = super.getFin().getOrdonnee();
		    rectangle = new Rectangle(new Coordonnees(	Math.min(debutAbscisse, finAbscisse),Math.min(debutOrdonnee, finOrdonnee)),
		                                  			Math.abs(finAbscisse - debutAbscisse),Math.abs(finOrdonnee - debutOrdonnee));
		}
		
		rectangle.setCouleur(this.getPanneauDessin().getCouleurCourante());
		rectangle.setRempli(this.getPanneauDessin().getModeRemplissage());
		VueForme vueRectangle = new VueRectangle(rectangle);
		return vueRectangle;
	}
}
