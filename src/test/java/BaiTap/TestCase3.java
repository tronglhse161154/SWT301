package BaiTap;

import org.junit.Test;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.AssertJUnit.assertEquals;

public class TestCase3 {
    @Test
    public void TestCase03_Failed() {

        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");


        WebElement MOBILElink = driver.findElement(By.className("first"));
        MOBILElink.click(); // Webpage is now http://live.techpanda.org/index.php/mobile.html


        WebElement sony = driver.findElement(By.xpath("//div[h2/a/@title='Sony Xperia']"));
        sony.findElement(By.className("btn-cart"));
        sony.click();


        WebElement qty = driver.findElement(By.xpath("//input[@title='Qty']"));
        qty.clear();
        qty.sendKeys("1000");

        WebElement update = driver.findElement(By.xpath("//button[@title='Update']"));
        update.click();

        WebElement message = driver.findElement(By.className("error"));


        String actual_error = message.getText();
        assertEquals("The requested quantity for \"Sony Xperia\" is not available.", actual_error);


        driver.close();
    }
    @Test
    public void TestCase03_Success() {

        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");


        WebElement MOBILElink = driver.findElement(By.className("first"));
        MOBILElink.click();


        WebElement sony = driver.findElement(By.xpath("//div[h2/a/@title='Sony Xperia']"));
        sony.findElement(By.className("btn-cart"));
        sony.click();


        WebElement empty = driver.findElement(By.id("empty_cart_button"));
        empty.click();


        WebElement header = driver.findElement(By.className("page-title"));
        String actual_message = header.findElement(By.xpath("./child::*")).getText();
        assertEquals("SHOPPING CART IS EMPTY", actual_message);


        driver.close();
    }
}
