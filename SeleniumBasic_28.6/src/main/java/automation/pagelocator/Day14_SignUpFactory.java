package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day14_SignUpFactory {
    private WebDriver driver;

    @FindBy(id = "txtFirstname")
    private WebElement textboxFirstname;
    @FindBy(id="txtEmail")
    private WebElement txtEmail;
    @FindBy(id = "txtCEmail")
    private WebElement txtConfirmEmail;
    @FindBy(id="txtPassword")
    private WebElement txtPassword;
    @FindBy(id="txtCPassword")
    private WebElement txtConfirmPass;
    @FindBy(id="txtPhone")
    private WebElement textPhone;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSignUp;

    @FindBy(xpath = "//li[@id='showsub']")
    private WebElement avatar;
    @FindBy(xpath = "//ul[@id='subulmenu'")
    private WebElement subMenu;
    @FindBy(xpath = "//a[text()='Chỉnh sửa thông tin']")
    private WebElement txtUpdateInfo;
    @FindBy(id = "txtpassword")
    private WebElement txtPass;
    @FindBy(id = "txtnewpass")
    private WebElement txtNewPass;
    @FindBy(id = "txtrenewpass")
    private WebElement txtRenewPass;
    @FindBy(xpath = "//button[text()='Lưu mật khẩu mới']")
    private WebElement buttonSavePassword;

    @FindBy(id = "email")
    private WebElement txtemail;
    @FindBy(id="password")
    private WebElement password;
    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement buttonLogin;

    public Day14_SignUpFactory(WebDriver _driver) {
        this.driver = _driver;
        PageFactory.initElements(_driver, this);
    }

    public void SignUpFunction(String firstName, String email, String pass, String phone)
    {
        textboxFirstname.sendKeys(firstName);
        txtEmail.sendKeys(email);
        txtConfirmEmail.sendKeys(email);
        txtPassword.sendKeys(pass);
        txtConfirmPass.sendKeys(pass);
        textPhone.sendKeys(phone);
        buttonSignUp.click();
    }

    public void updatePassword(String pass, String newPass)
    {
        Actions action = new Actions(driver);
        action.moveToElement(avatar);
        action.moveToElement(subMenu);
        action.moveToElement(txtUpdateInfo);
        action.click().perform();
        txtPass.sendKeys(pass);
        txtNewPass.sendKeys(newPass);
        txtRenewPass.sendKeys(newPass);
        txtRenewPass.sendKeys(newPass);
        buttonSavePassword.click();
    }

    public void loginWithNewPassword(String email, String newPass)
    {
        txtemail.clear();
        txtemail.sendKeys(email);
        password.clear();
        password.sendKeys(newPass);
        buttonLogin.click();
    }
}
