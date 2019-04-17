package cn.itcast.controller;

import cn.itcast.domain.PageBean;
import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping(value = "/findAll")
    public String findAll(Model model,
                          @RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "3") Integer pageSize) {
        PageBean pb = productService.findAll(pageNum,pageSize);
        //System.out.println(list);
        model.addAttribute("pb",pb);
        return "/product/product-list";
    }


    @RequestMapping(value = "/productAddUI")
    public String productAddUi() {
        return "/product/product-add";
    }


    //添加
    @RequestMapping(value = "/productAdd")
    public String productAdd(Product product) {
        System.out.println(product);
        productService.ProductAdd(product);
        return "redirect:/product/findAll";
    }


    @RequestMapping(value = "/updateUi")
    public String updateUi(Integer id,Model model) {
        //System.out.println(111);
        //System.out.println(id);
        //根据id查询
        Product service = productService.findById(id);
        //System.out.println(service.getCityName());
        model.addAttribute("product",service);
        return "/product/product-update";
    }


    //修改
    @RequestMapping(value = "/updateProduct")
    public String update(Product product) {
        System.out.println("执行...");
    productService.updateProduct(product);
    return "redirect:/product/findAll";
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id) {
        productService.delete(id);
        return "redirect:/product/findAll";
    }
}
