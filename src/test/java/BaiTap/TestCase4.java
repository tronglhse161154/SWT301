package BaiTap;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import static org.testng.AssertJUnit.assertEquals;
import java.util.ArrayList;

public class TestCase4 {
    @Test
    public void TestCase04() {
        // Step 1
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        String mainWindow = driver.getWindowHandle();

        // Step 2
        WebElement MOBILElink = driver.findElement(By.className("first"));
        MOBILElink.click(); // Webpage is now http://live.techpanda.org/index.php/mobile.html

        // Step 3
        ArrayList<String> test_names = new ArrayList<>();
        WebElement sony = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
        test_names.add(sony.getText());

        sony = driver.findElement(By.xpath("//div[h2/a/@title='Sony Xperia']//div[@class='actions']//ul[@class='add-to-links']//li[2]//a[1]"));
        sony.click();

        WebElement iphone = driver.findElement(By.xpath("//a[@title='IPhone'][normalize-space()='IPhone']"));
        test_names.add(iphone.getText());

        iphone = driver.findElement(By.xpath("//div[h2/a/@title='IPhone']//div[@class='actions']//ul[@class='add-to-links']//li[2]//a[1]"));
        iphone.click();

        // Step 4
        WebElement compare = driver.findElement(By.xpath("//button[@title='Compare']"));
        compare.click();

        // Step 5
        for (String handle: driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        ArrayList<String> actual_names = new ArrayList<>();
        WebElement new_sony = driver.findElement(By.xpath("//a[normalize-space()='Sony Xperia']"));
        actual_names.add(new_sony.getText());

        WebElement new_iphone = driver.findElement(By.xpath("//a[normalize-space()='IPhone']"));
        actual_names.add(new_iphone.getText());

        assertEquals(test_names, actual_names);

        // Close all popups and the driver
        driver.close();
        driver.switchTo().window(mainWindow);
        driver.close();
    }
}
