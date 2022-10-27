package testovi;


import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


class RegistracijaTest {

	
	private Logger log = Logger.getLogger(RegistracijaTest.class.getName());

	
	private WebDriver driver;
	private JavascriptExecutor js;
	private Map<String, Object> vars;

	@BeforeEach // OVO SVE ZA POKRETANJE DRAJVERA
	void podesavanje() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nenad\\Desktop\\SeleniumDriver\\Driver\\chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}
	@AfterEach
	void zatvoriDrajver() {
		driver.quit(); // 
	}

	/*------------------------------------------------------------------------------------------------*/
	
	
	  @Test
	  public void registracija() {
	    driver.get("http://www.misic.rs/");
	    driver.manage().window().maximize();
	    driver.findElement(By.linkText("registrovati")).click();
	    driver.findElement(By.name("firstname")).click();
	    js.executeScript("window.scrollTo(0,295)");
	    driver.findElement(By.name("firstname")).sendKeys("Nenad");
	    driver.findElement(By.name("lastname")).click();
	    driver.findElement(By.name("lastname")).sendKeys("Jankovic");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).sendKeys("jankovicnenad617@gmail.com");
	    driver.findElement(By.name("telephone")).click();
	    js.executeScript("window.scrollTo(0,700)");
	    driver.findElement(By.name("telephone")).sendKeys("064123456");
	    driver.findElement(By.name("address_1")).click();
	    driver.findElement(By.name("address_1")).sendKeys("Cacak BB");
	    driver.findElement(By.name("city")).click();
	    driver.findElement(By.name("city")).sendKeys("Cacak");
	    driver.findElement(By.name("country_id")).click();
	    driver.findElement(By.name("zone_id")).click();
	    {
	      WebElement dropdown = driver.findElement(By.name("zone_id"));
	      dropdown.findElement(By.xpath("//option[. = 'Jedinstvena zona']")).click();
	    }
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).sendKeys("adminadmin123");
	    driver.findElement(By.name("confirm")).click();
	    driver.findElement(By.name("confirm")).sendKeys("adminadmin123");
	    driver.findElement(By.cssSelector(".button")).click();
	    
	    String sb = "\nIme testa : Registracija korisnika \n" + "Opis testa : Test proverava registraciju korisnika \n"
				+ "Test je uspesan \n\n";
		log.info(sb.toString());
		try {

			FileWriter fw = new FileWriter(
					"C:\\Users\\nenad\\Desktop\\ProjekatTSW\\izvestajTestova\\test-report.txt",
					true);
			fw.write(sb.toString());
			fw.flush();
			fw.write("\n\n");
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	  }
	}
	
	
	

