package pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by yasup on 18.11.2019.
 */
public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='ui-link' and contains(text(), 'PlayStation 4 Slim Black')]")
    public WebElement productPS;

    @FindBy(xpath = "//A[@class='ui-link'][text()='Игра Detroit: Стать человеком (PS4)']")
    public WebElement productDetroid;

    @FindBy(xpath = "//button[@class='button-ui button-ui_brand buy-btn button-ui_passive']")
    public WebElement buyProduct;

    @FindBy(xpath = "//div[@class='product-price__current']")
    public WebElement productPrice;

    public void clickBuyProduct() throws InterruptedException {
        buyProduct.click();
        Thread.sleep(1000);
    }

}
