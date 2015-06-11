/* HISTORIQUE:
 *
 * Version 1.1 - 22/11/2014 - Ajout de la progressBar et du controle des services.
 * Version 1.0 - 22/11/2014 - Cr�ation de la classe.
 * 
 * FINN HISTORIQUE
 */

package org.tref.views.frames.splash;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.UIManager;

import org.tref.Access;
import org.tref.common.resources.PEnumLogs;
import org.tref.common.resources.Ressources;
import org.tref.common.utils.Config;
import org.tref.install.Install;
import org.tref.views.ViewPrefs;
import org.tref.views.ViewsRessources;
import org.tref.views.frames.erreurs.ErrorFrame;


public class SplashScreen extends JWindow {

    /** Duree de visibilite du splashscreen. */
    private int duration;

    /** La progressBar. */
    private JProgressBar _progressBar = new JProgressBar(0, 100);

    /** num */
    int num = 0;  
    
    int reste = 0;


    /**
     * <h3>prs.views.frames.PRSSplashScreen();</h3>
     *</br>
     *<p>Constructeur 
     *</p>
     *<b>Note: </b>Neant
     * @param d
     */
    public SplashScreen(int d) {
	_progressBar.setValue(0);
	_progressBar.setStringPainted(true);
	duration = d;
    }


    /**
     * <h3>prs.views.frames.showSplash();</h3>
     *</br>
     *<p>Cette methode permet l'affichage du splashscreen.</br>
     *</p>
     *<b>Note:</b>N�ant
     */
    public void showSplash() {

	System.out.println("init du panneau.");
	JPanel content = (JPanel)getContentPane();
	content.setBackground(Color.white);

	System.out.println("init de lma fenetre.");
	// Set the window's bounds, centering the window
	int width = 450;
	int height = 300;

	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	int x = (screen.width-width)/2;
	int y = (screen.height-height)/2;
	setBounds(x,y,width,height);

	System.out.println("init du logo");
	// Build the splash screen
	JPanel centerPane = new JPanel(new BorderLayout());
	centerPane.setBackground(Color.WHITE);
	JLabel label = new JLabel(new ImageIcon(getClass().getResource(ViewsRessources.getInstance().getImgsPath() 
			+ Ressources.getInstance().getSepProj() +"splashscreen1.jpg")));

	System.out.println("init de la zone sud");
	centerPane.add(label, BorderLayout.CENTER);
	centerPane.add(_progressBar, BorderLayout.SOUTH);

	JPanel copyrtpane = new JPanel();
	copyrtpane.setBackground(Color.decode("#F2F2F2"));

	JPanel copyrtPRbar = new JPanel(new BorderLayout());
	JLabel copyrt = new JLabel
		("Copyright 2014, fernoult corporation d'sa m�re", JLabel.CENTER);
	copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
	copyrt.setForeground(Color.decode("#1C1C1C")); // #E6E6E6
	// On initialise la progressBar.
	_progressBar.setPreferredSize(new Dimension(450, 22));
	
	System.out.println("init de la zone nord");
	JPanel loginpane = new JPanel(new FlowLayout());
	JLabel name = new JLabel("CORP/Login : ");
	name.setFont(new Font("Sans-Serif", Font.BOLD, 12));
	name.setForeground(Color.BLACK); // .decode("#B40404")

	JLabel login = new JLabel(System.getProperty("user.name"));
	login.setFont(new Font("Sans-Serif", Font.BOLD, 12));
	login.setForeground(Color.decode("#08298A"));

	loginpane.add(name);
	loginpane.add(login);

	content.add(loginpane, BorderLayout.NORTH);
	content.add(centerPane, BorderLayout.CENTER);
	content.add(copyrt, BorderLayout.SOUTH);
	content.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

	// Display it
	setVisible(true);
	iterate();
//	displayProgress("PROGRESSSSSSSS");
//	displayFirstLaunch("FIRST");
	dispose();
    }

    /**
     * <h3>prs.views.frames.iterate();</h3>
     *</br>
     *<p>Cette methode permet l'iteration sur les services passes en /m </br>
     *	et pour chacun d'entre eux de verifier si le service cote server est en fonction.</br>
     *	Si le service tourne, alors le flag du service est positionne a "true".</br>
     *	Sinon il est positionne a false.
     *</p>
     *<b>Note:</b>N�ant
     * @param liste_
     */
    public void iterate() {

		Preferences prefs = Preferences.userNodeForPackage(Access.class);
		String flag = Ressources.ALREADY_INSTALLED;		

	if (prefs.getBoolean(flag, true)) {
	    
	    // Compte les tours de boucles
	    int cserv = 0;
	    num = 100/(4 +  2);
	    
		cserv++;
		if (cserv == 1) {
		    num = num + 1;
		}else {
		    num = num + num;
		}
		
	    // On met a jour la ProgressBar.
	    displayProgress("Test chaine progress");
	    
	    reste = (100 - _progressBar.getValue()) / 10;
	    displayProgress("Chargement des profils Users");

	    
	 // On lance l'explorateur
	    

	}else {
	    
	    System.out.println("premiere utilisation");
	    displayFirstLaunch("Premiere utilisattion");
	    
	    // On lance l'install
	    
	}



    }

    /**
     * <h3>prs.views.frames.displayProgress();</h3>
     *</br>
     *<p>Cette methode permet l'affichage et l'avancement de la progressBar.</br>
     *</p>
     *<b>Note:</b>N�ant
     * @param service
     */
    private void displayProgress(String chaine_) {

	try {
	    _progressBar.setFont(new Font("Arial", Font.BOLD, 12));
	    if (chaine_.contains("Chargement des profils Users")) {
		num = num + reste + 3;
		_progressBar.setString("Loading : " + chaine_);
		_progressBar.setValue(num + reste);
		Thread.sleep(80);
	    }else {
		if ((num - 10) > 0) {
//		    _progressBar.setValue(num - 10);
		    num = num - 5;
		}else {
		    _progressBar.setValue(10);
		}
		_progressBar.setString("Tests Connexion : " + chaine_);
		Thread.sleep(100);
		_progressBar.setValue(num + 10);
		Thread.sleep(200);
		_progressBar.setValue(num);
		Thread.sleep(300);
		for (int i = 0; i < 30; i++) {
		    _progressBar.setValue(num + i);
			Thread.sleep(10);
		}
	    }
	    

	} catch (InterruptedException IEE) {
	    System.err.println("[ERREUR] IEE # InteruptedException " + IEE.getMessage());
	}
    }
    
    /**
     * <h3>prs.views.frames.displayFirstLaunch();</h3>
     *</br>
     *<p>Cette methode permet de </br>
     *</p>
     *<b>Note:</b>N�ant
     * @param chaine_
     */
    private void displayFirstLaunch(String chaine_) {
	
	
	    while (num < 100) {
		_progressBar.setFont(new Font("Arial", Font.BOLD, 12));
		_progressBar.setString(chaine_);
		_progressBar.setValue(num + 1);
		try {
		    Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		num ++;
	    }
	    
    }

    /**
     * <h3>prs.views.frames.showSplashAndExit();</h3>
     *</br>
     *<p>Cette methode permet l'execution du splashscreen. </br>
     *</p>
     *<b>Note:</b>N�ant
     */
    public void showSplashAndExit() {
	showSplash();
    }

}
