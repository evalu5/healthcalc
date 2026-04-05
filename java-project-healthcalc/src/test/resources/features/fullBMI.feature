Feature: Clasificación  completa del Índice de Masa Corporal (Full BMI)
Como usuario de la calculadora HealthCalc
Quiero obtener mi categoría de peso según el valor de mi índice de Masa Corporal
Para conocer mi estado nutricional

    Background:
        Given la calculadora de la salud está iniciada
        And el ususario ha seleccionado la métrica Full BMI

    @HighPriority 
    Scenario Outline: Categorización exitosa en todos los rangos
        Given un valor de BMI <valor_bmi>
        When ejecuto la clasificación de BMI
        Then el resultado debe ser <categoria>

        Examples:
            | valor_bmi | categoria          |
            | 15.0      | Delgadez Severa    |
            | 16.5      | Delgadez Moderada  |
            | 18.0      | Delgadez Leve      |
            | 22.0      | Normal             |
            | 27.5      | Sobrepeso          |
            | 32.5      | Obesidad I         |
            | 37.5      | Obesidad II        |
            | 45.0      | Obesidad III       |
