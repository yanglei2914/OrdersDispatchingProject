package tool_test;

import main.java.tool.ManyToOneCalculation;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * ManyToOneCalculationTest
 *
 * @author yuxi
 * @date 2018/12/3
 */
public class ManyToOneCalculationTest {

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
        ManyToOneCalculation.getProbabilityDistribution(targetOrderProbabilityDistribution, ordersProbabilityDistribution);
    }
}