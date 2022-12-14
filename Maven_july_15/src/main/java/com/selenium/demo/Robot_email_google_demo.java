package com.selenium.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Robot_email_google_demo {
	public static WebDriver driver;

	public static void down_enter_btn() throws AWTException {
		Robot a = new Robot();
		//down
		a.keyPress(KeyEvent.VK_DOWN);
		a.keyRelease(KeyEvent.VK_DOWN);
		//enter
		a.keyPress(KeyEvent.VK_ENTER);
		a.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\005\\eclipse-workspace\\Automation_project\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	driver.get("https://www.google.co.in/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15) );
	WebElement gmail = driver.findElement(By.xpath("//a[.='Images']//preceding::a"));

	Actions a = new Actions(driver);
	a.contextClick(gmail).perform();
	
	String google_pg = driver.getWindowHandle();
	//System.out.println("google page : "+google_pg);
	Set<String> all_pages = driver.getWindowHandles();
	System.out.println("all pages id:"+all_pages);

	for(String id : all_pages) {
		if (id.equals(google_pg)) {
			continue;
		}else {
			driver.switchTo().window(id);
			System.out.println("end");
		}
	}
	}
}
