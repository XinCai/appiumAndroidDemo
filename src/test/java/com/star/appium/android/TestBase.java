package com.star.appium.android;

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

    protected AppiumServer appium;
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setupMethod () {

    }

    @Parameters ({ "server", "device" })
    @BeforeTest
    public void setupTest () throws MalformedURLException {
        this.appium = new AppiumServer(); // pass server address from testng later
        this.appium.startServer();

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("avd", "Nexus_5_API_28");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        caps.setCapability("app","/Users/hostapp/Downloads/app-alphaFlavor-debug.apk");

        driver = new AndroidDriver<IOSElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver,60);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardownMethod () {

    }

    @AfterTest
    public void tearDownTest () {
        driver.quit();
        this.appium.stopServer();
    }
}