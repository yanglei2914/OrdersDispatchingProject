package service.impl;

import dao.IOrderDao;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import service.IOrderService;

/**
 * OrderService
 *
 * @author yuxi
 * @date 2018/12/3
 */
public class OrderService implements IOrderService {
    @Autowired
    private IOrderDao orderDao;
    public Order getOrderByTime(int beginTime, int endTime){
        return orderDao.getOrderByTime(beginTime, endTime);
    }
}
