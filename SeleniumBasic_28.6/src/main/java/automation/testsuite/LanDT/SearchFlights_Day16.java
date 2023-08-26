package automation.testsuite.LanDT;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public final class SearchFlights_Day16 extends automation.common.CommonBase {
	@BeforeTest
	  @Parameters({"browser"})
    public static void createDriver(@Optional("chrome") String browser) {
        setupDriver(browser);
        driver.get("https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html");
    }
	
	@Test
	public void ChooseDatePicker() {
		WebElement dateBox = driver.findElement(
				By.xpath("(//label[text()='Departing']/following-sibling::div//input[@name='daterange-single'])[1]"));
		// Fill date as dd/mm/yyyy as 25/09/2024
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", dateBox);
		// Press tab to shift focus to time field
		dateBox.clear();
		dateBox.sendKeys("25092024");
		dateBox.sendKeys(Keys.TAB);
	}
	@AfterTest
	public void closeBrowserTest() {

//		quitDriver(driver);
	}
	
}