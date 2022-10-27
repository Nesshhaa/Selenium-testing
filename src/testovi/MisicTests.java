package testovi;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses({ RegistracijaTest.class, PrijavaTest.class, PodaciPrijavljenogKorisnikaTest.class, DodavanjeUKorpuTest.class,
	IznosKorpeTest.class, ONamaTest.class, PerformanseTest.class, PretragaTest.class, ListaZeljaTest.class, DrustveneMrezeTest.class,PoredjenjeProizvodaTest.class})

class MisicTests {

}
