package Framework;

import Framework.enums.Mobile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;

public class BaseTestLogin {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException, MalformedURLException {



        driver = Os.getDriver(Mobile.ANDROID);



        Thread.sleep(1000);
    }


    public void quit() {
        driver.quit();
    }

    public  File[] getListOfFiles(String directoryName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File directory = new File(classLoader.getResource(directoryName).getFile());
        File[] files = directory.listFiles();
        // System.out.println("Found " + files.length + " files in " + directoryName + " folder");
        return files;
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException{
        driver.quit();
    }
}
