package com.star.appium.android;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TheStarAppTest extends TestBase {

    @DataProvider
    public static Iterator <Object []> getOrientation () {
        final List <Object []> data = new ArrayList();
        data.add (new Object [] { ScreenOrientation.LANDSCAPE });
        data.add (new Object [] { ScreenOrientation.PORTRAIT });
        return data.iterator ();
    }

    @Test
    public void LoginTest() {

        //skip button click
        driver.findElement(By.id("au.com.star.app.debug.debug:id/skip_button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logobanner")));

        // scroll to end of term and condition
        scrollDownAndAcceptCondtion();
        login("1442830", "star2468");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("au.com.star.app.debug.debug:id/membership_parent")));

        //assert the member name and memebership tier
        Assert.assertEquals("SUNNY P3 TEST", driver.findElement(By.id("au.com.star.app.debug.debug:id/membership_tile_member_name")).getText());
        Assert.assertEquals("BRONZE", driver.findElement(By.id("au.com.star.app.debug.debug:id/membership_tile_current_tier")).getText());
    }

    private void login(String userName, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("au.com.star.app.debug.debug:id/login_title")));
        driver.findElementById("au.com.star.app.debug.debug:id/login_title").click();
        driver.findElementById("au.com.star.app.debug.debug:id/member_id_edittext").click();
        driver.findElementById("au.com.star.app.debug.debug:id/member_id_edittext").sendKeys(userName);
        driver.findElementById("au.com.star.app.debug.debug:id/password_edittext").click();
        driver.findElementById("au.com.star.app.debug.debug:id/password_edittext").sendKeys(password);
        driver.findElementById("au.com.star.app.debug.debug:id/sign_in").click();
    }


    @Test
    public void starAppStartTest1 () {

        System.out.println("this is testing start ....");

    }


    @Test
    public void starAppStartTest2 () {

        System.out.println("this is testing start ....");

    }

    private void scrollDownAndAcceptCondtion(){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(1000,1000)).moveTo(PointOption.point(500,500)).release().perform();

        touchAction.press(PointOption.point(1000,1000)).moveTo(PointOption.point(500,500)).release().perform();
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1000,1000)));
        touchAction.press(PointOption.point(1000,1000)).moveTo(PointOption.point(500,500)).release().perform();
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1000,1000)));
        touchAction.press(PointOption.point(1000,1000)).moveTo(PointOption.point(500,500)).release().perform();
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1000,1000)));
        touchAction.press(PointOption.point(1000,1000)).moveTo(PointOption.point(500,500)).release().perform();
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1000,1000)));
        touchAction.press(PointOption.point(1000,1000)).moveTo(PointOption.point(500,500)).release().perform();
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1000,1000)));
        touchAction.press(PointOption.point(1000,1000)).moveTo(PointOption.point(500,500)).release().perform();
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1000,1000)));
        touchAction.press(PointOption.point(1000,1000)).moveTo(PointOption.point(500,500)).release().perform();

        driver.findElement(By.id("au.com.star.app.debug.debug:id/id_terms_agree_checkbox")).click();
        touchAction.tap(TapOptions.tapOptions().withPosition(PointOption.point(1000,1000)));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("au.com.star.app.debug.debug:id/btn_license_accept")));
        driver.findElement(By.id("au.com.star.app.debug.debug:id/btn_license_accept")).click();
    }

    private void scrollDown() {
        //if pressX was zero it didn't work for me
        int pressX = driver.manage().window().getSize().width / 2;
        // 4/5 of the screen as the bottom finger-press point
        int bottomY = driver.manage().window().getSize().height * 4/5;
        // just non zero point, as it didn't scroll to zero normally
        int topY = driver.manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        scroll(pressX, bottomY, pressX, topY);
    }

    /*
     * don't forget that it's "natural scroll" where
     * fromY is the point where you press the and toY where you release it
     */
    private void scroll(int fromX, int fromY, int toX, int toY) {

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(fromX,fromY)).moveTo(PointOption.point(toX,toY)).release().perform();
    }


    public void scrollToCoordinates(int coordinate) {


        TouchAction action = new TouchAction(driver);
        PointOption pointOptionFrom = new PointOption();
        pointOptionFrom.withCoordinates(0,200);

        PointOption pointOptionTo = new PointOption();
        pointOptionTo.withCoordinates(100,coordinate);

        WaitOptions waitOptions = new WaitOptions();

        action.press(pointOptionFrom).waitAction().waitAction().moveTo(pointOptionTo).release().perform();

    }

    public void scrollAndClick(String visibleText) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))")).click();
    }

