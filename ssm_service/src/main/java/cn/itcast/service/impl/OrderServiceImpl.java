package cn.itcast.service.impl;

import cn.itcast.dao.OrderDao;
import cn.itcast.domain.Order;
import cn.itcast.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public PageInfo<Order> findAllOrder(Integer pageNum,Integer pageSize) {
        //System.out.println(orderDao.findAllOrder());
        //开启静态方法
        PageHelper.startPage(pageNum,pageSize);
        List<Order> list = orderDao.findAllOrder();
        PageInfo<Order> info = new PageInfo<>(list);
        return info;
    }

    @Override
    public void deleteOrder(Integer id) {
        orderDao.deleteOrder(id);
    }

    @Override
    public void addOrder(Order order) {
        System.out.println(order.getOrderTime());
        orderDao.addOrder(order);
    }
}
