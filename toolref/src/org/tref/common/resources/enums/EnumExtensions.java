package org.tref.common.resources.enums;

import org.tref.common.resources.Ressources;


public enum EnumExtensions {

	XML(".xml", Ressources.getInstance().getXmlDirectory()),
	TXT(".txt", Ressources.getInstance().getTxtDirectory()),
	CSV(".csv", Ressources.getInstance().getCsvDirectory()),
	PROPS(".properties", Ressources.getInstance().getPropsDirectory());
	
	private String _ext = "";
	private String _repo = "";
	
	/**
	 * Constructeur.
	 * @param ext_
	 * @param repo_
	 */
	EnumExtensions(String ext_, String repo_){
		_ext = ext_;
		_repo = repo_;
	}
	
	/**
	 * Methode overridee toString()
	 */
	@Override
	public String toString() {
		return _ext + " " + _repo;
	}
	
	/**
	 * <b>Methode:  com.common.getRepository()</b><br/>
	 *
	 *<b>Description: </b> Retourne le repertoire des fichiers concernes.<br/>
	 *<br/>
	 * @return String
	 */
	public String getRepository(){
		return _repo;
	}
	
	/**
	 * <b>Methode:  com.common.getExtension()</b><br/>
	 *
	 *<b>Description: </b> Retourne l'extension de fichier<br/>
	 *<br/>
	 * @return String
	 */
	public String getExtension() {
		return _ext;
	}
	
}
