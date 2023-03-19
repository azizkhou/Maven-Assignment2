package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    WebDriver driver;
    public WelcomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Hovers']")
    WebElement hoverLink;
    @FindBy(xpath = "(//img[@alt='User Avatar'])[1]")
    public WebElement image1ToHoverMouser;
    @FindBy(xpath = "(//img[@alt='User Avatar'])[2]")
    public WebElement image2ToHoverMouser;
    @FindBy(xpath = "(//img[@alt='User Avatar'])[3]")
    public WebElement image3ToHoverMouser;

    @FindBy(xpath = "//h5[normalize-space()='name: user1']")
    public WebElement username1OnHover;

    @FindBy(xpath = "//h5[normalize-space()='name: user2']")
    public WebElement username2OnHover;

    @FindBy(xpath = "//h5[normalize-space()='name: user3']")
    public WebElement username3OnHover;

    @FindBy(xpath = "//a[normalize-space()='Context Menu']")
    public WebElement rightClickOption;

    @FindBy(xpath = "//div[@id='hot-spot']")
    public WebElement boxForRightClick;
    @FindBy(xpath = "//a[normalize-space()='Multiple Windows']")
    public WebElement multipleWindowOption;

    @FindBy(xpath = "//a[normalize-space()='Click Here']")
    public WebElement ClickHereOnMultipleWindowPage;

    @FindBy(xpath = "//a[normalize-space()='11111Click Here']")
    public WebElement invlidClickHereOnMultipleWindowPageXpath;
    @FindBy(xpath = "//h3[normalize-space()='New Window']")
    public WebElement newWindowTextOnMultipleWindowPage;

    @FindBy(xpath = "//a[normalize-space()='Dropdown']")
    public WebElement dropDownOption;

    @FindBy(id = "dropdown")
    public WebElement dropdownId;


    public void clickOnHover(){
        hoverLink.click();
    }

    public void clickOnRightClickOption(){
        rightClickOption.click();
    }

    public void clickOnMultipleWindowOption(){
        multipleWindowOption.click();
    }

    public void clickOnDropdownOption(){
        dropDownOption.click();
    }
}
