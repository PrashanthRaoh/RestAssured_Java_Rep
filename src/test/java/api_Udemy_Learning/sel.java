package api_Udemy_Learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import groovy.time.Duration;

public class sel {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\GPT_Automation - ASR-US-Canada\\AutomationRoleBased\\Config\\Drivers\\chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://timkenfs.riversand.com/home");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.cssSelector("[type=\"email\"]"));
		email.sendKeys("raoad@timken.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
		Thread.sleep(20000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement home = (WebElement) 
				jse.executeScript("return document.querySelector(\"#app\").shadowRoot.querySelector(\"#rsC1QllivOHqSo9Ft6\").shadowRoot.querySelector(\"#navMenu\").shadowRoot.querySelector(\"#pageMenuIcon_4 > a\"),[]");
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", home);
		Thread.sleep(5000);
		
		

	}

}
