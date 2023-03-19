package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[normalize-space()='Monitors'])[1]")
    WebElement monitorTabButton;
    @FindBy(xpath = "(//a[normalize-space()='Laptops'])[1]")
    WebElement laptopTabButton;
    @FindBy(xpath = "(//a[normalize-space()='Phones'])[1]")
    WebElement phonesTabButton;
    @FindBy(xpath = "//a[normalize-space()='Samsung galaxy s6']")
    WebElement mobilePhoneInList;
    @FindBy(xpath = "//a[normalize-space()='Sony vaio i5']")
    WebElement firstLaptopInList;
    @FindBy(xpath = "//a[normalize-space()='Apple monitor 24']")
    WebElement monitorInList;
    @FindBy(id = "nava")
    WebElement logoOfWebsite;


    public void clickOnPhoneTab(){
        phonesTabButton.click();
    }

    public void clickOnLaptopTab(){
        laptopTabButton.click();
    }

    public void clickOnMonitorsTab(){
        monitorTabButton.click();
    }

    public boolean verifyLaptopDisplayed(){
        boolean flag;
        try {
            flag= firstLaptopInList.isDisplayed();
        }catch (Exception e){
            flag = false;
        }
        return flag;
    }

    public boolean verifyPhoneDisplayed(){
        return mobilePhoneInList.isDisplayed();
    }

    public boolean verifyMonitorDisplayed(){
        return monitorInList.isDisplayed();
    }

    public boolean verifyLogoOfWebsiteDisplayed(){
        return logoOfWebsite.isDisplayed();
    }

}

