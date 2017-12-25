import io.appium.java_client.windows.WindowsDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sang Nguyen on 7/5/2017.
 */
public class NotepadTest {
    private static WindowsDriver driver = null;
    private static WebElement element = null;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void quitDriver() {
        driver.closeApp();
        driver.findElementByName("Don't Save").click();
        driver.quit();
    }

    @Test
    public void test1() {
        WebElement element = driver.findElementByName("Text Editor");
        element.sendKeys("This is some text");
        element.sendKeys(Keys.ENTER);
        element.sendKeys("Time is");
        element.sendKeys(Keys.ENTER);
        element.sendKeys(Keys.F5);
    }

    @Test
    public void test2() throws IOException {
        driver.findElementByName("Edit").click();
        //driver.findElementByName("Select All").click();
        element.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        File ss = (driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ss, new File("Np.png"));
    }
}
