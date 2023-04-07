package browserhandler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import properties.VitaMojoUIProperties;

public class BrowserHandler {

    public WebDriver fetchBrower(String selectedBrowser) throws Exception {
        if (selectedBrowser.equals("chrome"))
            return fetchChromeBrowser();
        else if (selectedBrowser.equals("firefox"))
            return fetchFirefoxBrowser();
        throw new Exception("No browser selected");
    }
    private WebDriver fetchFirefoxBrowser() {
        // Firefox driver may not work. Faced some issue here while running the tests
        System.setProperty("webdriver.gecko.driver", getClass().getClassLoader().getResource(VitaMojoUIProperties.firefoxDriver).getPath());
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver fetchChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource(VitaMojoUIProperties.chromeDriver).getPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable--notifications");
        options.addArguments("disable-infobars");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

}
