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

class IznosKorpeTest {

	private Logger log = Logger.getLogger(IznosKorpeTest.class.getName());

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
	  public void iznosUKorpi() {
	    driver.get("http://www.misic.rs/");
	    driver.manage().window().maximize();
	    driver.findElement(By.cssSelector("#menu_category_Menu_KLb6X83A_34 span:nth-child(2)")).click();
	    js.executeScript("window.scrollTo(0,289)");
	    driver.findElement(By.cssSelector(".sort > select")).click();
	    {
	      WebElement dropdown = driver.findElement(By.cssSelector(".sort > select"));
	      dropdown.findElement(By.xpath("//option[. = 'Ceni (Visoka > Niska)']")).click();
	    }
	    js.executeScript("window.scrollTo(0,295)");
	    driver.findElement(By.cssSelector(".clear2:nth-child(1) .tb_button_add_to_cart span")).click();
	    {
	      WebElement element = driver.findElement(By.cssSelector(".clear2:nth-child(1) .tb_button_add_to_cart span"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    driver.findElement(By.cssSelector("div:nth-child(2) > .product-thumb .tb_button_add_to_cart span")).click();
	    {
	      WebElement element = driver.findElement(By.cssSelector("div:nth-child(2) > .product-thumb .tb_button_add_to_cart span"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    driver.findElement(By.cssSelector(".clear2:nth-child(3) .tb_button_add_to_cart span")).click();
	    {
	      WebElement element = driver.findElement(By.cssSelector(".clear2:nth-child(3) .tb_button_add_to_cart span"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    driver.findElement(By.cssSelector(".col-md-12 > #HeaderLogoSystem_TXk8xnRf img")).click();
	    driver.findElement(By.cssSelector(".tb_total > .tb_integer")).click();
	    js.executeScript("window.scrollTo(0,154)");
	    String iznos = driver.findElement(By.cssSelector("#total tr:nth-child(2) > .right:nth-child(2)")).getText();
	   System.out.println(iznos);
	    String ocekivano = "709,970.00";
	    assertEquals(ocekivano, iznos);
	    
	    String sb = "\nIme testa : Provera ukupnog iznosa u korpi \n" + "Opis testa : Test proverava da li je ukupan "
	    		+ "iznos dodatih proizvoda u korpi ispravan \n"
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
