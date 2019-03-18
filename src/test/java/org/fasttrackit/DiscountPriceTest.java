package org.fasttrackit;

import org.fasttrackit.pageobjects.Header;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class DiscountPriceTest extends TestBase{

    @Test
    public void discountPriceTest()  {


        String keyword = "vase";
        Header header = PageFactory.initElements(driver, Header.class);
        header.search(keyword);

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        String oldPrice = productsGrid.getOldPriceForModernMurrayCeramicVase().getText();
        String specialPrice = productsGrid.getSpecialPriceForModernMurrayCeramicVase().getText();
        System.out.println(oldPrice + specialPrice);

        String[] oldPriceSplit = oldPrice.split(" ");
        String oldPriceNumber = oldPriceSplit[0];
        String oldPriceString = oldPriceSplit[1];

        oldPriceNumber = oldPriceNumber.replace(",", ".");

        String[] specialPriceSplit = specialPrice.split(" ");
        String specialPriceNumber = specialPriceSplit[0];
        String specialPriceString = specialPriceSplit[1];

        specialPriceNumber = specialPriceNumber.replace(",", ".");


        System.out.println(oldPriceNumber + specialPriceNumber);
        double convertedOldPriceNumber = Double.parseDouble(oldPriceNumber);
        double convertedSpecialPriceNumber = Double.parseDouble(specialPriceNumber);

        assertThat("the product is not on sale", convertedSpecialPriceNumber, lessThan(convertedOldPriceNumber));


        }



    }





