package fr.eseo.i1.gpi.artiste.controleur.outils;

import fr.eseo.i1.gpi.artiste.modele.Coordonnees;
import fr.eseo.i1.gpi.artiste.modele.formes.Cercle;
import fr.eseo.i1.gpi.artiste.vue.formes.VueCercle;
import fr.eseo.i1.gpi.artiste.vue.formes.VueForme;

public class OutilCercle extends OutilForme {

	protected VueForme creerVueForme() {
		
		Cercle cercle;
		double debutAbscisse = super.getDebut().getAbscisse();
		double finAbscisse = super.getFin().getAbscisse();
	    double debutOrdonnee = super.getDebut().getOrdonnee();
	    double finOrdonnee = super.getFin().getOrdonnee();
	    double taille = Math.max(Math.abs(finAbscisse - debutAbscisse), Math.abs(finOrdonnee - debutOrdonnee));
		
	    if(super.estDoubleClick()) {
			cercle = new Cercle(super.getDebut());
		
	    } else {
	    	cercle = new Cercle(new Coordonnees(
	    			(debutAbscisse < finAbscisse ? debutAbscisse : debutAbscisse - taille),
	    			(debutOrdonnee < finOrdonnee ? debutOrdonnee : debutOrdonnee - taille)),
	    			taille);
		}
	    
	    cercle.setCouleur(this.getPanneauDessin().getCouleurCourante());
	    cercle.setRempli(this.getPanneauDessin().getModeRemplissage());
		VueForme vueCercle = new VueCercle(cercle);
		return vueCercle;
	}

}
