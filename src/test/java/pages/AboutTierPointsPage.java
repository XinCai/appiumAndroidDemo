package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AboutTierPointsPage {

    private AppiumDriver driver;


    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/page_title")
    private MobileElement title;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/desc")
    private MobileElement description;

    public AboutTierPointsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    public String getTitle() {
        return title.getText();
    }

}
