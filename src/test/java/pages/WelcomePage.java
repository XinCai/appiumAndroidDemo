package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    private AppiumDriver driver;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/btn_events")
    private MobileElement btnEvents;

    // Drawer open -- xpath
    // //android.widget.ImageButton[@content-desc="Drawer open"]

    @AndroidFindBy(xpath = "android.widget.ImageButton[@content-desc='Drawer open']")
    private MobileElement drawerOpen;


    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/rememberPassword")
    private MobileElement rememberPassword;


    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/sign_up")
    private MobileElement signUp;


    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/btn_promotions")
    private MobileElement btnPromotions;


    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/btn_bookhotel")
    private MobileElement btnBookHotel;


    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/btn_restaurants")
    private MobileElement btnRestaurants;


    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/btn_casino")
    private MobileElement btnCasino;


    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/btn_bars_and_club")
    private MobileElement btnBarsAndClub;


    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/btn_starplay")
    private MobileElement btnStarPlay;


    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/btn_member_login")
    private MobileElement btnMemberLogin;


    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/login_title")
    private MobileElement loginTitle;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/member_id_edittext")
    private MobileElement memeberIdEditText;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/password_edittext")
    private MobileElement passwordEditText;

    @AndroidFindBy(id = "au.com.star.app.debug.debug:id/sign_in")
    private MobileElement singIn;


    public WelcomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void login(String userName, String password) {
        driver.findElementById("au.com.star.app.debug.debug:id/login_title").click();
        driver.findElementById("au.com.star.app.debug.debug:id/member_id_edittext").click();
        driver.findElementById("au.com.star.app.debug.debug:id/member_id_edittext").sendKeys(userName);
        driver.findElementById("au.com.star.app.debug.debug:id/password_edittext").click();
        driver.findElementById("au.com.star.app.debug.debug:id/password_edittext").sendKeys(password);
        driver.findElementById("au.com.star.app.debug.debug:id/sign_in").click();
    }
}
