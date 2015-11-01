package org.tref.common.tools;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.tref.Access;

public class FileToolXML {

	/** Instance unique de la classe. */
	private static FileToolXML XMLU_INSTANCE;
	
	/**
	 * Constructeur
	 */
	private FileToolXML() {
	}
	
	/**
	 * Retourne l'instance de la classe.
	 * @return
	 */
	public static FileToolXML getInstance(){
		
		// Le singleton qui va bien.
		if (XMLU_INSTANCE == null) {
			XMLU_INSTANCE = new FileToolXML();
		}
		
		return XMLU_INSTANCE;
	}
	
	/**
	 * Creer un fichier XML
	 * @return
	 */
	public boolean createXMLFile(){
		return true;
	}
	
	/**
	 * Creer plusieurs fichiers XML
	 * @return
	 */
	public boolean createXMLFiles(){
		return true;
	}
	
	/**
	 * Lit et retourne un objet Document a partir d'un fichier XML.
	 * @param fullFileName_
	 * @param type_
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
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
