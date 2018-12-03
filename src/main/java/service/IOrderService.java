package service;

import model.Order;

/**
 * IOrderService
 *
 * @author yuxi
 * @date 2018/12/3
 */
public interface IOrderService {
    public Order getOrderByTime(int beginTime, int endTime);
}
