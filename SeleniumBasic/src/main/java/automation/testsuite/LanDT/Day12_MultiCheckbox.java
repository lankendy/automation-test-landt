package automation.testsuite.LanDT;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Day12_MultiCheckbox extends CommonBase {
    @BeforeMethod
    public void init() {
        driver = initChromeDriver("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
    }
    @Test
    public void multiCheckbox() {
        // cach kiem tra cac o checkbox da duoc click hay chua
        //1. lay het list checkbox
        List<WebElement> listCheckbox = driver.findElements(By.xpath("(//div[@class='panelbody'])[3]//div[@class='checkbox']//input"));
        System.out.println("Tong so luong checkbox: " +listCheckbox.size());

        //2. duyet list tren de lay ra tung checkbox
        for (int i=0; i< listCheckbox.size(); i++) {
            System.out.println("Checkbox o vi tri thu " + i + "isSelected " + listCheckbox.get(i).isSelected());
            // tao bien luu gia tri true false de check dieu kien if else
            boolean isCheckboxSelected = listCheckbox.get(i).isSelected();
            if (isCheckboxSelected == false) {
                listCheckbox.get(i).click();
                pause(4000);
                System.out.println("checkbox o vi tri thu " + i + "da duoc checked");
            }
        }

        // 3. cach lay ra tung item cu the - dua vao so luong item tren list
        System.out.println("====================");
        for (int i = 0; i < listCheckbox.size(); i++) {
            // lay ra element theo thu tu trong list web element da luu de kiem tra tung thang checkbox
            WebElement itemCheckbox = driver.findElement(
                    By.xpath("((//div[@class='panel-body'])[3]//div[@class='checkbox']//input[" + (i + 1) + "]"));
            System.out.println(itemCheckbox.isSelected());

        }
        pause(2000);
//        driver.close();
    }
}
