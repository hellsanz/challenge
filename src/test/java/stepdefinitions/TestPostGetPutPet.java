package stepdefinitions;

import Tests.ui.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.apiControl;
import utils.container;


import static org.junit.Assert.assertTrue;

public class TestPostGetPutPet extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger("MyClass");
    private static int control = 200;
    private static long statusCode;
    private static long idpet = 0;
    private static String petName;
    utils.container sendContainer = new container();
    utils.container responseContainer;
    utils.apiControl apiControl = new apiControl();

    //? ============================================>>>>>>>>>>>>>>  POST
    @Given("ingreso los datos de la mascota")
    public void dataInPetPost() {
        logger.debug("= = = = = = = = => postPet test Start");
        logger.debug("- - - - - - - - - - - - - - - - - - -");
        petName = "doggy";//hardcode
    }

    @When("envio los datos post")
    public void dataSendPetPost() {
        responseContainer = apiControl.petPost(petName, sendContainer);
        idpet = responseContainer.getId();
        statusCode = responseContainer.getStatusCode();
        petName = responseContainer.getName();
        logger.debug("Status Code: "+statusCode);
        logger.debug("id pet: "+idpet);
        logger.debug("name pet: "+petName);
    }

    @Then("responden con un mensaje de exito post")
    public void responsePetPost() {
        if (control == statusCode){
            logger.debug("postPet test passed");
            logger.debug("__________________");
            assertTrue(true);
        }
        else {
            assertTrue(false);
            logger.debug("postPet test NOT passed");
        }
    }

    //? ============================================>>>>>>>>>>>>>>  GET
    @Given("ingreso el id de la mascota get")
    public void dataInPetGet() {
        logger.debug("= = = = = = = = => getPet test Start");
        logger.debug("- - - - - - - - - - - - - - - - - - -");
        //seteado desde el post anterior
        //hardcode o ingreso por consola en en caso de que no se haya ejecutado el post
    }

    @When("envio los datos get")
    public void dataSendPetGet() {
        responseContainer = apiControl.petGet(idpet, sendContainer);
        logger.debug("Status Code: "+responseContainer.getStatusCode());
        logger.debug("id pet: "+idpet);
        logger.debug("name pet: "+responseContainer.getName());
    }

    @Then("responden con un mensaje de exito get")
    public void responsePetGet() {
        if (control == responseContainer.getStatusCode()){
            assertTrue(true);
            logger.debug("getPet test passed");
            logger.debug("__________________");
        }else {
            logger.debug("getPet test NOT passed");
        }
    }

    //? ============================================>>>>>>>>>>>>>>  PUT
    @Given("ingreso el id de la mascota put")
    public void dataInPetPut() {
        logger.debug("= = = = = = = = => putPet test Start");
        logger.debug("- - - - - - - - - - - - - - - - - - -");
        //seteado desde el post anterior
        //hardcode o ingreso por consola en en caso de que no se haya ejecutado el post
    }

    @When("envio los datos put")
    public void dataSendPetPut() {
        sendContainer.setName("kitty");
        logger.debug("name pet modified to: "+sendContainer.getName()+"\nid: "+idpet);
        responseContainer = apiControl.petPut(idpet, sendContainer);
        logger.debug("Status Code: "+responseContainer.getStatusCode());
        logger.debug("id pet: "+idpet);
        logger.debug("name pet: "+responseContainer.getName());
    }

    @Then("responden con un mensaje de exito put")
    public void responsePetPut() {
        if (control == responseContainer.getStatusCode()){
            assertTrue(true);
            logger.debug("putPet test passed");
            logger.debug("__________________");
        }else {
            logger.debug("putPet test NOT passed");
        }
    }
}
