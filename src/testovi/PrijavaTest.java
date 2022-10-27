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


class PrijavaTest {

	
	private Logger log = Logger.getLogger(PrijavaTest.class.getName());

	
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
	  public void prijava() {
	    driver.get("http://www.misic.rs/");
	    driver.manage().window().maximize();
	    {
	      WebElement element = driver.findElement(By.cssSelector("#menu_category_Menu_KLb6X83A_25 > a > .tb_text"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.findElement(By.linkText("prijaviti")).click();
	    js.executeScript("window.scrollTo(0,295)");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).sendKeys("jankovicnenad617@gmail.com");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).sendKeys("adminadmin123");
	    driver.findElement(By.cssSelector(".right:nth-child(2) > .button")).click();
	    
	    String sb = "\nIme testa : Prijava korisnika \n" + "Opis testa : Test proverava prijavu korisnika na sajt \n"
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
	
	
	

