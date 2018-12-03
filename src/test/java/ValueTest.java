import org.junit.Assert;
import org.junit.Test;

public class ValueTest {

    @Test
    public void test1() {
        String[] s = {"[94133,94133]", "[94200,94299]", "[94600,94699]"};
        ValidateValue input = new ValidateValue(s);
        input.checkValues();
        int[] expected = {94133, 94133, 94200, 94299, 94600, 94699};
        Assert.assertArrayEquals(expected, input.getValues());
    }

    @Test
    void test2() {
        String[] s = {"[94133,94133]", "[94200,94299]", "[94226,94399]"};
        ValidateValue input = new ValidateValue(s);
        input.checkValues();
        int[] expected = {94133, 94133, 94200, 94299, 94226, 94399};
        Assert.assertArrayEquals(expected, input.getValues());
    }

    @Test
    void test3() {
        String[] s = {"[11111,25000]", "[24999,49000]", "[49002,94399]"};
        ValidateValue input = new ValidateValue(s);
        input.checkValues();
        int[] expected = {11111, 25000, 24999, 49000, 49002, 94399};
        Assert.assertArrayEquals(expected, input.getValues());
    }
}
