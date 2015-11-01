/* HISTORIQUE
 *
 * [Modif]  - V.01 - 00/00/0000 - Ajout de l'historique.
 * [Create] - V.00 - 00/00/0000 - Creation de la classe.
 *
 * FIN HISTORIQUE
 */
package org.tref.model;

import com.jtattoo.plaf.AbstractLookAndFeel;

/**
 * Classe de ...
 */
public interface ILAndF {

	/** Methode getLafName();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the lafName
	 */
	public abstract String getLafName();

	/** Methode setLafName();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * String LAndFImpl.java
	 * 
	 * @return the lafName
	 */
	public abstract void setLafName(String lafName_);

	/** Methode getLafPath();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the lafPath
	 */
	public abstract String getLafPath();

	/** Methode setLafPath();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * String LAndFImpl.java
	 * 
	 * @return the lafPath
	 */
	public abstract void setLafPath(String lafPath_);

	/** Methode getLafObject();
	 * [DESCRIPTION]:
	 * Cette methode retourne (le/la/les) </br></br>
	 * 
	 * @return the lafObject
	 */
	public abstract AbstractLookAndFeel getLafObject();

	/** Methode setLafObject();
	 * [DESCRIPTION]:
	 * Cette methode initialise (le/la/les) </br></br>
	 * [PARAMETRES]:
	 * AbstractLookAndFeel LAndFImpl.java
	 * 
	 * @return the lafObject
	 */
	public abstract void setLafObject(AbstractLookAndFeel lafObject_);

	/* Methodes overridee de sa classe mere.
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public abstract int hashCode();

	/* Methodes overridee de sa classe mere.
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public abstract boolean equals(Object obj);

	/* Methodes overridee de sa classe mere.
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public abstract String toString();

}