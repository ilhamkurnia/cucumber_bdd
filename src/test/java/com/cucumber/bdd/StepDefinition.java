package com.cucumber.bdd;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.cucumber.bdd.config.AutomationFrameworkConfig;
import com.cucumber.bdd.driver.DriverSingleton;
import com.cucumber.bdd.pages.Cart;
import com.cucumber.bdd.pages.LoginPages;
import com.cucumber.bdd.pages.Transaction;
import com.cucumber.bdd.utils.ConfigurationProperties;
import com.cucumber.bdd.utils.Constants;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private static WebDriver driver;
	private LoginPages loginPages;
	private Cart cart;
	private Transaction transaction;
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPages = new LoginPages();
		cart = new Cart();
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
	
	
	@And("User Menambahkan Product")
	public void user_tambah_product() {
		cart.OrderProductWomen();
		cart.OrderProductDress();
		cart.OrderProductShirt();
	}
	
	@And("User Membayar Product")
	public void user_buy_product() {
		scrollDown(driver);
		transaction.processSummary();
		transaction.processAddress();
	}
	
	@Then("User berhasil membeli product")
	public void customer_berhasil_membeli() {
	}
	
	
	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0, 1000)");
	}
	
}
