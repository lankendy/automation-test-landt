package automation.pagelocator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertTrue;

public class Day15_ClientPageFactory {
    private WebDriver driver;

    @FindBy(xpath = "//a[@title='Add client']")
    private WebElement btnAddClient;

    @FindBy(xpath = "//label[text()='Person']")
    private WebElement checkboxPerson;

    @FindBy(xpath = "//input[@id='company_name']")
    private WebElement txtcompanyName;

    @FindBy(xpath = "//div[@id='s2id_created_by']")
    private WebElement checkboxOwner;

    // xpath cua dropdown list
    // Gia tri cua tung owner trong man add client
    @FindBy(xpath = "(//ul[@role='listbox'])[9]/li[1]")
    private WebElement ownerValue1;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement btnSave;

    @FindBy(xpath = "//a[text()='Clients']")
    private WebElement clientTab;

    @FindBy(xpath = "(//input[@placeholder='Search'])[2]")
    private WebElement textboxSearch;

    @FindBy(xpath = "//a[text()='Do Lan']")
    private WebElement searchResult;
    public Day15_ClientPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void AddClient(String personName) throws InterruptedException
    {
        DashboardPage dashboard = new DashboardPage();
        driver.findElement(dashboard.clientLink).click();
        btnAddClient.click();
        Thread.sleep(4000);
        checkboxPerson.click();
        txtcompanyName.sendKeys(personName);
        checkboxOwner.click();
        ownerValue1.click();
        btnSave.click();
        // khong thuc hien duoc, bao loi  intercepted
//        clientTab.click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clientTab);
        Thread.sleep(4000);
        textboxSearch.sendKeys(personName);
        Thread.sleep(4000);
        assertTrue(searchResult.isDisplayed());
    }
}
