package properties;

import utils.PropertyReader;

public class VitaMojoUIProperties {

    private static PropertyReader propertyReader = new PropertyReader("ui-integration.properties");

    public static String vitaMojoWebUrl = propertyReader.getProperty("vita_mojo_url");
    public static String selectedBrowser = propertyReader.getProperty("browser");

    public static String chromeDriver = propertyReader.getProperty("chrome_driver");

    public static String firefoxDriver = propertyReader.getProperty("firefox_driver");

}
