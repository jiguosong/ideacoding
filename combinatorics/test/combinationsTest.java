package combinatorics.test;

import combinatorics.src.combinations;
import org.junit.Test;

import java.util.List;

/**
 * Created by songjiguo on 1/3/17.
 */
public class combinationsTest {
    @Test
    public void combine() throws Exception {
        List<List<Integer>> result;
        combinations test = new combinations();

        int n = 4;
        int k =2;

        result = test.combine(n, k);
        for (List<Integer> E : result){
            System.out.println(E);
        }
    }

    @Test
    public void combinationSum() throws Exception {

    }

    @Test
    public void combinationSum2() throws Exception {

    }

    @Test
    public void combinationSum3() throws Exception {

    }

    @Test
    public void combinationSum4() throws Exception {

    }

}