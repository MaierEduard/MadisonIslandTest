package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.fasttrackit.pageobjects.ShopBy;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class SortByTest {
    public static class SortByBalckColor {

        @Test
        public void sortByBlackColor() {

            System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());
            WebDriver driver = new ChromeDriver();
            driver.get(AppConfig.getSiteUrl());

            Header header = PageFactory.initElements(driver, Header.class);

            Actions actions = new Actions(driver);
            actions.moveToElement(header.womenCategory).build().perform();
            header.pantsDenimCategory.click();
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

    public static class SortByPrice100_199 {

        @Test
        public void sortByPrice100_199() {

            System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());
            WebDriver driver = new ChromeDriver();
            driver.get(AppConfig.getSiteUrl());

            Header header = PageFactory.initElements(driver, Header.class);

            Actions actions = new Actions(driver);
            actions.moveToElement(header.womenCategory).build().perform();
            header.pantsDenimCategory.click();
            ShopBy shopBy = PageFactory.initElements(driver, ShopBy.class);
            shopBy.price100_199.click();
            String sortPrice = shopBy.getPriceAfterSort().getText();
            System.out.println(sortPrice);

            ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
            List<WebElement> productPriceContain = productsGrid.productPriceContains;

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

    public static class SortByPrice200Above {

        @Test
        public void sortByPrice200Above() {

            System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());
            WebDriver driver = new ChromeDriver();
            driver.get(AppConfig.getSiteUrl());

            Header header = PageFactory.initElements(driver, Header.class);

            Actions actions = new Actions(driver);
            actions.moveToElement(header.womenCategory).build().perform();
            header.pantsDenimCategory.click();
            ShopBy shopBy = PageFactory.initElements(driver, ShopBy.class);
            shopBy.clickPrice200Above();
            String sortPrice = shopBy.priceAfterSort.getText();
            String[] splitSortPrice = sortPrice.split(" ");
            String convertSortPrice = splitSortPrice[0];
            convertSortPrice = convertSortPrice.replace(",", ".");
            System.out.println(convertSortPrice);
            ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

            List<WebElement> productPriceContain = productsGrid.productPriceContains;

            for (WebElement contain : productPriceContain) {
                String productPrice = contain.getText();

                String[] splitProductPrice = productPrice.split(" ");
                String convertProductPrice = splitProductPrice[0];
                convertProductPrice = convertProductPrice.replace(",", ".");
                System.out.println(convertProductPrice);

                assertThat("Products price is lower than 200 RON", convertProductPrice, greaterThan(convertSortPrice));

            }

        }
    }
}
