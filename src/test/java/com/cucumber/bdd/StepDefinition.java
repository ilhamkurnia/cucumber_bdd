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
import com.cucumber.bdd.pages.Transaksi;
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
	private Transaksi transaksi;

	@Autowired
	ConfigurationProperties configurationProperties;

	@Before
	public void setUp() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPages = new LoginPages();
		cart = new Cart();
		transaksi = new Transaksi();
	}

	@AfterAll
	public static void quitDriver() {
		tunggu(10);
		driver.quit();
	}

	@Given("User mengakses url")
	public void user_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}

	@When("User login dengan username dan password")
	public void user_login_dengan_username_password() {
		loginPages.loginForm(configurationProperties.getEmail(), configurationProperties.getPassword());
	}

	@Then("User berhasil login")
	public void user_berhasil_login() {
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getTextBerhasil(), loginPages.getTxtUser());
	}

	@When("User menambahkan product women")
	public void user_tambah_product_women() {
		cart.OrderProductWomen();
	}

	@And("User menambahkan product dress")
	public void user_tambah_product_dress() {
		cart.OrderProductDress();
	}

	@And("User menambahkan product shirt")
	public void user_tambah_product_shirt() {
		cart.OrderProductShirt();
	}

	@Then("User berhasil menambahkan ketiga product")
	public void customer_berhasil_membeli() {
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getTextCheckout(), cart.getTxtCheckout());
	}

	@When("User proceed product")
	public void user_proceed_product() {
		transaksi.processSummary();
	}

	@And("User proceed address")
	public void user_proceed_address() {
		transaksi.processAddress();
	}
	
	@And("User proceed shipping")
	public void user_proceed_shipping() {
		transaksi.processShipping();
	}
	
	@And("User payment product")
	public void user_payment_product() {
		transaksi.processPayment();
	}
	
	@Then("User berhasil membayar product")
	public void user_berhasil_membayar_product() {
		driver.navigate().refresh();
		tunggu(2);
		assertEquals(configurationProperties.getTextPayment(), transaksi.getTxtPayment());
		
	}

	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
