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


class PerformanseTest {

	private Logger log = Logger.getLogger(PerformanseTest.class.getName());

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
	public void BrzinaOtvaranja5stranica() throws InterruptedException {

		double p = System.currentTimeMillis();

		driver.get("http://www.misic.rs/");
		double k = System.currentTimeMillis();
		double res = k - p;
		String ispis1 = "Pocetna stranica: "+res;
		System.out.println(ispis1);
		/* ===================================================== */

		double p2 = System.currentTimeMillis();

		driver.get("http://www.misic.rs/information/contact");
		double k2 = System.currentTimeMillis();
		double res2 = k2 - p2;
		String ispis2 = "Kontakt stranica: "+res2;
		System.out.println(ispis2);
		/* ===================================================== */

		double p3 = System.currentTimeMillis();

		driver.get("http://www.misic.rs/klima-uredjaji-i-grejanje");
		double k3 = System.currentTimeMillis();
		double res3 = k3 - p3;
		String ispis3 = "Stranica za klima uredjaje i grejanje: "+res3;
		System.out.println(ispis3);
		/* ===================================================== */

		double p4 = System.currentTimeMillis();

		driver.get("http://www.misic.rs/nacin-isporuke");
		double k4 = System.currentTimeMillis();
		double res4 = k4 - p4;
		String ispis4 = "Stranica za nacin isporuke: "+res4;
		System.out.println(ispis4);
		/* ===================================================== */

		double p5 = System.currentTimeMillis();

		driver.get("http://www.misic.rs/bela-tehnika/ugradna-tehnika");
		double k5 = System.currentTimeMillis();
		double res5 = k5 - p5;
		String ispis5 = "Stranica za ugradnu tehniku: "+res5;
		System.out.println(ispis5);
		/* ===================================================== */

		double srednjaVR = (res + res2 + res3 + res4 + res5) / 5;
		String ukupanIspis = "Srednja vrednost: " + srednjaVR;
		System.out.println(ukupanIspis);
		/* ===================================================== */

		String sb = "\nIme testa : Performasne otvaranja \n"
				+ "Opis testa : Performanse otvaranja 5 razlicitih stranica \n" + "Test je uspesan \n\n";
		log.info(sb.toString());
		try {

			FileWriter fw = new FileWriter(
					"C:\\Users\\nenad\\Desktop\\ProjekatTSW\\izvestajTestova\\test-report.txt",
					true);
			fw.write(sb.toString());
			fw.write("\nIzvestaj o performansama stranica.\n");
			fw.write(ispis1+"\n");
			fw.write(ispis2+"\n");
			fw.write(ispis3+"\n");
			fw.write(ispis4+"\n");
			fw.write(ispis5+"\n");
			fw.write("\n--------------------------------------------------------------\n");
			fw.write(ukupanIspis+"\n");
			fw.flush();
			fw.write("\n\n");
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	
	}
	
	
	

