package by.javatest.task1;

import by.javatest.task1.service.Convert;
import by.javatest.task1.service.impl.ConvertImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConvertTest {
    private Convert convert = new ConvertImpl();

    @Test
    public void testConvertIPv4ToInt() {
        String ip = "64.233.187.99";
        long actual = convert.convertIPv4ToInt(ip);
        long expected = 1089059683;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testConvertIntToIPv4() {
        long ip = 3221226219L;
        String actual = convert.convertIntToIPv4(ip);
        String expected = "192.0.2.235";
        Assert.assertEquals(actual, expected);
    }
}
