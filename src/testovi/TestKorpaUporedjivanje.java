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

class TestKorpaUporedjivanje {

	private Logger log = Logger.getLogger(TestKorpaUporedjivanje.class.getName());

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
	  public void testKorpa() {
		driver.get("http://www.misic.rs/");
	    driver.manage().window().maximize();
	    js.executeScript("window.scrollTo(0,200)");
	    driver.findElement(By.cssSelector("#menu_category_Menu_KLb6X83A_34 span:nth-child(2)")).click();
	    js.executeScript("window.scrollTo(0,295)");
	    driver.findElement(By.cssSelector(".sort > select")).click();
	    {
	      WebElement dropdown = driver.findElement(By.cssSelector(".sort > select"));
	      dropdown.findElement(By.xpath("//option[. = 'Ceni (Visoka > Niska)']")).click();
	    }
	    js.executeScript("window.scrollTo(0,288)");
	    driver.findElement(By.linkText("Gorenje TCX 306 ZGNT, Toplotna pumpa")).click();
	    js.executeScript("window.scrollTo(0,100)");
	    String proizvod1 = driver.findElement(By.cssSelector("h1")).getText();
	    driver.findElement(By.id("button-cart")).click();
	    driver.findElement(By.linkText("Klima uređaji & grejanje")).click();
	    js.executeScript("window.scrollTo(0,288)");
	    driver.findElement(By.linkText("Gorenje TCX 201 ZGNT, Toplotna pumpa")).click();
	    String proizvod2 =driver.findElement(By.cssSelector("h1")).getText();
	    driver.findElement(By.id("button-cart")).click();
	    driver.findElement(By.linkText("Klima uređaji & grejanje")).click();
	    js.executeScript("window.scrollTo(0,289)");
	    driver.findElement(By.linkText("Gorenje TC 301 ZGNT, Toplotna pumpa")).click();
	    String proizvod3 =driver.findElement(By.cssSelector("h1")).getText();
	    driver.findElement(By.id("button-cart")).click();
	    driver.findElement(By.cssSelector(".tb_total > .tb_integer")).click();
	    String proizvod1Korpa = driver.findElement(By.cssSelector("tbody:nth-child(2) > tr:nth-child(1) > .name")).getText();
	    String proizvod2Korpa = driver.findElement(By.cssSelector("tbody:nth-child(2) > tr:nth-child(2) > .name")).getText();
	    String proizvod3Korpa = driver.findElement(By.cssSelector("tbody:nth-child(2) > tr:nth-child(3) > .name")).getText();
	    js.executeScript("window.scrollTo(0,295)");
	    assertEquals(proizvod1, proizvod1Korpa);
	    assertEquals(proizvod2, proizvod2Korpa);
	    assertEquals(proizvod3, proizvod3Korpa);
	  }
}
