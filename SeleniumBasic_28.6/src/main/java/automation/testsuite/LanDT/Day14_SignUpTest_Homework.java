package automation.testsuite.LanDT;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pagelocator.DashboardPage;
import automation.pagelocator.Day14_DanhSachKhoaHoc;
import automation.pagelocator.Day14_LoginPageFactory;
import automation.pagelocator.Day14_SignUpFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class Day14_SignUpTest_Homework extends CommonBase {
    @BeforeTest
    public void openApplication()
    {
        driver = initChromeDriver(AccountConstant.webURL1);
    }
    @Test
    public void signupSuccessfully()
    {
        Day14_SignUpFactory factory = new Day14_SignUpFactory(driver);
        factory.SignUpFunction("DemoName", "dolansoict9@gmail.com", "1234567aA@", "0979535888");

        Day14_DanhSachKhoaHoc dsKhoaHoc = new Day14_DanhSachKhoaHoc(driver);
        By expected = By.xpath("//div[@class='login']");
        WebElement expectedElement = driver.findElement(expected);
        assertTrue(expectedElement.isDisplayed());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        factory.updatePassword("1234567aA@", "1234567aAb@");

        Day14_LoginPageFactory loginPage = new Day14_LoginPageFactory(driver);
        loginPage.LoginFunctionFactory("dolansoict9@gmail.com", "1234567aAb@");

        DashboardPage dashboard = new DashboardPage();

        WebElement dashboardExpected = driver.findElement(By.xpath(dashboard.dashBoardText));
        assertTrue(dashboardExpected.isDisplayed());
    }
}
