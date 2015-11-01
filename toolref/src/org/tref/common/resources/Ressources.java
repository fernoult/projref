package org.tref.common.resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.tref.Access;
import org.tref.common.resources.enums.EnumExtensions;

public class Ressources {

	/** Instance de la classe Ressources */
	private static Ressources RES_INSTANCE;
	
	/** separateur systeme */
	private static final String SEP_SYS = System.getProperty("file.separator");

	/** separateur de l'application. */
	private static final String SEP = "/";
	
	/** Chemin de la racine des packages "utiles" */
	private static final String PACKAGE_RACINE = Access.class.getPackage().getName().replace(".", SEP);
	
	/** Chemin de la racine des resources communes de l'appli */
	private static final String COMMON_RACINE = PACKAGE_RACINE + SEP + "common";
	
	/** Racine du package des fichiers de conf et de bd. */
	private static final String FILES_RACINE =  PACKAGE_RACINE + SEP + "common" + SEP + "localdb";
	
	/** Racine des fichiers .properties. */
	private static final String PROPS_DIRECTORY = FILES_RACINE + SEP + "props";
	
	/** Racine des fichiers xml. */
	private static final String XML_DIRECTORY = FILES_RACINE + SEP + "xml";
	
	/** Racine des fichiers csv. */
	private static final String CSV_DIRECTORY = FILES_RACINE + SEP + "csv";
	
	/** Racine des fichiers txt. */
	private final String TXT_DIRECTORY = FILES_RACINE + SEP + "txt";

	/** Chemin du fichier properties des communs. */
	private static final String COMMON_PROPERTIES =  COMMON_RACINE.replace(SEP, ".") + ".Common";
	
	/** Chemin du fichier properties des logs. */
	private static final String LOGS_PROPERTIES =  COMMON_RACINE.replace(SEP, ".") + ".Logs";
	
	/** Bundle d'acces au properties communs du projet */
	private static final ResourceBundle COMMON_BUNDLE = ResourceBundle.getBundle(COMMON_PROPERTIES);

	/** Bundle d'acces au properties communs du projet */
	private static final ResourceBundle LOGS_BUNDLE = ResourceBundle.getBundle(LOGS_PROPERTIES);
	
	/** SimpleDateFormat commun du projet */
	public static final SimpleDateFormat COMMON_SDF = new SimpleDateFormat(COMMON_BUNDLE.getString("log.date.pattern.value"));
	
	/**
	 * Constructeur.
	 */
	private Ressources(){
		
	}
	
	/**
	 * <b>Methode:  org.se.common.resources.getInstance()</b><br/>
	 *
	 *<b>Description: </b> Renvoit l'instance de la classe de ressources.<br/>
	 *<br/>
	 * @return Ressources
	 */
	public static Ressources getInstance(){
		
		if (RES_INSTANCE == null) {
			RES_INSTANCE = new Ressources();
		}
		return RES_INSTANCE;
	}

	/**
	 * <b>Methode:  org.se.common.resources.getCommonLabel()</b><br/>
	 *
	 *<b>Description: </b> Retourne la valeur de la cle passee en parametres depuis le fichier Common.properties.<br/>
	 *<br/>
	 * @param key_
	 * @return String
	 */
	public String getCommonLabel(String key_){
		return COMMON_BUNDLE.getString(key_);
	}
	
	/**
	 * <b>Methode:  org.se.common.resources.getLogsLabel()</b><br/>
	 *
	 *<b>Description: </b> Retourne la valeur de la cle passee en parametres depuis le fichier Logs.properties.<br/>
	 *<br/>
	 * @param key_
	 * @return String
	 */
	public String getLogsLabel(String key_){
		return LOGS_BUNDLE.getString(key_);
	}
	
	/**
	 * <b>Methode:  org.se.common.resources.getDateMillis()</b><br/>
	 *
	 *<b>Description: </b> Retourne la date courante formatee en millisecondes.<br/>
	 *<br/>
	 * @return String
	 */
	public String getDateMillis() {
		return COMMON_SDF.format(new Date());
	}
	
	// LOGS TESTS
	public static final String LOGS_TEST_ERREUR = getInstance().getLogsLabel("logs.test.erreur.message");
	public static final String LOGS_TEST_SUCCES = getInstance().getLogsLabel("logs.test.succes.message");
	public static final String LOGS_TEST_WARNING = getInstance().getLogsLabel("logs.test.warning.message");
	public static final String LOGS_TEST_INFO = getInstance().getLogsLabel("logs.test.info.message");
	public static final String LOGS_TEST_ACTION = getInstance().getLogsLabel("logs.test.action.message");
	
