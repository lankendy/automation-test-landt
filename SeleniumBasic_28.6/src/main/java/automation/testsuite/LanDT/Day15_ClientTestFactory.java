package automation.testsuite.LanDT;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pagelocator.DashboardPage;
import automation.pagelocator.Day14_LoginPageFactory;
import automation.pagelocator.Day15_ClientPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class Day15_ClientTestFactory extends CommonBase {
    @BeforeTest
    //    buoi 18 multi browser
//    @Parameters("testNgBrowser")
//    public void openPage(String browser) {
//        setupDriver(browser);
//        driver.get(AccountConstant.webURL);
//    }
    public void openApplication()
    {
        driver = initChromeDriver(AccountConstant.webURL);
    }




    @Test
    public void addClientSuccessfully() throws InterruptedException
    {
        Day14_LoginPageFactory login = new Day14_LoginPageFactory(driver);
        login.LoginFunctionFactory("admin@demo.com", "riseDemo");
        DashboardPage dashboard = new DashboardPage();
        pause(4000);
        WebElement expected = driver.findElement(By.xpath(dashboard.dashBoardText));
        assertTrue(expected.isDisplayed());

        Day15_ClientPageFactory client = new Day15_ClientPageFactory(driver);
        client.AddClient("Do Lan");

    }
}
