Feature: realizar un post de una mascota para una API

  Scenario: agregar mascota a la API
    Given ingreso los datos de la mascota
    When envio los datos post
    Then responden con un mensaje de exito post

  Scenario: obtener mascota de la API
    Given ingreso el id de la mascota get
    When envio los datos get
    Then responden con un mensaje de exito get

  Scenario: modificar mascota de la API
    Given ingreso el id de la mascota put
    When envio los datos put
    Then responden con un mensaje de exito put