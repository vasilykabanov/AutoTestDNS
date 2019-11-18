package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by yasup on 18.11.2019.
 */
public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//INPUT[@class='ui-input-search__input main-search-form__input ui-autocomplete-input']")
    public WebElement mainSearch;

    @FindBy(xpath = "(//SPAN[@class='ui-input-search__icon ui-input-search__icon_search'])[2]")
    public WebElement buttonSearch;

    @FindBy(xpath = "//div[@class='buttons']/a/span/span[@data-of='totalPrice']")
    public WebElement totalPrice;

    @FindBy(xpath = "(//SPAN[@class='btn-cart-link__cart'])[2]")
    public WebElement buttonCart;


    public void gotoCart() {
        buttonCart.click();
    }

    public void clickSearch() {
        buttonSearch.click();
    }

    public void mainSearchInput(String value) {
        mainSearch.clear();
        mainSearch.click();
        mainSearch.sendKeys(value);
    }

    public int getPrice(WebElement element) {
        return Integer.parseInt(element.getText().replaceAll("\\D", ""));
    }
}
