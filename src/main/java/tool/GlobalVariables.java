package main.java.tool;

/**
 * GlobalVariables
 *
 * @author yuxi
 * @date 2018/12/3
 */
public class GlobalVariables {
    //一条订单的看单时间可以从数据集中的最短响应时间得出
    final static int WATCH_TIME_FOR_ONE_ORDER = 2;
    //分单的时间窗口
    final static int DISPATCHING_TIME_WINDOW = 30;
    //响应时间分段
    final static float[] RESPONSE_TIME_WINDOWS = {0f, 10f, 30f};
    //一秒内采样的精度
    final static int SAMPLES_IN_ONE_SECOND = 5;
}
