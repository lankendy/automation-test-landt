package automation.testsuite.LanDT;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day12_Dropdownlist extends CommonBase {
    @Test
    public void openPage() {
        driver = initChromeDriver("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        Select singleSelect = new Select(driver.findElement(By.id("select-demo")));
        System.out.println("Size is: " + singleSelect.getOptions().size());

        WebElement dropDayWebElement = driver.findElement(By.id("select-demo"));
        dropDayWebElement.click();

        singleSelect.selectByVisibleText("Monday");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("Monday", singleSelect.getFirstSelectedOption().getText());
    }
}
