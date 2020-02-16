package com.demo.rest.service.impl;

import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.rest.domain.Greeting;
import com.demo.rest.domain.Person;
import com.demo.rest.exception.GreetingException;
import com.demo.rest.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

	private static final Logger LOG = LoggerFactory.getLogger(GreetingServiceImpl.class);

	@Override
	public Greeting getGreeting(Locale locale, Person person) {
		try {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("greeting.messages.message", locale);
			String message = resourceBundle.getString("greeting");
			return new Greeting(person.getFirstname(), person.getLastname(), message);
		} catch (Exception ex) {
			LOG.error("getGreeting() ", ex);
			throw new GreetingException();
		}
	}
}