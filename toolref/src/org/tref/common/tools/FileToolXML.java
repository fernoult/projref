package org.tref.common.utils;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.tref.Access;

public class XMLFileUtils {

	private static XMLFileUtils XMLU_INSTANCE;
	
	private XMLFileUtils() {
	}
	
	public static XMLFileUtils getInstance(){
		
		if (XMLU_INSTANCE == null) {
			XMLU_INSTANCE = new XMLFileUtils();
		}
		
		return XMLU_INSTANCE;
	}
	
	public boolean createXMLFile(){
		return true;
	}
	
	public boolean createXMLFiles(){
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
