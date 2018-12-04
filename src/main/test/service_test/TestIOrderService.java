/**
 * TestIOrderService
 *
 * @author yuxi
 * @date 2018/12/3
 */
package service_test;
import model.Order;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IOrderService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestIOrderService {
    @Autowired
    private IOrderService orderService;
    @Test
    public void getOrderByTime(){
        Order order = orderService.getOrderByTime(0,1000);
        assertEquals("Wrong! ",985,order.getTime());
    }
}
