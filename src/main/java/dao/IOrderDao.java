package dao;

import model.Order;

/**
 * IOrderDao
 *
 * @author yuxi
 * @date 2018/12/3
 */
public interface IOrderDao {
    public Order getOrderByTime(int beginTime, int endTime);
}
