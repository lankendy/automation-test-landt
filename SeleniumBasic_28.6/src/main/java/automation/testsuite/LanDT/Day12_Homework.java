package automation.testsuite.LanDT;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day12_Homework extends CommonBase {
    @Test
    public void openPage() {
        driver = initChromeDriver("http://demo.seleniumeasy.com/input-form-demo.html");
        Select select = new Select(driver.findElement(By.xpath("//select[@name='state']")));
        select.selectByVisibleText("Alabama");

        WebElement rdo = driver.findElement(By.xpath("//input[@value='yes']"));
        rdo.click();
    }
}
