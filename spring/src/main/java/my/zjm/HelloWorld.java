package my.zjm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class: hello world.
 *
 * @author jiangmingzhou
 */
public class HelloWorld {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        sayHelloWorld();
    }

    private static void sayHelloWorld() {
        LOG.info("Hello world!");
    }
}
