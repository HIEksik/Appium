package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReusableMethods {
    static AndroidDriver<AndroidElement> driver=Driver.getAndroidDriver();
    public static void koordinatTiklamaMethodu(int x,int y) throws InterruptedException {
        TouchAction action=new TouchAction(driver);
        action.press(PointOption.point(x,y)).release().perform();
        Thread.sleep(1000);
    }



}