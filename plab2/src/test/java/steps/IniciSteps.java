package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IniciSteps {
	
	 private CommonSteps step = new CommonSteps();
	 
	 //escenari 1: Mostrar la pagina dinici correctament
	 @Given("LUsuari entra a la pagina principal de OpenCart")
	 public void  UsuariEntraAlaPaginaDeOpenCart() {
		 step.funcio1();
	 }
		
	@When ("la pagina es carrega correctament")
	public void LaPaginaEsCarregaCorrectament() {
		String title = step.driver.findElement(By.className("col-sm-4")).getText();
		Assert.assertTrue(title.contains("Your Store"));
		
	}

	@Then ("Confirmem que la pagina es carrega i mostra les opcions disponibles correctament")
	public void ConfirmemQueLaPaginaEsCarregaIMostraLesOpcionsDisponilesCorrectament() throws InterruptedException {
		String title = step.driver.findElement(By.className("navbar")).getText();
		Assert.assertTrue(title.contains("Desktops"));
		Thread.sleep(200);
		step.driver.close();
	}
	

	//escenari 2: accedir a les categories amb menus no desplegables
	@When ("^LUsuari clica sobre la opcio (.*)")
	public void LUsuariClicaSobreLaOpcio(String article) {
		step.funcioclick("partialLinkText", article);
		//step.driver.findElement(By.partialLinkText(article)).click();
			
	}

	@Then ("^La pagina mostra (.*)")
	public void LaPaginaMostra(String article) throws InterruptedException{
		String title = step.driver.findElement(By.className("col-sm-9")).getText();
		Assert.assertTrue(title.contains(article));
		Thread.sleep(200);
		step.driver.close();
	}

	
	

	//escenari 3: accedir a les categories amb menus desplegables
	

	@Then ("^Mostra les opcions del menu desplegabla de la categoria (.*)")
	public void MostraLesOpcionsDelMenuDesplegablaDeLaCategoria(int numero) throws InterruptedException{
		
		if (numero != 4){
			String title = step.driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[" + numero + "]/div/a")).getText();
			Assert.assertTrue(title.contains("Show All"));
		} else {
			String title = step.driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[8]/div/a")).getText();
			Assert.assertTrue(title.contains("Show All"));
		}
		Thread.sleep(200);
		step.driver.close();	
	}

	
	//escenari 4: Si es fa click a un producte a la pagina principal que es mostri la descripcio 
	 	  
	 
	 @Then ("^Es mostra el producte (.*) amb detalls i preu")
	 public void EsMostraElProducteAmbDetallsIPreu(String producte) throws InterruptedException {
		 String title = step.driver.findElement(By.className("breadcrumb")).getText();
		 Assert.assertTrue(title.contains(producte));
		 Thread.sleep(200);
		 step.driver.close();	
	 }
	 
	 
	 
	//escenari 5: verificar que es pot fer el canvi de moneda 
	 
	 @When ("El client pren sobre la moneda al header")
	 public void ElClientPrenSobreLaMonedaAlHeader() {
		 step.funcioclick("xpath", "//*[@id=\"form-currency\"]/div/button");		
	 }
	 	  
	 @And ("^LUsuari canvia el tipus de moneda a (.*)")
	 public void LUsuariCanviaElTipusDeMonedaA(String opcio) throws InterruptedException {
		 Thread.sleep(1000);
		 if(opcio.equals("€ Euro")) {
			 step.funcioclick("xpath", "//*[@id=\"form-currency\"]/div/ul/li[1]/button");		
			 //step.driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button")).click();
		 }
		 if(opcio.equals("£ Pound Sterling")) {
			 step.funcioclick("xpath", "//*[@id=\"form-currency\"]/div/ul/li[2]/button");	
			 //step.driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button")).click();
		 }
		 if(opcio.equals("$ US Dollar")) {
			 step.funcioclick("xpath", "//*[@id=\"form-currency\"]/div/ul/li[3]/button");	
			 //step.driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button")).click();
		 }
		 
		
	 }
	 
	 @Then ("^Es mostren els productes amb el tipus de moneda (.*) corresponent")
	 public void EsMostrenElsProductesAmbElTipusDeMonedaCorresponent(String simbol) throws InterruptedException {
		 String preu = step.driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/p[2]")).getText();
		 Assert.assertTrue(preu.contains(simbol));
		 Thread.sleep(200);
		 step.driver.close();
	 } 
	 
	 
	 //escenari 6: verificar que es pot buscar un producte al buscador 
	 
	 @When ("^LUsuari escriu (.*) al buscador")
	 public void LUsuariEscriuAlBuscador(String opcio) {
		 step.driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys(opcio);
		
	 }
	 	
	 @And ("LUsuari confirma lopcio")
	 public void LUsuariConfirmaLopcio() {
		 step.funcioclick("xpath", "//*[@id=\"search\"]/span/button");	
		 //step.driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		
	 }
	 
	 @Then ("^Es mostra o no els productes buscats (.*)")
	 public void EsMostraONoElsProductesBuscats(String opcio) throws InterruptedException {
		 if (opcio.equals("iPhone")) {
			 Thread.sleep(1000);
			 String prod = step.driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a")).getText();
			 Assert.assertTrue(prod.contains(opcio));
			
		 }else {
			 Thread.sleep(200);
			 String prod = step.driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText();
			 Assert.assertTrue(prod.contains("Your shopping cart is empty!"));
					 
		 }
		 step.driver.close();
		 
	 }
}
