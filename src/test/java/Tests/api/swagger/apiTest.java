package Tests.api.swagger;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import utils.apiControl;
import utils.container;
import static org.junit.Assert.assertTrue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class apiTest {
    private static final Logger logger = LoggerFactory.getLogger("MyClass");
    private static long idpet = 0;

    @Test
    public void test1postPet()
    {
        logger.debug("= = = = = = = = => postPet test Start");
        logger.debug("- - - - - - - - - - - - - - - - - - -");
        utils.container sendContainer = new container();
        utils.container responseContainer;
        utils.apiControl apiControl = new apiControl();
        int control = 200;
        responseContainer = apiControl.petPost("doggy", sendContainer);
        idpet = responseContainer.getId();
        logger.debug("Status Code: "+responseContainer.getStatusCode());
        logger.debug("id pet: "+idpet);
        logger.debug("name pet: "+responseContainer.getName());
        if (control == responseContainer.getStatusCode()){
            assertTrue(true);
            logger.debug("postPet test passed");
            logger.debug("__________________");
        }
        else {
            logger.debug("postPet test NOT passed");
        }
    }

    @Test
    public void test2getPet()
    {
        logger.debug("= = = = = = = = => getPet test Start");
        logger.debug("- - - - - - - - - - - - - - - - - - -");
        utils.container sendContainer = new container();
        utils.container responseContainer;
        utils.apiControl apiControl = new apiControl();
        int control = 200;
        responseContainer = apiControl.petGet(idpet, sendContainer);
        logger.debug("Status Code: "+responseContainer.getStatusCode());
        logger.debug("id pet: "+idpet);
        logger.debug("name pet: "+responseContainer.getName());
        if (control == responseContainer.getStatusCode()){
            assertTrue(true);
            logger.debug("getPet test passed");
            logger.debug("__________________");
        }else {
            logger.debug("getPet test NOT passed");
        }
    }

    @Test
    public void test3putPet()
    {
        logger.debug("= = = = = = = = => putPet test Start");
        logger.debug("- - - - - - - - - - - - - - - - - - -");
        utils.container sendContainer = new container();
        utils.container responseContainer = new container();
        utils.apiControl apiControl = new apiControl();
        int control = 200;
        sendContainer.setName("kitty");
        logger.debug("name pet modified to: "+sendContainer.getName()+"\nid: "+idpet);

        responseContainer = apiControl.petPut(idpet, sendContainer);
        logger.debug("put sent\n...>");

        logger.debug("Status Code: "+responseContainer.getStatusCode());
        logger.debug("id pet: "+idpet);
        logger.debug("name pet: "+responseContainer.getName());

        if (control == responseContainer.getStatusCode()){
            assertTrue(true);
            logger.debug("putPet test passed");
            logger.debug("__________________");
        }else {
            logger.debug("putPet test NOT passed");
        }
    }
}