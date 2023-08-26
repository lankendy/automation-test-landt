package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day14_LoginPageFactory {
    @FindBy(id = "email")
    private WebElement txtemail;
    @FindBy(id="password")
    private WebElement password;
    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//div[normalize-space()='Authentication failed!' and @role='alert']")
    public WebElement authenticationFail;

    private WebDriver driver;

    public Day14_LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void LoginFunctionFactory(String email, String pass)
    {
        txtemail.clear();
        txtemail.sendKeys(email);
        password.clear();
        password.sendKeys(pass);
        buttonLogin.click();
    }
}
