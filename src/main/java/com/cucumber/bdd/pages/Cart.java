package com.cucumber.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.bdd.driver.DriverSingleton;

public class Cart {
	
private WebDriver driver;
	
	public Cart() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	private WebElement btnWomen;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	private WebElement btnDress;
	
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	private WebElement btnShirt;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")
	private WebElement viewProductWomen;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img")
	private WebElement viewProductDress;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	private WebElement viewProductShirt;
	
	@FindBy(id = "add_to_cart")
	private WebElement btnAddToCart;	
	
	@FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
	private WebElement btnContinue;
	
	
	public void OrderProductWomen() {
		btnWomen.click();
		viewProductWomen.click();
		tunggu(5);
		changeLayer(driver);
		btnAddToCart.click();
		driver.switchTo().defaultContent();
		btnContinue.click();
	}
	
	public void OrderProductDress() {
		btnDress.click();
		viewProductDress.click();
		tunggu(5);
		changeLayer(driver);
		btnAddToCart.click();
		driver.switchTo().defaultContent();
		btnContinue.click();
	}
	
	public void OrderProductShirt() {
		btnShirt.click();
		viewProductShirt.click();
		tunggu(5);
		changeLayer(driver);
		btnAddToCart.click();
		driver.switchTo().defaultContent();
		btnContinue.click();
	}
	
	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void changeLayer(WebDriver driver) {
		driver.switchTo().frame(driver.findElement(By.className("fancybox-iframe")));
	}
	
	public static void popUps(WebDriver driver) {
		driver.switchTo().alert();
		driver.findElement(By.className("continue btn btn-default button exclusive-medium")).click();;
	}
	
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0, -1000)");
	}
	
	
	

}
