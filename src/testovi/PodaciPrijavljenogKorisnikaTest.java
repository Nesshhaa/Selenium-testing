package testovi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

class PodaciPrijavljenogKorisnikaTest {

	

	private Logger log = Logger.getLogger(PodaciPrijavljenogKorisnikaTest.class.getName());

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
	
	
	@Test
	  public void proveraPodatakaKorisnika() {
	    driver.get("http://www.misic.rs/");
	    driver.manage().window().maximize();
	    driver.findElement(By.linkText("prijaviti")).click();
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).sendKeys("jankovicnenad617@gmail.com");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).sendKeys("adminadmin123");
	    driver.findElement(By.cssSelector(".right:nth-child(2) > .button")).click();
	    driver.findElement(By.linkText("Izmeni lične podatke")).click();
	    js.executeScript("window.scrollTo(0,141)");
	    String ime = driver.findElement(By.name("firstname")).getAttribute("value");
	    js.executeScript("window.scrollTo(0,350)");
	    String prezime =driver.findElement(By.name("lastname")).getAttribute("value");
	    String email = driver.findElement(By.name("email")).getAttribute("value");
	    String telefon = driver.findElement(By.name("telephone")).getAttribute("value");
	    assertEquals("Nenad", ime);
	    assertEquals("Jankovic", prezime);
	    assertEquals("jankovicnenad617@gmail.com", email);
	    assertEquals("064123456", telefon);
	    System.out.println(ime);
	    System.out.println(prezime);
	    System.out.println(email);
	    System.out.println(telefon);
	    
	    
	    String sb = "\nIme testa : Provera podataka prijavljenog korsinika \n" + "Opis testa : Test proverava indentičnost podataka prijavljenog korisnika \n"
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

	
