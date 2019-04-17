package cn.itcast.service.impl;

import cn.itcast.dao.ProductDao;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public PageBean findAll(Integer pageNum, Integer pageSize) {
        //分页查询
        //开始索引
        //每页个数
        PageBean pb = new PageBean();
        pb.setPageNum(pageNum);
        pb.setPageSize(pageSize);
        //查询总条数
       Integer totalCount =  productDao.findTotal();
       //总页数
        Double totalPage = Math.ceil(totalCount*1.0/pageSize);
        pb.setTotalPage(totalPage.intValue());
        pb.setTotalCount(totalCount);
        //查询当前页信息
        Integer startIndex = (pageNum-1)*pageSize;
        Integer endIndex = pageNum*pageSize;
        List<Product> list = productDao.findAll(startIndex,endIndex);
        //System.out.println(startIndex);
        //System.out.println(endIndex);
        pb.setList(list);
        return pb;
    }

    @Override
    public void ProductAdd(Product product) {
        productDao.ProductAdd(product);
    }

    @Override
    public Product findById(Integer id) {
        Product product = productDao.findById(id);
       // System.out.println("11111"+product);
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void delete(Integer id) {
        productDao.delete(id);
    }
}
