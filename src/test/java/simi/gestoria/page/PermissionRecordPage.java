package simi.gestoria.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import simi.gestoria.resources.DataSheet;
import simi.gestoria.resources.Log;
import simi.gestoria.resources.Screenshot;

public class PermissionRecordPage extends PermissionSearchPage {
	
	public PermissionRecordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By titleLocator = By.cssSelector("h3.page-title");
	By selectionPermisoLocator = By.id("ddlPermisos");
	By textFolioDocumentoInicioTramiteLocator = By.id("txtFolio");
	By dateFechaLocator = By.id("txtFecha");
	By fileDocumentoInicioTramiteLocator = By.id("Archivo");
	By textFolioDocumentoPermisoLocator = By.id("txtFolioP");
	By dateFechaDocumentoPermisoLocator = By.id("txtFechaP");
	By dateFechaVigenciaDocumentoPermisoLocator = By.id("txtVigencia");
	By selectionTipoDocumentoDocumentoPermisoLocator = By.id("ddlTipoDoc");
	By textRFCLocator = By.id("txtRFC");
	By textRazonSocialLocator = By.id("txtRazSoc");
	By textResponsivaLocator = By.id("txtResponsiva");
	By fileDocumentoPermisoLocator = By.id("ArchivoP");
	By checkboxRecibo = By.xpath("//label[@for='cbRecibo']/strong");
	By textFolioReciboLocator = By.id("txtFolioR");
	By listTipoDocumentoReciboLocator = By.id("ddlTipoDocTR");
	By textImporteReciboLocator = By.id("txtImporteR");
	By dateFechaReciboLocator = By.id("txtFechaR");
	By listMetodoPagoReciboLocator = By.id("ddlTipoFormaPagoR");
	By fileReciboLocator = By.id("ArchivoR");
	By checkboxFactura = By.xpath("//label[@for='cbFactura']/strong");
	By textFolioFacturaLocator = By.id("txtFolioF");
	By listTipoDocumentoFacturaLocator = By.id("ddlTipoDocTF");
	By textImporteFacturaLocator = By.id("txtImporteF");
	By dateFechaFacturaLocator = By.id("txtFechaF");
	By listMetodoPagoFacturaLocator = By.id("ddlTipoFormaPagoF");
	By fileFacturaLocator = By.id("ArchivoF");
	By textObservacionesLocator = By.id("txtObserv");
	By listEstatusLocator = By.id("ddlEstatus");
	By buttonGuardarLocator = By.id("btnGuardar");
	By messageGuardarPermisoLocator = By.id("lblMensaje");
	By buttonAceptarLocator = By.linkText("Aceptar");
	By inicioTramiteLocator = By.xpath("//div[@class='modal-content']/div[2]/div[1]/div[2]/i");
	By permisoLocator = By.xpath("//div[@class='modal-content']/div[2]/div[2]/div[2]/i");
	By reciboLocator = By.xpath("//div[@class='modal-content']/div[2]/div[3]/div[2]/i");
	By facturaLocator = By.xpath("//div[@class='modal-content']/div[2]/div[4]/div[2]/i");
	
	Screenshot screenshot =  new Screenshot(driver);
	
	public void addPermission() throws Exception {
		
		//selectionOptionBusquedaPermisoSucursal();	
		//selectionOptionGestorPermiso(option);
		ingresoPagina();
		selectDropdownList(selectionPermisoLocator, dataSheet.getCellValue(19, 1));
		documentoInicioTramite(dataSheet.getCellValue(22, 1), dataSheet.getCellValue(23, 1), dataSheet.getCellValue(24, 1));
		documentoPermiso(dataSheet.getCellValue(22, 1), dataSheet.getCellValue(22, 1), dataSheet.getCellValue(22, 1), 
						dataSheet.getCellValue(22, 1), dataSheet.getCellValue(22, 1), dataSheet.getCellValue(22, 1),
						dataSheet.getCellValue(22, 1), dataSheet.getCellValue(22, 1));
		recibo();
		factura();
		type("Observaciones prueba", textObservacionesLocator);
		selectDropdownList(listEstatusLocator, "INGRESADO");
		click(buttonGuardarLocator);
		aceptarRegistroPermiso();	
	} 
	
