package com.escom;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.escom.dao.IMateriaDAO;
import com.escom.entities.Alumno;
import com.escom.entities.Materia;
import com.escom.entities.TableReaderUtilities;

@SpringBootApplication
public class ChidoApplication {

	@Autowired
	private IMateriaDAO repo;
	
	
	public static void main(String[] args) {				
		SpringApplication.run(ChidoApplication.class, args);
										
	}
	@PostConstruct
	public void init() {
		
		WebDriver driver;
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
		driver.findElement(By.cssSelector("input[id*='ctl00_mainCopy_Txbx_Busqueda']")).sendKeys("2001400264");	
		driver.findElement(By.cssSelector("input[id*='ctl00_mainCopy_Btn_Buscar']")).click();		
			
		//for(int i=1; i<=10;i++) {
			String noBoleta = "2012400005";
			//if(i>=1&&i<10)noBoleta=noBoleta+"000";
			//if(i>=10&&i<100)noBoleta=noBoleta+"00";
			//if(i>=100)noBoleta=noBoleta+"0";
			//noBoleta=noBoleta+i;			
			driver.get("https://www.saes.escasto.ipn.mx/Ejecutivo/BUSQUEDA_ALUMNO/BusquedaAlumnoRes.aspx?Boleta="+noBoleta+"&Tipo=Inscrito");		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			driver.switchTo().frame(0);		
			//System.out.println(	driver.getPageSource());	
			TableReaderUtilities readerTBL = new TableReaderUtilities();
			Alumno alumno = readerTBL.getAlumnoNotes(driver.getPageSource());
			alumno.setNoBoleta(noBoleta);
					
			/*for(Materia a:alumno.getPrimerSemestre()) {
				System.out.println(a.getClave()+ " "+ a.getCalificacion());
				a.setBoleta(noBoleta);			
				repo.save(a);
			}
			for(Materia a:alumno.getSegundoSemestre()) {
				System.out.println(a.getClave()+ " "+ a.getCalificacion());
				a.setBoleta(noBoleta);			
				repo.save(a);
			}
			for(Materia a:alumno.getTercerSemestre()) {
				System.out.println(a.getClave()+ " "+ a.getCalificacion());
				a.setBoleta(noBoleta);			
				repo.save(a);
			}
			for(Materia a:alumno.getCuartoSemestre()) {
				System.out.println(a.getClave()+ " "+ a.getCalificacion());
				a.setBoleta(noBoleta);			
				repo.save(a);
			}
			for(Materia a:alumno.getQuintoSemestre()) {
				System.out.println(a.getClave()+ " "+ a.getCalificacion());
				a.setBoleta(noBoleta);			
				repo.save(a);
			}*/
		//}
		
	}

}
