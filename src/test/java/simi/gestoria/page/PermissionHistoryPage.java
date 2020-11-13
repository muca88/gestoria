package simi.gestoria.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import simi.gestoria.base.Base;
import simi.gestoria.resources.Screenshot;

public class PermissionHistoryPage extends Base {

	public PermissionHistoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By optionPermissionHistoryLocator = By.cssSelector("a[href='/Gestoria/Home/HistorialPermisos']");
	By titleLocator = By.cssSelector("h3.page-title");
	By buttonExportarExcelLocator = By.id("btnExportExcel");
	
	Screenshot screenshot =  new Screenshot(driver);
	
	public void selectionOptionBusquedaPermisoSucursal() {
		click(optionPermissionHistoryLocator);
		log.logInfo("PermissionHistoryPage", "Opcion historial de permisos");
	}
	
	public void permissionHistory() throws InterruptedException {
		click(buttonExportarExcelLocator);
		log.logInfo("PermissionHistoryPage", "Opcion exportar excel");
		Thread.sleep(3000);
		screenshot.CapturaImagenen();
	}
	
	public void ingresoPagina() {
		explicitWait(5, titleLocator);
		if (isDisplayed(titleLocator)) {
			log.logInfo("PermissionRecordPage","Ingreso a " + getText(titleLocator));
			screenshot.CapturaImagenen();
		
		} else {
			log.logInfo("PermissionRecordPage","No fue posible ingresar a la pagina");
		}
	}

}
