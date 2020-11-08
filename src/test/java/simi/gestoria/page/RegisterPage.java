package simi.gestoria.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import simi.gestoria.base.Base;
import simi.gestoria.resources.Log;
import simi.gestoria.resources.Screenshot;

public class RegisterPage extends Base {

	By nameUserLocator = By.id("NombreUsuario");
	By contraseñaLocator = By.id("PasswordHash");
	By iniciarSesionLocator = By.cssSelector("button[class='btn btn-primary btn-block']");
	By bienvenidaTextLocator = By.cssSelector("h3[class='page-title']");
	String bienvenidaText;
	Screenshot screenshot = new Screenshot(driver);
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	public void registerUser(String user,String password) throws InterruptedException {
		implicitWait(2000);
		type(user, nameUserLocator);
		log.logInfo("RegisterPage", "Captura de usuario");
		type(password, contraseñaLocator);
		log.logInfo("RegisterPage", "Captura de contraseña");
		screenshot.CapturaImagenen();
		click(iniciarSesionLocator);
		log.logInfo("RegisterPage", "Inicio de sesion");
		bienvenidaText = getText(bienvenidaTextLocator);
		
		if (bienvenidaText.equals("Bienvenido: admmartha")) {
			log.logInfo("RegisterPage", "Ingreso a gestoria");
			screenshot.CapturaImagenen();
		} else {
			log.logInfo("RegisterPage", "No ingreso a gestoria");
			screenshot.CapturaImagenen();
		}
	}

}
