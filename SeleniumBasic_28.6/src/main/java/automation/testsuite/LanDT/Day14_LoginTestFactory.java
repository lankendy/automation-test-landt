package automation.testsuite.LanDT;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pagelocator.DashboardPage;
import automation.pagelocator.Day14_LoginPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class Day14_LoginTestFactory extends CommonBase {
    @BeforeTest
    @Parameters("testNgBrowser")
    public void openPage(String browserName) {
        setupDriver(browserName);
        driver.get(AccountConstant.webURL);
    }
//    public void openApplication()
//    {
//        driver = initChromeDriver(AccountConstant.webURL);
//    }

    @Test
    public void loginSuccessfully()
    {
        Day14_LoginPageFactory factory = new Day14_LoginPageFactory(driver);
        factory.LoginFunctionFactory("admin@demo.com", "riseDemo");

        DashboardPage dashboard = new DashboardPage();
        pause(4000);
        WebElement expected = driver.findElement(By.xpath(dashboard.dashBoardText));
        assertTrue(expected.isDisplayed());


    }

    @AfterTest
    public void closeDriver()
    {
        driver.close();
    }
}
