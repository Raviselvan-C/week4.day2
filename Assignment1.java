package week4.day2;

import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	public static void main(String[] args) {

		// Web driver implementation for Chrome Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Set the implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// maximize the browser
		driver.manage().window().maximize();
		// launch the url
		driver.get("http://www.leafground.com/pages/Window.html");
		// click the Open Home Page button
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		// create Set and covert to List to handle multiple window
		Set<String> browser = driver.getWindowHandles();
		List<String> Window = new ArrayList<String>(browser);
		// Switch control to new window
		driver.switchTo().window(Window.get(1));
		// Close the window
		driver.close();
		// Switch control to base window
		driver.switchTo().window(Window.get(0));
		// click the 'Open Multiple Windows' button
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		// create Set and covert to List to handle multiple window
		Set<String> browser1 = driver.getWindowHandles();
		List<String> Window2 = new ArrayList<String>(browser1);
		// Find the no of new windows opened.
		int noOfWindows = Window2.size() - 1;
		// print the new windows opened
		System.out.println("number of opened windows : " + noOfWindows);
		// Switch control to 2nd window
		driver.switchTo().window(Window2.get(2));
		// Close the window
		driver.close();
		// Switch control to 1st window
		driver.switchTo().window(Window2.get(1));
		// Close the window
		driver.close();
		// Switch control to base window
		driver.switchTo().window(Window2.get(0));
		// click the 'Do not close me' button
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		// create Set and covert to List to handle multiple window
		Set<String> browser3 = driver.getWindowHandles();
		List<String> Window3 = new ArrayList<String>(browser3);
		// Switch control to 2nd window
		driver.switchTo().window(Window3.get(2));
		// Close the window
		driver.close();
		// Switch control to 1st window
		driver.switchTo().window(Window3.get(1));
		// Close the window
		driver.close();
		// Switch control to base window
		driver.switchTo().window(Window3.get(0));
		// click the 'Wait for 5 seconds' button
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		// create Set and covert to List to handle multiple window
		Set<String> browser4 = driver.getWindowHandles();
		List<String> Window4 = new ArrayList<String>(browser4);
		// Switch control to 2nd window
		driver.switchTo().window(Window4.get(2));
		// Get Title for 3rd Window
		String title_3rdWindow = driver.getTitle();
		// Switch control to 1st window
		driver.switchTo().window(Window4.get(1));
		// Get Title for 2nd Window
		String title_2ndWindow = driver.getTitle();
		System.out.println("2nd window opened is " + title_2ndWindow);
		System.out.println("3rd window opened is " + title_3rdWindow);

	}

}
