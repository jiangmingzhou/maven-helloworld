package my.zjm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A sample test for helloworld
 *
 * @author jiangmingzhou
 */
public class HelloWorldTest extends TestBase {

    @Before
    public void init() {

    }

    @Test
    public void test() {
        HelloWorld.main(null);
        Assert.assertTrue(true);
    }

    @After
    public void clean() {

    }
}
