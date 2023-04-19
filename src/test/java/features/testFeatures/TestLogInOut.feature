Feature: Login and Logout

  Scenario: abrir y cerrar la sesión
    Given estando en la pagina principal
    When ingresando user y pass desde el popup login haciendo click en login
    Then se abre y cierra la sesión

