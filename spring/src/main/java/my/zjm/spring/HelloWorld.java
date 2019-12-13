package my.zjm.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * hello world
 *
 * @author jiangmingzhou
 */
public class HelloWorld {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

    public void sayHelloWorld() {
        LOG.info("Hello world!");
    }

    public static void main(String[] args) {
        /*
            Annotation
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloWorldAppBeans.class);
        HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
        helloWorld.sayHelloWorld();

        /*
            XML
         */
        applicationContext = new ClassPathXmlApplicationContext("spring/helloworld.xml");
        helloWorld = applicationContext.getBean(HelloWorld.class);
        helloWorld.sayHelloWorld();
    }
}
