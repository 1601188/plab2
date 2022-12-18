package steps;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class registrarStep {
	
	private CommonSteps step = new CommonSteps();
	
	//escenari 1: registre d'un usuari correctament
	@Given ("LUsuari entra la pagina web")
	public void LUsuariEntraLaPaginaWeb() {
		 step.funcio1();
	}
	

	@When ("LUsuari li dona a lopcio registrar")
	public void LUsuariLiDonaALopcioRegistrar () {
		step.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		step.driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
	}
	
	@Then ("Se li Mostra el formulari que ha de emplenar")
	public void SeLiMostraElFormulariQueHaDeEmplenar() {
		String title = step.driver.findElement(By.className("col-sm-9")).getText();
		Assert.assertTrue(title.contains("Account"));
		
	}
	
	@And ("^LUsuari Inserta les dades (.*) (.*) (.*) (.*)")
	public void LUsuariInsertaLesDades(String name, String lastname, String telefon, String password) {
		Random numerorandom = new Random();
		int num = numerorandom.nextInt(10000);
		String email = "Lauragomez" + num + "@gmail.com";
		step.driver.findElement(By.id("input-firstname")).sendKeys(name);
		step.driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		step.driver.findElement(By.id("input-email")).sendKeys(email);
		step.driver.findElement(By.id("input-telephone")).sendKeys(telefon);
		step.driver.findElement(By.id("input-password")).sendKeys(password);
		step.driver.findElement(By.id("input-confirm")).sendKeys(password);
	}
	
	@And ("LUsuari accepta la politica de privacitat")
	public void LUsuariAcceptaLaPoliticaDePrivacitat() {
		step.driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		
	}
	
	@And ("LUsuari Clica sobre Login per confirmar les dades")
	public void LUsuariClicaSobreLoginPerConfirmarLesDades() {
		step.driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
	}
	
	@Then ("Sha de mostrar una pagina de confirmacio de creacio de Usuari")
	public void ShaDeMostrarUnaPaginaDeConfirmacioDeCreacioDeUsuari() throws InterruptedException {
		String title = step.driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText();
		Assert.assertTrue(title.contains("Congratulations"));
		Thread.sleep(200);
		step.driver.close();	
		
	}
	
	//escenari 2: registre amb correu existent
	
	@And ("^LUsuari inserta (.*) (.*) (.*) (.*) (.*)")
	public void LUsuariInserta(String name, String lastname,String email, String telefon, String password) {

		step.driver.findElement(By.id("input-firstname")).sendKeys(name);
		step.driver.findElement(By.id("input-lastname")).sendKeys(lastname);
		step.driver.findElement(By.id("input-email")).sendKeys(email);
		step.driver.findElement(By.id("input-telephone")).sendKeys(telefon);
		step.driver.findElement(By.id("input-password")).sendKeys(password);
		step.driver.findElement(By.id("input-confirm")).sendKeys(password);
	}
	
	@Then ("Sha de mostrar una pagina indicant que el mail existeix")
	public void ShaDeMostrarUnaPaginaIndicantQueElMailExisteix() throws InterruptedException {
		String title = step.driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
		Assert.assertTrue(title.contains("Warning: E-Mail Address is already registered!"));
		Thread.sleep(200);
		step.driver.close();	
		
	}
	
}
