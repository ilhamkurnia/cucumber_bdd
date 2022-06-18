package com.cucumber.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.bdd.driver.DriverSingleton;

public class LoginPages {
	
private WebDriver driver;
	
	public LoginPages() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement btnSignIn;
	
	@FindBy(name = "email")
	private WebElement inputEmail;
	
	@FindBy(name = "passwd")
	private WebElement inputPassword;
	
	@FindBy(name = "SubmitLogin")
	private WebElement btnLogin;
	
	@FindBy(className = "account")
	private WebElement txtUser;
	
	public void loginForm(String email, String password) {
		btnSignIn.click();
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public String getTxtUser() {
		return txtUser.getText();
	}

}
