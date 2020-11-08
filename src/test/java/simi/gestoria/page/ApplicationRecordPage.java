package simi.gestoria.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import simi.gestoria.base.Base;
import simi.gestoria.resources.DataSheet;
import simi.gestoria.resources.Log;
import simi.gestoria.resources.Screenshot;

public class ApplicationRecordPage extends Base{
	
	By optionRegistroSolicitudLocator = By.cssSelector("a[href='/Gestoria/Home/RegistroSolicitud']");
	By titleLocator = By.id("lblTituloVentana");
	By textUnidadNegocioLocator = By.id("txtBusqueda");
	By buttonBuscarLocator =  By.id("btnBuscar");
	By listTipoSolicitudLocator = By.id("ddlTipoSolicitud");
	By buttonGuardarLocator = By.id("btnGuarda");
	By textClaveSapLocator = By.id("txtClaveSAP");
	By textNombreLocator = By.id("txtNombre");
	
	Screenshot screenshot = new Screenshot(driver);

	public ApplicationRecordPage(WebDriver driver) {
		super(driver);
	}
	
	public void selectionOptionRegistroSolicitud() {
		click(optionRegistroSolicitudLocator);
		log.logInfo("ApplicationRecordPage", "Opcion registro solicitud");
	}
	
	public void applicationRecord(String unidadNegocio) throws Exception {
		screenshot.CapturaImagenen();
		explicitWait(5, textUnidadNegocioLocator);
		
		if (isDisplayed(titleLocator)) {
			log.logInfo("ApplicationRecordPage", "Ingresa a registro solicitud");
		
		} else {
			log.logInfo("ApplicationRecordPage", "No ingreso a registro solicitud");
		}
		
		type(unidadNegocio, textUnidadNegocioLocator);
		log.logInfo("ApplicationRecordPage", "Captura de unidad de negocio");
		click(buttonBuscarLocator);
		log.logInfo("ApplicationRecordPage", "Selecciona boton buscar unidad de negocio");
		explicitWaitAttribute(5, textClaveSapLocator, dataSheet.getCellValue(4, 1));
		dataSheet.writeCellValue(0, 6, 1, getAttribute(textNombreLocator).trim());
		selectDropdownList(listTipoSolicitudLocator, dataSheet.getCellValue(7, 1));
		log.logInfo("ApplicationRecordPage", "Selecciona tipo de solicitud");
		screenshot.CapturaImagenen();
		click(buttonGuardarLocator);
		log.logInfo("ApplicationRecordPage", "Selecciona boton guardar registro solicitud de negocio");
		explicitWaitAttribute(5, textClaveSapLocator, "");
		
		if (getAttribute(textClaveSapLocator).equals("")) {	
			log.logInfo("ApplicationRecordPage", "La solicitud se guardo exitosamente");
			screenshot.CapturaImagenen();
		} else {
			log.logInfo("ApplicationRecordPage", "La solicitud no se guardo exitosamente");
			screenshot.CapturaImagenen();
		}

	}
}
