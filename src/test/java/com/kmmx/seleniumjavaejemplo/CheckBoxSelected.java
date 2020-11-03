package com.kmmx.seleniumjavaejemplo;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Model.Alumno;
import junit.framework.Assert;
import seleniumjava.TableReader;
import seleniumjava.TableReaderUtilities;

public class CheckBoxSelected {
	private WebDriver driver;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/googledriver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saes.escasto.ipn.mx");
		driver.findElement(By.cssSelector("input[id*='ctl00_leftColumn_LoginUser_UserName']")).sendKeys("GAAJ861103");				
		driver.findElement(By.cssSelector("input[id*='ctl00_leftColumn_LoginUser_Password']")).sendKeys("JaasieL21+");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		driver.findElement(By.cssSelector("input[id*='ctl00_leftColumn_LoginUser_LoginButton']")).click();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#ctl00_subMenun1>td>table>tbody>tr>td>a")).click();	
		
		
			
	}
	@Test	
	public void testGooglePage() {
		driver.findElement(By.cssSelector("input[id*='ctl00_mainCopy_Txbx_Busqueda']")).sendKeys("2001400264");	
		driver.findElement(By.cssSelector("input[id*='ctl00_mainCopy_Btn_Buscar']")).click();		
		String noBoleta = "2012400005";
		driver.get("https://www.saes.escasto.ipn.mx/Ejecutivo/BUSQUEDA_ALUMNO/BusquedaAlumnoRes.aspx?Boleta="+noBoleta+"&Tipo=Inscrito");		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		driver.switchTo().frame(0);		
		//System.out.println(	driver.getPageSource());	
		TableReaderUtilities readerTBL = new TableReaderUtilities();
		Alumno alumno = readerTBL.getAlumnoNotes(driver.getPageSource());
		alumno.setNoBoleta(noBoleta);

	}
	
}
