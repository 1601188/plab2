package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import steps.IniciSteps;


public class footterSteps {
	
	private CommonSteps step = new CommonSteps();
	
	//escenari 1: verificar que es pot accedir a les opcions d'informacio del peu de pagina
	@Given ("Pagina principal de la web")
	public void PaginaPrincipalDeLaWeb() {
		 step.funcio1();
	}
	
	
	@When ("^LUsuari clica sobre una opcio dinformacio (.*)")
	public void LUsuariClicaSobreUnaOpcioDinformacio(String opcio) {
		//step.driver.findElement(By.partialLinkText(opcio)).click();
		step.funcioclick("partialLinkText", opcio);
	}
	
	@Then  ("^Se li ha de mostra la pagina amb linformacio (.*) on ha clicat")
	public void SeLiHaDeMostraLaPaginaAmbLinformacioOnHaClicat(String opcio) throws InterruptedException {
		String title = step.driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertTrue(title.contains(opcio));
		Thread.sleep(200);
		step.driver.close();
	}
	
	
	//escenari 2: verificar que un usuari pot contactar amb lempresa
	
	@Then  ("Se li mostra el formulari")
	public void SeLiMostraElFormulari() {
		String title = step.driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertTrue(title.contains("Contact Us"));
	}
	
	@And ("^LUsuari emplena les dades (.*) (.*) (.*)")
	public void LUsuariEmplenaLesDades(String enquiry ,String email,String nom) throws InterruptedException {
		step.driver.findElement(By.id("input-name")).sendKeys(nom);
		step.driver.findElement(By.id("input-email")).sendKeys(email);
		step.driver.findElement(By.id("input-enquiry")).sendKeys(enquiry);
		Thread.sleep(500);
	}
	
	@And ("Clica al boto per enviar les dades")
	public void ClicaAlBotoPerEnviarLesDades() throws InterruptedException {
		WebElement ele = step.driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input"));
		JavascriptExecutor jse = (JavascriptExecutor)step.driver;
		jse.executeScript("arguments[0].click()", ele);

	}
	
	@Then ("Senvien les dades correctament")
	public void SenvienLesDadesCorrectament() throws InterruptedException {
		Thread.sleep(1000);
		String title = step.driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertTrue(title.contains("Contact Us"));
		
	}
	
	
	
	//escenari 3: verificar que es pot accedir a la pagina de devolucio desde lopcio del footer i emplenar el formulari i enviar
	
	@Then ("Es mostra el formulari de devolucio")
	public void EsMostraElFormulariDeDevolucio() {
		String title = step.driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[1]/legend")).getText();
		Assert.assertTrue(title.contains("Order History"));
	}
	
	@And ("^El client inserta les dades (.*) (.*) (.*) (.*) (.*) (.*) (.*) (.*)")
	public void ElClientInsertaLesDades(String details, String name, String lastname, String email, String telephone,String orderid,String prodname,String prodcode) throws InterruptedException {

		
		 step.funciosendkeys("xpath", "//*[@id=\"input-firstname\"]", name); 
		 step.funciosendkeys("id", "input-lastname", lastname); 
		 step.funciosendkeys("id", "input-email", email); 
		 step.funciosendkeys("id", "input-telephone", telephone); 
		 step.funciosendkeys("id", "input-order-id", orderid); 
		 step.funcioclick("xpath","//*[@id=\"content\"]/form/fieldset[1]/div[6]/div/div/span/button");
		 step.funcioclick("xpath","/html/body/div[3]/div/div[1]/table/tbody/tr[3]/td[5]");
		 
		 
		 step.funciosendkeys("id", "input-product", prodname); 
		 step.funciosendkeys("id", "input-model", prodcode); 
		 step.funcioclick("xpath","//*[@id=\"content\"]/form/fieldset[2]/div[4]/div/div[2]/label/input");
		
		 step.funciosendkeys("id", "input-comment", details); 
		 
	}
	
	@And ("Confirmar les dades")
	public void ConfirmarLesDades() {
		WebElement ele = step.driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input"));
		JavascriptExecutor jse = (JavascriptExecutor)step.driver;
		jse.executeScript("arguments[0].click()", ele);

	}
	
	@Then ("Confirmacio denviament")
	public void ConfirmacioDenviament() {
		String title = step.driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText();
		Assert.assertTrue(title.contains("Thank you for submitting your return request. Your request has been sent to the relevant department for processing."));
		
	}
	
}


