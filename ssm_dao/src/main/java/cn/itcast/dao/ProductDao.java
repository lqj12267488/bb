package cn.itcast.dao;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.Product;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    @Select("select * from(select rownum r,product.* from product) t where t.r>#{startIndex} and t.r<=#{endIndex}")
    List<Product> findAll(
            @Param(value = "startIndex") Integer startIndex,
            @Param(value = "endIndex") Integer endIndex);

    @Insert("insert into product values(com_sequence.nextval,#{productNum},#{productName},#{cityName}," +
            "#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void ProductAdd(Product product) ;

    //根据id查询
    @Select(value = "select * from product where id = #{id}")
    Product findById(Integer id);


    //修改
    @Update(value = "update product set productNum = #{productNum},productName = #{productName},cityName = #{cityName}," +
            "departureTime = #{departureTime},productPrice = #{productPrice},productDesc = #{productDesc},productStatus = #{productStatus} where id = #{id}")
    void updateProduct(Product product);


    //删除
    @Delete("delete from product where id = #{id}")
    void delete(Integer id);

    //订单查询
    @Select(value = "select * from product where id = #{id}")
    Product findOne(Integer id);
    @Select("select count(1) from product")
    Integer findTotal();
}
