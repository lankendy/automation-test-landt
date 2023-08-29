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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By locatorTextExpected = By.xpath("//p[contains(text(), 'Kỹ thuật lập trình sạch và đẹp')]");
        wait.until(ExpectedConditions.elementToBeClickable(locatorTextExpected));
        scrollToElement(locatorTextExpected);
        int numberOfIframe = driver.findElements(By.tagName("iframe")).size();
        int index = 0;
        for (int i = 0; i < numberOfIframe; i++) {
            driver.switchTo().frame(i);
            int iframeIndex = driver.findElements(By.xpath("//button[text()='Đăng ký ngay']")).size();
            if (iframeIndex != 0) {
                index = iframeIndex;
            }
            driver.switchTo().defaultContent();
        }
        driver.switchTo().frame(index);
        inputTextJavaScriptValue(By.xpath("//input[@name='account_name']"), "Do Lan - auto test");
        inputTextJavaScriptValue(By.xpath("//input[@id='account_phone']"), "097475864594");
        click(By.xpath("//button[text()='Đăng ký ngay']"));

        Assert.assertEquals(true, driver.findElement(By.xpath("//button[text()='Đăng ký ngay']")).isDisplayed());

    }
}
