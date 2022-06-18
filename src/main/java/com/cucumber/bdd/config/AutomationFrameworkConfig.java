package com.cucumber.bdd.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("com.cucumber.bdd")
public class AutomationFrameworkConfig {

	public AutomationFrameworkConfig() {
		
	}
	
}