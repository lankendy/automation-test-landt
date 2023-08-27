package automation.testsuite.LanDT;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day14_UpdatePasswordTest extends CommonBase {
    @BeforeTest
    public void openPage()
    {
        driver = initChromeDriver(AccountConstant.webDanhSachKhoaHoc);
    }
}
