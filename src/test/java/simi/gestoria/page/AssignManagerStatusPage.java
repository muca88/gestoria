package simi.gestoria.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import simi.gestoria.resources.DataSheet;
import simi.gestoria.resources.Log;
import simi.gestoria.resources.Screenshot;

public class AssignManagerStatusPage extends PermissionSearchPage {

	public AssignManagerStatusPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By listGestoresLocator = By.id("ddlGestores");
	By listEstatusLocator = By.id("ddlEstatus");
	By buttonGuardarLocator = By.id("btnGuarda");
	By buttonRegresarLocator = By.xpath("//div/a[@href='/Gestoria/Home/BusquedaPermiso']");	
	By titleRegresoLocator = By.cssSelector("h3.page-title");
	By titleLocator = By.id("lblTituloVentana");
	
	Log log;
	Screenshot screenshot;
	
	public void assignManagerStatus(String button,String gestor,String estatus) throws Exception {
		log = new Log();
		screenshot =  new Screenshot(driver);
		explicitWait(5, titleLocator);
		if (isDisplayed(titleLocator)) {
			log.logInfo("ApplicationRecordPage", "Ingreso a la opcion " + getText(titleLocator));

		} else {
			log.logInfo("AssignManagerStatusPage", "No fue posible ingresar a la opcion" + getText(titleLocator));
		}
		
		selectDropdownList(listGestoresLocator,gestor);
		log.logInfo("AssignManagerStatusPage", "Captura gestor");
		selectDropdownList(listEstatusLocator,estatus);
		log.logInfo("AssignManagerStatusPage", "Captura estatus");
		
		if (button.equals("Guardar")) {
			screenshot.CapturaImagenen();
			click(buttonGuardarLocator);
			log.logInfo("AssignManagerStatusPage", "Opcion guardar");
			explicitWait(5, titleLocator);
			
			if (getText(titleLocator).equals("Registro solicitud unidad de negocio")) {
				log.logInfo("AssignManagerStatusPage", "Se guarda gestor y estatus");
			
			} else {
				log.logInfo("AssignManagerStatusPage", "No se guardo gestor y estatus");
				screenshot.CapturaImagenen();
			}
		}else if (button.equals("Regresar")) {
			screenshot.CapturaImagenen();
			click(buttonRegresarLocator);
			log.logInfo("AssignManagerStatusPage", "Opcion regresar");
			explicitWait(5, titleRegresoLocator);
			
			if (isDisplayed(titleRegresoLocator)) {
				log.logInfo("AssignManagerStatusPage", "Se regresa a la opción " + getText(titleRegresoLocator));
				screenshot.CapturaImagenen();
			
			} else {
				log.logInfo("AssignManagerStatusPage", "No fue posible retornar");
				screenshot.CapturaImagenen();
			}
		}
	}
}
