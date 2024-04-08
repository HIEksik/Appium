package tests.day4;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyApp;
import utils.Driver;
import utils.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyConverter {


    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();

    AllCurrencyApp page=new AllCurrencyApp();

    @Test
    public void allCurrunvyAppTest() throws InterruptedException, IOException {

        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));
// uygulamanin acildigi dogrulanir
        Assert.assertTrue(page.toolBar.isDisplayed());

// cevirmek istedigimiz para birimi zloty olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(493,480);
        ReusableMethods.scrollWithUiScrollableAndClick("PLN");


// cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(497,658);
        ReusableMethods.scrollWithUiScrollableAndClick("TRY");
        ReusableMethods.scrollWithUiScrollableAndClick("1");
        for (int i = 0; i < 3; i++) {
            page.sisift.click();
        }

// cevrilen tutar screenShot olarak kaydedilir
        // 1. Yol
       // File ekranKaydi=driver.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(ekranKaydi,new File("plnTotry.jpg"));

        // 2.Yol
        ReusableMethods.getScreenshot("TryToZloty");
// Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
// kullaniciya sms olarak bildirilir

        String tryDeger=page.tryText.getText();
        driver.sendSMS("5555555555","Zloty nin Try karsiligi: "+tryDeger);










    }
}
