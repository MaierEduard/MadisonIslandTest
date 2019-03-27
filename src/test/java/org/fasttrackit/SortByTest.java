package org.fasttrackit;

import org.fasttrackit.pageobjects.ProductsCategory;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.fasttrackit.pageobjects.ShopBy;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class SortByTest {
    public static class SortByBalckColor extends TestBase {

        @Test
        public void sortByBlackColor() {

            ProductsCategory productsCategory = PageFactory.initElements(driver, ProductsCategory.class);


            Actions actions = new Actions(driver);
            actions.moveToElement(productsCategory.womenCategory).build().perform();
            productsCategory.pantsDenimCategory.click();
            ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
            ShopBy shopBy = PageFactory.initElements(driver, ShopBy.class);
            shopBy.blackColorButton.click();
            String blackColor = shopBy.getBlackColorButton().getAttribute("alt");
            System.out.println(blackColor);

            List<WebElement> productColorContain = productsGrid.productColorContainers;

            for (WebElement contain : productColorContain) {
                String productsColor = contain.getAttribute("alt");
                System.out.println(productsColor);

                assertThat("The products don't have the same color", productsColor, is(blackColor.toLowerCase()));
            }

        }




    }

    public static class SortByPrice100_199 extends TestBase{

        @Test
        public void sortByPrice100_199() {

            ProductsCategory productsCategory = PageFactory.initElements(driver, ProductsCategory.class);


            Actions actions = new Actions(driver);
            actions.moveToElement(productsCategory.womenCategory).build().perform();
            productsCategory.pantsDenimCategory.click();
            ShopBy shopBy = PageFactory.initElements(driver, ShopBy.class);
            shopBy.price100_199.click();
            String sortPrice = shopBy.getPriceAfterSort().getText();
            System.out.println(sortPrice);

            ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
            List<WebElement> productPriceContain = productsGrid.productPriceContainsShopBy;

            for (WebElement contain : productPriceContain) {
                String productPrice = contain.getText();
                String[] splitProductPrice = productPrice.split(" ");
                String convertProductPrice = splitProductPrice[0];
                convertProductPrice = convertProductPrice.replace(",", ".");



            String[] splitSortPrice1 = sortPrice.split("- ");
            String sortPrice100 = splitSortPrice1[0];
            String sortPrice199 = splitSortPrice1[1];
            System.out.println(sortPrice100);
            System.out.println(sortPrice199);

            String[] splitSortPrice100 = sortPrice100.split(" ");
            String convertSortPrice100 = splitSortPrice100[0];
            convertSortPrice100 = convertSortPrice100.replace(",", ".");
            System.out.println(convertSortPrice100);

            String[] splitSortPrice199 = sortPrice199.split(" ");
            String convertSortPrice199 = splitSortPrice199[0];
            convertSortPrice199 = convertSortPrice199.replace(",", ".");
            System.out.println(convertSortPrice199);

                assertThat("Products price is lower than 199.99 RON", convertProductPrice, lessThan(convertSortPrice199));
                assertThat("Products price is lower than 100.00 RON", convertProductPrice, greaterThan(convertSortPrice100));



            }
        }


    }

    public static class SortByPrice200Above extends TestBase{

        @Test
        public void sortByPrice200Above() {

            ProductsCategory productsCategory = PageFactory.initElements(driver, ProductsCategory.class);

            Actions actions = new Actions(driver);
            actions.moveToElement(productsCategory.womenCategory).build().perform();
            productsCategory.pantsDenimCategory.click();
            ShopBy shopBy = PageFactory.initElements(driver, ShopBy.class);
            shopBy.clickPrice200Above();
            String sortPrice = shopBy.priceAfterSort.getText();
            String[] splitSortPrice = sortPrice.split(" ");
            String convertSortPrice = splitSortPrice[0];
            convertSortPrice = convertSortPrice.replace(",", ".");
            System.out.println(convertSortPrice);
            ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

            List<WebElement> productPriceContain = productsGrid.productPriceContainsShopBy;

            for (WebElement contain : productPriceContain) {
                String productPrice = contain.getText();

                String[] splitProductPrice = productPrice.split(" ");
                String convertProductPrice = splitProductPrice[0];
                convertProductPrice = convertProductPrice.replace(",", ".");
                System.out.println(convertProductPrice);

                assertThat("Products price is lower than 200 RON", convertProductPrice, greaterThan(convertSortPrice));

            }
        }

            public static class SortByBlueColor extends TestBase {

                @Test
                public void sortByBlueColor() {

                    ProductsCategory productsCategory = PageFactory.initElements(driver, ProductsCategory.class);
                    Actions actions = new Actions(driver);
                    actions.moveToElement(productsCategory.womenCategory).build().perform();
                    productsCategory.pantsDenimCategory.click();
                    ShopBy shopBy = PageFactory.initElements(driver, ShopBy.class);
                    shopBy.blueColorButton.click();
                    String blueButton = shopBy.blueColorButton.getAttribute("alt");
                    ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);


                    List<WebElement> productColorContainer = productsGrid.productColorContainers;


                    for (WebElement container : productColorContainer) {
                        String productColor = container.getAttribute("alt");
                        System.out.println(productColor);

                        assertThat("The color is not the same", blueButton.toLowerCase(), is(productColor));


                    }
                }
            }}}
