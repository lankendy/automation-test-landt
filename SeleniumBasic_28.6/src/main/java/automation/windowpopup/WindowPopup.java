package automation.windowpopup;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowPopup extends CommonBase {
    @BeforeTest
    public void openPage()
    {
        driver = initChromeDriver("https://demo.guru99.com/popup.php");
    }
    @Test
    public void TestPopupWindow()
    {
        click(By.xpath("//a[contains(@href,'popup.php')]"));
        //luu lai lop window dau tien
        String mainWindow = driver.getWindowHandle();
        // lay ra tat ca cac tab windows dang open
        Set<String> windows = driver.getWindowHandles();
        //duyet tung phan tu khong trung lap trong Collection => foreach
        for (String window: windows){
            System.out.println(window);
            if(!mainWindow.equals(window)) {
                // so sanh neu window khac mainwindow thi chuyen qua de thao tac
                driver.switchTo().window(window);
                pause(2000);
                System.out.println("Da chuyen den lop window con");
//                mot so ham ho tro
                System.out.println("Title " + driver.switchTo().window(window).getTitle());
                System.out.println("Current url: " + driver.switchTo().window(window).getCurrentUrl());
                type(By.name("emailid"), "testdemo@gmail.com");
                click(By.name("btnLogin"));
                //get text trang sau khi submit
                String text = driver.findElement(By.xpath("//table//td//h2")).getText();
                System.out.println(text);
                Assert.assertEquals(text, "Access details to demo site.");
                driver.close();
            }
        }
        // switching to parent window
        driver.switchTo().window(mainWindow);
        System.out.println("Da chuyen ve lop main window: " + driver.getCurrentUrl());
    }
}
