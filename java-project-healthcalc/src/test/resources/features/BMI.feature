  
Feature: Cálculo del Índice de Masa Corporal (BMI)
  Como estudiante de Ingeniería de la Salud
  Quiero calcular el índice de masa corporal según el peso y la altura
  Para obtener mi indicador de estado nutricional

  Background:
    Given la calculadora de salud está iniciada
    And el usuario ha seleccionado la métrica BMI

  @HighPriority
  Scenario Outline: Cálculo exitoso del valor de BMI 
    Given el peso es <peso>
    And la altura es <altura>
    When ejecuto el cálculo de BMI
    Then el resultado numérico debe ser <resultado>

    Examples:
      | peso | altura | resultado |
      | 70.0 | 1.75   | 22.86     |
      | 85.0 | 1.80   | 26.23     |
      | 50.0 | 1.50   | 22.22     |

  @EdgeCase
  Scenario Outline: Cálculo del BMI en límites biológicos permitidos
    Given el peso es <peso>
    And la altura es <altura>
    When ejecuto el cálculo de BMI
    Then el resultado numérico debe ser <resultado>

    Examples:
      | peso  | altura | resultado |
      | 1.0   | 0.30   | 11.11     |
      | 700.0 | 3.00   | 77.78     |

  @ErrorHandling
  Scenario Outline: Intento de cálculo del BMI con datos biológicamente imposibles
    Given el peso es <peso>
    And la altura es <altura>
    When ejecuto el cálculo de BMI
    Then el sistema debe lanzar una excepción

    Examples:
      | peso  | altura |
      | -10.0 | 1.70   |
      | 70.0  | -1.70  |
      | 0.0   | 1.70   |
      | 70.0  | 0.0    |
      | 0.9   | 1.70   |
      | 700.1 | 1.70   |
      | 70.0  | 3.01   |