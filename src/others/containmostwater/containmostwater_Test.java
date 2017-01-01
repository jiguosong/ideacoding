package others.containmostwater;

import org.junit.Test;

import static org.junit.Assert.*;

public class containmostwater_Test {

    @Test
    public void test() {
        containmostwater test = new containmostwater();
        int[] height = {1, 3, 2, 4, 5, 6, 10, 2};
        int ans = test.maxArea(height);
        System.out.println(ans);
        assertEquals("must be", 15, ans);
    }
}
