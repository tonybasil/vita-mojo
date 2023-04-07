package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    @FindBy(id = "email")
    private WebElement loginEmailInputField;
    @FindBy(id = "password")
    private WebElement loginPasswordInputField;
    @FindBy(xpath = "//*[@id=\"auth\"]/ul/li/button[2]")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"scroll-container\"]/div[1]/div/div/section/ul/li[2]")
    private WebElement createAccountTab;

    @FindBy(id = "email")
    private WebElement createAccountEmailInputField;
    @FindBy(id = "password")
    private WebElement createAccountPasswordInputField;
    @FindBy(id = "phoneNumber")
    private WebElement createAccountPhoneNumberInputField;
    @FindBy(id = "firstName")
    private WebElement createAccountNameInputField;
    @FindBy(xpath = "//*[@id=\"auth\"]/ul/li/button")
    private WebElement createAccountButton;

    @FindBy(xpath = "//*[@id=\"auth\"]/ul/li/div[3]/div/div/div")
    private WebElement countryCodeField;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(loginEmailInputField));
        if (!driver.getCurrentUrl().contains("/auth/login")) {
            throw new IllegalStateException("This is not the login Page," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public LoginPage sendEmail(String email) {
        loginEmailInputField.sendKeys(email);
        return this;
    }

    public LoginPage sendPassword(String password) {
        loginPasswordInputField.sendKeys(password);
        return this;
    }

    public LoginPage clickCreateAccountTab() {
        createAccountTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(createAccountPhoneNumberInputField));
        return this;
    }

    public String fetchCountryCode() {
        return countryCodeField.getText();
    }


    public LoginPage fillRegistrationForm(String email, String password, String name, String phoneNumber) {
        createAccountEmailInputField.sendKeys(email);
        createAccountPasswordInputField.sendKeys(password);
        createAccountNameInputField.sendKeys(name);
        createAccountPhoneNumberInputField.sendKeys(phoneNumber);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public LoginVerificationPage clickLoginButton() {
        loginButton.click();
        return new LoginVerificationPage(driver);
    }

}
