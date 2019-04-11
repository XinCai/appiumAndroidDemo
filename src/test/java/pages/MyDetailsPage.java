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

public class MyDetailsPage {

    private AppiumDriver driver;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/contact_mobile_txt")
    private MobileElement mobileNumber;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/contact_home_txt")
    private MobileElement homePhone;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/tv_item_value")
    private MobileElement emailId;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/residential_add_txt")
    private MobileElement residentialAddress;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/mailing_add_txt")
    private MobileElement mailAddress;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/password_parent")
    private MobileElement passwordTab;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/txt_dob")
    private MobileElement memberDob;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/txt_member_id")
    private MobileElement memberID;


    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/member_name")
    private MobileElement memeberName;

    public MyDetailsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public String getMemberId(){
        return memberID.getText();
    }

    public String getMemberName(){
        return memeberName.getText();
    }

    public String getDateOfBirth(){
        return memberDob.getText();
    }

    public String getMobileNum(){
        return mobileNumber.getText();
    }

    public String getHomePhone(){
        return homePhone.getText();
    }

    public String getEmail(){
        return emailId.getText();
    }


    public void scrollDown(AppiumDriver driver, WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(memberID));

        TouchAction touchAction = new TouchAction(driver);

        for (int i = 0; i < 1; i++) {
            //touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(880,1200)));
            touchAction.press(PointOption.point(880,1285)).moveTo(PointOption.point(880,120)).release().perform();
        }
    }
}
