package automation.iframe;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day17_Iframe_Homework2 extends CommonBase {
    @BeforeTest
    public void openPage()
    {
        driver = initChromeDriver("https://codestar.vn/");
    }
    @Test
    public void handleIframeSignGetDocx()
    {
        pause(5000);
        driver.switchTo().frame(3);
        inputTextJavaScriptValue(By.xpath("//input[@name='account_name']"), "Do Lan - auto test");
        inputTextJavaScriptValue(By.xpath("//input[@id='account_phone']"), "097475864594");
        click(By.xpath("//button[text()='Đăng ký ngay']"));
        Assert.assertEquals(true, driver.findElement(By.xpath("//button[text()='Đăng ký ngay']")).isDisplayed());

    }
}
