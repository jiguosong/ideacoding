package heap.test;

import heap.src.rangeAddition;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by songjiguo on 1/3/17.
 */
public class rangeAdditionTest {
    @Test
    public void getModifiedArray() throws Exception {
        rangeAddition test = new rangeAddition();
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int length = 5;
        int[] ans = test.getModifiedArray(length, updates);
        System.out.println(Arrays.toString(ans));
    }

}