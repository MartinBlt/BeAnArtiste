package fr.eseo.i1.gpi.artiste.controleur.outils;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import fr.eseo.i1.gpi.artiste.modele.Coordonnees;
import fr.eseo.i1.gpi.artiste.modele.ListeModification;
import fr.eseo.i1.gpi.artiste.modele.formes.Etoile;
import fr.eseo.i1.gpi.artiste.modele.formes.Forme;
import fr.eseo.i1.gpi.artiste.vue.ihm.popup.PopupEtoile;
import fr.eseo.i1.gpi.artiste.vue.ihm.popup.PopupForme;
import fr.eseo.i1.gpi.artiste.vue.ihm.popup.PopupHauteurLargeur;

public class OutilSelectionner extends Outil {
	
	private static final Color couleurSelection = new Color(148, 77, 255);
	
	Color couleurFormeSelectionnee;
	Forme formeSelectionnee = null;
	Forme formeSelectionneeAvant = null;
	boolean priseEnCours, clicDroite;
	
	@Override
	public void mousePressed(MouseEvent event) {
		this.setDebut(new Coordonnees(event.getX(), event.getY()));
		
		//Gestion clic DROITE ou GAUCHE
		if(SwingUtilities.isLeftMouseButton(event)) {
			clicDroite = false;
		}
		if(SwingUtilities.isRightMouseButton(event)) {
			clicDroite = true;
		}
		
		this.formeSelectionneeAvant = this.getFormeSelectionnee();
		this.formeSelectionnee = this.selectionForme();
		
		//Gestion location du clic
		if(formeSelectionnee == null) {
			this.clicVide();	
		} else if (formeSelectionnee.equals(formeSelectionneeAvant)) {
			this.clicFormeSelectionnee();
		} else {
			this.clicNouvelleForme();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent event) {
		if(priseEnCours) {
			priseEnCours = false;
			this.setFin(new Coordonnees(event.getX(), event.getY()));
			
			Coordonnees nouvellePosition = new Coordonnees(	
			this.getFin().getAbscisse()-(this.getFormeSelectionnee().getLargeur()/2),
			this.getFin().getOrdonnee()-(this.getFormeSelectionnee().getHauteur()/2));
			
			this.getFormeSelectionnee().setPosition(nouvellePosition);
			
			super.getPanneauDessin().repaint();
			super.getPanneauInformation().reset();
			super.getPanneauInformation().afficher(formeSelectionnee, couleurFormeSelectionnee);
		}
	}
	
	private Forme selectionForme() {
		int nbFormes = super.getPanneauDessin().getVueFormes().size();
		for(int i = 0 ; i < nbFormes ; i++) {
			if(super.getPanneauDessin().getVueFormes().get(i).getForme().contient(this.getDebut())) {
				return super.getPanneauDessin().getVueFormes().get(i).getForme();
			}
		}
		return null;
	}
	
	private void clicNouvelleForme() {
		//Gestion ancienne selection
		if(formeSelectionneeAvant != null) {
			formeSelectionneeAvant.setCouleur(couleurFormeSelectionnee);
			super.getPanneauInformation().reset();
		}
		
		//Gestion nouvelle selection
		this.couleurFormeSelectionnee = formeSelectionnee.getCouleur();
		formeSelectionnee.setCouleur(couleurSelection);
		
		super.getPanneauInformation().afficher(formeSelectionnee, couleurFormeSelectionnee);
		
		super.setFormeSelectionnee(formeSelectionnee);
		super.getPanneauDessin().repaint();
	}
	
	private void clicFormeSelectionnee() {
		if(clicDroite) {
			
			ListeModification modifications = null;
			switch(this.getFormeSelectionnee().getType()) {
				case "autre":
					PopupForme popupForme = new PopupForme(null, "Modification : Forme Quelconque", true, this.getFormeSelectionnee(), couleurFormeSelectionnee);
					modifications = popupForme.showPopup();
					break;
				case "hauteur=largeur":
					PopupHauteurLargeur popupHauteurLargeur = new PopupHauteurLargeur(null, "Modification : Forme Carre/Cercle", true, this.getFormeSelectionnee(), couleurFormeSelectionnee);
					modifications = popupHauteurLargeur.showPopup();
					break;
				case "etoile":
					PopupEtoile popupEtoile = new PopupEtoile(null, "Modification : Forme Etoile", true, this.getFormeSelectionnee(), couleurFormeSelectionnee);
					modifications = popupEtoile.showPopup();
					break;
				case "texte":
					//PopupTexte popup = new PopupTexte(null, "Modification : Forme Texte", true, this.getFormeSelectionnee(), couleurFormeSelectionnee);
					//modifications = popup.showPopup();
					break;
				case "ligne":
					//PopupLigne popup = new PopupLigne(null, "Modification : Forme Texte", true, this.getFormeSelectionnee(), couleurFormeSelectionnee);
					//modifications = popup.showPopup();
					break;
				default: throw new IllegalArgumentException("Une des valeurs est négatif");
			}

			if(modifications.changement()) {
				switch(this.getFormeSelectionnee().getType()) {
					case "etoile":
						((Etoile) this.getFormeSelectionnee()).setNombreBranches(modifications.getNombreBranche());
						((Etoile) this.getFormeSelectionnee()).setLongueurBranche(modifications.getLongueurBranche());
					case "autre":
					case "hauteur=largeur":
						this.getFormeSelectionnee().setLargeur(modifications.getLargeur());
						this.getFormeSelectionnee().setHauteur(modifications.getHauteur());
						this.getFormeSelectionnee().setRempli(modifications.isRemplissage());
						this.getFormeSelectionnee().setCouleur(modifications.getCouleur());
						couleurFormeSelectionnee = modifications.getCouleur();
						break;
				}
				
				super.getPanneauDessin().repaint();
				
			} else if(modifications.supprimer()) {
				super.getPanneauDessin().supprimerVueForme(this.getFormeSelectionnee());
				super.setFormeSelectionnee(null);
				super.getPanneauDessin().repaint();
				this.getPanneauInformation().reset();
			}
		
		} else {
			priseEnCours = true;
		}
	}
	
	private void clicVide() {
		//Gestion ancienne selection
		if(formeSelectionneeAvant != null) {
			formeSelectionneeAvant.setCouleur(couleurFormeSelectionnee);
			super.setFormeSelectionnee(null);
			super.getPanneauDessin().repaint();
			super.getPanneauInformation().reset();
		}
	}
	
	public void reset() {
		if(formeSelectionnee != null) {
			formeSelectionnee.setCouleur(couleurFormeSelectionnee);
			super.setFormeSelectionnee(null);
			super.getPanneauDessin().repaint();
			super.getPanneauInformation().reset();
		}
	}
	
	public String getNom() {
		return "Selectionnee";
	}
	
	
}
