package automation.testsuite.LanDT;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day12_Radiobutton extends CommonBase {
    @BeforeTest
    public void openPage() {
        driver = initChromeDriver("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }

    @Test
    public void handleCheckbox() {
        WebElement rdoMale = driver.findElement(By.xpath("(//input[@value='Male' and @type='radio'])[1]"));
        boolean check = rdoMale.isSelected();
        if (check == false) {
            rdoMale.click();
            System.out.println("Male radio is clicked");
        }
        else {
            WebElement rdoFemale = driver.findElement(By.xpath("(//input[@value='Female' and @type='radio'])[1]"));
            rdoFemale.click();
            System.out.println("Female radio is clicked");
        }
//        driver.close();
    }
}
