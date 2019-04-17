package cn.itcast.dao;

import cn.itcast.domain.Order;
import cn.itcast.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(property = "product",javaType = Product.class,column = "productId",
            one = @One(
                  select = "cn.itcast.dao.ProductDao.findOne"
            ))
    })

    List<Order>findAllOrder();
    @Delete("delete from orders where id = #{id}")
    void deleteOrder(Integer id);
    @Insert("insert into orders values(com_sequence.nextval,#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},22)")
    void addOrder(Order order);
}