//
//        this.main.onElement ("DoubleTap")
//                .tap ();
//
//        final DoubleTapActivity p = new DoubleTapActivity (this.androidDevice);
//        p.onElement ("Button")
//                .doubleTap ();
//
//        final String message = p.onDevice ()
//                .handleAlert ();
//        Assert.assertEquals (message, "Double tap successful!");
//
//        this.main.onElement ("Back")
//                .tap ();
    //}
//
//    /**
//     * @author wasiq.bhamla
//     * @since Feb 2, 2018 2:59:25 PM
//     */
//    @Test
//    public void testDragDrop () {
//        this.main.onElement ("DragDrop")
//                .tap ();
//
//        final DragDropActivity dd = new DragDropActivity (this.androidDevice);
//        dd.onElement ("DropMe")
//                .dragDrop (dd.getElement ("DropZone"));
//        dd.onElement ("Success")
//                .verifyThat ()
//                .textShouldBeEqualTo ("Circle dropped");
//
//        this.main.onElement ("Back")
//                .tap ();
//    }
//
//    /**
//     * @author wasiqb
//     * @since Oct 20, 2018
//     */
//    @Test
//    public void testLogin () {
//        final LoginActivityAction login = new LoginActivityAction (this.androidDevice);
//        login.addInputValue ("UserName", "admin")
//                .addInputValue ("Password", "admin")
//                .perform ();
//    }
//
//    /**
//     * @author wasiq.bhamla
//     * @since Feb 8, 2018 4:15:53 PM
//     */
//    @Test
//    public void testLongPress () {
//        this.main.onElement ("LongPress")
//                .tap ();
//
//        final LongPressActivity lp = new LongPressActivity (this.androidDevice);
//        lp.onElement ("Button")
//                .longPress ();
//        final String message = lp.onDevice ()
//                .handleAlert ();
//        Assert.assertEquals (message, "you pressed me hard :P");
//
//        this.main.onElement ("Back")
//                .tap ();
//    }
//
//    /**
//     * @author wasiq.bhamla
//     * @throws InterruptedException
//     * @since Jan 23, 2018 9:39:20 PM
//     */
//    @Test
//    public void testNativeView () throws InterruptedException {
//        this.main.onElement ("ChainedView")
//                .tap ();
//
//        final ChainedViewActivity chained = new ChainedViewActivity (this.androidDevice);
//        chained.onElement ("Text1")
//                .verifyThat ()
//                .textShouldBeEqualTo ("Hello World, I'm View one ");
//        chained.onElement ("Text2")
//                .verifyThat ()
//                .textShouldBeEqualTo ("Hello World, I'm View two ");
//        chained.onElement ("Text3")
//                .verifyThat ()
//                .textShouldBeEqualTo ("Hello World, I'm View three ");
//
//        this.main.onElement ("Back")
//                .tap ();
//    }
//
//    /**
//     * @author wasiqb
//     * @param orientation
//     * @since Oct 21, 2018
//     */
//    @Test (dataProvider = "getOrientation")
//    public void testRotation (final ScreenOrientation orientation) {
//        this.main.onDevice ()
//                .rotate (orientation);
//        assertThat (this.main.onDevice ()
//                .rotation ()
//                .name ()).isEqualTo (orientation.name ());
//    }
//
//    /**
//     * @author wasiq.bhamla
//     * @since Jan 27, 2018 7:45:48 PM
//     */
//    @Test
//    public void testSlider () {
//        this.main.onElement ("Slider")
//                .tap ();
//
//        final SliderActivity slide = new SliderActivity (this.androidDevice);
//        slide.onElement ("Slider")
//                .swipe (SwipeDirection.RIGHT, SwipeStartPosition.LEFT, 75);
//        slide.onElement ("Slider1")
//                .swipe (SwipeDirection.LEFT, SwipeStartPosition.RIGHT, 75);
//
//        this.main.onElement ("Back")
//                .tap ();
//    }
//
//    /**
//     * @author wasiq.bhamla
//     * @since Feb 1, 2018 3:15:23 PM
//     */
//    @Test
//    public void testVerticleSwipe () {
//        this.main.onElement ("VerticalSwipe")
//                .tap ();
//
//        final VerticleSwipeActivity vs = new VerticleSwipeActivity (this.androidDevice);
//        vs.onElement ("List")
//                .swipe (SwipeDirection.UP, SwipeStartPosition.BOTTOM, 25);
//        vs.onElement ("List")
//                .swipe (SwipeDirection.DOWN, SwipeStartPosition.TOP, 25);
//
//        this.main.onElement ("Back")
//                .tap ();
//    }
}