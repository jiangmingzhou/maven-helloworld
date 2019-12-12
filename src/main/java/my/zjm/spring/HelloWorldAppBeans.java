package my.zjm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Beans holder.
 *
 * @author jiangmingzhou
 */
@Configuration @Import({ HelloWorldAppConfig.class }) @PropertySource({
        "classpath:log4j.properties" }) public class HelloWorldAppBeans {
    @Autowired private HelloWorldAppConfig appConfig;

    @Bean public HelloWorld helloWorld() {
        return new HelloWorld();
    }

}
