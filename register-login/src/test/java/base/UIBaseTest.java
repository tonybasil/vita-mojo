package base;

import browserhandler.BrowserHandler;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import properties.VitaMojoUIProperties;

public class UIBaseTest {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setup() throws Exception {
        driver.set(new BrowserHandler().fetchBrower(VitaMojoUIProperties.selectedBrowser));
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.get().close();
        driver.get().quit();
    }

}
