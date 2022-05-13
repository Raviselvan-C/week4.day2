package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Set the implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// maximize the browser
		driver.manage().window().maximize();
		// launch the url
		driver.get("https://www.amazon.in/");
		// search as oneplus 9 pro
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		// Click the search button
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		// Get the price of the first product
		String priceOf1stProduct = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		// Print the price of the first product
		System.out.println("Price of first Product : " + priceOf1stProduct);
		// Get the number of customer ratings for the first displayed product text
		String noOfCustomerRatings = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"))
				.getText();
		// Print the number of customer ratings for the first displayed product
		System.out.println("The number of customer ratings : " + noOfCustomerRatings);
		// Click the first text link of the first image
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		// handling the multiple window
		Set<String> win = driver.getWindowHandles();
		List<String> Win = new ArrayList<String>(win);
		// selenium taking control of new window
		driver.switchTo().window(Win.get(1));
		// change the default driver to screenshot driver
		TakesScreenshot scrsht = ((TakesScreenshot) driver);
		File sourceImage = scrsht.getScreenshotAs(OutputType.FILE);
		File destImage = new File("E:\\TestLeaf Trainnig\\MavenProject\\src\\snap\\IMG001.png");
		FileUtils.copyFile(sourceImage, destImage);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(3000);
		// Get the cart sub total text
		String subTotal3 = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		String subTotal2 = subTotal3.replaceAll(".00", "");
		String subTotal = subTotal2.substring(1);
		// verify if sub total is correct
		if (priceOf1stProduct.equals(subTotal)) {
			System.out.println("Price of the product and subtotal is same");
		} else {
			System.out.print("#################Alert####################");
			System.out.println("Price of the product and subtotal is same");
		}

	}

}
