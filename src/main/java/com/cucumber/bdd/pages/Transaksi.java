package com.cucumber.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.bdd.driver.DriverSingleton;

public class Transaksi {
	
private WebDriver driver;
	
	public Transaksi() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")
	private WebElement btnProcessSum;
	
	@FindBy(css = "#center_column > form > p > button")
	private WebElement btnProcessAddress;
	
	@FindBy(css = "#form > p > button > span")
	private WebElement btnProcessShipping;
	
	@FindBy(css = "#ordermsg > textarea")
	private WebElement inputInfoAddress;
	
	@FindBy(id = "uniform-cgv")
	private WebElement cbTerm;
	
	@FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
	private WebElement btnPayWire;
	
	@FindBy(css = "#cart_navigation > button")
	private WebElement btnConfirm;
	
	
	@FindBy(className = "navigation_page")
	private WebElement txtPayment;
	
	public void processSummary() {
		scrollDown(driver);
		btnProcessSum.click();
	}
	
	public void processAddress() {
		scrollDown(driver);
		inputInfoAddress.sendKeys("Jl. Raya Pondok Rajeg");
		btnProcessAddress.click();
	}
	
	public void processShipping() {
		scrollDown(driver);
		cbTerm.click();
		btnProcessShipping.click();
	}
	
	public void processPayment() {
		scrollDown(driver);
		btnPayWire.click();
		scrollDown(driver);
		btnConfirm.click();
	}
	
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0, 1000)");
	}
	
	public String getTxtPayment() {
		return txtPayment.getText();
	}
	


}
