package fr.eseo.i1.gpi.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.i1.gpi.artiste.modele.Coordonnees;
import fr.eseo.i1.gpi.artiste.modele.formes.Texte;
import fr.eseo.i1.gpi.artiste.vue.formes.VueForme;
import fr.eseo.i1.gpi.artiste.vue.formes.VueTexte;
import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauBarreOutils;

public class OutilTexte extends OutilForme {
	
	public PanneauBarreOutils panneauOutils = null;
	
	public OutilTexte(PanneauBarreOutils panneauOutils) {
		this.panneauOutils = panneauOutils;
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		this.setDebut(new Coordonnees(event.getX(), event.getY()));
		this.setFin(new Coordonnees(event.getX(), event.getY()));
		super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
		super.getPanneauDessin().repaint();
	}
	
	@Override
	protected VueForme creerVueForme() {
		Texte texte;
	    String texteEntre = (String) 
	    		JOptionPane.showInputDialog(super.getPanneauDessin(),
	    									"Texte à afficher",
	    									"Texte",
	    									JOptionPane.QUESTION_MESSAGE);
	    if(texteEntre != null) {
	    	texte = new Texte(	new Coordonnees(super.getFin().getAbscisse(),
	    									super.getFin().getOrdonnee()), 
	    									texteEntre,
	    									panneauOutils.getFontTexte(),
	    									panneauOutils.getTailleTexte());

	    	texte.setCouleur(this.getPanneauDessin().getCouleurCourante());
	    	VueTexte vueTexte = new VueTexte(texte);
	    	return vueTexte;
		} else {
			texte = new Texte();
	    	VueTexte vueTexte = new VueTexte(texte);
	    	return vueTexte;
		}
	}
	
}
