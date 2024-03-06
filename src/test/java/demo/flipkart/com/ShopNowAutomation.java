package demo.flipkart.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShopNowAutomation {
	public static void main(String[] args) {
		// Set path to the WebDriver, for example, the ChromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			
			driver.get("https://www.flipkart.com");
			driver.manage().window().maximize();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='Flipkart']")));																									// element
			System.out.println("Homepage loaded successfully.");
			driver.findElement(By.name("q")).sendKeys("laptop");
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'_1fQZEK')]"))).click();
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}
			
			driver.findElement(By.id("pincodeInputId")).sendKeys("600044");
			driver.findElement(By.xpath("//span[text()='Check']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='row']//li//button)[1]")))
					.click();
			System.out.println("Product added to the cart.");

			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Place Order')]")))
					.click();
			System.out.println("Proceeded to checkout.");

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form//div//input")))
			
					.sendKeys("abc@gmail.com" + Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form//div[2]//input")))
			
			.sendKeys("9840076968" + Keys.ENTER);
			
	
			System.out.println("User logged in successfully.");

		} finally {
			// Cleanup
			driver.quit();
		}
	}
}
