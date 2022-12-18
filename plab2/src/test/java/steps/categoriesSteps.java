package steps;

import java.time.Duration;

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

import steps.IniciSteps;


public class categoriesSteps {
	
	
	private CommonSteps step = new CommonSteps();
	
	//escenari 1: verificar que es poden filtrar productes d'una categoria 
	@Given ("LUsuari entra a OpenCart")
	public void LUsuariEntraAOpenCart() {
		 step.funcio1();
	}
	
	@When ("LUsuari clica sobre una categoria")
	public void LUsuariClicaSobreUnaCategoria() {
		step.funcioclick("xpath", "//*[@id=\"menu\"]/div[2]/ul/li[6]/a");
	}
	
	@And ("LUsuari filtra els productes de menor a major preu")
	public void LLUsuariFiltraElsProductesDeMenorAMajorPreu() {
		step.funcioclick("xpath", "//*[@id=\"input-sort\"]");
		step.funcioclick("xpath", "//*[@id=\"input-sort\"]/option[4]");
		
	}
	@Then  ("Se li ha de mostrar els productes ordenats per preu")
	public void SeLiHaDeMostrarElsProductesOrdenatsPerPreu(){
		//String title = new WebDriverWait(step.driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-sort\"]/option[4]"))).getText(); 
		//Boolean trobat = step.funcioconfirmaciotext("xpath","//*[@id=\"input-sort\"]/option[4]", "Price (Low > High)");
		String title = step.driver.findElement(By.xpath("//*[@id=\"input-sort\"]/option[4]")).getText();
		Assert.assertTrue(title.contains("Price (Low > High)"));	
		step.driver.close();

	}
	
	
	//escenari 2: verificar que es pot canviar de categoria desde el menu flotant a l'esquerra
	@When ("LUsuari clica sobre una categoria desplegable")
	public void LUsuariClicaSobreUnaCategoriaDesplegable() {
		step.funcioclick("xpath", "//*[@id=\"menu\"]/div[2]/ul/li[1]/a");
		step.funcioclick("xpath", "//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[1]/a");
	}
	
	@And ("LUsuari clica a un altra tipus de producte de la categoria desde el menu flotant")
	public void LUsuariClicaAUnAltraTipusDeProducteDeLaCategoriaDesdeElMenuFlotant() {
		step.funcioclick("xpath", "//*[@id=\"column-left\"]/div[1]/a[3]");
	}
	
	@Then  ("Se li ha de mostrar els productes de una altre categoria")
	public void SeLiHaDeMostrarElsProductesDeUnaAltreCategoria() {
		//String title = new WebDriverWait(step.driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/h2"))).getText();
		//Boolean trobat = step.funcioconfirmaciotext("xpath","//*[@id=\"content\"]/h2", "Mac");
		//Assert.assertTrue(trobat);
		String title = step.driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText();
		Assert.assertTrue(title.contains("Mac"));	
		step.driver.close();
	}
	
	
}
