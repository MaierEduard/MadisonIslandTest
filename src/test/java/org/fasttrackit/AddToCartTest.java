package org.fasttrackit;

import org.fasttrackit.pageobjects.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
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
        productsPage.sizeM_Button.click();
        productsPage.addToCartButton.click();

        String requiredFieldMsg = productsPage.getRequiredFieldMsgFromColor().getText();
        System.out.println(requiredFieldMsg);
            String expectedRequiredFieldMsg = "This is a required field.";

        assertThat("Successful added to shopping cart",expectedRequiredFieldMsg ,containsString(requiredFieldMsg));
        }


    @Test
        public void addToCartFromProdactPage_samePrice() {

        Header header = PageFactory.initElements(driver, Header.class);

        header.clickHomeLogo();
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.clickProductChelseaTeeHomePage();
        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
        productsPage.blueColorButton.click();
        productsPage.clickSizeM();
        String productPrice = productsPage.getRegularPriceWithoutDiscount().getText();
        System.out.println(productPrice);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        productsPage.addToCartButton.click();
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

        driver.quit();
        }


    @Test
        public void addToCartDifferentQuantitySameProduct() throws InterruptedException {

        Header header = PageFactory.initElements(driver,Header.class);
        Thread.sleep(3000);
        header.clickHomeLogo();
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.clickProductChelseaTeeHomePage();
        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
        productsPage.sizeM_Button.click();
        productsPage.blueColorButton.click();
        productsPage.clearQuantityFild();
        String firstQuantityNumber = "2";
        productsPage.numberOfQuantity(firstQuantityNumber);
        String firstQuantityInProductPage = productsPage.getQuantity().getAttribute("value");
        double convertedFirstQuantityInProductPage = Double.parseDouble(firstQuantityInProductPage);
        System.out.println(convertedFirstQuantityInProductPage + " succesed convert number");
        productsPage.addToCartButton.click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        System.out.println("Successful added to cart");
        driver.navigate().back();
        Thread.sleep(2000);
        String seconndQuantityNumber = "3";
        productsPage.clearQuantityFild();
        productsPage.numberOfQuantity(seconndQuantityNumber);

        String secondQuantityInProductPage = productsPage.getQuantity().getAttribute("value");
        double convertedSecondQuantityInProductPage = Double.parseDouble(secondQuantityInProductPage);
        productsPage.addToCartButton.click();
        Thread.sleep(5000);


        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        String totalQuantityInSoppingCart = shoppingCart.getQuantityFild().getAttribute("value");
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
        productsPage.blueColorButton.click();
        productsPage.addToCartButton.click();

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
            productsPage.blueColorButton.click();
            productsPage.sizeM_Button.click();
            String productNameInProductPage = productsPage.getProductName().getText();
            System.out.println(productNameInProductPage);
            productsPage.addToCartButton.click();
            ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
           String productNameInShoppingCart =  shoppingCart.getProductName().getText();
            System.out.println(productNameInShoppingCart);


            String msgSuccessAdded = shoppingCart.getMsgSuccessAdded().getText();
            System.out.println(msgSuccessAdded);
            assertThat("Chelsea Tee was added to your shopping cart.", containsString(msgSuccessAdded));
            shoppingCart.firstRemoveButton.click();
            String msgEmptyShopingCart = shoppingCart.getMsgEmptyShoppingCart().getText();
            System.out.println(msgEmptyShopingCart);

            assertThat("SHOPPING CART IS EMPTY",containsString(msgEmptyShopingCart.toUpperCase()));
    }


    @Test
        public void firstRemoveItemInShoppingCartWithTwoProducts() throws InterruptedException {

        Header header = PageFactory.initElements(driver, Header.class);
        header.clickHomeLogo();
        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.clickProductChelseaTeeHomePage();
        ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
        productsPage.blueColorButton.click();
        productsPage.sizeM_Button.click();
        productsPage.addToCartButton.click();
        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        String firstProductInShoppingCart = shoppingCart.getFirstProduct().getText();
        System.out.println(firstProductInShoppingCart);
        header.clickHomeLogo();
        Actions action = new Actions(driver);
        action.moveToElement(header.womenCategory).build().perform();
        Thread.sleep(3000);
        header.pantsDenimCategory.click();
        WomenPage womenPage = PageFactory.initElements(driver, WomenPage.class);
        womenPage.productTrbecaSkinnyJean.click();
        productsPage.blackColorButton.click();
        productsPage.size28Bottun.click();
        productsPage.addToCartButton.click();
        String secodProductInShoppingCart = shoppingCart.getSecondProduct().getText();
        System.out.println(secodProductInShoppingCart);
        List<WebElement> produsInCosInainteDeRemove = driver.findElements(By.cssSelector(".cart-table.data-table .product-name"));
        for (WebElement produse:produsInCosInainteDeRemove) {
            String numeleProduselelorInainteDeRemove = produse.getText();
            System.out.println("lista produselor inainte de eliminare"+numeleProduselelorInainteDeRemove);

        }
        shoppingCart.secondRemoveButton.click();


        List<WebElement> produsInCos = driver.findElements(By.cssSelector(".cart-table.data-table .product-name"));
        for (WebElement produsele:produsInCos) {
            String numeleProduselelorDupaRemove = produsele.getText();
            System.out.println("lista produselor dupa eliminare"+numeleProduselelorDupaRemove);

        }
    }



    @Test
        public void subTotalForChelseaTee() throws InterruptedException {


            driver.findElement(By.xpath("//div[@class='page-header-container']//img[@class='large']")).click();
            driver.findElement(By.xpath("//div[@class='product-info']//a[@href='https://fasttrackit.org/selenium-test/chelsea-tee-703.html']")).click();
        driver.findElement(By.className("option-m")).click();
        driver.findElement(By.cssSelector(".configurable-swatch-list .option-blue")).click();
        driver.findElement(By.cssSelector(".input-text.qty")).clear();
        driver.findElement(By.cssSelector(".input-text.qty")).sendKeys("3");
        Thread.sleep(1000);
        driver.findElement(By.className("add-to-cart-buttons")).click();
        Thread.sleep(2000);
        String productPrice = driver.findElement(By.xpath("//td[@class='product-cart-price']//span[@class='cart-price']//span[@class='price']")).getText();
        System.out.println(productPrice);
        String[] splitProductPrice = productPrice.split(" ");
        String intProductPrice = splitProductPrice[0];
        intProductPrice = intProductPrice.replace(",", ".");
        double convertProductPrice = Double.parseDouble(intProductPrice);
        System.out.println(convertProductPrice);

        String productQuantity = driver.findElement(By.cssSelector(".product-cart-actions .input-text.qty")).getAttribute("value");
        double convertProductQuantity = Double.parseDouble(productQuantity);
        System.out.println(convertProductQuantity);

        String totalPrice = driver.findElement(By.cssSelector(".product-cart-total span.cart-price span")).getText();
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
        productsPage.blueColorButton.click();
        productsPage.sizeS_Button.click();



        String blueTshirt = productsPage.getBlueTshirtLink().getAttribute("src");
        System.out.println( blueTshirt);
        productsPage.addToCartButton.click();
        ShoppingCart shoppingCart = PageFactory.initElements(driver, ShoppingCart.class);
        String expectBlueTshirt = shoppingCart.getBlueTshirtLink().getAttribute("src");
        System.out.println(expectBlueTshirt);

        assertThat("The color T-shirt in imige is not the same", blueTshirt, is(expectBlueTshirt));
        driver.quit();




        }
    }

