package tool;

import java.util.ArrayList;

/**
 * ManyToOneCalculation
 * 计算一个订单在多对一情况下响应时间的概率分布
 * @author yuxi
 * @date 2018/12/3
 */
public class ManyToOneCalculation {
    /**
    * @author yuxi
    * @time 2018-12-04 09:59
    * @method getProbabilityDistribution
    * @param targetOrderProbabilityDistribution ArrayList<Float> 目标订单在一对一情况下的响应时间的概率分布
    *        ordersProbabilityDistribution ArrayList<ArrayList<Float>> 与目标名单竞争的其他订单的响应时间概率分布
    * @return ArrayList<Float> 目标订单在多对一情况下响应时间的概率分布 以一秒为步长
    * @version V1.0.1
    * @description 使用积分加采样的方法优化多对一的计算流程，避免原来基于暴力组合的计算流程所带来的组合爆炸
    */
    public static ArrayList<Double> getProbabilityDistribution(ArrayList<Float> targetOrderProbabilityDistribution, ArrayList<ArrayList<Float>> ordersProbabilityDistribution){
        int timeSlot = (int)(GlobalVariables.RESPONSE_TIME_WINDOWS[1] - GlobalVariables.RESPONSE_TIME_WINDOWS[0]);
        double timeIncreasement = 1.00 / GlobalVariables.SAMPLES_IN_ONE_SECOND;
        ArrayList<Double> resultProbabilityDistribution = new ArrayList<Double>();
        //被积变量
        double t = 0;
        for(int second = 0; second < GlobalVariables.RESPONSE_TIME_WINDOWS[1]; second++) {
            //由采样所得的概率总和
            double sampleSum = 0;
            //记录这一次采样的开始时刻
            double startTime = t;
            //在时间段内的总采样次数
            for (int sample = 1; sample < GlobalVariables.SAMPLES_IN_ONE_SECOND; sample++) {
                double tmpProd = 1;
                t = t + timeIncreasement;
                for (int orderIndex = 0; orderIndex < ordersProbabilityDistribution.size(); orderIndex++) {
                    tmpProd = tmpProd * (1 - (t) * ordersProbabilityDistribution.get(orderIndex).get(0) / timeSlot);
                }
                sampleSum = sampleSum + tmpProd;
            }
            sampleSum = sampleSum * 2;
            double fa = 1;
            double fb = 1;
            t = t + timeIncreasement;
            //加边界值 f(a) 和 f(b)
            for (int orderIndex = 0; orderIndex < ordersProbabilityDistribution.size(); orderIndex++) {
                fa = fa * (1 - startTime * ordersProbabilityDistribution.get(orderIndex).get(0) / timeSlot);
                fb = fb * (1 - t * ordersProbabilityDistribution.get(orderIndex).get(0) / timeSlot);
            }
            sampleSum = sampleSum + fa + fb;
            sampleSum = sampleSum * timeIncreasement / 2;
            sampleSum = sampleSum * (targetOrderProbabilityDistribution.get(0) / timeSlot);
            resultProbabilityDistribution.add(sampleSum);
        }
        return resultProbabilityDistribution;
    }
}
