package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement placeOrderButton;
    @FindBy(xpath = "//a[normalize-space()='Cart']")
    WebElement cartMenuButton;

    public void clickOnCartMenuPage() {
        cartMenuButton.click();
    }

    public boolean verifyPlaceOrderButton(){
        return placeOrderButton.isDisplayed();
    }

}

