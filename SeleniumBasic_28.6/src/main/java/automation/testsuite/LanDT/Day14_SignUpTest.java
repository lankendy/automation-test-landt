package automation.testsuite.LanDT;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pagelocator.Day14_DanhSachKhoaHoc;
import automation.pagelocator.Day14_SignUpFactory;
import automation.pagelocator.Day14_UpdatePasswordFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v113.fedcm.model.Account;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class Day14_SignUpTest extends CommonBase {
    @BeforeTest
    public void openApplication()
    {
        driver = initChromeDriver(AccountConstant.webURL1);
    }
    @Test
    public void signupSuccessfully()
    {
        Day14_SignUpFactory factory = new Day14_SignUpFactory(driver);
        factory.SignUpFunction("DemoName", "dolansoict67gmail.com", "1234567aA@", "0979535888");

        Day14_DanhSachKhoaHoc dsKhoaHoc = new Day14_DanhSachKhoaHoc(driver);
        By expected = By.xpath("//div[@class='login']");
        WebElement expectedElement = driver.findElement(expected);
        assertTrue(expectedElement.isDisplayed());

        factory.updatePassword("1234567aA@", "1234567aAb@");
    }
}
