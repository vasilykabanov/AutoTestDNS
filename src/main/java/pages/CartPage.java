package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by yasup on 18.11.2019.
 */
public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//LABEL[@class='radio__label'])[3]")
    public WebElement radioLabelGuarantee;

    @FindAll({@FindBy(xpath = "//div[@class='cart-list__product-price']/div[@class='item-price']/span")})
    public List<WebElement> cartListProduct;

    @FindAll({@FindBy(xpath = "//button[@class='remove-button']")})
    public List<WebElement> removeButton;

    @FindBy(xpath = "//button[@class='count-buttons__button count-buttons__button_plus']")
    public WebElement buttonPlus;

    @FindBy(xpath = "//a[@class='restore-last-removed']")
    public WebElement buttonReturnRemoved;

    public void removeItemById(int i) throws InterruptedException {
        WebElement removeItem = removeButton.get(i);
        removeItem.click();
        Thread.sleep(1000);
    }

    public void clickButtonPlus() throws InterruptedException {
            buttonPlus.click();
        Thread.sleep(3000);
    }

    public void clickButtonReturnRemoved() throws InterruptedException {
        buttonReturnRemoved.click();
        Thread.sleep(1000);
    }


}
