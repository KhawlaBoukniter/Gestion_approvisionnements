import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

public class TestSpring {

    @Test
    public void testSpringEnvironment() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        System.out.println("The Spring environment was built successfully!");
        context.close();

        assertTrue(true);
    }
}