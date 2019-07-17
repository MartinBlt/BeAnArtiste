package fr.eseo.i1.gpi.artiste.controleur.outils;

import fr.eseo.i1.gpi.artiste.modele.Coordonnees;
import fr.eseo.i1.gpi.artiste.modele.formes.Etoile;
import fr.eseo.i1.gpi.artiste.vue.formes.VueEtoile;
import fr.eseo.i1.gpi.artiste.vue.formes.VueForme;
import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauBarreOutils;

public class OutilEtoile extends OutilForme {
	
	public PanneauBarreOutils panneauOutils = null;
	
	public OutilEtoile(PanneauBarreOutils panneauOutils) {
		this.panneauOutils = panneauOutils;
	}
	
	@Override
	protected VueForme creerVueForme() {
		Etoile etoile = null;
	    double taille = super.getDebut().distanceVers(super.getFin());
		
	    if(super.estDoubleClick()) {
			etoile = new Etoile(	new Coordonnees(super.getFin().getAbscisse() - 
													(Etoile.LARGEUR_PAR_DEFAUT/2), 
													super.getFin().getOrdonnee() - 
													(Etoile.LARGEUR_PAR_DEFAUT/2)),
									Etoile.LARGEUR_PAR_DEFAUT, 
									panneauOutils.getNbBranches(), 
									Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
									panneauOutils.getLongueurBranche());
	    } else {
			etoile = new Etoile(	new Coordonnees(super.getFin().getAbscisse()
													- taille, 
													super.getFin().getOrdonnee()
													- taille),
									taille*2,
									panneauOutils.getNbBranches(), 
									Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
									panneauOutils.getLongueurBranche());
		}
		
		etoile.setCouleur(this.getPanneauDessin().getCouleurCourante());
		etoile.setRempli(this.getPanneauDessin().getModeRemplissage());
		VueForme vueEtoile = new VueEtoile(etoile);
		return vueEtoile;
	}
}
