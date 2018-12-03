package main.java.tool;

import java.util.ArrayList;

/**
 * ManyToOneCalculation
 *
 * @author yuxi
 * @date 2018/12/3
 */
public class ManyToOneCalculation {
    public static ArrayList<Float> getProbabilityDistribution(ArrayList<Float> targetOrderProbabilityDistribution, ArrayList<ArrayList<Float>> ordersProbabilityDistribution){
        System.out.println(GlobalVariables.WATCH_TIME_FOR_ONE_ORDER);
        double sampleSum = 0;
        int timeSlot = (int)(GlobalVariables.RESPONSE_TIME_WINDOWS[1] - GlobalVariables.RESPONSE_TIME_WINDOWS[0]);
        double timeIncreasement = 1.00 / GlobalVariables.SAMPLES_IN_ONE_SECOND;
        double t = 0;
        for(int sample = 1; sample < timeSlot * GlobalVariables.SAMPLES_IN_ONE_SECOND - 1; sample++){
            double tmpProd = 1;
            t = t + timeIncreasement;
            for(int orderIndex = 0; orderIndex < ordersProbabilityDistribution.size(); orderIndex++){
                tmpProd = tmpProd * (1 - (t) * ordersProbabilityDistribution.get(orderIndex).get(0) / timeSlot);
            }
            sampleSum = sampleSum + tmpProd;
        }
        sampleSum = sampleSum * 2;
        sampleSum = sampleSum + 1;
        double tmpProd = 1;
        for(int orderIndex = 0; orderIndex < ordersProbabilityDistribution.size(); orderIndex++){
            tmpProd = tmpProd * (1 - (GlobalVariables.RESPONSE_TIME_WINDOWS[1]) * ordersProbabilityDistribution.get(orderIndex).get(0) / timeSlot);
        }
        sampleSum = sampleSum + tmpProd;
        sampleSum = sampleSum * timeIncreasement / 2;
        sampleSum = sampleSum * (targetOrderProbabilityDistribution.get(0)/timeSlot);
        System.out.println(sampleSum);
        ArrayList<Float> result = new ArrayList<Float>();
        result.add(0.02f);
        result.add(0.01f);
        return result;
    }
}
