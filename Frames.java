package Aug5Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Frames {
	WebDriver driver;
	

	@Test
	public void heroku() throws InterruptedException {		
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		wait.until(ExpectedConditions.
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frameset-middle");
		driver.switchTo().frame("frame-left");
		driver.switchTo().frame("frame-middle");
		driver.switchTo().frame("frame-right");
		driver.switchTo().frame("frame-bottom");
		driver.navigate().to("http://the-internet.herokuapp.com/iframe");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mce_0_ifr"));
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.id("[id=tinymce]")).sendKeys("This is a frame assignment" );
	}
	//@Test
	public void cookbook() throws InterruptedException {		
		driver.get("http://www.cookbook.seleniumacademy.com/Frames.html");
		String parent = driver.getWindowHandle();
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("right"));
		driver.switchTo().frame("right");
		driver.findElement(By.cssSelector("body > iframe")).click();
		Set<String> set = driver.getWindowHandles();
        String[] tabs = set.toArray(new String[set.size()]);
        driver.switchTo().window(tabs[1]);
        driver.close();
        driver.switchTo().window(parent);
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
