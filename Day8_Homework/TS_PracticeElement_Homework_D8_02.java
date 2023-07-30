package automation.testsuite.LanDT;
import org.openqa.selenium.WebElement;
import org.testng.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automation.common.CommonBase;

public class TS_PracticeElement extends CommonBase{
    @BeforeMethod
    public void init() {
        driver = initChromeDriver("https://automationfc.github.io/basic-form/index.html");
    }

    @Test
    public void Demo_TestCase() {
        /*1. name*/
        WebElement name = driver.findElement(By.id("name"));
        WebElement name_name = driver.findElement(By.name("name"));

        /*2. Address*/
        WebElement address = driver.findElement(By.id("address"));
        WebElement address_name = driver.findElement(By.name("address"));

        /*3. Email*/
        WebElement email = driver.findElement(By.id("email"));
        WebElement email_name = driver.findElement(By.name("email"));

        /*4. Password*/
        WebElement password = driver.findElement(By.id("password"));
        WebElement password_name = driver.findElement(By.id("password"));

    }
}
