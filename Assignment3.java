package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Set the implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// maximize the browser
		driver.manage().window().maximize();
		// launch the url
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		// Create webelement Object for all the dropdown present in the website
		WebElement dp1 = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		WebElement dp2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		WebElement dp3 = driver.findElement(By.xpath("//select[@id='dropdown3']"));
		WebElement dp4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		WebElement dp5 = driver.findElement(By.xpath("(//select)[5]"));
		WebElement dp6 = driver.findElement(By.xpath("//select[@multiple='']"));
		// Create Object for accessing the select class for all the dropdown
		Select drop1 = new Select(dp1);
		Select drop2 = new Select(dp2);
		Select drop3 = new Select(dp3);
		Select drop4 = new Select(dp4);
		Select drop5 = new Select(dp5);
		Select drop6 = new Select(dp6);
		// Select the first Drop down using index
		drop1.selectByIndex(1);
		// Select the second Drop down using text
		drop2.selectByVisibleText("Selenium");
		// Select the 3rd Drop down using value
		drop3.selectByValue("1");
		// Get the number of options in the drop down
		int dropDownCount = drop4.getOptions().size();
		System.out.println("Dropdown options count is " + dropDownCount);
		// Select the multiple options in the drop down
		driver.findElement(By.xpath("(//select)[5]")).sendKeys("Selenium");
		drop6.selectByVisibleText("Selenium");
		drop6.selectByVisibleText("UFT/QTP");
		drop6.selectByVisibleText("Loadrunner");
	}

}
