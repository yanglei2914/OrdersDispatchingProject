package dao.impl;

import dao.IOrderDao;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * OrderDao
 *
 * @author yuxi
 * @date 2018/12/3
 */

public class OrderDao implements IOrderDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Order getOrderByTime(int beginTime, int endTime){
        String sql = "SELECT order_id, second from TestOrder where second > ?  and second < ?";
        final Order order = new Order();
        jdbcTemplate.query(sql, new Object[]{beginTime, endTime}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                order.setOrderId(resultSet.getString("order_id"));
                order.setTime(resultSet.getInt("second"));
            }
        });
        return order;
    }
}
