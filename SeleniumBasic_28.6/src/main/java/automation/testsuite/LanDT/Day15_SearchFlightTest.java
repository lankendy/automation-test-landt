package automation.testsuite.LanDT;

import automation.common.CommonBase;
import automation.constant.AccountConstant;
import automation.pagelocator.Day15_SearchFlight_Homework;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day15_SearchFlightTest extends CommonBase {
    @BeforeTest
    public void openPage()
    {
        driver = initChromeDriver(AccountConstant.webSearchFlight);
    }
    @Test
    public void searchFlight()
    {
        Day15_SearchFlight_Homework searchFlight = new Day15_SearchFlight_Homework(driver);
        searchFlight.searchFlight("Ha Noi", "Ho Chi Minh", "30/09/2024", "adults", "economy");
    }
}
