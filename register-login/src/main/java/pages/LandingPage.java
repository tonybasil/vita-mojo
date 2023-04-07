package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LandingPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    @FindBy(xpath = "//*[@id=\"single-spa-application:@vmos2/storeSelection\"]/div/div[1]/header/div/div/a")
    private WebElement loginButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        if (!driver.getCurrentUrl().contains("/store-selection")) {
            throw new IllegalStateException("This is not the landing Page," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

}
