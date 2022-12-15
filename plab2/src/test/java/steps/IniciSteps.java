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
	
	//dubte 1, cada vegada q faig un escenari ha de fer el primer pas ?
	// dubte 2, reutilitzacio de steps
	// dubte 3, es pot utilitzar xpath
	// dubte 4, parts de la pagina web
	// dubte 5, ensnyar escenaris
	// dubte 6, confirmar amb el text esta be?
	
	
	//primer escenario
	WebDriver driver;
	
	
	@Given("LUsuari entra a la pagina principal de OpenCart")
	public void UsuariEntraAlaPaginaDeOpenCart() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://opencart.abstracta.us/");
	}
	

	@When ("la pagina es carrega correctament")
	public void LaPaginaEsCarregaCorrectament() {
		String title = driver.findElement(By.className("col-sm-4")).getText();
		Assert.assertTrue(title.contains("Your Store"));
		
	}

	@Then ("Confirmem que la pagina es carrega i mostra les opcions disponibles correctament")
	public void ConfirmemQueLaPaginaEsCarregaIMostraLesOpcionsDisponilesCorrectament() throws InterruptedException {
		String title = driver.findElement(By.className("navbar")).getText();
		Assert.assertTrue(title.contains("Desktops"));
		Thread.sleep(200);
	    driver.close();
	}
	

	//segundo escenario
	
	
	@When ("^LUsuari clica sobre la opcio (.*) del menu")
	public void LUsuariClicaSobreLaOpcioDelMenu(String article) {
		//UsuariEntraAlaPaginaDeParabank();
		driver.findElement(By.partialLinkText(article)).click();
			
	}

	@Then ("^La pagina mostra (.*)")
	public void LaPaginaMostra(String article) throws InterruptedException{
		String title = driver.findElement(By.className("col-sm-9")).getText();
		Assert.assertTrue(title.contains(article));
		Thread.sleep(200);
	    driver.close();
	}

	
	// escenario 3

	
	@When("LUsuari clica a la opcio de Login")
	public void LUsuariClicaALaOpcioDeLogin() {
		  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
	}
	
	@And("^LUsuari fica (.*) (.*)") 
	public void LUsuariFica(String string1, String string2) {
	    driver.findElement(By.id("input-email")).sendKeys(string1);
	    driver.findElement(By.id("input-password")).sendKeys(string2);
	
	}
	
	
	@And ("LUsuari clica al boto login")
	public void LUsuariClicaAlBotoLogin() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	}
	
	
	@Then("LUsuari fa login correctament") 
	public void LUsuariFaLoginCorrectament() throws InterruptedException{
		String title = driver.findElement(By.className("col-sm-9")).getText();
		Assert.assertTrue(title.contains("My Account"));
		//Thread.sleep(200);
	    //driver.close();
	}
	
	//escenari 4
	
	
	
	@When ("^LUsuari clica sobre la opcio (.*) del menu desplegable")
	public void LUsuariClicaSobreLaOpcioDelMenuDesplegable(String article) {
		driver.findElement(By.partialLinkText(article)).click();
	}
	
	
	//
	@Then ("^Mostra les opcions del menu desplegabla de la categoria (.*)")
	public void MostraLesOpcionsDelMenuDesplegablaDeLaCategoria(int numero) throws InterruptedException{
		
		if (numero != 4){
			String title = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[" + numero + "]/div/a")).getText();
			Assert.assertTrue(title.contains("Show All"));
		} else {
			String title = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[8]/div/a")).getText();
			Assert.assertTrue(title.contains("Show All"));
		}
		Thread.sleep(200);
		driver.close();	
	}
	
	//escenari 5

	@When ("LUsuari clica sobre la opcio registrar")
	public void LUsuariClicaSobreLOpcioRegistrar() {
		  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		  driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
	}
	
	@Then ("Se li Mostra el formulari que ha de emplenar")
	public void SeLiMostraElFormulariQueHaDeEmplenar() {
		String title = driver.findElement(By.className("col-sm-9")).getText();
		Assert.assertTrue(title.contains("Account"));

		
	}
	@And ("^LUsuari Inserta les dades (.*) (.*) (.*) (.*) (.*)")
	public void LUsuariInsertaLesDades(String name, String lastname, String email, String telefon, String password) {
		driver.findElement(By.id("input-firstname")).sendKeys(name);
	    driver.findElement(By.id("input-lastname")).sendKeys(lastname);
	    driver.findElement(By.id("input-email")).sendKeys(email);
	    driver.findElement(By.id("input-telephone")).sendKeys(telefon);
	    driver.findElement(By.id("input-password")).sendKeys(password);
	    driver.findElement(By.id("input-confirm")).sendKeys(password);
	}
	
	@And ("LUsuari accepta la politica de privacitat")
	public void LUsuariAcceptaLaPoliticaDePrivacitat() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		
	}
	
	@And ("LUsuari Clica sobre Login per confirmar les dades")
	public void LUsuariClicaSobreLoginPerConfirmarLesDades() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
	}
	
	@Then ("Sha de mostrar una pagina de confirmacio de creacio de Usuari")
	public void ShaDeMostrarUnaPaginaDeConfirmacioDeCreacioDeUsuari() throws InterruptedException {
		String title = driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText();
		Assert.assertTrue(title.contains("Congratulations"));
		Thread.sleep(200);
		driver.close();	
		
	}
	
	//escenari6
	
	
	 @And ("LUsuari vol tancar sessio i clica al boto LogOut")
	 public void LUsuariVolTancarSessioIClicaAlBotoLogOut() {
		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
		
	 }
	 
	 @Then ("Sha de tancar la sessio del Usuari")
	 public void ShaDeTancarLaSessioDelUsuari() throws InterruptedException {
		 String title = driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText();
		 Assert.assertTrue(title.contains("logged off"));
		 Thread.sleep(200);
		 driver.close();	
	 }
	 
	
	 //escenari 7
	 
	 @When ("^LUsuari clica sobre un producte (.*)")
	 public void LUsuariClicaSobreUnProducte(String producte) {
		 driver.findElement(By.partialLinkText(producte)).click();
		
	 }
	 	  
	 
	 @Then ("^Es mostra el producte (.*) amb detalls i preu")
	 public void EsMostraElProducteAmbDetallsIPreu(String producte) throws InterruptedException {
			String title = driver.findElement(By.className("breadcrumb")).getText();
			Assert.assertTrue(title.contains(producte));
			Thread.sleep(200);
			driver.close();	
	 }
	 */
	 
	 //escenari 8

	 @When("LUsuari clica sobre un producte iPhone") 
	 public void LUsuariClicaSobreUnProducteiPhone()  {
		 driver.findElement(By.partialLinkText("iPhone")).click();			
	 }
	 @And ("LUsuari selecciona la quantitat")
	 public void LUsuariSeleccionaLaQuantitat()  {
		 driver.findElement(By.id("input-quantity")).sendKeys("1");
			
	 }
	 @And ("LUsuari clica sobre el boto add to cart per afegir")
	 public void LUsuariClicaSobreElBotoAddToCartPerAfegir() {
		 driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
			
	 }
	 @Then ("Es confirma que sha afegit correctament el producte")
	 public void EsConfirmaQueShaAfegitCorrectamentElProducte() throws InterruptedException  {
		Thread.sleep(2000);
		String title = driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();
		Assert.assertTrue(title.contains("Success: You have added"));
		
	 }
	 
	 //escenari 9
	 
	 
	 @When ("LUsuari clica sobre el producte CANON EOS 5D a la pagina principal")
	 public void LUsuariClicaSobreElProducteCANONEOS5DALaPaginaPrincipal() {
		 driver.findElement(By.partialLinkText("Canon EOS 5D")).click();
	 }
	 	
	 
	 @And ("LUsuari clica al boto de reviews")
	 public void LUsuariClicaAlBotoDeReviews() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[2]/li[2]/a")).click();
	 }
	  
	 @And ("^LUsuari emplena el formulari de la review amb les dades (.*) (.*)")
	 public void LUsuariEmplenaElFormulariDeLaReviewAmbLesDades(String review, String nom) throws InterruptedException {
		 	//String review = "Producte molt bonic esteticament i molt facil dutilitzar, el recomano";
			driver.findElement(By.id("input-name")).sendKeys(nom);
		    driver.findElement(By.id("input-review")).sendKeys(review);
		    Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"form-review\"]/div[4]/div/input[5]")).click();
	 }
	 
	 @And ("LUsuari clica al boto de continue per guardar la review")
	 public void LUsuariClicaAlBotoDeContinuePerGuardarLaReview() throws InterruptedException {
			driver.findElement(By.xpath("//*[@id=\"button-review\"]")).click();

	 }
	  
	 @Then ("Es confirma que sha guardat la review del producte")
	 public void EsConfirmaQueShaGuardatLaReviewDelProducte() throws InterruptedException {
		Thread.sleep(2000);
		String title = driver.findElement(By.xpath("//*[@id=\"form-review\"]/div[2]")).getText();
		Assert.assertTrue(title.contains("Thank you"));
		Thread.sleep(200);
		driver.close();	
	 }
	 
	 
	 
	//escenari 10
	 
}
