Feature: Agregar una laptop al carrito

  Scenario: Agregar una laptop al carrito de compras
    Given que estoy en la página de inicio de la tienda en línea
    When hago clic sobre una laptop
    And agrego la laptop al carrito
    Then veo que la laptop está en el carrito de compras
