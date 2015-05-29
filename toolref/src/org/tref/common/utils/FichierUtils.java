package org.tref.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.tref.Access;
import org.tref.common.resources.PEnumLogs;
import org.tref.common.resources.Ressources;

public class FichierUtils {

	private static final Ressources _ressources = Ressources.getInstance();
	
	private static FichierUtils FM_INSTANCE;
	
	private ArrayList<String> _listeReps = new ArrayList<>();
	
	private ArrayList<String> _listefiles = new ArrayList<>();
	
//	private Path _copyXmlConfPath;
	
	private FileOutputStream _copyXmlConfPath;
	
	private FichierUtils(){
		
	}
	
	public static FichierUtils getInstance(){
		if (FM_INSTANCE == null) {
			FM_INSTANCE = new FichierUtils();
		}
		return FM_INSTANCE;
	}
	
	private static boolean createFile(String repositoryPath_, String fileName_){
		
		File file = new File(repositoryPath_ + fileName_);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	private static boolean createFile(String fullPath_){
		
		File file = new File(fullPath_);
		try {
			file.createNewFile();
			System.out.println(PEnumLogs.INFO.getLogMessage("Creation du fichier " + fullPath_));
		} catch (IOException e) {
			System.err.println(PEnumLogs.ERREUR.getLogMessage("echec de la creation de " + fullPath_));
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean createRepository(String path_){
		
		File file = new File(path_);
		if (!file.exists()) {
			file.mkdirs();
			System.out.println(PEnumLogs.INFO.getLogMessage("creation du repertoire " + path_));
		}else {
			System.err.println(PEnumLogs.ERREUR.getLogMessage("echec de la creation de " + path_));
			return false;
		}
		return true;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.createArbo()</b><br/>
	 *
	 *<b>Description: </b> Cree l'arborescence de repertoires et fichiers.<br/>
	 *<br/>
	 * @param path_
	 * @return boolean
	 */
	synchronized public boolean createArbo(String path_){
		
		// Initialise les chemins des repertoires.
		_listeReps.add(path_);
		_listeReps.add(path_ + _ressources.getSepSystem() + "db" + _ressources.getSepSystem() + "xml");
		_listeReps.add(path_ + _ressources.getSepSystem() + "db" + _ressources.getSepSystem() + "csv");
		_listeReps.add(path_ + _ressources.getSepSystem() + "conf");
		
		// Initialise les chemins des fichiers.
		_listefiles.add(path_ + _ressources.getSepSystem() + "conf" + _ressources.getSepSystem() + "conf.xml");
		
		File files = new File(path_);
		
		if (!files.exists()) {
			
			String confPath = null;
			
			try {
				// Creation des repertoires.
				for (Iterator<String> iterator = _listeReps.iterator(); iterator.hasNext();) {
					String rep = (String) iterator.next();
					createRepository(rep);
				}
				Thread.sleep(1000);
				
				// Creation des fichiers.
				for (Iterator<String> iterator = _listefiles.iterator(); iterator.hasNext();) {
					String file = (String) iterator.next();
					if (file.contains("conf")) {
						confPath = _listefiles.get(0);
					}
					createFile(file);
				}
				Thread.sleep(1000);
				
			} catch (InterruptedException e1) {
				System.err.println(PEnumLogs.ERREUR.getLogMessage(e1.getClass().getName() + " - " + e1.getMessage()));
				return false;
			}
			
			createConfFile(confPath, _listeReps);
			
		}else {
			System.err.println(PEnumLogs.WARNING.getLogMessage("le chemin " + path_ + " n'est pas retrouve."));
			removeArbo(path_, null);
			return false;
		}
		return true;
	}
	
	/**
	 * <b>Methode:  org.se.common.utils.removeArbo()</b><br/>
	 *
	 *<b>Description: </b> Detruit l'arborescende de l'application.<br/>
	 *<br/>
	 * @param path_ void
	 */
	public void removeArbo(String path_, Config confObj_){ // D:\DEPLOIE_TEST\EveSports
		
		try {
			
			System.out.println(PEnumLogs.INFO.getLogMessage("Supression des fichiers de l'arborescence"));
			Files.deleteIfExists(Paths.get(confObj_.get_confRacine() + _ressources.getSepSystem() + "conf.xml"));
			Files.deleteIfExists(Paths.get(confObj_.get_dbRacine() + _ressources.getSepSystem() + "xml" + _ressources.getSepSystem() + "users.xml"));
			Thread.sleep(500);
			
			System.out.println(PEnumLogs.INFO.getLogMessage("Supression des repertoires de l'arborescence"));
			Files.deleteIfExists(Paths.get(confObj_.get_confRacine()));
			Files.deleteIfExists(Paths.get(confObj_.get_dbRacine() + _ressources.getSepSystem() + "xml"));
			Files.deleteIfExists(Paths.get(confObj_.get_dbRacine() + _ressources.getSepSystem() + "csv"));
			Files.deleteIfExists(Paths.get(confObj_.get_dbRacine()));
			Thread.sleep(500);

			System.out.println(PEnumLogs.INFO.getLogMessage("Supression du repertoire principal"));
			Files.deleteIfExists(Paths.get(confObj_.get_appliRacine()));
			
			
		} catch (IOException e) {
			System.err.println(PEnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
		} catch (InterruptedException e) {
			System.err.println(PEnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
		}
	}
	
	private boolean createConfFile(String path_, ArrayList<String> listeReps_){
		
		// On recupere les valeurs par defaut:
		String[] tab = _ressources.getCommonLabel("config.default.values").split(" ");
		if (!ConfigUtils.getInstance().writeConfigObject(ConfigUtils.getInstance().createConfigObject(tab, listeReps_), path_)) {
			return false;
		}
		
		return true;
	}
	
	public Document readXMLFile(String fullFileName_, String type_) throws JDOMException, IOException{
		
		Document document = new Document();										// Creation du document de retour.
		SAXBuilder sxb = new SAXBuilder();										// Creation du builder.
		
		if (type_.equals("LOCAL")) {
			document = sxb.build(Access.class.getResourceAsStream(fullFileName_));	// Initialisation du document de retour.			
		}else {
			document = sxb.build(new File(fullFileName_));	// Initialisation du document de retour.
		}
		
		return document;
	}
	
	
}
