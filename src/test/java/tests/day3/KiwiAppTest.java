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
// vari//s ulkesi secenegine tiklanir ve gidilecek ulke girilir
       // ReusableMethods.koordinatTiklamaMethodu(311,921);
       // driver.getKeyboard().pressKey("Antalya");
       // Thread.sleep(1000);
       // ReusableMethods.koordinatTiklamaMethodu(292,289);
       // page.chooseButton.click();
// gidi//s tarihi mart ayinin 21 i olarak secilir ve set date e tiklanir
       // ReusableMethods.koordinatTiklamaMethodu(424,1052);
       // ReusableMethods.koordinatTiklamaMethodu(968,1333);
       // page.setDateButton.click();
// sear//ch butonuna tiklanir
       // page.searchButton.click();
// en  //ucuz ve aktarmasiz filtrelemeleri yapilir
       // ReusableMethods.koordinatTiklamaMethodu(270,259);
       // ReusableMethods.koordinatTiklamaMethodu(522,595);
//
       // ReusableMethods.koordinatTiklamaMethodu(522,259);
       // ReusableMethods.koordinatTiklamaMethodu(431,1458);
//
       // Thread.sleep(3000);
//
//
//
// gele//n bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
       // String enUcuzTicketText=page.enUcuzTicket.getText();
       // driver.sendSMS("555555555555","Kiwi uygulamasindaki en ucuz bilet fiyati: "+enUcuzTicketText);
    }
}