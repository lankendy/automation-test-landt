package automation.testsuite.LanDT;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Day16_AlertSendKeys extends CommonBase {
    @BeforeTest
    public void openPage() {
        driver = initChromeDriver("https://demo.automationtesting.in/Alerts.html");
    }
    @Test
    public void alert()
    {
        driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
        pause(2000);
        driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
        driver.switchTo().alert().sendKeys("Do Lan");
        pause(2000);
        driver.switchTo().alert().accept();
        WebElement element = getElementPresentDOM(By.id("demo1"));
        String actualText = element.getText();
        assertEquals(actualText, "Hello Do Lan How are you today");
        pause(2000);
    }

    @AfterTest
    public void closePage()
    {
        quitDriver(driver);
    }
}
