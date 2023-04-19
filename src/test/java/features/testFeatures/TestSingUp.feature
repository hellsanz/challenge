Feature: Registro de Usuario

  Scenario: Registrar un nuevo usuario
    Given que estoy en la página principal
    When se genera el nombre y usuario
    And hago clic en el botón de registro
    Then la cuenta es creada exitosamente
