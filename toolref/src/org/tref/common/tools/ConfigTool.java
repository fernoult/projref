package org.tref.common.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.tref.Access;
import org.tref.common.resources.PEnumLogs;
import org.tref.common.resources.Ressources;
import org.tref.views.frames.erreurs.ErrorFrame;

public class ConfigUtils {

	private static ConfigUtils CU_INSTANCE;
	
	private InputStream _is;
	
	private ObjectInputStream _ois;
	
	private FileOutputStream _fos;
	
	private ObjectOutputStream _oos;
	
	private Ressources _ressources = Ressources.getInstance();
	
	private Config _configObj;
	
	private ConfigUtils(){
		
	}
	
	public static ConfigUtils getInstance(){
		if (CU_INSTANCE == null) {
			CU_INSTANCE = new ConfigUtils();
		}
		return CU_INSTANCE;
	}
	
	public Config getConfigObject(){
		
		Config confObj = new Config();
		Preferences prefs = Preferences.userNodeForPackage(Access.class);

		try {
			Document document = FichierUtils.getInstance().readXMLFile(prefs.get("CONFIG_PATH", ""), "NOT_LOCAL");
			Element elem = document.getRootElement();
			List<Element> liste = elem.getChildren();
			for (Iterator<Element> iterator = liste.iterator(); iterator.hasNext();) {
				Element element = (Element) iterator.next();
				
				if (element.getName().equals("INSTALED")) {
					confObj.set_installed(element.getValue());
					
				}else if (element.getName().equals("APP_PATH")) {
					confObj.set_appliRacine(element.getValue());
					
				}else if (element.getName().equals("DBA_PATH")) {
					confObj.set_dbRacine(element.getValue());
					
				}else if (element.getName().equals("CONF_PATH")) {
					confObj.set_confRacine(element.getValue());
					
				}
			}
		} catch (JDOMException e) {
			System.err.println(PEnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		} catch (IOException e) {
			System.err.println(PEnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		}
		
		return confObj;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.createConfigObject()</b><br/>
	 *
	 *<b>Description: </b> Cree et renvoit un objet Config a partir des parametres passes a la methode.<br/>
	 *<br/>
	 * @param configTab_
	 * @return Config
	 */
	public Config createConfigObject(String[] configTab_, ArrayList<String> listeReps_){
		
		// Cration de l'objet de conf.
		
		Config confObj = new Config();
		
		confObj.set_installed(configTab_[3]);
		
		for (Iterator<String> iterator = listeReps_.iterator(); iterator.hasNext();) {
			String rep = (String) iterator.next();
			
			if (!rep.contains("conf") && !rep.contains("xml") && !rep.contains("csv")) {
				confObj.set_appliRacine(rep);
			}else if (rep.contains("conf")) {
				confObj.set_confRacine(rep);
			}else {
				confObj.set_dbRacine(rep.substring(0, rep.lastIndexOf(_ressources.getSepSystem())));
			}
		}
		
		return confObj;
	}
	
	public boolean writeConfigObject(Config confObj_, String path_){
		
		String confxml = _ressources.getSepProj() + _ressources.getXmlDirectory() + _ressources.getSepProj() + "users.xml";	// Chemin du fichier xml

		// Chargement du fichier xml.
		Document document = null;
		Element racine = null;
		try {
			document = FichierUtils.getInstance().readXMLFile(confxml, "LOCAL");
			racine = document.getRootElement();
		} catch (JDOMException jdomexcep) {
			JOptionPane.showMessageDialog(null, jdomexcep.getMessage() + "\nChemin : " + confxml);
			return false;
		} catch (IOException ioexcep) {
			JOptionPane.showMessageDialog(null, ioexcep.getMessage() + "\nChemin : " + confxml);
			return false;
		}

		// On initialise le user
		Element installed = new Element("INSTALLED");
		Element app_path = new Element("APP_PATH");
		Element dba_path = new Element("DBA_PATH");
		Element conf_path = new Element("CONF_PATH");
		
		installed.setText(confObj_.get_installed());
		app_path.setText(confObj_.get_appliRacine());
		dba_path.setText(confObj_.get_dbRacine());
		conf_path.setText(confObj_.get_confRacine());
		
		racine.addContent(installed);
		racine.addContent(app_path);
		racine.addContent(dba_path);
		racine.addContent(conf_path);

		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		
		try {
			outputter.output(document, new FileOutputStream(path_));
		} catch (FileNotFoundException e) {
			System.err.println(PEnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
			return false;
		} catch (IOException e) {
			System.err.println(PEnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
			return false;
		}

		return true;
	}


	public Config get_configObj() {
		return _configObj;
	}

	public void set_configObj(Config _configObj) {
		this._configObj = _configObj;
	}
	
	
	
}
