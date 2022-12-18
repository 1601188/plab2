package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import steps.IniciSteps;

public class loginSteps {
	
	 private CommonSteps step = new CommonSteps();
	
	//escenari 1: login d'un usuari creat
	 
	@Given ("Pagina principal de OpenCart")
	public void PaginaPrincipalDeOpenCart() {
		 step.funcio1();
	}
		
	
	@When("LUsuari clica a la opcio de Login")
	public void LUsuariClicaALaOpcioDeLogin() {
		step.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		step.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
	}
	
	@And("^LUsuari fica (.*) (.*)") 
	public void LUsuariFica(String string1, String string2) {
		step.driver.findElement(By.id("input-email")).sendKeys(string1);
		step.driver.findElement(By.id("input-password")).sendKeys(string2);
	
	}
	
	
	@And ("LUsuari clica al boto login")
	public void LUsuariClicaAlBotoLogin() {
		step.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	}
	
	
	@Then("LUsuari fa login correctament") 
	public void LUsuariFaLoginCorrectament() throws InterruptedException{
		String title = step.driver.findElement(By.className("col-sm-9")).getText();
		Assert.assertTrue(title.contains("My Account"));
		Thread.sleep(200);
		
	}
	
	
	//escenari 2: Un usuari fa logout 
	
	
	 @And ("LUsuari vol tancar sessio i clica al boto LogOut")
	 public void LUsuariVolTancarSessioIClicaAlBotoLogOut() {
		 step.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		 step.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
	 }
	 
	 @Then ("Sha de tancar la sessio del Usuari")
	 public void ShaDeTancarLaSessioDelUsuari() throws InterruptedException {
		 String title = step.driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText();
		 Assert.assertTrue(title.contains("logged off"));
		 Thread.sleep(200);
		 step.driver.close();	
	 }
	 
	 
	 //scenari 3: verificar que es pot recuperar la contrasenya oblidada
	  @Then ("Se li avisa de que la contrasenya es incorrecta")
	  public void SeLiAvisaDeQueLaContrasenyaEsIncorrecta() throws InterruptedException {
			 String title = step.driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
			 Assert.assertTrue(title.contains("Warning: No match for E-Mail Address and/or Password."));
			 Thread.sleep(200);
	  }
	 
	  @When ("LUsuari clica a recuperar la contrasenya")
	  public void LUsuariClicaARecuperarLaContrasenya() {
			 step.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")).click();
	  }
	  @And ("^LUsuari escriu el seu correu (.*)")
	  public void LUsuariEscriuElSeuCorreu(String email) {
			step.driver.findElement(By.id("input-email")).sendKeys(email);
			step.driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
	  }
	  @Then ("Se li confirma que ha rebut un correu per recuperar la contrasenya")
	  public void SeLiConfirmaQueHaRebutUnCorreuPerRecuperarLaContrasenya() throws InterruptedException {
		  Thread.sleep(1000);
		  String title = step.driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		  Assert.assertTrue(title.contains("An email with a confirmation link has been sent your email address."));
		  step.driver.close();
	  }

}
