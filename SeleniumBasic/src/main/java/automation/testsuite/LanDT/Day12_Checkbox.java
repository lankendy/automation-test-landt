package automation.testsuite.LanDT;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day12_Checkbox extends CommonBase {
    @BeforeTest
    public void openPage() {
        driver = initChromeDriver("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
    }

    @Test
    public void handleCheckbox() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement thisCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        boolean check = thisCheckbox.isSelected();
        if (check == false) {
            thisCheckbox.click();
        }
        System.out.println("Element is selected: " + thisCheckbox.isSelected());
    }

}
