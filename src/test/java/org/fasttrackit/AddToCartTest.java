package org.fasttrackit;

import org.fasttrackit.pageobjects.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class AddToCartTest extends TestBase {

    @Test
        public void addToCartWithoutColor() {


        Header header = PageFactory.initElements(driver, Header.class);
        header.clickHomeLogo();
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.clickProductChelseaTeeHomePage();
        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
        productsPage.getSizeM_Button().click();
        productsPage.getQuantity().click();

        String requiredFieldMsg = productsPage.getRequiredFieldMsgFromColor().getText();
        System.out.println(requiredFieldMsg);
            String expectedRequiredFieldMsg = "This is a required field.";

        assertThat("Successful added to shopping cart",expectedRequiredFieldMsg ,containsString(requiredFieldMsg));
        }


    @Test
        public void addToCartFromProdactPage_samePrice() {


        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.clickProductChelseaTeeHomePage();
        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
        productsPage.getBlueColorButton().click();
        productsPage.clickSizeM();
        String productPrice = productsPage.getRegularPriceWithoutDiscount().getText();
        System.out.println(productPrice);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        productsPage.getAddToCartButton().click();
        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        String shoppingCartPrice = shoppingCart.getProductPrice().getText();
        System.out.println(shoppingCartPrice);

        String[] splitProductPrice = productPrice.split(" ");
        String productPriceNumber = splitProductPrice[0];
        productPriceNumber = productPriceNumber.replace(",", ".");

        String[] splitAddToCartPrice = shoppingCartPrice.split(" ");
        String addToCartNumber = splitAddToCartPrice[0];
        addToCartNumber = addToCartNumber.replace(",", ".");
        System.out.println(productPriceNumber + "  "+ shoppingCartPrice);

       assertThat("The price is not the same", productPriceNumber, equalTo(addToCartNumber));


        }


    @Test
        public void addToCartDifferentQuantitySameProduct() throws InterruptedException {

        Header header = PageFactory.initElements(driver,Header.class);
        Thread.sleep(3000);
        header.clickHomeLogo();
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.clickProductChelseaTeeHomePage();
        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
        productsPage.clickSizeM();
        productsPage.getBlueColorButton().click();
        productsPage.clearQuantityFild();
        String firstQuantityNumber = "2";
        productsPage.numberOfQuantity(firstQuantityNumber);
        String firstQuantityInProductPage = productsPage.getQuantity().getAttribute("value");
        double convertedFirstQuantityInProductPage = Double.parseDouble(firstQuantityInProductPage);
        System.out.println(convertedFirstQuantityInProductPage + " succesed convert number");
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        productsPage.getAddToCartButton().click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        System.out.println("Successful added to cart");
        driver.navigate().back();
        Thread.sleep(2000);
        String seconndQuantityNumber = "3";
        productsPage.clearQuantityFild();
        productsPage.numberOfQuantity(seconndQuantityNumber);

        String secondQuantityInProductPage = productsPage.getQuantity().getAttribute("value");
        double convertedSecondQuantityInProductPage = Double.parseDouble(secondQuantityInProductPage);
        productsPage.getAddToCartButton().click();
        Thread.sleep(5000);


        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        String totalQuantityInSoppingCart = shoppingCart.getFirstQuantityField().getAttribute("value");
        double convertedTotalQuantityInSoppingCart = Double.parseDouble(totalQuantityInSoppingCart);

        assertThat("Total quantity is wrong", convertedFirstQuantityInProductPage + convertedSecondQuantityInProductPage, is(equalTo(convertedTotalQuantityInSoppingCart)));

    }

    @Test
        public void addToCartWithoutSize() {


        Header header = PageFactory.initElements(driver, Header.class);
        header.clickHomeLogo();
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.clickProductChelseaTeeHomePage();
        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
        productsPage.getBlueColorButton().click();
        productsPage.getAddToCartButton().click();

        String requiredFieldMsg = productsPage.getRequiredFieldMsgFromSize().getText();
        String expectedRequiredFieldMsg = "This is a required field.";
        assertThat("Successful added to shopping cart", expectedRequiredFieldMsg, is(requiredFieldMsg));

    }

        @Test
        public void removeItemInShoppingCartWithOneProductTest() {

            Header header = PageFactory.initElements(driver, Header.class);
            header.clickHomeLogo();
            ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
            productsGrid.clickProductChelseaTeeHomePage();
            ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
            productsPage.getBlueColorButton().click();
            productsPage.clickSizeM();
            String productNameInProductPage = productsPage.getProductName().getText();
            System.out.println(productNameInProductPage);
            productsPage.getAddToCartButton().click();
            ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
           String productNameInShoppingCart =  shoppingCart.getProductName().getText();
            System.out.println(productNameInShoppingCart);


            String msgSuccessAdded = shoppingCart.getMsgSuccessAdded().getText();
            System.out.println(msgSuccessAdded);
            assertThat("Chelsea Tee was added to your shopping cart.", containsString(msgSuccessAdded));
            shoppingCart.getFirstRemoveButton().click();
            String msgEmptyShopingCart = shoppingCart.getMsgEmptyShoppingCart().getText();
            System.out.println(msgEmptyShopingCart);

            assertThat("SHOPPING CART IS EMPTY",containsString(msgEmptyShopingCart.toUpperCase()));
    }


    @Test
        public void secondRemoveItemInShoppingCartWithTwoProducts() throws InterruptedException {

        Header header = PageFactory.initElements(driver,Header.class);
        ProductsCategory productsCategory = PageFactory.initElements(driver,ProductsCategory.class);
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.clickProductChelseaTeeHomePage();
        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
        productsPage.getBlueColorButton().click();
        productsPage.clickSizeM();
        productsPage.getAddToCartButton().click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        String firstProductInShoppingCart = shoppingCart.getFirstProduct().getText();
        System.out.println("first product " + firstProductInShoppingCart);
        header.clickHomeLogo();
        Actions action = new Actions(driver);
        action.moveToElement(productsCategory.womenCategory).build().perform();
        Thread.sleep(3000);
        productsCategory.pantsDenimCategory.click();
        WomenPage womenPage = PageFactory.initElements(driver, WomenPage.class);
        womenPage.productTrbecaSkinnyJean.click();
        productsPage.getBlackColorButton().click();
        productsPage.size28Bottun.click();
        productsPage.getAddToCartButton().click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        String secondProductInShoppingCart = shoppingCart.getSecondProduct().getText();
        System.out.println("second product " + secondProductInShoppingCart);

        shoppingCart.getSecondRemoveButton().click();

//        String secondProductInShoppingCart = shoppingCart.getSecondProduct().getText();
        List<WebElement> productContain = driver.findElements(By.cssSelector(".cart-table.data-table .product-name"));
        for (WebElement products:productContain) {
            String productsName = products.getText();

            assertThat("can't remove the product", secondProductInShoppingCart, not(is(productsName)) );
        }

    }



    @Test
        public void subTotalForChelseaTee() throws InterruptedException {

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        ProductsPage productsPage = PageFactory.initElements(driver,ProductsPage.class);
        ShoppingCart shoppingCart = PageFactory.initElements(driver,ShoppingCart.class);

        productsGrid.clickProductChelseaTeeHomePage();
        productsPage.getBlackColorButton().click();
        productsPage.clickSizeM();
        productsPage.clearQuantityFild();
        productsPage.getQuantity().sendKeys("3");
        Thread.sleep(1000);
        productsPage.getAddToCartButton().click();
        Thread.sleep(2000);
        String productPrice = shoppingCart.getProductPrice().getText();
        String[] splitProductPrice = productPrice.split(" ");
        String intProductPrice = splitProductPrice[0];
        intProductPrice = intProductPrice.replace(",", ".");
        double convertProductPrice = Double.parseDouble(intProductPrice);
        System.out.println(convertProductPrice);
        String productQuantity = shoppingCart.getFirstQuantityField().getAttribute("value");
        double convertProductQuantity = Double.parseDouble(productQuantity);
        System.out.println(convertProductQuantity);
        String totalPrice = shoppingCart.getSubTotalPrice().getText();
        String[] splitTotalPrice = totalPrice.split(" ");
        String intTotalPrice = splitTotalPrice[0];
        intTotalPrice = intTotalPrice.replace(",", ".");
        double convertTotalPrice = Double.parseDouble(intTotalPrice);
        System.out.println(convertTotalPrice);

        assertThat("Total price is wrong" ,convertProductPrice*convertProductQuantity, is(convertTotalPrice) );

        }


    @Test
        public void addToCartFromShearchResultsTest() {

        String keyword = "vase";

        Header header = PageFactory.initElements(driver,Header.class);
        header.search(keyword);
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);


            String heraldGlassVase = "Herald Glass Vase";
        productsGrid.addProductToCart(heraldGlassVase,driver);

          String succesMessage = driver.findElement(By.className("success-msg")).getText();
            assertThat("Unexpected success message", succesMessage, is(heraldGlassVase + " was added to your shopping cart."));

        }



    @Test
        public void productColorChangeInAddToCart() {

        Header header = PageFactory.initElements(driver, Header.class);
        header.clickHomeLogo();
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.clickProductChelseaTeeHomePage();
        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
        productsPage.getBlueColorButton().click();
        productsPage.getSizeS_Button().click();



        String blueTshirt = productsPage.getBlueTshirtLink().getAttribute("src");
        System.out.println( blueTshirt);
        productsPage.getAddToCartButton().click();
        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        String expectBlueTshirt = shoppingCart.getBlueTshirtLink().getAttribute("src");
        System.out.println(expectBlueTshirt);

        assertThat("The color T-shirt in imige is not the same", blueTshirt, is(expectBlueTshirt));
        driver.quit();

        }
