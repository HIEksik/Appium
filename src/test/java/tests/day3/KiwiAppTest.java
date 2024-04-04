package tests.day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

public class KiwiAppTest {

    AndroidDriver<AndroidElement> driver=Driver.getAndroidDriver();
    KiwiPage page=new KiwiPage();




    @Test
    public void kiwiAppTest() throws InterruptedException {

// uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled(ConfigReader.getProperty("kiwiKimlik")));
// uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(page.misafirButonu.isDisplayed());
// misafir olarak devam et e tiklanir
        page.misafirButonu.click();
        Thread.sleep(1000);
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        page.continueButonu.click();
        Thread.sleep(1000);
        page.continueButonu.click();
        Thread.sleep(1000);
        page.exploreTheAppButuno.click();



// Trip type,one way olarak secilir
       Thread.sleep(2000);
       ReusableMethods.koordinatTiklamaMethodu(196,724);
       ReusableMethods.koordinatTiklamaMethodu(209,1800);
// kalk//is ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.koordinatTiklamaMethodu(336,889);
        ReusableMethods.koordinatTiklamaMethodu(1016,244);
// kalk//is yapilacak ulke/sehir girilir ve sec e tiklanir
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Istanbul");
        } else {
            page.sehirEkleKutusu.sendKeys("Ankara");
        }
        Thread.sleep(1000);
        ReusableMethods.koordinatTiklamaMethodu(253,405);

        page.chooseButton.click();
// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        ReusableMethods.koordinatTiklamaMethodu(323,1040);
       driver.getKeyboard().pressKey("Antalya");
       Thread.sleep(1000);
       ReusableMethods.koordinatTiklamaMethodu(318,401);
        page.chooseButton.click();

// gidis tarihi mart ayinin 21 i olarak secilir ve set date e tiklanir
        ReusableMethods.koordinatTiklamaMethodu(388,1190);
        ReusableMethods.koordinatTiklamaMethodu(397,1440);
        page.setDateButton.click();

        //search butonuna tiklanir
        page.searchButton.click();
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
        ReusableMethods.koordinatTiklamaMethodu(288,371);
        ReusableMethods.koordinatTiklamaMethodu(187,693);

       ReusableMethods.koordinatTiklamaMethodu(532,371);
       ReusableMethods.koordinatTiklamaMethodu(109,1809);

        Thread.sleep(3000);
//
//
//
      //   gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String enUcuzTicketText=page.enUcuzTicket.getText();
        driver.sendSMS("5555555555","Kiwi uygulamasindaki en ucuz bilet fiyati: "+enUcuzTicketText);
    }
}