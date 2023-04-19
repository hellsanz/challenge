
# Buafest #
El proyecto se encuentra codificado en Java utilizando Maven para incorporar Selenium WebDriver, JUnit, REST Assured y Cucumber, mediante el patrón de diseño Page Object Model.

### Descripción ###
Se encarga de realizar la automatización de pruebas de registro, inicio de sesión, cierre de sesión y agregado de productos al carrito de compras de un usuario
en la página web Demoblaze. Además, realiza pruebas de API con el protocolo HTTP en la página web Swagger utilizando POST, GET y PUT mediante el uso de REST Assured.

### Estructura del proyecto ###
Los tests de UI se encuentran en la carpeta src/test/java/tests/ui, mientras que los tests de API están en la carpeta src/test/java/tests/api/swagger.

_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _

### ### ### ### ###
### Directorios ###
El proyecto se encuentra estructurado de la siguiente manera:
-buafest
    -src
        -main
            -java
                -helpers
                -POM
                    -cart
                    -home
                    -product
            -resources
                -driver
        -test
            -java
                -features
                    -runners: contiene los archivos .java que ejecutan los tests
                    -testFeatures: contiene los archivos .feature
                -stepsdefinitions: contiene los archivos .java
                -tests
                    -api.swagger
                    -ui
                -utils
            -resources
                -driver: contiene el controlador del navegador Chrome
    -target
        -site
            -surefire-report.html: contiene el reporte de pruebas
        -Buafest-1.0-SNAPSHOT.jar: contiene el snapshot del proyecto


_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _

###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###


### Comandos de ejecución ###
Para ejecutar los tests, se pueden usar tanto el IDE de preferencia como la consola de comandos con el comando
mvn test

### Reportes de pruebas ###
los reportes se generan con el comando:     mvn surefire-report:report
y se encuentran en la carpeta:              target/site/surefire-report.html

### Pruebas de UI ###
Para ejecutar las pruebas de UI, se debe ejecutar el comando:    mvn test
en la consola de comandos, o bien, ejecutar los archivos
TestAddToCart.java          que se encuentra en la ruta:     src/test/java/features/runners/ui o bien el archivo
TestSingUpLogInOut.java     que se encuentra en la ruta:     src/test/java/Tests/ui/singUpLogInOut/TestSingUpLogInOut.java

### Pruebas de API ###
Para ejecutar las pruebas de API, se debe ejecutar el comando:   mvn test
en la consola de comandos, o bien, ejecutar el archivo
apiTest.java                que se encuentra en la ruta:     src/test/java/Tests/api/swagger/apiTest.java


###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###


### Configuración ###
El controlador del navegador Chrome (chromedriver.exe) se encuentra en la carpeta driver dentro de la ruta:      src/test/resources/driver.
Los archivos de prueba se encuentran en la ruta:                src/test/java
y los archivos de features se encuentran en la ruta:            src/test/resources

### Generar ejecutable ###
el proyecto genera un snapshot que se encuentra en la carpeta target con el nombre de Buafest-1.0-SNAPSHOT.jar

### pom.xml ###
El archivo pom.xml contiene las dependencias necesarias para ejecutar el proyecto. Además, contiene la configuración de los plugins para generar el reporte de pruebas y el snapshot.


###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###

### metodo de ejecucion ###
Para ejecutar el proyecto se debe tener instalado Java y Maven, luego se debe ejecutar el comando:      mvn test
en la consola de comandos (tanto de la ide como una terminal externa).
Existen dos formas de ejecutar el proyecto, la primera es ejecutar el comando mvn test en la consola de comandos, y la segunda
es ejecutar individualmente cada uno de los tests de UI y API por separado.

###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###   ###


