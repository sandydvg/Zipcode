import org.junit.Assert;
import org.junit.Test;
public class InputTest {

    @Test
    public void test1() {
        String[] s = {"[94133,94133]", "[94200,94299]", "[94600,94699]"};
        ZipCodeValidator input = new ZipCodeValidator(s);
        input.checkzipcode();
        String[] expected = {"[94133,94133]", "[94200,94299]", "[94600,94699]"};
        Assert.assertArrayEquals(expected, input.getzipcode());
    }

    @Test
    public void test2() {
        String[] s = {"[94133,94133]", "[94200,94299]", "[94226,94399]"};
        ZipCodeValidator input = new ZipCodeValidator(s);
        input.checkzipcode();
        String[] expected = {"[94133,94133]", "[94200,94299]", "[94226,94399]"};

        Assert.assertArrayEquals(expected, input.getzipcode());
    }

    @Test
    public void test3() {
        String[] s = {"[11111,25000]", "[24999,49000]", "[49002,94399]"};
        ZipCodeValidator input = new ZipCodeValidator(s);
        input.checkzipcode();
        String[] expected = {"[11111,25000]", "[24999,49000]", "[49002,94399]"};
        Assert.assertArrayEquals(expected, input.getzipcode());
    }

    @Test
    public void test4() {
        String[] s = {"[10001,99999]"};
        ZipCodeValidator input = new ZipCodeValidator(s);
        input.checkzipcode();
        String[] expected = {"[10001,99999]"};
        Assert.assertArrayEquals(expected, input.getzipcode());
    }
}
