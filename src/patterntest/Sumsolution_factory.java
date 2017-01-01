package patterntest;

public class Sumsolution_factory {
   public static Sum solve(Sumtype type) {
       Sum res = null;
       switch (type) {
       case twosum:
           res = Twosum.instance();
           break;
       default:
           // throw some exception
           break;
       }
       return res;
   }
}
