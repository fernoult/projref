/* ihmref-LAF.java
 * HISTORIQUE
 *
 * [MODIF]: Version - le 9 avr. 2015 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.views.comp.vbeans;

import com.jtattoo.plaf.AbstractLookAndFeel;

public class LAF {

	private String _lafName;
	private String _lafPath;
	private AbstractLookAndFeel _lafObject;
	
	/** LAF
	 * Constructeur
	 */
	public LAF() {
		super();
	}
	
	/** LAF
	 * Constructeur
	 */
	public LAF(String lafName_, String lafPath_, AbstractLookAndFeel lafObject_) {
		super();
		_lafName = lafName_;
		_lafPath = lafPath_;
		_lafObject = lafObject_;
	}

	/** Methode getLafName();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the lafName
	 */
	public String getLafName() {
		return _lafName;
	}

	/** Methode setLafName();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * String LAF.java
	 * 
	 * @return the lafName
	 */
	public void setLafName(String lafName_) {
		_lafName = lafName_;
	}

	/** Methode getLafPath();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the lafPath
	 */
	public String getLafPath() {
		return _lafPath;
	}

	/** Methode setLafPath();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * String LAF.java
	 * 
	 * @return the lafPath
	 */
	public void setLafPath(String lafPath_) {
		_lafPath = lafPath_;
	}

	/** Methode getLafObject();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the lafObject
	 */
	public AbstractLookAndFeel getLafObject() {
		return _lafObject;
	}

	/** Methode setLafObject();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * AbstractLookAndFeel LAF.java
	 * 
	 * @return the lafObject
	 */
	public void setLafObject(AbstractLookAndFeel lafObject_) {
		_lafObject = lafObject_;
	}

	/* Methodes overridee de sa classe mere.
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_lafName == null) ? 0 : _lafName.hashCode());
		result = prime * result
				+ ((_lafObject == null) ? 0 : _lafObject.hashCode());
		result = prime * result
				+ ((_lafPath == null) ? 0 : _lafPath.hashCode());
		return result;
	}

	/* Methodes overridee de sa classe mere.
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LAF other = (LAF) obj;
		if (_lafName == null) {
			if (other._lafName != null)
				return false;
		} else if (!_lafName.equals(other._lafName))
			return false;
		if (_lafObject == null) {
			if (other._lafObject != null)
				return false;
		} else if (!_lafObject.equals(other._lafObject))
			return false;
		if (_lafPath == null) {
			if (other._lafPath != null)
				return false;
		} else if (!_lafPath.equals(other._lafPath))
			return false;
		return true;
	}

	/* Methodes overridee de sa classe mere.
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LAF [_lafName=" + _lafName + ", _lafPath=" + _lafPath
				+ ", _lafObject=" + _lafObject + "]";
	}
	
	
	
	
	
}
