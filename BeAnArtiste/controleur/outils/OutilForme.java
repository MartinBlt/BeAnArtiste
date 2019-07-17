package fr.eseo.i1.gpi.artiste.controleur.outils;

import java.awt.event.MouseEvent;
import fr.eseo.i1.gpi.artiste.modele.Coordonnees;
import fr.eseo.i1.gpi.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil {
	
	public void mousePressed(MouseEvent event) {
		this.setDebut(new Coordonnees(event.getX(), event.getY()));
	}
	
	public void mouseReleased(MouseEvent event) {
		Coordonnees positionMouse = new Coordonnees(event.getX(), event.getY());
		this.setFin(positionMouse);
		if(!super.estDoubleClick()) {
			super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			super.getPanneauDessin().repaint();
		}
	}
	
	public void mouseClicked(MouseEvent event) {
		if(event.getClickCount() == 2 ) {
			this.setDebut(new Coordonnees(event.getX(), event.getY()));
			this.setFin(new Coordonnees(event.getX(), event.getY()));
			super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			super.getPanneauDessin().repaint();
		}
	}
	
	protected abstract VueForme creerVueForme();
	
	public String getNom() {
		return "Forme";
	}
}
