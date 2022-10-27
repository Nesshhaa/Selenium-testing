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

import org.junit.jupiter.api.Test;

class ONamaTest {

	private Logger log = Logger.getLogger(ONamaTest.class.getName());

	private WebDriver driver;
	private JavascriptExecutor js;
	private Map<String, Object> vars;

	@BeforeEach 
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
	  public void oNama() {
	    driver.get("http://www.misic.rs/");
	    driver.manage().window().maximize();
	    js.executeScript("window.scrollTo(0,323)");
	    js.executeScript("window.scrollTo(0,3408)");
	    driver.findElement(By.cssSelector(".tb_menu_page_4 .tb_text")).click();
	    js.executeScript("window.scrollTo(0,288)");
	    String oNama =driver.findElement(By.id("content")).getText();
	    System.out.println(oNama);
	  
	    
	   String sb = "\nIme testa : O nama \n" + "Opis testa : Test uzima deo podataka o kompaniji Overnight \n"
				+ "Test je uspesan \n\n";
		log.info(sb.toString());
		try {

			FileWriter fw = new FileWriter(
					"C:\\Users\\nenad\\Desktop\\ProjekatTSW\\izvestajTestova\\test-report.txt",
					true);
			fw.write(sb.toString());
			fw.write(oNama);
			fw.flush();
			fw.write("\n\n");
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	  }
	
	
	
	
}
