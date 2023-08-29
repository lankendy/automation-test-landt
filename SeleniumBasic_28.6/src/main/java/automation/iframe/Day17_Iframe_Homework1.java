package automation.iframe;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class Day17_Iframe_Homework1 extends CommonBase {
    @BeforeTest
    public void openPage() {
        driver = initChromeDriver("https://codestar.vn/");
    }
    @Test
    public void handleIframeMessenger()
    {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By iframeLocator = By.xpath("//iframe[@name='f24776a142596f4']");
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("f24776a142596f4"));
        pause(10000);
        // switch toi iframe messenger
//        driver.switchTo().frame("f24776a142596f4");
        //buton bat dau chat
        click(By.xpath("//span[text()='Bắt đầu chat']/parent::div"));
        //text dang nhap
        By textLoginExpected = By.xpath("//div[text()='Đăng nhập']");
        WebElement textLogin = getElementPresentDOM(textLoginExpected);
        assertEquals(textLogin.getText(), "Đăng nhập");
    }
    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}
