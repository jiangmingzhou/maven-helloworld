package my.zjm.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Configuration for hello-world app.
 *
 * @author jiangmingzhou
 */
@Configuration @PropertySource({ "log4j.properties" }) public class HelloWorldAppConfig {
    @Value("${log4j.rootLogger}") private String rootLogger;

    @Bean public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public String getRootLogger() {
        return rootLogger;
    }

    public void setRootLogger(String rootLogger) {
        this.rootLogger = rootLogger;
    }
}
