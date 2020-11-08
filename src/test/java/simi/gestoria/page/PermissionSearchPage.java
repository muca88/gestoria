package simi.gestoria.page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import simi.gestoria.base.Base;
import simi.gestoria.resources.DataSheet;
import simi.gestoria.resources.Log;
import simi.gestoria.resources.Screenshot;

public class PermissionSearchPage extends Base {
	
	public PermissionSearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By optionPermissionsRequestLocator = By.cssSelector("a[href='/Gestoria/Home/BusquedaPermiso']");
	By rowsLocator = By.xpath("//table[@id='dtSolicitudes']/tbody/tr");
	
	By listLocator = By.xpath("//tr[@class='child']/td/ul/li");
	By tablaPermisos = By.id("tblPermisos");
	By rowsPermisosLocator = By.xpath("//table[@id='tblPermisos']/tbody/tr");
	By solicitudIngresosLocator = By.xpath("//table[@id='tblPermisos']/tbody/tr/td[2]");
	By pagesPermisosLocator = By.xpath("//div[@id='tblPermisos_paginate']/ul/li[@class='paginate_button active']");
	By buttonNextLocator = By.xpath("//div[@id='tblPermisos_paginate']/ul/li[@id='tblPermisos_next']/a");
	By buttonCerrarLocator = By.xpath("//button[@class='btn btn-secondary']");
	By inicioTramiteLocator = By.xpath("//div[@class='modal-content']/div[2]/div[1]/div[2]/i");
	By permisoLocator = By.xpath("//div[@class='modal-content']/div[2]/div[2]/div[2]/i");
	By reciboLocator = By.xpath("//div[@class='modal-content']/div[2]/div[3]/div[2]/i");
	By facturaLocator = By.xpath("//div[@class='modal-content']/div[2]/div[4]/div[2]/i");
	By numberPageLocator = By.xpath("//div[@id='dtSolicitudes_paginate']/ul/li");
	By buttonNextSolicitudesLocator = By.xpath("//li[@id='dtSolicitudes_next']/a");
	
	int list;
	String seleccionar;
	String solicitudIngresosPath;
	String buttonDetallePath;
	String buttonEliminarPath;
	
	Screenshot screenshot =  new Screenshot(driver);
	
	public void selectionOptionBusquedaPermisoSucursal() {
		log = new Log();
		click(optionPermissionsRequestLocator);
		log.logInfo("PermissionSearchPage", "Opcion permisos por sucursal");
	}
	
	public void selectionOptionGestorPermiso(String optionTable) throws Exception  {
		log = new Log();
		boolean exit = false;
		explicitWait(5, rowsLocator);
		int pages = numberItems(numberPageLocator);
		pages = pages -2;
		for (int p = 1; p <= pages; p++) {
			for (int i = 1; i <= findElements(rowsLocator).size(); i++) {
				By claveSapLocator = By.xpath("//table[@id='dtSolicitudes']/tbody/tr[" + i + "]/td[3]");
				By tipoSolicitudLocator = By.xpath("//table[@id='dtSolicitudes']/tbody/tr[" + i + "]/td[4]");
				By nombreLocator = By.xpath("//table[@id='dtSolicitudes']/tbody/tr[" + i + "]/td[5]");
			
				if (getText(claveSapLocator).equals(dataSheet.getCellValue(4, 1))
						&&getText(tipoSolicitudLocator).equals(dataSheet.getCellValue(7, 1))
						&&getText(nombreLocator).equals(dataSheet.getCellValue(6, 1))) {
						log.logInfo("PermissionSearchPage", "-- La solicitud se encontro en la pagina " + p + " fila " + i);	
						optionsTable(optionTable,i);
						
						exit = true;
						break;	
			
				}else {	
				log.logInfo("PermissionSearchPage", "La solicitud no se encontro en la pagina " + p);
				}
			}
			
			if (exit==true) {	
				break;
			
			}else if (p < pages) {
				click(buttonNextSolicitudesLocator);
			
			}else if (p == pages) {
				log.logInfo("PermissionSearchPage", "La solicitud no se encuentro en las paginas existentes");
			} 
				
		}
	}
		 
	public void optionsTable(String option,int i) {
		By plusSymbolLocator = By.xpath("//table[@id='dtSolicitudes']/tbody/tr[" + i + "]/td[1]");
		
		if (option.equals("gestorEstatus")) {
			click(plusSymbolLocator);
			explicitWait(5, listLocator);
			list = findElements(listLocator).size()-1;
			i +=1;
			seleccionar = "//table[@id='dtSolicitudes']/tbody/tr[" + i + "]/td/ul/li[" + list + "]/span[2]";
			By optionTable = By.xpath(seleccionar);
			click(optionTable);
			log.logInfo("PermissionSearchPage", "Opcion gestor estatus");
			screenshot.CapturaImagenen();
		
		} else if (option.equals("permiso")) {
			click(plusSymbolLocator);
			explicitWait(5, listLocator);
			list = findElements(listLocator).size();
			i +=1;
			seleccionar = "//table[@id='dtSolicitudes']/tbody/tr[" + i + "]/td/ul/li[" + list + "]/span[2]";
			By optionTable = By.xpath(seleccionar);
			click(optionTable);
			log.logInfo("PermissionSearchPage", "Opcion permiso");
			screenshot.CapturaImagenen();
		
		} else if (option.equals("detallePermisos")) {
			seleccionar = "//table[@id='dtSolicitudes']/tbody/tr[" + i + "]/td[2]";
			By optionTable = By.xpath(seleccionar);
			click(optionTable);
			log.logInfo("PermissionSearchPage", "Opcion detalle de permiso");
			screenshot.CapturaImagenen();
		}
	}
	
	public void optionsTablePermisos(String optionTablePermisos,String solicitudIngresos) {
		boolean exit = false;
		explicitWait(5, pagesPermisosLocator);
		for (int p = 0; p <= findElements(rowsPermisosLocator).size(); p++) {
			
			explicitWait(5, rowsPermisosLocator);
			for (int r = 1; r <= findElements(rowsPermisosLocator).size(); r++) {
				solicitudIngresosPath = "//table[@id='tblPermisos']/tbody/tr[" + r + "]/td[2]";
				By solicitudIngresosLocator = By.xpath(solicitudIngresosPath);
		
				if (getText(solicitudIngresosLocator).equals(solicitudIngresos)) {
					optionTablePermisos(optionTablePermisos,r);
					exit = true;
					break;
				
				}else {
					System.out.println("No se encontro el permiso");
				}
			}
			
			if (exit==true) {	
				break;
			
			}else {
				/*
				 * páginas = 10
				 * p=10
				 * 
				 * si páginas==p
				 * */
				click(buttonNextLocator);
			}
		}
	}
	
	public String optionTablePermisos(String optionTablePermisos,int r) {
		String documento="";
		if (optionTablePermisos.equals("detalle")) {
			
			buttonDetallePath = "//table[@id='tblPermisos']/tbody/tr[ " + r + "]/td[6]/input";
			By buttonDetalleLocator = By.xpath(buttonDetallePath);
			click(buttonDetalleLocator);
			explicitWait(5, buttonCerrarLocator);
	
			
		}else if (optionTablePermisos.equals("editar")) {
			//click(buttonEditarLocator);
		
		}else if (optionTablePermisos.equals("eliminar")) {
			
			buttonEliminarPath = "//table[@id='tblPermisos']/tbody/tr[ " + r + "]/td[8]/a";
			By buttonEliminarLocator = By.xpath(buttonEliminarPath);
			click(buttonEliminarLocator);
		
		
		}
	return 	documento;
	}
}
