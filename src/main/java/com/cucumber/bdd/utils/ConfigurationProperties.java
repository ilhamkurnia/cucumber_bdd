package com.cucumber.bdd.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${email}")
	private String email;
	
	@Value("${password}")
	private String password;
	
	@Value("${textUser}")
	private String textUser;
	
	@Value("${textUser}")
	private String textBerhasil;
	
	@Value("${textCheckout}")
	private String textCheckout;
	
	@Value("${textPayment}")
	private String textPayment;

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTextUser() {
		return textUser;
	}

	public void setTextUser(String textUser) {
		this.textUser = textUser;
	}

	public String getTextBerhasil() {
		return textBerhasil;
	}

	public void setTextBerhasil(String textBerhasil) {
		this.textBerhasil = textBerhasil;
	}

	public String getTextCheckout() {
		return textCheckout;
	}

	public void setTextCheckout(String textCheckout) {
		this.textCheckout = textCheckout;
	}

	public String getTextPayment() {
		return textPayment;
	}

	public void setTextPayment(String textPayment) {
		this.textPayment = textPayment;
	}
	
	
	
	
	
	
	
	
	
	
}
