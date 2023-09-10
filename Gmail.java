package Aug5Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Gmail {
	WebDriver driver;
	

	@Test
	public void verifyloginToNicheThyselfIsSuccessful() throws InterruptedException {	
		driver.get("https://www.google.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String parent = driver.getWindowHandle();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Gmail")));
		Actions act = new Actions(driver);
		WebElement link = driver.findElement(By.linkText("Gmail"));
		act.moveToElement(link).keyDown(Keys.CONTROL).keyDown(Keys.ENTER).click().build().perform();
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		Set<String> set1 = driver.getWindowHandles();
        String[] tabs1 = set1.toArray(new String[set1.size()]);
		driver.switchTo().window(tabs1[1]);
		driver.findElement(By.linkText("Sign in")).click();
		Set<String> set = driver.getWindowHandles();
        String[] tabs = set.toArray(new String[set.size()]);
        driver.switchTo().window(tabs[2]);
		driver.switchTo().activeElement().sendKeys("success");
		Thread.sleep(5000);
		driver.switchTo().window(parent);
		WebElement search = driver.findElement(By.cssSelector("[jsname='vdLsw']"));
		act.moveToElement(search).doubleClick().sendKeys("Selenium is Easy").sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
