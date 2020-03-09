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


    /**
     * Method: getNombreAnneeAnciennete()
     */

    //Employé dateDembauche avec date 2ans avant aujourdhui=>
    //2 années d'anvinennété
    @Test
    @DisplayName("Test Get Nombre Annee Anciennete Nmoins2")
    public void testGetNombreAnneeAncienneteNMoins2() throws Exception {
        // TODO: Test goes here...

        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now().minusYears(2));

        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(2);

    }

   /* @Test
    @DisplayName("Test Get Nombre Annee Anciennete Nplus2")
    public void testGetNombreAnneeAncienneteNPlus2() throws Exception {
        //DAte dans le futur

        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now().plusYears(2));

        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(-2);
    }*/

    //DATE D'aujourdhui => 0
    @Test
    @DisplayName("Test Get Nombre Annee Anciennete Date actuelle")
    public void testGetNombreAnneeAncienneteN0() throws Exception {
        //DAte d'aujourd'hui'

        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now());

        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(0);
    }


    //DATE D'aujourdhui => indéfinie =>0
   /* @Test
    @DisplayName("Test Get Nombre Annee Anciennete null")
    public void testGetNombreAnneeAncienneteNull() throws Exception {
        //DAte d'embauche indéfinie'

        //Given
        public Integer getNombreAnneeAnciennete() {
            if (dateEmbauche != null && dateEmbauche.isBefore(LocalDate.now())) {
                return LocalDate.now().getYear() - dateEmbauche.getyear();
            }
        }
        Employe employe = new Employe();
        employe.setDateEmbauche(null);

        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnees).isNull();

    }*/

    /**
     * Method: getNbConges()
     */
    @Test
    @DisplayName("Test Get Nb Conges")
    public void testGetNbConges() throws Exception {
        // TODO: Test goes here...
    }

    /**
     * Method: getNbRtt()
     */
    @Test
    @DisplayName("Test Get Nb Rtt")
    public void testGetNbRtt() throws Exception {
        // TODO: Test goes here...
    }

    /**
     * Method: getNbRtt(LocalDate d)
     */
    @Test
    @DisplayName("Test Get Nb Rtt D")
    public void testGetNbRttD() throws Exception {
        // TODO: Test goes here...
    }

    /**
     * Method: getPrimeAnnuelle()
     */

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
