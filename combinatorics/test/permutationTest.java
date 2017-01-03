package combinatorics.test;

import combinatorics.src.permutation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songjiguo on 1/2/17.
 */
public class permutationTest {
    @Test
    public void permute() throws Exception {
        permutation test = new permutation();
        int[] nums = new int[] {1,2,3};
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result = test.permute(nums);
        System.out.println(result);
    }

    @Test
    public void permute2() throws Exception {
        permutation test = new permutation();
        int[] nums = new int[] {1,2,3};
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        result = test.permute2(nums);
        System.out.println(result);
    }

}