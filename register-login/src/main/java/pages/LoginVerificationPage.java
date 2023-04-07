package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginVerificationPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberField;

    public LoginVerificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberField));
        if (!driver.getCurrentUrl().contains("/account/verification")) {
            throw new IllegalStateException("This is not the login verification Page," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public String fetchPhone() {
        return phoneNumberField.getAttribute("value");
    }

}
