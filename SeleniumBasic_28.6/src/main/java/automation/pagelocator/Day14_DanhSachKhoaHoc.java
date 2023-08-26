package automation.pagelocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;

public class Day14_DanhSachKhoaHoc {
    public By textThongBao = By.id("thongbao");
    private WebDriver driver;

    public Day14_DanhSachKhoaHoc(WebDriver _driver) {
        this.driver = _driver;
        PageFactory.initElements(_driver, this);
    }
}
