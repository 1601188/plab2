package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CommonSteps {
	
	WebDriver driver;
	
	public void  funcio1() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://opencart.abstracta.us/");

	}
	
	public void  funcioclick(String tipus, String path) {
		switch(tipus) {
			case "xpath":
				driver.findElement(By.xpath(path)).click();
				break;
			case "className":
				driver.findElement(By.className(path)).click();
				break;
			case "id":
				driver.findElement(By.id(path)).click();
				break;
			case "partialLinkText":
				driver.findElement(By.partialLinkText(path)).click();
				break;
			default:
				break;	
		}

	}
	
	public void  funciosendkeys(String tipus, String path, String keys) {
		switch(tipus) {
			case "xpath":
				driver.findElement(By.xpath(path)).sendKeys(keys);
				break;
			case "className":
				driver.findElement(By.className(path)).sendKeys(keys);
				break;
			case "id":
				driver.findElement(By.id(path)).sendKeys(keys);
				break;
			default:
				break;	
		}

	}
	
	/*
	public boolean funcioconfirmaciotext(String tipus,String path, String text) {
		
		Boolean trobat = false;
		
		switch(tipus) {
			case "xpath":
				String title = driver.findElement(By.xpath(path)).getText();
				trobat = title.contains(text);
				return trobat;
			case "className":
				String title2 = driver.findElement(By.className(path)).getText();
				trobat = title2.contains(text);
				return trobat;
			case "id":
				String title3 = driver.findElement(By.className(path)).getText();
				trobat = title3.contains(text);
				return trobat;
			default:
				break;	
		
		}
		
		return trobat;
	}
	*/
	
	
	
	
	

}
