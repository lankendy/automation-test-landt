package automation.testsuite.LanDT;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pagelocator.Day14_UpdatePasswordFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day14_UpdatePasswordTest extends CommonBase {
    @BeforeTest
    public void openPage()
    {
        driver = initChromeDriver(AccountConstant.webDanhSachKhoaHoc);
    }
    @Test
    public void updatePasswordSuccessful()
    {
        Day14_UpdatePasswordFactory factory = new Day14_UpdatePasswordFactory(driver);
        factory.updatePassword("1234567aA@", "1234567aAb@");
    }
}
