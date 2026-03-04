package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import healthcalc.exceptions.InvalidHealthDataException;

@DisplayName("Tests para la métrica WC (Waist Circumference)")
public class WCTest {

    private HealthCalc healthCalc;

    @BeforeEach
    void setUp() {
        healthCalc = new HealthCalcImpl();
    }

    @Nested
    @DisplayName("Validación de seguridad y límites")
    class WCSafetyTests {

        @ParameterizedTest(name = "Perímetro inválido: {0} cm")
        @ValueSource(floats = {29f, 0f, -10f, 251f})
        @DisplayName("Bloqueo de perímetros fuera de rango biológico (30-250cm)")
        void testPerimetroInvalido(float wc) {
            // Arrange & Act & Assert (Patrón AAA en una línea para excepciones)
            assertThrows(InvalidHealthDataException.class, () -> healthCalc.wcClassification(wc, 'm'));
        }
    }

    @Nested
    @DisplayName("Clasificación de Riesgo Cardiovascular")
    class WCClassificationTests {

        @ParameterizedTest(name = "Hombre con {0}cm debe ser {1}")
        @CsvSource({
            "93.9, Riesgo Bajo",
            "94.0, Riesgo Elevado",
            "101.9, Riesgo Elevado",
            "102.0, Riesgo Muy Elevado"
        })
        @DisplayName("Límites de riesgo para hombres")
        void testWCHombres(float wc, String expected) throws InvalidHealthDataException {
            // Arrange (los datos vienen del CsvSource)
            
            // Act
            String result = healthCalc.wcClassification(wc, 'm');
            
            // Assert
            assertEquals(expected, result);
        }

        @ParameterizedTest(name = "Mujer con {0}cm debe ser {1}")
        @CsvSource({
            "79.9, Riesgo Bajo",
            "80.0, Riesgo Elevado",
            "87.9, Riesgo Elevado",
            "88.0, Riesgo Muy Elevado"
        })
        @DisplayName("Límites de riesgo para mujeres")
        void testWCMujeres(float wc, String expected) throws InvalidHealthDataException {
            // Act
            String result = healthCalc.wcClassification(wc, 'f');
            
            // Assert
            assertEquals(expected, result);
        }
    }
}