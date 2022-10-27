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

class DrustveneMrezeTest {

	private Logger log = Logger.getLogger(DrustveneMrezeTest.class.getName());

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
	  public void drustveneMreze() {
	    driver.get("http://www.misic.rs/");
	    driver.manage().window().setSize(new Dimension(1382, 754));
	    js.executeScript("window.scrollTo(0,1832)");
	    js.executeScript("window.scrollTo(0,2898)");
	    driver.findElement(By.cssSelector(".fa-facebook")).click();
	    assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/misicdoo/?notif_t=page_new_likes&ref=notif");
	   
	  }
	
	 @Test
	  public void drustveneMrezeTwiter() {
	    driver.get("http://www.misic.rs/");
	    driver.manage().window().setSize(new Dimension(1382, 754));
	    js.executeScript("window.scrollTo(0,517)");
	    js.executeScript("window.scrollTo(0,2871)");
	    driver.findElement(By.cssSelector(".fa-twitter")).click();
	    assertEquals(driver.getCurrentUrl(), "https://twitter.com/misic_prodaja");
	    
	    String sb = "\nIme testa : Test drustvenih mreza \n" + "Opis testa : Test proverava pristup profilima drustvenih mreza  \n"
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
