package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitLoadingPage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/skip_button")
    private MobileElement skipButton;

    public InitLoadingPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void skipAnimation(WebDriverWait wait){
        skipButton.click();
    }
}
