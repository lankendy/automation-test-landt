package automation.testsuite.LanDT;
import org.openqa.selenium.WebElement;
import org.testng.*;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import automation.common.CommonBase;

public class TS_PracticeElement extends automation.common.CommonBase{
    @BeforeMethod
    public void init() {
        driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
    }

    @Test
    public void Demo_TestCase() {
        /* user email*/
        WebElement userEmail = driver.findElement(By.id("userId"));
        WebElement userEmail_name = driver.findElement(By.name("email"));
        System.out.println("user email is " + userEmail.toString());

        /*Password*/
        WebElement password = driver.findElement(By.id("pass"));
        WebElement password_name = driver.findElement(By.name("Password"));
        System.out.println("password is " + password.toString());

        /*Company*/
        WebElement company = driver.findElement(By.name("company"));

        /*Mobile number*/
        WebElement mobileNumber = driver.findElement(By.name("mobile name"));

    }
}
