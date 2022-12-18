package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class cistellaSteps {
	
	 private CommonSteps step = new CommonSteps();
	

	//escenari 1: Afegir un producte a la cistella
	@Given ("Pagina principal")
	public void PaginaPrincipal () {
		 step.funcio1();
	}
	
	@When ("LUsuari clica a un producte")
	public void LUsuariClicaAUnProducte() throws InterruptedException {
		Thread.sleep(1000);
		step.funcioclick("partialLinkText", "iPhone");	
	}
	
	@And ("LUsuari lafegeix a la cistella")
	public void LUsuariLafegeixALaCistella() throws InterruptedException {
		Thread.sleep(1000);
		step.funcioclick("xpath", "//*[@id=\"button-cart\"]");			
	}
	
	@Then ("El producte sha afegit a la cistella correctament")
	public void ElProducteShaAfegitALaCistellaCorrectament() throws InterruptedException {
		Thread.sleep(1000);
		String title = step.driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();
		Assert.assertTrue(title.contains("Success"));
	}
	
	

	 //escenari 2: Eliminar un producte desde la cistella
	 @And ("LUsuari clica a la cistella per visualitzar els seus productes")
	 public void LUsuariClicaALaCistellaPerVisualitzarElsSeusProductes() {
		step.funcioclick("xpath", "//*[@id=\"top-links\"]/ul/li[4]/a/i");		
	 }
	 
	 @And ("LUsuari elimina un dels seus productes")
	 public void LUsuariEliminaUnDelsSeusProductes() throws InterruptedException {
		step.funcioclick("xpath", "//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[4]/div/span/button[2]/i");				
	 }
	  
	 @Then ("El producte sha eliminat correctament de la cistella")
	 public void ElProducteShaEliminatCorrectamentDeLaCistella() throws InterruptedException {
		Thread.sleep(1000);
		String title = step.driver.findElement(By.xpath("//*[@id=\"cart-total\"]")).getText();
		Assert.assertTrue(title.contains("0 item(s)"));	
		step.driver.close();
	 }
	
	
	 //escenari 3: Avisar de que no hi ha stock dun producte a la cistella
	 @Then ("Es mostra un missatge de que no hi ha stock del producte")
	 public void EsMostraUnMissatgeDeQueNoHiHaStockDelProducte() throws InterruptedException {
		Thread.sleep(1000);
		String title = step.driver.findElement(By.xpath("//*[@id=\"checkout-cart\"]/div[1]")).getText();	
		Assert.assertTrue(title.contains("not in stock!"));	
		step.driver.close();
	 }

}
