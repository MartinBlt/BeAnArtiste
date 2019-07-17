package fr.eseo.i1.gpi.artiste.controleur.outils;

import fr.eseo.i1.gpi.artiste.modele.Coordonnees;
import fr.eseo.i1.gpi.artiste.modele.formes.Carre;
import fr.eseo.i1.gpi.artiste.vue.formes.VueCarre;
import fr.eseo.i1.gpi.artiste.vue.formes.VueForme;

public class OutilCarre extends OutilForme {

	protected VueForme creerVueForme() {
		
		Carre carre;
		double debutAbscisse = super.getDebut().getAbscisse();
		double finAbscisse = super.getFin().getAbscisse();
	    double debutOrdonnee = super.getDebut().getOrdonnee();
	    double finOrdonnee = super.getFin().getOrdonnee();
	    double taille = Math.max(Math.abs(finAbscisse - debutAbscisse), Math.abs(finOrdonnee - debutOrdonnee));
		
	    if(super.estDoubleClick()) {
	    	carre = new Carre(super.getDebut());
		
	    } else {
	    	carre = new Carre(new Coordonnees(
	    			(debutAbscisse < finAbscisse ? debutAbscisse : debutAbscisse - taille),
	    			(debutOrdonnee < finOrdonnee ? debutOrdonnee : debutOrdonnee - taille)),
	    			taille);
		}
	    
	    carre.setCouleur(this.getPanneauDessin().getCouleurCourante());
	    carre.setRempli(this.getPanneauDessin().getModeRemplissage());
		VueForme vueCarre = new VueCarre(carre);
		return vueCarre;
	}
}
