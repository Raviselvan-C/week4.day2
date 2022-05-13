package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		// Web driver implementation for Chrome Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Set the implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// maximize the browser
		driver.manage().window().maximize();
		// launch the url
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		// create webelement object for frame1
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		// switch to the frame1
		driver.switchTo().frame(frame);
		// Enter the text box inside frame
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("Assignment2");
		// create webelement object for frame3
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		// switch to the frame3
		driver.switchTo().frame(frame3);
		// Click the check box
		driver.findElement(By.xpath("//input[@id='a']")).click();
		// come out of the frame
		driver.switchTo().defaultContent();
		// create webelement object for frame2
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		// switch to the frame2
		driver.switchTo().frame(frame2);
		// select the dropdown
		driver.findElement(By.xpath("//select[@id='animals']")).sendKeys("Avatar");
	}

}
