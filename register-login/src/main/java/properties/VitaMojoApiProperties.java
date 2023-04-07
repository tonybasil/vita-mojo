package properties;

import utils.PropertyReader;

public class VitaMojoApiProperties {
    private static PropertyReader propertyReader = new PropertyReader("api-integration.properties");

    public static String v1SignupUrl = propertyReader.getProperty("vita_mojo_base_url") + "/user/v1/user";
    public static String v1LoginUrl = propertyReader.getProperty("vita_mojo_base_url") + "/user/v1/auth";

}
