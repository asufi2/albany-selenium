package testng;


import utlities.ReadConfigFiles;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

public class TestNgMavenExampleTest {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(TestNgMavenExampleTest.class);


    public void run() {
        LOGGER.debug("This is debug message");
        LOGGER.info("This is info message");
        LOGGER.warn("This is a warning message");
        LOGGER.error("This is an error message");
        LOGGER.fatal("This is dangerous");
        LOGGER.trace("General Information");
    }

    @Test
    public void testPropertyFile() {
        //    LOGGER.info(ReadConfigFiles.getPropertyValues("DbPassword"));
        // the above can be used, or you can pass it as a String value. as bellow
        String value = ReadConfigFiles.getPropertyValues("DbUser");
        LOGGER.info(value);
    //    LOGGER.info(ReadConfigFiles.getPropertyValues("DbPassword"));
    }
}
