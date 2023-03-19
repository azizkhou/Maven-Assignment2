package TestCases;

import Utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.WelcomePage;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestForPracticeActions {
    static WebDriver driver;
    public HomePage homePage;
    public CartPage cartPage;
    public WelcomePage welcomePage;
    public Actions actions;


    @BeforeClass
    public void tearUp(){
        driver = launchBrowser("Chrome");
        System.out.println("Launching Browser");
        driver.get("http://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        welcomePage = new WelcomePage(driver);
        actions = new Actions(driver);
        Util.holdExecution(4);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://the-internet.herokuapp.com/");
        Util.holdExecution(4);
    }

    @Test
    public void verifyHoverFunctionality(){
        welcomePage.clickOnHover();
        Util.holdExecution(2);
        actions.moveToElement(welcomePage.image1ToHoverMouser).build().perform();
        Assert.assertTrue(welcomePage.username1OnHover.isDisplayed());
        Util.holdExecution(4);

        actions.moveToElement(welcomePage.image2ToHoverMouser).build().perform();
        Util.holdExecution(2);
        Assert.assertTrue(welcomePage.username2OnHover.isDisplayed());

        actions.moveToElement(welcomePage.image3ToHoverMouser).build().perform();
        Util.holdExecution(2);
        Assert.assertTrue(welcomePage.username3OnHover.isDisplayed());

    }

    @Test (priority = 1)
    public void verifyUserCanRightClick(){
        welcomePage.clickOnRightClickOption();
        Util.holdExecution(2);
        actions.contextClick(welcomePage.boxForRightClick).build().perform();
        Util.holdExecution(4);


    }

    @Test
    public void verify_multiple_window_option(){
        welcomePage.clickOnMultipleWindowOption();
        Util.holdExecution(2);

        welcomePage.ClickHereOnMultipleWindowPage.click();
        String currentWindow = driver.getWindowHandle();
        Set<String> handles=driver.getWindowHandles();

        for (String handle: handles) {
            System.out.println("Window ID------" + handle);
            if(handle.equalsIgnoreCase(currentWindow)){
                continue;
            }

            driver.switchTo().window(handle);
            Util.holdExecution(2);
            if (welcomePage.newWindowTextOnMultipleWindowPage.isDisplayed())
            {
                break;
            }

        }
        Util.holdExecution(2);
        driver.switchTo().window(currentWindow);
        Util.holdExecution(2);

        Assert.assertTrue(welcomePage.ClickHereOnMultipleWindowPage.isDisplayed());

    }

    @Test
    public void Verify_dropDown_Functionality(){
        welcomePage.clickOnDropdownOption();
        Util.holdExecution(2);
        Select selectOption = new Select(welcomePage.dropdownId);
        Util.holdExecution(2);
        selectOption.selectByValue("2");
        Util.holdExecution(2);
    }

    @Test
    public void Verify_dropDown_Functionality_by_SelectByIndex(){
        welcomePage.clickOnDropdownOption();
        Util.holdExecution(2);
        Select selectOption = new Select(welcomePage.dropdownId);
        Util.holdExecution(2);
        selectOption.selectByIndex(1);
        Util.holdExecution(2);
    }

    @Test
    public void Verify_dropDown_Functionality_by_SelectByVisibleText(){
        welcomePage.clickOnDropdownOption();
        Util.holdExecution(2);
        Select selectOption = new Select(welcomePage.dropdownId);
        Util.holdExecution(2);
        selectOption.selectByVisibleText("Option 2");
        Util.holdExecution(2);
    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }



    public static WebDriver launchBrowser(String browserName){
        WebDriver driver1;
        if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator+"resources"+File.separator+"drivers"+File.separator+"chromedriver.exe");
            driver1 = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "resources" + File.separator + "drivers" + File.separator + "geckodriver");
            driver1 = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("safari")){
            driver1 = new SafariDriver();
        }else if (browserName.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+File.separator+"resources"+File.separator+"drivers"+File.separator+"msedgedriver.exe");
            driver1 = new EdgeDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ File.separator+"resources"+File.separator+"drivers"+File.separator+"chromedriver.exe");
            driver1 = new ChromeDriver();
        }
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver1;
    }
}
