package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoomSession1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(frameElement);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Ravi");
		alert.accept();
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if (text.contains("Ravi")) {
			System.out.println("Ravi is displayed");
		} else {
			System.out.println("Ravi is not displayed");
		}

	}
}
