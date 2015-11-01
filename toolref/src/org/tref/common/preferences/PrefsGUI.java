package org.tref.common.preferences;

import java.util.Locale;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.tref.Access;
import org.tref.common.resources.Ressources;
import org.tref.common.resources.enums.EnumLogs;
import org.tref.views.ViewsRessources;
import org.tref.views.frames.erreurs.ErrorFrame;

public class PrefsGUI {

	private static PrefsGUI PREFS_INSTANCE;
	
	private Locale _locale;
	
	private String _laf;
	
	private Preferences prefs = Preferences.userNodeForPackage(Access.class);
	
	private static final String THEMES = "THEME";
	
	private static final String LANGUE = "LANGUE";
	
	private PrefsGUI() {
		
	}
	
	public static PrefsGUI getInstance(){
		
		// Le singleton qui va bien.
		if (PREFS_INSTANCE == null) {
			PREFS_INSTANCE = new PrefsGUI();
		}
		
		return PREFS_INSTANCE;
	}

	
	public void initPrefs(){
		
		String langue = prefs.get(LANGUE, "fr");
		String country = langue.toUpperCase();
		
		_locale = new Locale(langue, country);
		_laf = prefs.get(THEMES, "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		
		System.out.println("LAndFImpl DANS LES PREFS : " + _laf);
		System.out.println("LOCALE DANS LES PREFS : " + langue + " " + country);

		ViewsRessources.getInstance().setLocale(_locale);
		ViewsRessources.getInstance().setLookAndFeel(_laf);
	
	}
	
	public void updateLOC(Locale locale_){
		
		try {
			prefs.put(LANGUE, locale_.getLanguage());
			prefs.flush();
			
		} catch (BackingStoreException e) {
			System.err.println(EnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		}
		
		_locale = new Locale(locale_.getLanguage(), locale_.getCountry());
		ViewsRessources.getInstance().setLocale(_locale);
	}
	
	public void updateLAF(String laf_){
		
		try {
			prefs.put(THEMES, laf_);
			prefs.flush();
			
		} catch (BackingStoreException e) {
			System.err.println(EnumLogs.ERREUR.getLogMessage(e.getClass().getName() + " - " + e.getMessage()));
			new ErrorFrame(e.getClass().toString(), e.getStackTrace());
		}
		
		_laf = laf_;
		ViewsRessources.getInstance().setLookAndFeel(_laf);
	}
	
	public String getLAF(){
		
		if (_laf == null) {
			_laf = prefs.get(THEMES, Ressources.getDefaultLAF());
		}
		return _laf;
	}
	
	public Locale getLocale(){
		return _locale;
	}
}
