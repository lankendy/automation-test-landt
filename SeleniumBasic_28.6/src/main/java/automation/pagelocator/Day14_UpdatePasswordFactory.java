package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day14_UpdatePasswordFactory {
    private WebDriver driver;
    @FindBy(xpath = "//i[@class='fa fa-caret-down']")
    private WebElement avatar;
    @FindBy(xpath = "//a[text()='Chỉnh sửa thông tin']")
    private WebElement txtUpdateInfo;
    @FindBy(id = "txtpassword")
    private WebElement txtPassword;
    @FindBy(id = "txtnewpass")
    private WebElement txtNewPass;
    @FindBy(id = "txtrenewpass")
    private WebElement txtRenewPass;
    @FindBy(xpath = "//button[text()='Lưu mật khẩu mới']")
    private WebElement buttonSavePassword;

    public Day14_UpdatePasswordFactory(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void updatePassword(String pass, String newPass)
    {
        Actions action = new Actions(driver);
        action.moveToElement(avatar);
        action.moveToElement(txtUpdateInfo);
        action.click().perform();
        txtPassword.sendKeys(pass);
        txtNewPass.sendKeys(newPass);
        txtRenewPass.sendKeys(newPass);
        txtRenewPass.sendKeys(newPass);
        buttonSavePassword.click();
    }
}
