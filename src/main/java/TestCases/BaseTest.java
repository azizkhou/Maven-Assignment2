package TestCases;

import Utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.HomePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static Properties prop = new Properties();

    static WebDriver driver;
    public HomePage homePage;
    public CartPage cartPage;

    public BaseTest(){
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+File.separator+"resources"+File.separator+"testdata"+File.separator+"config.properties");
            prop.load(file);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e1) {
            e1.printStackTrace();
        }
    }


    @BeforeClass
    public void tearUp(){
      driver = launchBrowser(prop.getProperty("browser"));
       driver = launchBrowser("chrome");

        System.out.println("Launching Browser");
        //driver.get(prop.getProperty("url"));
        driver.get("https://www.demoblaze.com/");
        homePage=new HomePage(driver);
        cartPage = new CartPage(driver);

        Util.holdExecution(4);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get(prop.getProperty("url"));
       // driver.get("https://www.demoblaze.com/");
        Util.holdExecution(2);
    }

    @Test(priority = 0)
    public void Verify_Logo_Displaying_on_Website(){
        Assert.assertTrue(homePage.verifyLogoOfWebsiteDisplayed());
    }

    @Test(priority = 2)
    public void Verify_Phone_Tab_Is_Working_Fine(){
        Util.holdExecution(2);
        homePage.clickOnPhoneTab();
        Assert.assertTrue(homePage.verifyPhoneDisplayed());


    }
    @Test(priority = 3)
    public  void Verify_Monitor_Tab_Is_Working_Fine(){
        homePage.clickOnMonitorsTab();
        Util.holdExecution(2);
        Assert.assertTrue(homePage.verifyMonitorDisplayed());

    }
    @Test(priority = 4)
    public void Verify_Laptops_Tab_Is_Working_Fine(){
        Util.holdExecution(4);
        homePage.clickOnLaptopTab();
        Util.holdExecution(2);
        Assert.assertTrue(homePage.verifyLaptopDisplayed());
    }


    @Test(priority = 1)
    public void Verify_Place_Order_Button_Display_On_Cart_Page(){
        cartPage.clickOnCartMenuPage();
        Util.holdExecution(2);
        Assert.assertTrue(cartPage.verifyPlaceOrderButton());
    }

    @Test(priority = 1)
    public void Verify_Place_Order_Button_Display_On_Cart_Page2(){
        Assert.assertTrue(false);
    }



    @AfterClass
    public void tearDown(){
        driver.quit();
        System.out.println("Closing Browser");
    }



    public static WebDriver launchBrowser(String browserName){
        WebDriver driver;
        if(browserName.equalsIgnoreCase("Chrome")){
           System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator+"resources"+File.separator+"drivers"+File.separator+"chromedriver.exe");
           driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "resources" + File.separator + "drivers" + File.separator + "geckodriver");
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }else if (browserName.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+File.separator+"resources"+File.separator+"drivers"+File.separator+"msedgedriver.exe");
            driver = new EdgeDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator+"resources"+File.separator+"drivers"+File.separator+"chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