	// ALREADY RUNNING
	/** Titre de la JOPtionPane du already running. */
	public static final String ALREADY_RUN_TITLE = getInstance().getCommonLabel("alreadyrun.title.text");

	/** Message de la JOPtionPane du already running. */
	public static final String ALREADY_RUN_MESSAGE = getInstance().getCommonLabel("alreadyrun.message.text");
	
	/** Nom de la Preference */
	public static final String ALREADY_INSTALLED = getInstance().getCommonLabel("config.alreadyInstalled.text");

	/** Numero de port associe a l'instance de l'application */
	public static final int LAUNCH_PORT = 12000;


	// LAndFImpl
	public static String getDefaultLAF() {
		return getInstance().getCommonLabel("laf.default.name");
	}
	
	/**
	 * <b>Methode:  org.se.common.resources.getFilePath()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin du fichier passe en parametre et <br/>
	 * 	renomme le fichier avec la bonne extensio le cas echeant.<br/>
	 *<br/>
	 * @param fileName_
	 * @param type_
	 * @return String
	 */
	public String getFilePath(String fileName_, EnumExtensions type_){
		
		String ext = type_.getExtension(), retour = null, prefix = type_.getRepository() + SEP;
		int begin = 0, end = 0;
		
		if (fileName_.contains(".")) {
			
			begin = fileName_.lastIndexOf(".");
			end = fileName_.length();
			
			for (int i = 0; i < EnumExtensions.values().length; i++) {
				if (!fileName_.substring(begin, end).equals(ext)) {
					retour = prefix + reformat(fileName_, ext, begin, end);
				}else {
					retour = prefix + fileName_;
				}
			}
			
		}else {
			retour = prefix + fileName_ + ext;
		}
		
		return retour;
	}

	/**
	 * <b>Methode:  org.se.common.resources.getRepositoryPath()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin du repertoire passe en parametre.<br/>
	 *<br/>
	 * @param type_
	 * @return String
	 */
	public String getRepositoryPath(EnumExtensions type_){
		return type_.getRepository();
	}
	
	/**
	 * <b>Methode:  org.se.common.resources.reformat()</b><br/>
	 *
	 *<b>Description: </b> Reformate le fichier passe en parametre avec la bonne extension.<br/>
	 *<br/>
	 * @param fileName_
	 * @param ext
	 * @return String
	 */
	private String reformat(String fileName_, String ext, int begin_, int end_) {
		
		String old = fileName_.substring(begin_, end_);
		return fileName_.replace(old, ext);
		
	}
	
	/**
	 * <b>Methode:  org.se.common.resources.get_sep()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le separateur.<br/>
	 *<br/>
	 * @return String
	 */
	public String getSepProj() {
		return SEP;
	}

	public String getSepSystem(){
		return SEP_SYS;
	}
	/**
	 * <b>Methode:  org.se.common.resources.get_fileRacine()</b><br/>
	 *
	 *<b>Description: </b> Renvoit la racine des fichiers de db.<br/>
	 *<br/>
	 * @return String
	 */
	public String getFileRacine() {
		return FILES_RACINE;
	}

	/**
	 * <b>Methode:  org.se.common.resources.get_propsDirectory()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin du repertoire des fichiers de properties.<br/>
	 *<br/>
	 * @return String
	 */
	public String getPropsDirectory() {
		return PROPS_DIRECTORY;
	}

	/**
	 * <b>Methode:  org.se.common.resources.get_xmlDirectory()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin du repertoire des fichiers xml.<br/>
	 *<br/>
	 * @return String
	 */
	public String getXmlDirectory() {
		return XML_DIRECTORY;
	}

	/**
	 * <b>Methode:  org.se.common.resources.get_csvDirectory()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin du repertoire des fichiers csv.<br/>
	 *<br/>
	 * @return String
	 */
	public String getCsvDirectory() {
		return CSV_DIRECTORY;
	}

	/**
	 * <b>Methode:  org.se.common.resources.get_txtDirectory()</b><br/>
	 *
	 *<b>Description: </b> Renvoit le chemin du repertoire des fichiers txt<br/>
	 *<br/>
	 * @return String
	 */
	public String getTxtDirectory() {
		return TXT_DIRECTORY;
	}

}
