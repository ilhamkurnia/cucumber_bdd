package com.cucumber.bdd;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.cucumber.bdd.config.AutomationFrameworkConfig;
import com.cucumber.bdd.driver.DriverSingleton;
import com.cucumber.bdd.pages.LoginPages;
import com.cucumber.bdd.utils.ConfigurationProperties;
import com.cucumber.bdd.utils.Constants;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private static WebDriver driver;
	private LoginPages loginPages;
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPages = new LoginPages();
	}
	
	@AfterAll
	public static void quitDriver() {
		tunggu(10);
		driver.quit();
	}
	
	@Given("User mengakses url")
	public void customer_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}
	
	@When("User login dengan username dan password")
	public void customer_login_dengan_username_password() {
		loginPages.loginForm(configurationProperties.getEmail(), configurationProperties.getPassword());
	}
	
	@Then("User berhasil login")
	public void customer_berhasil_login() {
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getTextUser(), loginPages.getTxtUser());
	}
	
	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
