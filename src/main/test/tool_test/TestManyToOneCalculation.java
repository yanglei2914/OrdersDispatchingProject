package tool_test;

import org.junit.Test;
import tool.ManyToOneCalculation;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * ManyToOneCalculationTest
 *
 * @author yuxi
 * @date 2018/12/3
 */
public class TestManyToOneCalculation {

    @Test
    public void getProbabilityDistribution() {
        ArrayList<Float> targetOrderProbabilityDistribution = new ArrayList<Float>();
        targetOrderProbabilityDistribution.add(0.5f);
        targetOrderProbabilityDistribution.add(0.3f);
        targetOrderProbabilityDistribution.add(0.2f);
        ArrayList<ArrayList<Float>> ordersProbabilityDistribution = new ArrayList<ArrayList<Float>>();
        ArrayList<Float> orderPd = new ArrayList<Float>();
        orderPd.add(0.4f);
        orderPd.add(0.3f);
        orderPd.add(0.3f);
        ordersProbabilityDistribution.add(orderPd);
        ArrayList<Double> result = new ArrayList<Double>();
        result = ManyToOneCalculation.getProbabilityDistribution(targetOrderProbabilityDistribution, ordersProbabilityDistribution);
        double sum = 0;
        for(int i = 0; i < result.size(); i++){
            sum = sum + result.get(i);
        }
        assertTrue("Test the sum of probabilities in one time slot", Math.abs(sum - 0.40) < 0.1);
        targetOrderProbabilityDistribution.clear();
        targetOrderProbabilityDistribution.add(0.5f);
        targetOrderProbabilityDistribution.add(0.3f);
        targetOrderProbabilityDistribution.add(0.2f);
        ordersProbabilityDistribution.clear();
        orderPd.clear();
        orderPd.add(0.4f);
        orderPd.add(0.3f);
        orderPd.add(0.3f);
        ArrayList<Float> orderPd1 = new ArrayList<Float>();
        orderPd1.add(0.6f);
        orderPd1.add(0.2f);
        orderPd1.add(0.2f);
        ordersProbabilityDistribution.add(orderPd);
        ordersProbabilityDistribution.add(orderPd1);
        result.clear();
        result = ManyToOneCalculation.getProbabilityDistribution(targetOrderProbabilityDistribution, ordersProbabilityDistribution);
        sum = 0;
        for(int i = 0; i < result.size(); i++){
            sum = sum + result.get(i);
        }
        assertTrue("Test the sum of probabilities in one time slot", Math.abs(sum - 0.29) < 0.1);

    }
}