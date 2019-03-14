package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;

public class BaseClass {

    public static WebDriver driver;

    public static final String baseUrl = "https://nodal.com";

    public WebDriver SetUp(){

        // OSX
        File classPathRoot = new File(System.getProperty("user.dir"));
        File specsFolder = new File(classPathRoot, "chromedriver");
        System.setProperty("webdriver.chrome.driver", specsFolder.toString());

        // Uncomment if on Windows
//        System.setProperty("webdriver.chrome.driver", "chromedriver-win.exe");

        driver = new ChromeDriver();

        return driver;
    }
}
