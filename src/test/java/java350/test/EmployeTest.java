package java350.test;
import com.ipiecoles.java.java350.model.Employe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

/**
 * Employe Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>mars 9, 2020</pre>
 */

@DisplayName("Employe Test")
public class EmployeTest {


  

    
//Use case : matricule manager,
// et p = Entreprise.primeAnnuelleBase() * Entreprise.INDICE_PRIME_MANAGER + primeAnciennete;
    @ParameterizedTest
    @CsvSource({"1,'T123456',0,1.0,1000.0"})
    @DisplayName("Test Get Prime Annuelle")
    public void testGetPrimeAnnuelle(Integer performance,
                                     String matricule,
                                     Integer nbAnneesAnciennete,
                                     Double tempsPartiel,
                                     Double prime
                                      ) {

        // Given
        Employe e = new Employe();
        e.setMatricule(matricule);
        e.setDateEmbauche(LocalDate.now().minusYears(nbAnneesAnciennete));
        e.setPerformance(performance);
        e.setTempsPartiel(tempsPartiel);

        //When

        Double result = e.getPrimeAnnuelle();

        //Then

        Assertions.assertThat(result).isEqualTo(prime);

    }

}
