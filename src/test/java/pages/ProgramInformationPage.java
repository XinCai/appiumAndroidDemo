package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgramInformationPage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/tier_points")
    private MobileElement tierPoints;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/my_benefits")
    private MobileElement myBenefits;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/star_gifts")
    private MobileElement starGift;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/casino_dollars")
    private MobileElement casinoDollar;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement haveQuestions;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[2]")
    private MobileElement faq;

    public ProgramInformationPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void haveQuestions(){
        haveQuestions.click();
    }

    public void tierPoints(){
        tierPoints.click();
    }

    public void starGift(){
        starGift.click();
    }

}
