package tests.day1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApkYukleme {
    AndroidDriver <AndroidElement> driver;

    //IOSDriver<IOSElement> iosDriver;

    AppiumDriver<MobileElement> appiumDriver;
    //// Her iki platformda da çalışır .

    @Test
    public void apkYukleme() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");


        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\LENOVO\\OneDrive\\Masaüstü\\Git\\Yeni_Proje\\Appium_T130\\Apps\\all-currency-converter-3-9-0 (1).apk");
        // Uygulamayı yüklemek için kullanılır .. Eger yüklü degilse kontrol eder yükler .. yüklü ise yüklü olup olmadıgını kontrol eder ve yüklüyse uygulamayı açar


        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }
}
