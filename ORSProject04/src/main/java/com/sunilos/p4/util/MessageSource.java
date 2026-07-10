package com.sunilos.p4.util;

import java.util.Locale;
import java.util.ResourceBundle;

public final class MessageSource {

	public static String ENGLISH_LANG_CODE = "en"; // language code define kiya hai
	public static String HINDI_LANG_CODE = "hi";
	public static String DEFAULT_LANGUAGE = ENGLISH_LANG_CODE;

	private static MessageSource ms = null; /// only one singletone banani hai

	private ResourceBundle rb = null;

	private MessageSource() { /// private constuct banai hai 
		this(DEFAULT_LANGUAGE);
	}

	private MessageSource(String lang) {
		rb = ResourceBundle.getBundle("message", new Locale(lang)); /// langauage code recive karta ha 
	}

	private MessageSource(Locale locale) {
		this(locale.getLanguage());
	}

	public static MessageSource getInstance() { /// user langaiua select nhai karta ha to by default englis aai gi
		return getInstance(DEFAULT_LANGUAGE);
	}

	public static MessageSource getInstance(String languageCode) { /// agar object nahi bana hai
		if (ms == null) { /// object bana de ga 
			ms = new MessageSource(languageCode);
		}
		return ms; /// object bana ha to  retur 
	}

	public void setLocale(String lang) {
		rb = ResourceBundle.getBundle("message", new Locale(lang));
	}

	public String getLanguage() {
		return rb.getLocale().getLanguage(); // currnet lanaga retur karta ha 
	}

	public String get(String key) {
		String val = ""; /// String emty banai hai
		try {
			val = rb.getString(key); // rb se value ko nikala
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}

	public static void main(String[] args) {
		MessageSource ms = MessageSource.getInstance();
		ms.setLocale("hi");
		String val = ms.get("login.userid");
		System.out.println("-->" + val);
	}
}
