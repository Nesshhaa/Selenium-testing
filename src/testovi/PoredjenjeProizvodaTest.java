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

class PoredjenjeProizvodaTest {

	private Logger log = Logger.getLogger(PoredjenjeProizvodaTest.class.getName());

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
	public void poredjenjeProizvoda() {
	  driver.get("http://www.misic.rs/");
	  driver.manage().window().setSize(new Dimension(1382, 754));
	  js.executeScript("window.scrollTo(0,316)");
	  driver.findElement(By.cssSelector("#menu_category_Menu_KLb6X83A_34 span:nth-child(2)")).click();
	  js.executeScript("window.scrollTo(0,289)");
	  driver.findElement(By.cssSelector(".sort > select")).click();
	  {
	    WebElement dropdown = driver.findElement(By.cssSelector(".sort > select"));
	    dropdown.findElement(By.xpath("//option[. = 'Ceni (Visoka > Niska)']")).click();
	  }
	  driver.findElement(By.linkText("Gorenje TCX 306 ZGNT, Toplotna pumpa")).click();
	  String proizvod1 = driver.findElement(By.cssSelector("h1")).getText();
	  driver.findElement(By.linkText("Dodaj za poređenje")).click();
	  driver.findElement(By.linkText("Klima uređaji & grejanje")).click();
	  driver.findElement(By.linkText("Gorenje TCX 201 ZGNT, Toplotna pumpa")).click();
	  String proizvod2 = driver.findElement(By.cssSelector("h1")).getText();
	  driver.findElement(By.linkText("Dodaj za poređenje")).click();
	  driver.findElement(By.cssSelector(".ico-mdi-twitter-retweet")).click();
	  js.executeScript("window.scrollTo(0,300)");
	  String proizvod1Lista = driver.findElement(By.cssSelector(".name:nth-child(2)")).getText();
	  String proizvod2Lista = driver.findElement(By.cssSelector(".name:nth-child(3)")).getText();
	  assertEquals(proizvod1, proizvod1Lista);
	  assertEquals(proizvod2, proizvod2Lista);
	  
	  String sb = "\nIme testa : Test uporedjivanja proizvoda \n" + "Opis testa : Test proverava da li funkcionise poredjenje proizvoda \n"
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




