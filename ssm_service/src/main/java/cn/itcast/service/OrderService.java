package cn.itcast.service;

import cn.itcast.domain.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {
    PageInfo<Order> findAllOrder(Integer pageNum, Integer pageSize);

    void deleteOrder(Integer id);

    void addOrder(Order order);
}
