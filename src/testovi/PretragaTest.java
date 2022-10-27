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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


class PretragaTest {

	private Logger log = Logger.getLogger(PretragaTest.class.getName());

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
	
	
	
	@Test
	  public void pretraga() {
	    driver.get("http://www.misic.rs/");
	    driver.manage().window().maximize();
	    {
	      WebElement element = driver.findElement(By.linkText("Telefoni & Tableti"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.findElement(By.id("filter_keyword")).click();
	    driver.findElement(By.id("filter_keyword")).sendKeys("TCX 306");
	    driver.findElement(By.id("search_button")).click();
	    js.executeScript("window.scrollTo(0,295)");
	    driver.findElement(By.linkText("Gorenje TCX 306 ZGNT, Toplotna pumpa")).click();
	    {
	      WebElement element = driver.findElement(By.linkText("Gorenje TCX 306 ZGNT, Toplotna pumpa"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	   String nazivProizvoda =  driver.findElement(By.cssSelector("h1")).getText();
	   assertTrue(nazivProizvoda.contains("TCX 306"));
	   
	   
	   String sb = "\nIme testa : Test pretrage proizvoda \n" + "Opis testa : Test proverava da li funkcionise pretraga proizvoda \n"
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

	
