package bits.test;

import bits.src.reversebits;
import org.junit.Test;

/**
 * Created by songjiguo on 1/2/17.
 */
public class reversebitsTest {
    @Test
    public void reverseBits() throws Exception {
        reversebits test = new reversebits();
        int ans = test.reverseBits(43261596);
        System.out.println(ans);
        System.out.println("testset");
    }
}