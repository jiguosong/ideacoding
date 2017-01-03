package bits.test;

import bits.src.numberof1bits;
import org.junit.Test;

/**
 * Created by songjiguo on 1/3/17.
 */
public class numberof1bitsTest {
    @Test
    public void rangeBitwiseAnd() throws Exception {
        numberof1bits test = new numberof1bits();
        int ans = test.rangeBitwiseAnd(1, 11);
        System.out.println(ans);
    }

    @Test
    public void hammingWeight() throws Exception {
        numberof1bits test = new numberof1bits();
        int ans = test.hammingWeight(11);
        System.out.println(ans);
    }

}