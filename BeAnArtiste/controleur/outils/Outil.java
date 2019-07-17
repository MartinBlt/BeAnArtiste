package fr.eseo.i1.gpi.artiste.controleur.outils;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import fr.eseo.i1.gpi.artiste.modele.Coordonnees;
import fr.eseo.i1.gpi.artiste.modele.formes.Forme;
import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauDessin;
import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauInformation;

public abstract class Outil implements MouseInputListener {
	
	private Coordonnees debut;
	private Coordonnees fin;
	private Forme formeSelectionnee = null;
	
	private PanneauDessin panneauDessin = null;
	private PanneauInformation panneauInformation = null;
	
	public Outil() {
		//Contructeur non utile
	}
	
	/**
	 * Accesseur de la coordonnee du début de l'action
	 * 
	 * @return coordonnee du début de l'action
	 */
	public Coordonnees getDebut() {
		return this.debut;
	}
	
	/**
	 * Mutateur de la coordonnee du début de l'action
	 * 
	 * @param debut coordonnee du début de l'action
	 */
	public void setDebut(Coordonnees debut) {
		this.debut = debut;
	}
	
	/**
	 * Accesseur de la coordonnee de la fin de l'action
	 * 
	 * @return coordonnée de la fin de l'action
	 */
	public Coordonnees getFin() {
		return this.fin;
	}
	
	/**
	 * Mutateur de la fin de l'action
	 * 
	 * @param fin coordonnée de la fin de l'action
	 */
	public void setFin(Coordonnees fin) {
		this.fin = fin;
	}
	
	/**
	 * Accesseur du Panneau Dessin en cours sur l'outil
	 * 
	 * @return panneauDessin
	 */
	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}
	
	/**
	 * Mutateur du panneau de dessin de l'outil en cours
	 * 
	 * @param panneauDessin
	 */
	public void setPanneauDessin(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}
	
	public void mouseClicked(MouseEvent event) {
		
	}
	
	public void mousePressed(MouseEvent event) {
		
	}
	
	public void mouseReleased(MouseEvent event) {
		
	}
	
	public void mouseEntered(MouseEvent event) {
		
	}
	
	public void mouseExited(MouseEvent event) {
		
	}
	
	public void mouseMoved(MouseEvent event) {
		
	}
	
	public void mouseDragged(MouseEvent event) {
		
	}
	
	public abstract String getNom();
	
	/**
	 * Renvoie TRUE si le dernier clic était un double clic sans bouger la souris
	 * 
	 * @return true pour double clic au même endroit sinon false
	 */
	public boolean estDoubleClick() {
		return(getDebut().toString().equals(getFin().toString()));
	}
	
	public void setFormeSelectionnee(Forme forme) {
		this.formeSelectionnee = forme;
	}
	
	public Forme getFormeSelectionnee() {
		return formeSelectionnee;
	}
	
	public void setPanneauInformation(PanneauInformation panneauInformation) {
		this.panneauInformation = panneauInformation;
	}
	
	public PanneauInformation getPanneauInformation() {
		return panneauInformation;
	}
}