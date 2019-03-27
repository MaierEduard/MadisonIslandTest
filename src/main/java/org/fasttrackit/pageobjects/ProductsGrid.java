package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductsGrid {


    @FindBy(xpath = "//div[@class='product-info' and .//button[contains(@class, 'btn-cart')]]//h2[@class='product-name']/a")
    private List<WebElement>addToCArtProductNameContainer;


    @FindBy(xpath = "//span[@class='price' and ./parent::*[not(contains(@class,'old-price'))]]")
    private List<WebElement> actualProductPriceContainers;

    @FindBy(xpath = "//select[@title='Sort By']")
    private WebElement sortBySelectList;

    public Select getSortBySelectList() {
        return new Select(sortBySelectList);
    }

    @FindBy(className = "sort-by-switcher")
    private WebElement sortDirectionButton;

    public WebElement getSortDirectionButton() {
        return sortDirectionButton;
    }

    @FindBy(css = ".products-grid .price")
    public List<WebElement> productPriceContainsShopBy;

    @FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']//span[@class='swatch-label']//img")
    public List<WebElement> productColorContainers;

    @FindBy(css = ".product-name > a")
    private List<WebElement> productNameContainers;

    public WebElement getAddToCartButton(String productName, WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='product-info' and .//a[text()='" + productName + "']]//button[@title='Add to Cart']"));
    }

    public void addProductToCart(String productName, WebDriver driver) {
        getAddToCartButton(productName, driver).click();
    }

    @FindBy(xpath = "//div[@class='product-info']//a[@title='Chelsea Tee']")
    private WebElement productChelseaTeeHomePage;

    public void clickProductChelseaTeeHomePage() {
        productChelseaTeeHomePage.click();
    }

    @FindBy(id = "old-price-437")
    private WebElement oldPriceForModernMurrayCeramicVase;


    @FindBy(id = "product-price-437")
    private WebElement specialPriceForModernMurrayCeramicVase;

    @FindBy(xpath = "//a[@class='link-compare']")
    private List<WebElement> vaseNameConatiner;

    public List<WebElement> getVaseNameConatiner() {
        return vaseNameConatiner;
    }

    public WebElement getSpecialPriceForModernMurrayCeramicVase() {
        return specialPriceForModernMurrayCeramicVase;
    }

    public WebElement getOldPriceForModernMurrayCeramicVase() {
        return oldPriceForModernMurrayCeramicVase;
    }

    public List<WebElement> getProductNameContainers() {
        return productNameContainers;
    }

    public List<WebElement> getAddToCArtProductNameContainer() {
        return addToCArtProductNameContainer;
    }

    public List<String> getProductName() {
        List<String> names = new ArrayList<>();
        for (WebElement nameContainers : productNameContainers) {
            String name = nameContainers.getText();
            names.add(name);
        }
        return names;
    }

    public List<WebElement> getActualProductPriceContainers() {
        return actualProductPriceContainers;
    }

    public List<Double> getActualProductPricesAsDoubles() {
        List<Double> convertedPrices = new ArrayList<>();

        for (WebElement priceContainer : actualProductPriceContainers) {
            String priceAsText = priceContainer.getText();

            //Matching: any character  except (^) dash,
            // at least 1 character (+)
            // followed by any character (.), at least 1 accurrence (+)
            //Extracting first part, before dash
            Pattern pattern = Pattern.compile("([^ ]+).+");
            Matcher matcher = pattern.matcher(priceAsText);

            if (matcher.find()) {
                String priceAsTextWithoutCurrency = matcher.group(1);

                priceAsTextWithoutCurrency = priceAsTextWithoutCurrency.replace(",", ".");

                double convertedPrice = Double.parseDouble(priceAsTextWithoutCurrency);
                convertedPrices.add(convertedPrice);
            }
        }
        return convertedPrices;
    }


}
