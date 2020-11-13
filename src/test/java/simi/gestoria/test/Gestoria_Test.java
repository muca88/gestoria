package simi.gestoria.test;

import org.testng.annotations.Test;

import simi.gestoria.base.Base;
import simi.gestoria.page.ApplicationRecordPage;
import simi.gestoria.page.AssignManagerStatusPage;
import simi.gestoria.page.PermissionHistoryPage;
import simi.gestoria.page.PermissionRecordPage;
import simi.gestoria.page.PermissionSearchPage;
import simi.gestoria.page.RegisterPage;
import simi.gestoria.resources.DataSheet;
import simi.gestoria.resources.ScreenRecorderUtil;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Gestoria_Test {
	
	protected WebDriver driver;
	Base base;
	DataSheet dataSheet; 
	ScreenRecorderUtil screenRecorderUtil;
	RegisterPage registerPage;
	ApplicationRecordPage applicationRecord;
	AssignManagerStatusPage assignManagerStatus;
	PermissionRecordPage permissionRecordPage;
	PermissionSearchPage permissionSearchPage;
	AssignManagerStatusPage assignManagerStatusPage;
	PermissionHistoryPage permissionHistoryPage;
	
  @BeforeClass
  public void setup() {
	 base = new Base(driver);
	 driver = base.chromeDriverConnection();
	 driver.manage().window().maximize();
	 base.visit("http://simimx-appqa01:8081/Gestoria/");
  }
  
  
  @Test
  public void Gestoria() throws Exception {
	  dataSheet = new DataSheet();
	  //ScreenRecorderUtil.startRecord("Gestoria");
	  //Ingresar usuario y contraseña
	  registerPage = new RegisterPage(driver);
	  registerPage.registerUser(dataSheet.getCellValue(1, 1),dataSheet.getCellValue(2, 1));
	  //Registrar unidad de negocio
	  applicationRecord = new ApplicationRecordPage(driver);
	  applicationRecord.selectionOptionRegistroSolicitud();
	  applicationRecord.applicationRecord(dataSheet.getCellValue(4, 1));
	  //Permisos por sucursal
	  permissionSearchPage = new PermissionSearchPage(driver);
	  permissionSearchPage.selectionOptionBusquedaPermisoSucursal();
	  //Gestor Estatus
	  //(9,1) gestorEstatus
	  permissionSearchPage.selectionOptionGestorPermiso(dataSheet.getCellValue(9, 1));
	  assignManagerStatusPage = new AssignManagerStatusPage(driver);
	  //(14,1) Regresar -- (16,1) Gestor -- (17,1) Estatus
	  assignManagerStatusPage.assignManagerStatus(dataSheet.getCellValue(14, 1), dataSheet.getCellValue(16, 1), dataSheet.getCellValue(17, 1));
	  //Permiso
	  //(10,1) permiso
	  permissionSearchPage.selectionOptionGestorPermiso(dataSheet.getCellValue(10, 1));
	  permissionRecordPage = new PermissionRecordPage(driver);
	  permissionRecordPage.addPermission();
	  //Detalle Permisos
	  //(11,1) detallePermisos
	  permissionSearchPage.selectionOptionGestorPermiso(dataSheet.getCellValue(11, 1));
	  //Opciones de Permiso
	  //Detalle
	  //(55,1) Detalle -- (56,1) Editar -- (57,1) Eliminar
	  //(19,1) Permiso
	  permissionRecordPage.optionsPerrmission(dataSheet.getCellValue(55, 1), dataSheet.getCellValue(19, 1));
	  //Editar
	  permissionRecordPage.optionsPerrmission(dataSheet.getCellValue(56, 1), dataSheet.getCellValue(19, 1));
	  //Eliminar
	  //permissionSearchPage.selectionOptionGestorPermiso(dataSheet.getCellValue(11, 1));
	  //permissionRecordPage.optionsPerrmission(dataSheet.getCellValue(57, 1), dataSheet.getCellValue(19, 1));
	  //ScreenRecorderUtil.stopRecord();
	  //Historial de Permisos
	  permissionHistoryPage = new PermissionHistoryPage(driver);
	  permissionHistoryPage.selectionOptionBusquedaPermisoSucursal();
	  permissionHistoryPage.permissionHistory();
  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
