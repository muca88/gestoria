package simi.gestoria.resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import simi.gestoria.base.Base;
import simi.gestoria.test.Gestoria_Test;


public class Screenshot extends Base{
	
	public Screenshot(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String NombreCarpeta() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		//yyyyMMdd_hhmmss
		String nombreCarpeta = formatter.format(date);
		return nombreCarpeta; 
	}
	
	public void CapturaImagenen() { 
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/"+ NombreCarpeta() +"/"+ NombreArchivo() + ".png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Excepción " + e.getMessage());
		}
	}
	
	public String NombreArchivo() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("hhmmssSSS");
		String NArchivo = formatter.format(date);
		return NArchivo;
	}
}
