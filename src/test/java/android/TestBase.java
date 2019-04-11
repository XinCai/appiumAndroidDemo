package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {

    private AppiumServer appium;
    protected AppiumDriver driver;
    protected WebDriverWait wait;
    private DesiredCapabilities caps;

    @Parameters ({ "server", "device" })
    @BeforeTest
    public void setupTest () throws MalformedURLException {
        appium = new AppiumServer(); // pass server address from testng later
        appium.startServer();

        caps = new DesiredCapabilities();
        caps.setCapability("avd", "Nexus_5X_API_27");
        //caps.setCapability("avd", "Nexus_5X_API_28");
        //caps.setCapability("avd", "nexus_5_8.1");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        //caps.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        caps.setCapability("app","/Users/hostapp/Downloads/app-alphaFlavor-debug.apk");

    }

    @BeforeMethod
    public void setupMethod () throws MalformedURLException {

        driver = new AndroidDriver<IOSElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        //driver = new AndroidDriver<IOSElement>(new URL("http://192.168.99.100:4723/wd/hub"),caps);

        wait = new WebDriverWait(driver,60);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void teardownMethod () {
        driver.quit();
    }

    @AfterTest
    public void tearDownTest () {

        appium.stopServer();
    }
}