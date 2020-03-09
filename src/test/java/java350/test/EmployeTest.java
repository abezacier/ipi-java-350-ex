package java350.test;
import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.ipiecoles.java.java350.model.Employe;

public class EmployeTest {
	
	// Employé dateEmbauche avec date 2 ans avant aujourd'hui=>
	// 2 années d'ancienneté
	
	@Test
	public void testAnciennetéDateEmbaucheNmoins2 () {
		//given
		
		Employe employe = new Employe ();
		employe.setDateEmbauche(LocalDate.now().minusYears(2));
		
		
		//when
		
		Integer nbAnnees = employe.getNombreAnneeAnciennete();
		
		//then
		
		Assertions.assertThat(nbAnnees).isEqualTo(2);
	}
	
	@Test
	public void testAncienneteDateEmbaucheNplus2() {
		
		Employe employe = new Employe ();
		employe.setDateEmbauche(LocalDate.now().plusYears(2));
		
		Integer nbAnnees = employe.getNombreAnneeAnciennete();
		
		Assertions.assertThat(nbAnnees).isEqualTo(0);
	}
	
	// date aujourd'hui => 0
	@Test
	public void testAncienneteDateEmbaucheToday() {
		
		// given
		Employe employe = new Employe ();
		employe.setDateEmbauche(LocalDate.now());
		
		
		//when
		Integer nbAnnees = employe.getNombreAnneeAnciennete();
		
		// then 
		
		Assertions.assertThat(nbAnnees).isEqualTo(0);
		
		
	}
	
	//Date embauche indéfinie => 0
	@Test
	public void testAncienneteDateEmbaucheUndifined() {
	
		//given
		
		
		/*public Integer getNombreAnneeAnciennete() {
			if(dateEmbauche != null && dateEmbauche.isbefore(LocalDate.now())) {
				return LocalDate.now().getYear()- dateEmbauche.getYear();
			}
			return 0;
		}
		*/
		
	Employe employe = new Employe ();
	employe.setDateEmbauche(null);
	
	//when
	
	Integer nbAnnees = employe.getNombreAnneeAnciennete();
	
	//then
	
	Assertions.assertThat(nbAnnees).isEqualTo(0);
	
	}
	
	//matricule
	//dateEmbauche
	//performance
	//tempsPartiel
	//Prime
	
	@ParameterizedTest()
	@CsvSource({
		
		" 1,'T12345',0,1.0,1000.0",
		" 1,'T12345',0,0.5,500.0",
		" 1,'M12345',0,1.0,1700.0",
		"2,T12345',0,1.0,2300.0",
		
	})
	
	public void testPrimeAnnuelle(Integer performance, String matricule, Integer nbAnneesAnciennete, Double tempsPartiel, Double prime ) {
		// given, when, then
		
		//given
		Employe employe = new Employe();
		employe.setMatricule(matricule);
		employe.setDateEmbauche(LocalDate.now().minusYears(nbAnneesAnciennete));
		employe.setTempsPartiel(tempsPartiel);
		employe.setPerformance(performance);
		
		//when
		Double primeCalculee = employe.getPrimeAnnuelle();
		
		//then
		Assertions.assertThat(primeCalculee).isEqualTo(prime);
		
		
		
	}
}
