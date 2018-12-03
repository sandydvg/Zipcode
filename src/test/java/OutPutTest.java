import org.junit.Assert;
import org.junit.Test;

public class OutPutTest {

    @Test
    public void test1() {
        int[] s = {94133, 94133, 94200, 94299, 94600, 94699};
        ComputeOutput input = new ComputeOutput(s);
        input.compute();
        String expected = "[94133,94133] [94200,94299] [94600,94699]";
        Assert.assertEquals(expected, input.toString());
    }

    @Test
    public void test2() {
        int[] s = {94133, 94133, 94200, 94299, 94226, 94399};
        ComputeOutput input = new ComputeOutput(s);
        input.compute();
        String expected = "[94133,94133] [94200,94399]";
        Assert.assertEquals(expected, input.toString());
    }

    @Test
    public void test3() {
        int[] s = {11111, 25000, 24999, 49000, 49002, 94399};
        ComputeOutput input = new ComputeOutput(s);
        input.compute();
        String expected = "[11111,49000] [49002,94399]";
        Assert.assertEquals(expected, input.toString());
    }
}
