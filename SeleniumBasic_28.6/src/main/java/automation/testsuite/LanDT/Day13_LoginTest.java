package automation.testsuite.LanDT;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pagelocator.DashboardPage;
import automation.pagelocator.Day13_LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class Day13_LoginTest extends CommonBase {
    @BeforeTest
    public void openPage() {
        driver = initChromeDriver(AccountConstant.webURL);
    }

    @Test
    public void loginSuccessfull() {
        Day13_LoginPage page = new Day13_LoginPage(driver);
        page.Login("admin@demo.com", "riseDemo");

        //        sau khi login success thi trang dashboard duoc hien thi
        DashboardPage dashBoard = new DashboardPage();
        WebElement expected = driver.findElement(By.xpath(dashBoard.dashBoardText));
        assertTrue(expected.isDisplayed());
    }

    @Test
    public void loginFailIncorrectEmail() {
        Day13_LoginPage page = new Day13_LoginPage(driver);
        page.Login("admin@demo_invalid.com", "riseDemo");
//        DashboardPage dashBoard = new DashboardPage();
        WebElement expected = driver.findElement(page.authenticationFail);
        assertTrue(expected.isDisplayed());
    }

    @Test
    public void loginFailIncorrectPassword() {
        Day13_LoginPage page = new Day13_LoginPage(driver);
        page.Login("admin@demo.com", "riseDemo_invalid");
        //        kiem tra ket qua sau khi login fail
        WebElement expected = driver.findElement(page.authenticationFail);
        assertTrue(expected.isDisplayed());
    }

    @Test
    public void loginFailEmailAndPassword()
    {
        Day13_LoginPage page = new Day13_LoginPage(driver);
        page.Login("admin@demoinvalid", "invalidPass");
        // kiem tra ket qua fail
        WebElement expected = driver.findElement(page.authenticationFail);
        assertTrue(expected.isDisplayed());
    }

    @Test
    public void logout()
    {
        this.loginSuccessfull();
        Day13_LoginPage page = new Day13_LoginPage(driver);
        WebElement avatarIcon = driver.findElement(page.avatar);
        avatarIcon.click();
        WebElement signoutIcon = driver.findElement(page.signout);
        signoutIcon.click();
        // kiem tra khi logout thanh cong
        WebElement expectedBtnSignIn = driver.findElement(page.buttonLogin);
        assertTrue(expectedBtnSignIn.isDisplayed());
    }
}