	public void optionsPerrmission(String optionTablePermisos,String detallePermisos,String solicitudIngresos) throws Exception {
		
		if (optionTablePermisos.equals("detalle")) {
			
			selectionOptionBusquedaPermisoSucursal();	
			selectionOptionGestorPermiso(detallePermisos);//Detalle permisoa
			optionsTablePermisos(optionTablePermisos, solicitudIngresos);
			click(buttonCerrarLocator);
			
		} else if (optionTablePermisos.equals("editar")) {
			selectionOptionBusquedaPermisoSucursal();	
			selectionOptionGestorPermiso(detallePermisos);//Detalle permisoa
			optionsTablePermisos("detalle", solicitudIngresos);
			
			if (getAttributeStyle(inicioTramiteLocator).equals("visibility: visible;")
				||getAttributeStyle(permisoLocator).equals("visibility: visible;")
				||getAttributeStyle(reciboLocator).equals("visibility: visible;")
				||getAttributeStyle(facturaLocator).equals("visibility: visible;")) {
				click(buttonCerrarLocator);
			}else {
				
				click(buttonCerrarLocator);
				//selectionOptionBusquedaPermisoSucursal();	
				//selectionOptionGestorPermiso(detallePermisos);//Detalle permisoa
				optionsTablePermisos(optionTablePermisos, solicitudIngresos);
				ingresoPagina();
				//documentoInicioTramite();
				//documentoPermiso();
				recibo();
				factura();
				type("Observaciones prueba", textObservacionesLocator);
				selectDropdownList(listEstatusLocator, "INGRESADO");
				click(buttonGuardarLocator);
				aceptarRegistroPermiso();
			}
				
		
		} else if (optionTablePermisos.equals("eliminar")) {
			
			selectionOptionBusquedaPermisoSucursal();	
			selectionOptionGestorPermiso(detallePermisos);//Detalle permisoa
			optionsTablePermisos(optionTablePermisos, solicitudIngresos);
			
		}
	}
			
	public void ingresoPagina() {
		log = new Log();
		explicitWait(5, titleLocator);
		if (isDisplayed(titleLocator)) {
			log.logInfo("PermissionRecordPage","Ingreso a " + getText(titleLocator));
		
		} else {
			log.logInfo("PermissionRecordPage","No fue posible ingresar a la pagina");
		}
	}
	
	public void documentoInicioTramite(String folio,String fecha,String ruta) {
		type(folio, textFolioDocumentoInicioTramiteLocator);
		log.logInfo("PermissionRecordPage","documentoInicioTramite -- Captura folio");
		type(fecha, dateFechaLocator);
		log.logInfo("PermissionRecordPage","documentoInicioTramite -- Captura fecha");
		type(ruta, fileDocumentoInicioTramiteLocator);
		log.logInfo("PermissionRecordPage","documentoInicioTramite -- Archivo guardado");
		screenshot.CapturaImagenen();
	}
	
	public void documentoPermiso(String folio,String fecha,String fechaVigencia
								,String tipoDocumento,String rfc,String razonSocial
								,String responsiva,String documento) {
		type("001", textFolioDocumentoPermisoLocator);
		log.logInfo("PermissionRecordPage","documentoPermiso -- Captura folio");
		type("21-09-2020", dateFechaDocumentoPermisoLocator);
		log.logInfo("PermissionRecordPage","documentoPermiso -- Captura fecha");
		type("28-09-2020", dateFechaVigenciaDocumentoPermisoLocator);
		log.logInfo("PermissionRecordPage","documentoPermiso -- Captura fechaVigencia");
		selectDropdownList(selectionTipoDocumentoDocumentoPermisoLocator, "ORIGINAL");
		log.logInfo("PermissionRecordPage","documentoPermiso -- Captura tipo documento");
		type("MUCP880820N58", textRFCLocator);
		log.logInfo("PermissionRecordPage","documentoPermiso -- Captura rfc");
		type("Razon Social Prueba", textRazonSocialLocator);
		log.logInfo("PermissionRecordPage","documentoPermiso -- Captura razon social");
		type("Responsiva", textResponsivaLocator);
		log.logInfo("PermissionRecordPage","documentoPermiso -- Captura responsiva");
		type("C:\\Users\\sispmunoz\\Desktop\\DocumentoPermiso.pdf", fileDocumentoPermisoLocator);
		log.logInfo("PermissionRecordPage","documentoPermiso -- Captura documento");
		screenshot.CapturaImagenen();
	}
	
	public void recibo() {
		click(checkboxRecibo);
		type("R001", textFolioReciboLocator);
		selectDropdownList(listTipoDocumentoReciboLocator, "ORIGINAL");
		type("1000", textImporteReciboLocator);
		type("21-09-2020", dateFechaReciboLocator);
		selectDropdownList(listMetodoPagoReciboLocator, "ORIGINAL");
		type("C:\\Users\\sispmunoz\\Desktop\\DocumentoPermiso.pdf", fileReciboLocator);		
	}
	
	public void factura() {
		click(checkboxFactura);
		type("F001", textFolioFacturaLocator);
		selectDropdownList(listTipoDocumentoFacturaLocator, "ORIGINAL");
		type("1000", textImporteFacturaLocator);
		type("21-09-2020", dateFechaFacturaLocator);
		selectDropdownList(listMetodoPagoFacturaLocator, "ORIGINAL");
		type("C:\\Users\\sispmunoz\\Desktop\\DocumentoPermiso.pdf", fileFacturaLocator);
	}
	


	public void aceptarRegistroPermiso() {
		explicitWait(5, messageGuardarPermisoLocator);
		if (getText(messageGuardarPermisoLocator).equals("El permiso se ha registrado correctamente.")) {
															
			click(buttonAceptarLocator);	
			System.out.println("The permission has been saved successfully");	
		
		} else {
			
			System.out.println("The permission has not been saved correctly");	
		
		}
	}
}