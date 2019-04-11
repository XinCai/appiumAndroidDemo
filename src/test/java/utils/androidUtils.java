package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class androidUtils {
    public void goBack(AppiumDriver driver){
        //TODO:
    }

    public void getScreenshot(AppiumDriver<AndroidElement> element) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        Date date = new Date();

        String fileName = simpleDateFormat.format(date);
        File des = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(des,new File(System.getProperty("user.dir") + "//Screeshot//" + fileName + ".png"));
        System.out.println("Screenshot is captured");
    }

}
