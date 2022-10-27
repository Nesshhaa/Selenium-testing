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

class ListaZeljaTest {

	private Logger log = Logger.getLogger(ListaZeljaTest.class.getName());

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
	  public void omiljeniProizvodi() {
	    driver.get("http://www.misic.rs/");
	    driver.manage().window().setSize(new Dimension(1382, 754));
	    driver.findElement(By.linkText("prijaviti")).click();
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).sendKeys("jankovicnenad617@gmail.com");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).sendKeys("adminadmin123");
	    driver.findElement(By.cssSelector(".right:nth-child(2) > .button")).click();
	    driver.findElement(By.cssSelector("#site_logo > img")).click();
	    driver.findElement(By.cssSelector("#menu_category_Menu_KLb6X83A_34 span:nth-child(2)")).click();
	    js.executeScript("window.scrollTo(0,290)");
	    driver.findElement(By.cssSelector(".sort > select")).click();
	    {
	      WebElement dropdown = driver.findElement(By.cssSelector(".sort > select"));
	      dropdown.findElement(By.xpath("//option[. = 'Ceni (Visoka > Niska)']")).click();
	    }
	    js.executeScript("window.scrollTo(0,306)");
	    driver.findElement(By.linkText("Gorenje TCX 306 ZGNT, Toplotna pumpa")).click();
	    //kupljenje imena proizvoda pre ubacivanja u listu zelja
	    String naziv = driver.findElement(By.cssSelector("h1")).getText();
	    driver.findElement(By.linkText("Dodaj u listu želja")).click();
	    js.executeScript("window.scrollTo(0,339)");
	    js.executeScript("window.scrollTo(0,1588)");
	    WebDriverWait wait = new WebDriverWait(driver,10);
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Menu_PkrgIeyB\"]/nav/ul/li[3]")));
	    driver.findElement(By.xpath("//*[@id=\"Menu_PkrgIeyB\"]/nav/ul/li[3]")).click();
	    //kupljenje naziva proizvoda u listi zelja
	    String nazivUListi = driver.findElement(By.cssSelector("#wishlist-row1226 .name")).getText();
	    //uporedjivanje
	    assertEquals(naziv, nazivUListi);
	    
	    String sb = "\nIme testa : Test liste zelja \n" + "Opis testa : Test proverava da li funkcionise dodavanje proizvoda u listu zelja \n"
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
