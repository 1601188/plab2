package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class producteSteps {
	
	 private CommonSteps step = new CommonSteps();
	 
	 //escenari 1: poder afegir a la cistella un producte desde la pantalla d'aquest
	 @Given("LUsuari entra a la pagina web")
	 public void  LUsuariEntraALaPaginaWeb() {
		 step.funcio1();
	 }
		
	 @When("LUsuari clica sobre el producte que linteresa") 
	 public void LUsuariClicaSobreElProducteQueLinteresa()  {
		 step.driver.findElement(By.partialLinkText("iPhone")).click();			
	 }
	 @And ("LUsuari selecciona la quantitat")
	 public void LUsuariSeleccionaLaQuantitat()  {
		 step.driver.findElement(By.id("input-quantity")).sendKeys("1");
			
	 }
	 @And ("LUsuari clica sobre el boto add to cart per afegir")
	 public void LUsuariClicaSobreElBotoAddToCartPerAfegir() {
		 step.driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
			
	 }
	 @Then ("Es confirma que sha afegit correctament el producte")
	 public void EsConfirmaQueShaAfegitCorrectamentElProducte() throws InterruptedException  {
		Thread.sleep(2000);
		String title = step.driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();
		Assert.assertTrue(title.contains("Success: You have added"));
		Thread.sleep(200);
		step.driver.close();
		
	 }
	 
	
	 //escenari 2: poder afegir una review d'un producte 

	 @When ("LUsuari clica sobre el producte CANON EOS 5D a la pagina principal")
	 public void LUsuariClicaSobreElProducteCANONEOS5DALaPaginaPrincipal() {
		 step.driver.findElement(By.partialLinkText("Canon EOS 5D")).click();
	 }
	 	
	 
	 @And ("LUsuari clica al boto de reviews")
	 public void LUsuariClicaAlBotoDeReviews() {
		 step.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[2]/li[2]/a")).click();
	 }
	  
	 @And ("^LUsuari emplena el formulari de la review amb les dades (.*) (.*)")
	 public void LUsuariEmplenaElFormulariDeLaReviewAmbLesDades(String review, String nom) throws InterruptedException {
		 step.driver.findElement(By.id("input-name")).sendKeys(nom);
		 step.driver.findElement(By.id("input-review")).sendKeys(review);
		 Thread.sleep(2000);
		 step.driver.findElement(By.xpath("//*[@id=\"form-review\"]/div[4]/div/input[5]")).click();
	 }
	 
	 @And ("LUsuari clica al boto de continue per guardar la review")
	 public void LUsuariClicaAlBotoDeContinuePerGuardarLaReview() throws InterruptedException {
		 step.driver.findElement(By.xpath("//*[@id=\"button-review\"]")).click();

	 }
	  
	 @Then ("Es confirma que sha guardat la review del producte")
	 public void EsConfirmaQueShaGuardatLaReviewDelProducte() throws InterruptedException {
		Thread.sleep(2000);
		String title = step.driver.findElement(By.xpath("//*[@id=\"form-review\"]/div[2]")).getText();
		Assert.assertTrue(title.contains("Thank you"));
		Thread.sleep(200);
		step.driver.close();	
	 }
	 

	 


	 

}
