package automation.testsuite.LanDT;

import automation.common.CommonBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Day16_Alert extends CommonBase {
    @BeforeTest
    public void openPage() {
        driver = initChromeDriver("http://demo.guru99.com/test/delete_customer.php");
    }
    @Test
    public void TestAlert()
    {
        driver.findElement(By.name("cusid")).sendKeys("12345678");
        driver.findElement(By.name("submit")).submit();
        pause(2000);

        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        assertEquals(alertMessage, "Do you really want to delete this Customer?");
        pause(2000);
        driver.switchTo().alert().accept();

        pause(2000);
        String actualMessage = driver.switchTo().alert().getText();
        assertEquals(actualMessage, "Customer Successfully Delete!");
        driver.switchTo().alert().accept();

        pause(2000);


    }
}
