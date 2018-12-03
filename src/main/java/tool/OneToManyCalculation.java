package tool;

import java.util.ArrayList;

/**
 * OneToManyCalculation
 *
 * @author yuxi
 * @date 2018/12/3
 */
public class OneToManyCalculation {
    public static ArrayList<Float> getProbabilityDistribution(int targetOrder, ArrayList<ArrayList<Float>> driversProbabilityDistribution, ArrayList<Float> driversOrderWatchTime){
        callTest();
        ArrayList<Float> result = new ArrayList<Float>();
        result.add(0.02f);
        result.add(0.01f);
        return result;
    };
    public static String callTest(){
        return "Hello world";
    }
}
