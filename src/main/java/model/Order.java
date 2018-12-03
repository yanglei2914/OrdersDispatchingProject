package model;

/**
 * Order
 *
 * @author yuxi
 * @date 2018/12/1
 */
public class Order {
    private String orderId;
    private int time;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
