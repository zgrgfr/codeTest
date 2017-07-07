import org.springframework.context.support.ClassPathXmlApplicationContext;
import springTest.service.HelloService;

/**
 * Created by guofengrui on 2017/7/7.
 */
public class aopTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        HelloService userService = context.getBean(HelloService.class);

        userService.txTest();

        context.close();
    }
}
