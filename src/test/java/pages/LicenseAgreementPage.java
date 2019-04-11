package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LicenseAgreementPage {

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/id_terms_agree_checkbox")
    private MobileElement termAgreeCheckbox;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/btn_license_accept")
    private MobileElement licenseAcceptBtn;

    @AndroidFindBy(id = "logobanner")
    private MobileElement logobanner;

    private AppiumDriver driver;

    public LicenseAgreementPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    public void scrollDownAndAcceptCondtion(AppiumDriver driver, WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(logobanner));
        TouchAction touchAction = new TouchAction(driver);

        for (int i = 0; i < 15; i++) {
            touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1000,1000)));
            touchAction.press(PointOption.point(1000,1000)).moveTo(PointOption.point(500,500)).release().perform();
        }

        termAgreeCheckbox.click();
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1000,1000)));
        wait.until(ExpectedConditions.elementToBeClickable(licenseAcceptBtn));
        licenseAcceptBtn.click();
    }


}
