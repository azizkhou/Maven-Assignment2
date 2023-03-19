package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
    WebDriver driver;
    public ProductDetailPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[normalize-space()='Add to cart']")
    WebElement addToCartButton;


}

