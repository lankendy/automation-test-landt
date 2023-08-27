package automation.pagelocator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class Day15_SearchFlight_Homework {
    @FindBy(xpath = "//input[@placeholder='City or airport'][1]")
    private WebElement flyingFrom;
    @FindBy(xpath = "(//input[@placeholder='City or airport'])[2]")
    private WebElement flyingTo;
    @FindBy(xpath = "//input[@name='daterange-single']")
    private WebElement departingDate;
    @FindBy(xpath = "(//label[text()='Departing']/following-sibling::div//input[@name='daterange-single'])[1]")
    private WebElement passengers;
    @FindBy(xpath = "(//button[@title='Economy'])[1]")
    private WebElement buttonCoach;
    @FindBy(xpath = "(//a[text()='Search Now'])[1]")
    private WebElement buttonSearch;
    private WebDriver driver;

    public Day15_SearchFlight_Homework(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFlight(String _flyingFrom, String _flyingTo, String _departingDate, String _passenger, String _coach)
    {
        flyingFrom.sendKeys(_flyingFrom);
        flyingTo.sendKeys(_flyingTo);
        ((JavascriptExecutor) driver).executeScript("argument[0].removeAttribute('readonly','readonly')", departingDate);
        departingDate.clear();
        departingDate.sendKeys(_departingDate);
        departingDate.sendKeys(Keys.TAB);
        passengers.click();
        WebElement adults = driver.findElement(By.xpath("(//label[text()='Adults']/following-sibling::div//div[@class='qtyInc'])[1]"));
        adults.click();
        buttonSearch.click();
    }
}
