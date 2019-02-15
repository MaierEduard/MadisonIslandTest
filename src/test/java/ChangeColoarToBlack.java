import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChangeColoarToBlack {



   @Test
    public void changeColoarToBlack() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test");
        String keyword = "vase";
        driver.findElement(By.className("input-text")).sendKeys(keyword + Keys.ENTER);

       System.out.println("Press enter in search fild");

       driver.findElement(By.className("option-black")).click();
       String linkForBlackVase = "https://fasttrackit.org/selenium-test/media/catalog/product/cache/1/small_image/210x/602f0fa2c1f0d1ba5e241f914e856ff9/h/d/hdd002_1.jpg";
       Thread.sleep(1000);

       String getSrcForVaseBlack = driver.findElement(By.xpath("//li[@class='item last']//img[@class='product-collection-image-437']")).getAttribute("src");

      System.out.println(getSrcForVaseBlack);

       assertThat("is not the same image",linkForBlackVase, is(getSrcForVaseBlack) );
    }

}
