package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String args[]) {
		// Webdriver implimentation for Chrome Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Set the implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// maximize the browser
		driver.manage().window().maximize();
		// launch the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		// Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		// Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		// create Set and covert to list for Handle multiple window
		Set<String> window = driver.getWindowHandles();
		List<String> listOfWindow = new ArrayList<String>(window);
		// take control of new window
		driver.switchTo().window(listOfWindow.get(1));
		// Click on First Resulting Contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		// take control of base window
		driver.switchTo().window(listOfWindow.get(0));
		// Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		// create Set and covert to list for Handle multiple window
		Set<String> window2 = driver.getWindowHandles();
		List<String> listOfWindow2 = new ArrayList<String>(window2);
		// take control of new window
		driver.switchTo().window(listOfWindow2.get(1));
		// Click on First Resulting Contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		// take control of base window
		driver.switchTo().window(listOfWindow2.get(0));
		// Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		// Handle the alert message
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		// Verify the page title
		if (title.equals("Merge Contacts | opentaps CRM")) {
			System.out.println("Title of the page is correct");
		} else {
			System.out.println("Title of the page is incorrect");
		}

	}

}
