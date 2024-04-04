package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AllCurrencyApp {


    public AllCurrencyApp(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);

    }



    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/toolbar")
    public WebElement toolBar;



    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b0")
    public WebElement sisift;
}
