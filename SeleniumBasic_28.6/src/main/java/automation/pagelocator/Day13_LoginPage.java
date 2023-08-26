package automation.pagelocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Day13_LoginPage {
    private By email = By.id("email");
    private By pass = By.id("password");
    public By buttonLogin = By.xpath("//button[text()='Sign in']");
    public By authenticationFail = By.xpath("//div[normalize-space()='Authentication failed!' and @role='alert']");
    public By avatar = By.xpath("//span[text()=\"John Doe\"]");
    public By signout = By.xpath("//ul[@class='dropdown-menu dropdown-menu-end w200 user-dropdown-menu show']/li[7]");
    private WebDriver driver;



    public Day13_LoginPage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void Login(String email, String pass) {
        WebElement txtEmail = driver.findElement(this.email);
        if (txtEmail.isDisplayed()) {
            txtEmail.clear();
            txtEmail.sendKeys(email);
        }

        WebElement txtPass = driver.findElement(this.pass);
        if (txtPass.isDisplayed()) {
            txtPass.clear();
            txtPass.sendKeys(pass);
        }

        WebElement btnLogin = driver.findElement(buttonLogin);
        if (btnLogin.isDisplayed()) {
            btnLogin.click();
        }

    }
}
