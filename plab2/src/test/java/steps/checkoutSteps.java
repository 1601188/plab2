package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import steps.IniciSteps;

public class checkoutSteps {
	
	private CommonSteps step = new CommonSteps();
	
	//escenari 1: verificar que no es pot comprar quan la cistella es buida
	@Given ("LUsuari es a la pagina principal")
	public void LUsuariEsALaPaginaPrincipal() {
		 step.funcio1();
	}
	
	@When ("LUsuari clica comprar a la opcio del header")
	public void LUsuariClicaComprarALaOpcioDelHeader() {
		step.funcioclick("xpath", "//*[@id=\"top-links\"]/ul/li[4]/a/i");
	}

	@Then  ("Se li avisa de que no te productes a la cistella")
	public void SeLiAvisaDeQueNoTeProductesALaCistella() {
		 String title = step.driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
		 Assert.assertTrue(title.contains("Your shopping cart is empty!"));
		 step.driver.close();
		
	}
	

	
	//escenari 2: verificar que es pot comprar desde un guest
	@When ("LUsuari afegeix un producte")
	public void LUsuariAfegeixUnProducte() {
		step.funcioclick("xpath", "//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]");	
	}
	
	@And ("LUsuari clica a la cistella per poder fer checkout")
	public void LUsuariClicaALaCistellaPerPoderFerCheckout(){
	
		new WebDriverWait(step.driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cart-total\"]"))).click();
			
	}
	

	@And ("LUsuari clica a lopcio checkout de la cistella")
	public void LUsuariClicaALopcioCheckoutDeLaCistella()  {

		new WebDriverWait(step.driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong"))).click();
	}
	@Then ("Se li mostra la pagina per omplir les seves dades")
	public void SeLiMostraLaPaginaPerOmplirLesSevesDades() {

		String title = new WebDriverWait(step.driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/h1"))).getText();
;
		Assert.assertTrue(title.contains("Checkout"));
		
	}
	@And ("LUsuari omple les seves dades")
	public void LUsuariOmpleLesSevesDades() throws InterruptedException {

		step.driver.findElement(By.xpath("//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input")).click();
		new WebDriverWait(step.driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"button-account\"]"))).click();

		new WebDriverWait(step.driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-firstname"))).sendKeys("Laura");
		step.funciosendkeys("id","input-payment-lastname","Gomez");

		step.funciosendkeys("id","input-payment-email","Laura@gmail.com");

		step.funciosendkeys("id","input-payment-telephone","655444555");

		step.funciosendkeys("id","input-payment-address-1","carrer Almeda");

		step.funciosendkeys("id","input-payment-city","Barcelona");

		step.funciosendkeys("id","input-payment-postcode","08790");

		step.funcioclick("xpath", "//*[@id=\"input-payment-country\"]");	

		step.funcioclick("xpath", "//*[@id=\"input-payment-country\"]/option[209]");	

		new WebDriverWait(step.driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-payment-zone\"]"))).click();
		new WebDriverWait(step.driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-payment-zone\"]/option[10]"))).click();

		
		WebElement ele = step.driver.findElement(By.xpath("//*[@id=\"button-guest\"]"));
		JavascriptExecutor jse = (JavascriptExecutor)step.driver;
		jse.executeScript("arguments[0].click()", ele);

		step.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement ele2 = step.driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]"));
		JavascriptExecutor jse2 = (JavascriptExecutor)step.driver;
		jse2.executeScript("arguments[0].click()", ele2);
		
		WebElement ele4 = step.driver.findElement(By.xpath("//*[@id=\"button-payment-method\"]"));
		JavascriptExecutor jse4 = (JavascriptExecutor)step.driver;
		jse4.executeScript("arguments[0].click()", ele4);
		
		step.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Thread.sleep(3000);
		WebElement ele3 = step.driver.findElement(By.xpath("//*[@id=\"button-confirm\"]"));
		JavascriptExecutor jse3 = (JavascriptExecutor)step.driver;
		jse3.executeScript("arguments[0].click()", ele3);
		
	}


	@Then ("Es verifica que sha confirmat la comanda")
	public void EsVerificaQueShaConfirmatLaComanda() throws InterruptedException {
		Thread.sleep(1000);
		String title = new WebDriverWait(step.driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h1"))).getText();
		Assert.assertTrue(title.contains("Your order has been placed!"));
		step.driver.close();	
		
	}
	
  
	
	//escenari 3: verificar que es pot comprar desde un usuari registrat
	@When ("^LUsuari inicia sessio (.*) (.*)")
	public void LUsuariIniciaSessio(String email,String password) throws InterruptedException {
		step.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		step.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		step.driver.findElement(By.id("input-email")).sendKeys(email);
		step.driver.findElement(By.id("input-password")).sendKeys(password);
		step.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

	
	}
	
	@And ("LUsuari confirma les seves dades ja guardades")
	public void LUsuariConfirmaLesSevesDadesJaGuardades() throws InterruptedException {
		step.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		step.driver.findElement(By.xpath("//*[@id=\"button-payment-address\"]")).click();
	
		step.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement click1 = step.driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]"));
		JavascriptExecutor jse5 = (JavascriptExecutor)step.driver;
		jse5.executeScript("arguments[0].click()", click1);

		WebElement click2 = step.driver.findElement(By.xpath("//*[@id=\"button-payment-method\"]"));
		JavascriptExecutor jse4 = (JavascriptExecutor)step.driver;
		jse4.executeScript("arguments[0].click()", click2);
		
		step.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement ele2 = step.driver.findElement(By.xpath("//*[@id=\"button-confirm\"]"));
		JavascriptExecutor jse2 = (JavascriptExecutor)step.driver;
		jse2.executeScript("arguments[0].click()", ele2);
		
		step.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


	}
	


	


}
