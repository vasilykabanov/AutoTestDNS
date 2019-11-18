import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

/**
 * Created by yasup on 18.11.2019.
 */
public class FirstTest extends BaseTest {

    @Before
    public void init() {
        driver.get(baseURL);
    }

    MainPage mainPage = new MainPage(driver);
    SearchResultPage searchResultPage = new SearchResultPage(driver);
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);

    @Test
    public void firstTest() throws InterruptedException {
        mainPage.mainSearchInput("playstation");
        mainPage.clickSearch();
        searchResultPage.productPS.click();
        int psPrice = productPage.getPrice(productPage.productPrice);
        productPage.selectCountByValue(productPage.chooseGuarantee, 2);
        int psPriseWithGuarantee = productPage.getPrice(productPage.productPrice);
        productPage.buyProduct();
        mainPage.mainSearchInput("detroid");
        mainPage.clickSearch();
        int detroidPrice = productPage.getPrice(searchResultPage.productPrice);
        searchResultPage.clickBuyProduct();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.totalPrice));
        int totalCartPrice = productPage.getPrice(searchResultPage.totalPrice);
        Assert.assertEquals(psPriseWithGuarantee + detroidPrice, totalCartPrice);
        mainPage.gotoCart();
        String textRadioLabelGuarantee = cartPage.radioLabelGuarantee.getText();
        Assert.assertTrue(textRadioLabelGuarantee.contains("2"));
        Assert.assertEquals(cartPage.getPrice(cartPage.cartListProduct.get(0)), psPrice);
        Assert.assertEquals(cartPage.getPrice(cartPage.cartListProduct.get(1)), detroidPrice);
        Assert.assertEquals(cartPage.getPrice(cartPage.totalPrice), psPriseWithGuarantee + detroidPrice);
        cartPage.removeItemById(1);
        Assert.assertEquals(1, cartPage.cartListProduct.size());
        Assert.assertEquals(cartPage.getPrice(cartPage.totalPrice), psPriseWithGuarantee);
        cartPage.clickButtonPlus();
        cartPage.clickButtonPlus();
        Assert.assertEquals(3 * psPrice, cartPage.getPrice(cartPage.cartListProduct.get(0)));
        //нажать вернуть удаленный товар, проверить что Detroit появился в корзине и сумма увеличилась на его значение
        cartPage.clickButtonReturnRemoved();
        Assert.assertEquals(cartPage.cartListProduct.size(), 2);
        Assert.assertEquals(cartPage.getPrice(cartPage.totalPrice), 3 * psPriseWithGuarantee + detroidPrice);
    }
}
