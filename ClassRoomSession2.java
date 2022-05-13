package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoomSession2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		System.out.println("First Window");
		String urlForWindow1 = driver.getCurrentUrl();
		String titleForWindow1 = driver.getTitle();
		System.out.println("URL : " + urlForWindow1);
		System.out.println("Title : " + titleForWindow1);
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		Set<String> windows = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(windows);
		driver.switchTo().window(listOfWindows.get(1));
		System.out.println("Second Window");
		String urlForWindow2 = driver.getCurrentUrl();
		String titleForWindow2 = driver.getTitle();
		System.out.println("URL : " + urlForWindow2);
		System.out.println("Title : " + titleForWindow2);
		driver.switchTo().window(listOfWindows.get(0));
		System.out.println("Again first Window");
		String urlForWindow3 = driver.getCurrentUrl();
		String titleForWindow3 = driver.getTitle();
		System.out.println("URL : " + urlForWindow3);
		System.out.println("Title : " + titleForWindow3);

	}

}
