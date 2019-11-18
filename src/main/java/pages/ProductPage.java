package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by yasup on 18.11.2019.
 */
public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='current-price-value']")
    public WebElement productPrice;

    @FindBy(xpath = "//select[@class='form-control select']")
    public WebElement chooseGuarantee;

    @FindBy(xpath = "//button[@class='btn btn-cart btn-lg']")
    public WebElement buyButton;

    public void buyProduct() {
        buyButton.click();
    }

    public void selectCountByValue(WebElement element, int count) {
        element.click();
        Select select = new Select(element);
        select.selectByValue(String.valueOf(count));
    }


}