@Test
    public void changeQuantitiesInShoppingCart() throws InterruptedException {


        Header header = PageFactory.initElements(driver, Header.class);
        ProductsCategory productsCategory = PageFactory.initElements(driver, ProductsCategory.class);
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.clickProductChelseaTeeHomePage();
        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
        productsPage.getBlueColorButton().click();
        productsPage.clickSizeM();
        productsPage.getAddToCartButton().click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        header.clickHomeLogo();
        Actions action = new Actions(driver);
        action.moveToElement(productsCategory.womenCategory).build().perform();
        Thread.sleep(3000);
        productsCategory.pantsDenimCategory.click();
        WomenPage womenPage = PageFactory.initElements(driver, WomenPage.class);
        womenPage.productTrbecaSkinnyJean.click();
        productsPage.getBlackColorButton().click();
        productsPage.size28Bottun.click();
        productsPage.getAddToCartButton().click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        List<WebElement> getFields = shoppingCart.getQuantitiesFields();
    for (WebElement contains : getFields) {
       contains.clear();
    }

    shoppingCart.getFirstQuantityField().sendKeys("5");
    shoppingCart.getSecondQunatityField().sendKeys("10");
    List<String> populateFields = new ArrayList<>();
    String firstNumber = shoppingCart.getFirstQuantityField().getAttribute("value");
    String secondNumber = shoppingCart.getSecondQunatityField().getAttribute("value");
    populateFields.add(firstNumber);
    populateFields.add(secondNumber);
    shoppingCart.getUpdateShoppingCart().click();

    for (WebElement contains : shoppingCart.getQuantitiesFields()) {
        String numberValueOfQuantities = contains.getAttribute("value");

        assertThat("the quantity not changed",numberValueOfQuantities, equalTo(populateFields));
    }

    }

    }


