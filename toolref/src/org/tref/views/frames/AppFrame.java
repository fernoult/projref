package org.tref.views.frames;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import org.tref.common.preferences.PrefsGUI;
import org.tref.common.resources.enums.EnumLogs;
import org.tref.views.ViewsRessources;
import org.tref.views.frames.erreurs.ErrorFrame;

public class AppFrame extends PFrame {
	
	/**
	 * 
	 * Constructeur de la classe AppFrame.java
	 */
	public AppFrame() {
		// appel du constructeur commun aux fenetres.
		super();
		
        // On ajoute un controle sur les fenetres "metier"
		// lors de la fermeture de celles-ci.
        addWindowListener(new WindowAdapter() {
        	
			@Override
        	public void windowClosing(WindowEvent e) {
        		
				// On positionne la Locale.
        		JComponent.setDefaultLocale(PrefsGUI.getInstance().getLocale());
        		
        		// Si la fenetre est l'instance de l'explorateur (fenetre principale de l'application)
        		// "org.tref.views.frames.ExploraterFrame"
        		if (e.getSource().getClass().getName().equals(ExploraterFrame.class.getName())) { 
        			
        			// On veut vraiment fermer l'application.
            		if ( confirmCloseApplication() == 0) {
            			
            			// On positionne le comportement de
            			// fermeture par defaut a EXIT_ON_CLOSE,
            			// et on ferme sur le dispose.
    					setDefaultCloseOperation(EXIT_ON_CLOSE);
    					dispose();
    				// Sinon
    				}else {
    					// On ne fait rien.
    					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					}
            		
        		// Sinon
				}else {
					
					// Si la liste des fenetres filles n'est pas vide.
					if (get_frames().size() > 0 ) {
						
						// On veut vraiment fermer la fenetre.
		        		if ( confirmCloseFrame() == 0) {
		        			// On positionne le comportement de fermeture par defaut a
		        			// "DISPOSE_ON_CLOSE"
							setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						}else {
							// On positionne le comportement de fermeture par defaut a
							// "DO_NOTHING_ON_CLOSE"
		        			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
						}
		        		
		        	// Sinon
					}else {
						
						// On ferme la fenetre.
						dispose();
					}

					
				}
        		// Si le traitement n'est pas encore termine, on interdit de fermer la fenetre avec la croix.
        		// et on affiche une fenetre d'avertissement avec message + possibilite d'annuler proprement la requete.
        		
        	}
		});
	}
	
	/**
	 * 
	 * <b>addFrame() - org.tref.views.frames.AppFrame.addFrame()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Ajoute une nouvelle instance de fenetre fille dans la liste.<br/>
	 * <br/>
	 * @param frame_
	 */
	protected void addFrame(PFrame frame_){
		
		// On recupere la liste et on y ajoute la fenetre fille.
		get_frames().add(frame_);
	}
	
	/**
	 * 
	 * <b>removeFrame() - org.tref.views.frames.AppFrame.removeFrame()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Enleve une fenetre de la liste des fenetres filles.<br/>
	 * <br/>
	 * @param frame_
	 * @return
	 */
	protected boolean removeFrame(PFrame frame_){
		
		// Init du booleen de retour.
		boolean ret = false;
		
		// On boucle sur chaque fenetres pour 
		// identifier celle que l'on veut enlever.
		for (int i = 0; i < get_frames().size(); i++) {
			if (get_frames().get(i).equals(frame_)) {
				get_frames().remove(i);
				ret = true;
			}
		}
		
		return ret;
	}
	
	/**
	 * 
	 * <b>removeFrames() - org.tref.views.frames.AppFrame.removeFrames()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Vide la liste des fenetres filles. <br/>
	 * <br/>
	 * @return
	 */
	protected void removeFrames(){
		
		// On vide la liste.
		get_frames().clear();
	}
	
	/**
	 * 
	 * <b>notifyFrame() - org.tref.views.frames.AppFrame.notifyFrame()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Notifie une fenetre fille particuliere.<br/>
	 * <br/>
	 * @param frame_
	 * @return
	 */
	protected boolean notifyFrame(PFrame frame_){
		return true;
	}
	
	/**
	 * 
	 * <b>notifyFrames() - org.tref.views.frames.AppFrame.notifyFrames()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Notifie toutes les fenetres filles.<br/>
	 * <br/>
	 */
	protected void notifyFrames(){
		
		// Pour chaque fenetre fille
		for (Iterator<?> iterator = get_frames().iterator(); iterator.hasNext();) {
			PFrame frame = (PFrame) iterator.next();
			try {
				Thread.sleep(20);
				
				// On ferme la fenetre.
				frame.dispose();
			} catch (InterruptedException e) {
				System.err.println(EnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
				new ErrorFrame(e.getClass().toString(), e.getStackTrace());
			}
		}
	}
	
	/**
	 * Ferme les fenetres.
	 */
	@Override
	public void dispose() {
		super.dispose();
		// ferme ses fenetre filles
		if (get_frames() != null) {
			notifyFrames();
		}
	}
	
	/**
	 * 
	 * <b>confirmCloseApplication() - org.tref.views.frames.AppFrame.confirmCloseApplication()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Ouvre une fenetre de confirmation avant la fermeture de la fenetre.<br/>
	 * <br/>
	 * @return
	 */
	protected int confirmCloseApplication(){
		
		// On positionne la Locale.
		JComponent.setDefaultLocale(PrefsGUI.getInstance().getLocale());
		
		// Retourne le code de la fenetre de confirmation.
		return  JOptionPane.showConfirmDialog(null, ViewsRessources.getInstance().getLibelleValue("appli.confirm.close.message.text"), 
				ViewsRessources.getInstance().getLibelleValue("frame.confirm.title.text"), JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * 
	 * <b>confirmCloseFrame() - org.tref.views.frames.AppFrame.confirmCloseFrame()</b><br/>
	 *
	 * <b>Description: </b> <br/>
	 * 		Ouvre une fenetre de confirmation avant la fermeture de la fenetre.<br/>
	 * <br/>
	 * @return
	 */
	protected int confirmCloseFrame(){
		
		// Retourne le code de la fenetre de confirmation.
		return JOptionPane.showConfirmDialog(null, ViewsRessources.getInstance().getLibelleValue("frame.confirm.close.message.text"), 
    				ViewsRessources.getInstance().getLibelleValue("frame.confirm.title.text"), JOptionPane.WARNING_MESSAGE);
	}
	
}
