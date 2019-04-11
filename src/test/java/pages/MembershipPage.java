package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MembershipPage {

    // logout button on drawer open
    //au.com.star.app.debug.debug:id/lin_menu_item_layout


    // casino dollar amt decimal
    //au.com.star.app.debug.debug:id/casino_dollar_amt_decimal

    // casino dollar amt separator
    //au.com.star.app.debug.debug:id/amt_seperator

    // casino dollar amt int
    //au.com.star.app.debug.debug:id/casino_dollar_amt_int

    // casino dollar holder
    //au.com.star.app.debug.debug:id/casino_dollar_lamount_holder

    // my offers
    // au.com.star.app.debug.debug:id/my_offers_img

    // parking
    //au.com.star.app.debug.debug:id/free_parking_img

    // drawer open - xpath
    //  android.widget.ImageButton[@content-desc="Drawer open"]

    // drawer open view
    //au.com.star.app.debug.debug:id/drawerRecyclerView


    // under this element : xpath value
        //  dashboard : (//android.widget.ImageView[@content-desc="image"])[6]

        // program information : (//android.widget.ImageView[@content-desc="image"])[7]
        @AndroidFindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout[2]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout")
        private MobileElement programInfo;

        // jackpot status : (//android.widget.ImageView[@content-desc="image"])[8]

        // play online : (//android.widget.ImageView[@content-desc="image"])[9]

        // my details : (//android.widget.ImageView[@content-desc="image"])[10]

        // FAQ : (//android.widget.ImageView[@content-desc="image"])[11]

    private AppiumDriver driver;
    // xpath
////android.widget.ImageButton[@content-desc="Drawer open"]
    @AndroidFindBy(accessibility = "Drawer open")
    private MobileElement drawerOpen;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/casino_dollar_amt_int")
    private MobileElement casinoDollars;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/membership_tile")
    private MobileElement membershipTitle;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/membership_tile_member_name")
    private MobileElement memberName;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/membership_tile_current_tier")
    private MobileElement membershipCurrentTier;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/tier_points_current")
    private MobileElement currentTierPoints;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/tier_points_next")
    private MobileElement nextTierPoints;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/star_gift_to_next")
    private MobileElement starGiftToNext;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/btn_cancel")
    private MobileElement cancelLogoutBtn;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/btn_call")
    private MobileElement logoutConfirmBtn;


    public MembershipPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void logout() {
        drawerOpen.click();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout[2]/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).click();

        logoutConfirmBtn.click();
    }

    public String getMememberShipName(){
        return memberName.getText();
    }

    public String getMemberShipTitle(){
        return membershipTitle.getText();
    }

    public String getMemberTier(){
        return membershipCurrentTier.getText();
    }

    public String getCurrentTierPoints(){
        return currentTierPoints.getText();
    }

    public String getNextTierPoints(){
        return nextTierPoints.getText();
    }

    public String getCasinoDollars() {
        return casinoDollars.getText();
    }

    public void scrollDown(AppiumDriver driver, WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(currentTierPoints));

        TouchAction touchAction = new TouchAction(driver);

        for (int i = 0; i < 1; i++) {
            touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1050,950)));
            touchAction.press(PointOption.point(1050,950)).moveTo(PointOption.point(1050,300)).release().perform();
        }
    }

    public void goToMemberDetailPage(){
        memberName.click();
    }

    public void openDrawer(){
        drawerOpen.click();
    }

    public void openProgramInfo(){
        drawerOpen.click();
        programInfo.click();
    }
}

