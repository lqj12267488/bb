package cn.itcast.service;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.Product;


public interface ProductService {
    PageBean findAll(Integer pageNum, Integer pageSize);

    void ProductAdd(Product product) ;
    //根据id查询
    Product findById(Integer id);

    void updateProduct(Product product);

    void delete(Integer id);
}
