package com.app.crud.estudiante.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Utilitario {

	@Autowired
	private MessageSource messageSource;
	
	public String getMessage(String key, Object... args) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(key, args, locale);
	}
}
