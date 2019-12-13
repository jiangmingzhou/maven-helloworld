package my.zjm;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.mockito.MockitoAnnotations;
import org.slf4j.LoggerFactory;

/**
 * Test base for all unit tests.
 *
 * @author jiangmingzhou
 */
public class TestBase {
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(TestBase.class);

    public TestBase() {
        MockitoAnnotations.initMocks(this);
    }

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(Description description) {
            LOG.warn("------------------------------------------------------------");
            LOG.warn("Starting test: {}#{} ", getTestClassName(), description.getMethodName());
            LOG.warn("-------------------------------------------------------------");
        }

        protected void finished(Description description) {
            LOG.warn("------------------------------------------------------------");
            LOG.warn("Finished test: {}#{} ", getTestClassName(), description.getMethodName());
            LOG.warn("-------------------------------------------------------------");
        }
    };

    private String getTestClassName() {
        return this.getClass().getName();
    }

    @BeforeClass
    public static void initLogger() throws Exception {
        PatternLayout layout = new PatternLayout();
        String conversionPattern = "%-5p[%d][%t]%C(%L):%m%n";
        layout.setConversionPattern(conversionPattern);

        // creates console appender
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setLayout(layout);
        consoleAppender.setTarget("System.out");
        consoleAppender.setEncoding("UTF-8");
        consoleAppender.activateOptions();

        // configures the root logger
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);
        rootLogger.removeAllAppenders();
        rootLogger.addAppender(consoleAppender);
    }

    public static void setLogLevel(Level level) {
        Logger.getRootLogger().setLevel(level);
    }

    public static Level getLogLevel() {
        return Logger.getRootLogger().getLevel();
    }

    public static void setLogLevel(String fileter, Level level) {
        Logger logger = Logger.getLogger(fileter);
        logger.setLevel(level);
    }
}
