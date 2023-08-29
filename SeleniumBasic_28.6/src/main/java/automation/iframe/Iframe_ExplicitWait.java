package automation.iframe;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Iframe_ExplicitWait extends CommonBase {
    @BeforeTest
    public void openPage()
    {
        driver = initChromeDriver("https://codestar.vn/");
    }
    @Test
    public void handleIframe()
    {
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        scrollToElement(By.xpath("//h2[text()='Đội ngũ giảng viên']"));
        driver.switchTo().frame(1); // index duoc lay sau khi run findIframe
        type(By.id("account_phone"), "0973996209");
        click(By.xpath("//button[text()='Gửi ngay']"));
    }
    @Test
    public void findIframe()
    {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pause(10000);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("So luong frame: " + size);
        for (int i=0; i< size;i++) {
            driver.switchTo().frame(i);
            int numberOfIframe = driver.findElements(By.xpath("//button[text()='Gửi ngay']")).size();
            if (numberOfIframe != 0) {
                System.out.println("Element can tim o vi tri thu: " + i);
            }
//            sau khi in ra element can tim phai tro ve frame cha de tim tiep den het
            driver.switchTo().defaultContent();
        }
    }
}
