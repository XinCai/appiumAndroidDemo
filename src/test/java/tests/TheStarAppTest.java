package tests;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import android.TestBase;
import android.TestData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class TheStarAppTest extends TestBase {

//    @DataProvider
//    public static Iterator <Object []> getOrientation () {
//        final List <Object []> data = new ArrayList();
//        data.add (new Object [] { ScreenOrientation.LANDSCAPE });
//        data.add (new Object [] { ScreenOrientation.PORTRAIT });
//        return data.iterator ();
//    }


    @DataProvider
    public Object[][] getData() throws FileNotFoundException {

        String filePath = new File("").getAbsolutePath();
        JsonElement jsonData = new JsonParser().parse(new FileReader( filePath + "/src/test/java/android/data.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<TestData> testData = new Gson().fromJson(dataSet, new TypeToken<List<TestData>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @Test(dataProvider = "getData")
    public void loginTest(TestData data) {

        InitLoadingPage initLoadingPage = new InitLoadingPage(driver);
        initLoadingPage.skipAnimation(wait);
        
        LicenseAgreementPage licenseAgreementPage = new LicenseAgreementPage(driver);
        licenseAgreementPage.scrollDownAndAcceptCondtion(driver,wait);

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.login(data.getUsername(),data.getPassword());

        //assert the member name and memebership tier
        Assert.assertEquals( driver.findElement(By.id("au.com.star.app.debug.debug:id/membership_tile_member_name")).getText(),data.getMemberName());
        Assert.assertEquals(driver.findElement(By.id("au.com.star.app.debug.debug:id/membership_tile_current_tier")).getText(), data.getMemberTier());
    }

    @Test(dataProvider = "getData")
    public void logoutTest (TestData data) {
        InitLoadingPage initLoadingPage = new InitLoadingPage(driver);
        initLoadingPage.skipAnimation(wait);

        LicenseAgreementPage licenseAgreementPage = new LicenseAgreementPage(driver);
        licenseAgreementPage.scrollDownAndAcceptCondtion(driver, wait);

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.login(data.getUsername(), data.getPassword());

        MembershipPage membershipPage = new MembershipPage(driver);
        membershipPage.logout();

        Assert.assertEquals(driver.findElement(By.id("au.com.star.app.debug.debug:id/login_title")).getAttribute("text"), "Login");

    }

    @Test(dataProvider = "getData")
    public void checkMemeberTierPointsTest(TestData data) {
        InitLoadingPage initLoadingPage = new InitLoadingPage(driver);
        initLoadingPage.skipAnimation(wait);

        LicenseAgreementPage licenseAgreementPage = new LicenseAgreementPage(driver);
        licenseAgreementPage.scrollDownAndAcceptCondtion(driver, wait);

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.login(data.getUsername(), data.getPassword());

        MembershipPage membershipPage = new MembershipPage(driver);

        String currentTierpoints = membershipPage.getCurrentTierPoints();
        String nextTierPoints = membershipPage.getNextTierPoints();
        Assert.assertEquals(currentTierpoints, data.getCurrentTierPoints());
        Assert.assertEquals(nextTierPoints, data.getNextTierPoints());

    }

    @Test(dataProvider = "getData")
    public void checkCasinoDollarsTest (TestData data) {
        InitLoadingPage initLoadingPage = new InitLoadingPage(driver);
        initLoadingPage.skipAnimation(wait);

        LicenseAgreementPage licenseAgreementPage = new LicenseAgreementPage(driver);
        licenseAgreementPage.scrollDownAndAcceptCondtion(driver, wait);

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.login(data.getUsername(), data.getPassword());

        MembershipPage membershipPage = new MembershipPage(driver);
        membershipPage.scrollDown(driver,wait);
        String casinoDollars = membershipPage.getCasinoDollars();
        Assert.assertEquals(casinoDollars, data.getCasinoDollars());

    }

    @Test(dataProvider = "getData")
    public void checkCustomerEmailTest (TestData data) {
        InitLoadingPage initLoadingPage = new InitLoadingPage(driver);
        initLoadingPage.skipAnimation(wait);

        LicenseAgreementPage licenseAgreementPage = new LicenseAgreementPage(driver);
        licenseAgreementPage.scrollDownAndAcceptCondtion(driver, wait);

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.login(data.getUsername(), data.getPassword());

        MembershipPage membershipPage = new MembershipPage(driver);
        membershipPage.goToMemberDetailPage();

        MyDetailsPage detailsPage = new MyDetailsPage(driver);
        detailsPage.scrollDown(driver,wait);
        String email = detailsPage.getEmail();
        Assert.assertEquals(email, data.getEmail());
    }

    @Test(dataProvider = "getData")
    public void checkProgramInformationTest (TestData data) {
        InitLoadingPage initLoadingPage = new InitLoadingPage(driver);
        initLoadingPage.skipAnimation(wait);

        LicenseAgreementPage licenseAgreementPage = new LicenseAgreementPage(driver);
        licenseAgreementPage.scrollDownAndAcceptCondtion(driver, wait);

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.login(data.getUsername(), data.getPassword());

        MembershipPage membershipPage = new MembershipPage(driver);
        membershipPage.openProgramInfo();

        ProgramInformationPage programInformationPage = new ProgramInformationPage(driver);
        programInformationPage.tierPoints();

        AboutTierPointsPage tierPointsPage = new AboutTierPointsPage(driver);

        Assert.assertEquals(tierPointsPage.getTitle(), "ABOUT TIER POINTS");

    }


    @Test(dataProvider = "getData")
    public void checkCustomerInfoTest (TestData data) {
        InitLoadingPage initLoadingPage = new InitLoadingPage(driver);
        initLoadingPage.skipAnimation(wait);

        LicenseAgreementPage licenseAgreementPage = new LicenseAgreementPage(driver);
        licenseAgreementPage.scrollDownAndAcceptCondtion(driver, wait);

        WelcomePage welcomePage = new WelcomePage(driver);

        welcomePage.login(data.getUsername(), data.getPassword());

        MembershipPage membershipPage = new MembershipPage(driver);
        membershipPage.goToMemberDetailPage();

        MyDetailsPage detailsPage = new MyDetailsPage(driver);
        //detailsPage.scrollDown(driver,wait);
//        String dateOfBirth = detailsPage.getDateOfBirth();
        String name = detailsPage.getMemberName();
       // String homePhone = detailsPage.getHomePhone();
        //String mobilePhone = detailsPage.getMobileNum();
        //String memeberID = detailsPage.getMemberId();
        Assert.assertEquals("222", data.getMemberName().contains(name));
    }

}