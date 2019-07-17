package fr.eseo.i1.gpi.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.i1.gpi.artiste.controleur.outils.OutilCarre;
import fr.eseo.i1.gpi.artiste.controleur.outils.OutilCercle;
import fr.eseo.i1.gpi.artiste.controleur.outils.OutilEllipse;
import fr.eseo.i1.gpi.artiste.controleur.outils.OutilEtoile;
import fr.eseo.i1.gpi.artiste.controleur.outils.OutilLigne;
import fr.eseo.i1.gpi.artiste.controleur.outils.OutilRectangle;
import fr.eseo.i1.gpi.artiste.controleur.outils.OutilTexte;
import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.i1.gpi.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirForme extends AbstractAction {
	
	public static final String NOM_ACTION_CHOISIR_LIGNE = "Ligne";
	public static final String NOM_ACTION_CHOISIR_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_CHOISIR_CERCLE = "Cercle";
	public static final String NOM_ACTION_CHOISIR_ETOILE = "Etoile";
	public static final String NOM_ACTION_CHOISIR_RECTANGLE = "Rectangle";
	public static final String NOM_ACTION_CHOISIR_CARRE = "Carré";
	public static final String NOM_ACTION_CHOISIR_TEXTE = "Texte";
	
	public PanneauDessin panneauDessin = null;
	public PanneauBarreOutils panneauOutils = null;
	public String action = null;
	
	public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauOutils, String action) {
		super(action);
		this.action = action;
		this.panneauDessin = panneauDessin;
		this.panneauOutils = panneauOutils;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		switch(this.action) 
		{
			case "Ligne":
				this.panneauDessin.associerOutil(new OutilLigne());
				break;
			case "Ellipse":
				this.panneauDessin.associerOutil(new OutilEllipse());
				break;
			case "Cercle":
				this.panneauDessin.associerOutil(new OutilCercle());
				break;
			case "Etoile":
				this.panneauDessin.associerOutil(new OutilEtoile(panneauOutils));
				break;
			case "Rectangle":
				this.panneauDessin.associerOutil(new OutilRectangle());
				break;
			case "Carré":
				this.panneauDessin.associerOutil(new OutilCarre());
				break;
			case "Texte":
				this.panneauDessin.associerOutil(new OutilTexte(panneauOutils));
				break;
			default:
				throw new IllegalArgumentException("Aucun outil connu sous ce nom");
		}
		
	}
}
