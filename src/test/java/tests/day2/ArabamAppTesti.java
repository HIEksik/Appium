package tests.day2;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArabamAppTesti {
    AndroidDriver <AndroidElement>driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();


        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        capabilities.setCapability("appPackage","com.dogan.arabam");   // çalışacak oldugumuz uygulamayı başlata bilmek için kullandıgımız capabilitiy ... Hangi uygulama başlatılacaksa
        // uygulamanın kimlik bilgisini girerek başlatabiliriz

        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity"); // uygulamada çalışacagımız sayfanın aktivity degerini buraya giriyoruz --
        // bize veriliyor --- biz alırsak --apk dan sondaki  boşluk ve sonrasını siliyoruz


        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }


    @Test
    public void arabamTest() throws InterruptedException {





        /*
        driver.activateApp("com.dogan.arabam");
        // bu method uygulamanın ilk açılır penceresinden başlar
         */

        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementByAccessibilityId("İlan Ver").isDisplayed());
        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();
        // kategori olarak otomobil secilir
        driver.findElementByXPath("//*[@text='Otomobil']").click();
        Thread.sleep(1000);

        // arac olarak Volkswagen secilir
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(440,1882)) // başlangıç ve bitiş noktamız

                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(80))) // Parmagımızla kaydırma hızı veya zamanı .. Süre artarsa kaydırma mesafesi azalır.. Azalırsa kaydırma mesafesi artar

                .moveTo(PointOption.point(440,330)) // parmagımızla nereye kadar dokunacağımız
                .release() // parmagı ekrandan kaldırma / kaydırma sonlandırma
                .perform(); // görevleri yap

        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();

        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Highline']").click();
        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        driver.findElementById("com.dogan.arabam:id/textViewSorting").click();
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();

        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        String enUcuzAracFiyati =driver.findElementByXPath("(//*[@resource-id='com.dogan.arabam:id/tvPrice'])[1]").getText();
        System.out.println(enUcuzAracFiyati);// 780.000 TL  -- sonucu böyle getirecek

        enUcuzAracFiyati=enUcuzAracFiyati.replaceAll("\\D",""); // String manipulasyon yapıldı sayı olmayan herşey silindi

        System.out.println(enUcuzAracFiyati); // 78000  // şimdi parse yapmaya hazır

        Assert.assertTrue(Integer.parseInt(enUcuzAracFiyati)>500000); // parse yaptık ınt e çevirdik ve 500.000 tl den buyuk oldugunu doğruladık








    }
}
